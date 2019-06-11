import pickle
import math
import pandas as pd
import datetime
import time
import os
from pyecharts import options as opts
from pyecharts.charts import Bar,Line,Grid
from datetime import timedelta

# 获取当前文件目录
file_dir = os.path.split(os.path.realpath(__file__))[0]
# 获取当前文件上级目录
resource_file_dir = os.path.abspath(os.path.dirname(os.path.dirname(os.path.dirname(__file__))))

# 预测未来一天
def predict_day(module):
    start_day = datetime.datetime.fromtimestamp(time.time())
    end_day = start_day + datetime.timedelta(days=1)

    start_day = datetime.datetime.strftime(start_day,"%Y-%m-%d")
    end_day = datetime.datetime.strftime(end_day,"%Y-%m-%d")

    predict_day = module.predict(start_day, end_day, dynamic=True)
    predict_day += math.fabs(predict_day.min())

    return predict_day

# 预测未来一周
def predict_week(module):
    week = {"Mon": 1, "Tue": 2, "Wed": 3, "Thu": 4, "Fri": 5, "Sat": 6, "Sun": 7}
    now_day = datetime.datetime.fromtimestamp(time.time())
    week_num = week[datetime.datetime.strftime(now_day,'%a')]
    mon_day = now_day - datetime.timedelta(days=week_num - 1)
    start_week_day = datetime.datetime.strftime(mon_day,'%Y-%m-%d')
    end_week_day = datetime.datetime.strftime(mon_day + datetime.timedelta(days=6),"%Y-%m-%d")
    # start_week_day = datetime.datetime.strftime(mon_day + datetime.timedelta(days=7),'%Y-%m-%d')
    # end_week_day = datetime.datetime.strftime(mon_day + datetime.timedelta(days=13),"%Y-%m-%d")
    print("start",start_week_day,"end",end_week_day)
    predict_week = module.predict(start_week_day, end_week_day, dynamic=True)
    # 处理数据
    predict_week += math.fabs(predict_week.min())
    row_name = predict_week.index
    rows=[row for row in row_name if row.hour>20 or row.hour<8]
    for row in rows:
        predict_week.ix[row] = 0
    new_week_data = pd.DataFrame(columns=['counts'],dtype=int)
    day = 0

    while day<predict_week.shape[0]:
        row_name = predict_week.index[day]
        day_name = datetime.datetime.strftime(row_name,"%Y-%m-%d")
        new_week_data.loc[day_name,'counts'] = round(predict_week[day_name].sum())
        day+=48
    new_index = []
    predict_week_index = list(predict_week.index)
    i = 0
    while i<len(predict_week_index):
        new_index.append(datetime.datetime.strftime(predict_week_index[i], "%a"))
        i +=48
    new_week_data.index = new_index

    return new_week_data

# 绘图
def overlap_line_scatter(day_data,week_data) -> Bar:
    # 处理日数据
    x_day = list(day_data[16:-7].index)
    for i in range(0,len(x_day)):
        x_day[i] = datetime.datetime.strftime(x_day[i],"%H:%M")
    Y_day = list(day_data[16:-7])
    for i in range(0,len(Y_day)): Y_day[i] = round(Y_day[i])

    # 处理周数据
    # print(week_data)
    # x_week = list(week_data.index)
    # Y_week = list(week_data['counts'])
    # print(Y_week)

    bar = (
        Bar()
        .add_xaxis(x_day)
        .add_yaxis("未来一天", Y_day)
        .set_global_opts(title_opts=opts.TitleOpts(title="网站在线倾听量预测"))
    )
    # line = (
    #     Line()
    #     .add_xaxis(x_week)
    #     .add_yaxis("未来一周", Y_week, symbol="triangle", symbol_size=20)
    #     .set_global_opts(legend_opts=opts.LegendOpts(pos_top="48%"))
    # )

    # grid = (
    #     Grid()
    #         .add(bar, grid_opts=opts.GridOpts(pos_bottom="60%"))
    #         .add(line, grid_opts=opts.GridOpts(pos_top="60%"))
    # )
    return bar


# 读取模型
module_file = open(file_dir+r"\module.pkl","rb")
module = pickle.load(module_file)

# 预测：返回预测结果、标准误差、置信区间
pre_day = predict_day(module)
# pre_week = predict_week(module)


# 输出
overlap_line_scatter(pre_day,pre_week).render(resource_file_dir+r"\html\new_time_sequence_file.html")