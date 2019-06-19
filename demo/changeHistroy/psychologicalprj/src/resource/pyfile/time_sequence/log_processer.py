import pandas as pd
import datetime
import time
import numpy as np

# 获取当前文件上级目录
resource_file_dir = os.path.abspath(os.path.join(os.getcwd(), ".."))

# 获取当前文件目录
file_dir = os.path.split(os.path.realpath(__file__))[0]

file_name = "listenning_record.csv"
file_path = resource_file_dir + r"\log\" + file_name
dateparse = lambda dates: pd.datetime.strptime(dates, '%H:%M')
df = pd.read_csv(file_path,header=0,date_parser=dateparse)
df.columns = ["start_time","end_time","count"]

# 建立当天Periods索引
date = datetime.datetime.fromtimestamp(time.time())
date -= datetime.timedelta(hours=date.hour)
date -= datetime.timedelta(minutes=date.minute)
date -= datetime.timedelta(days=1)
start_time = date.strftime("%Y-%m-%d %H:%M")
end_time = (date + datetime.timedelta(hours=24)).strftime("%Y-%m-%d %H:%M")

rng = pd.date_range(start_time,end_time,freq="30T")

# 将数据列转换为时间序列
st = df["start_time"]
et = df["end_time"]
for i in range(0, df.shape[0]):
    st[i] = datetime.datetime.strptime(date.strftime("%Y-%m-%d ")+st[i], "%Y-%m-%d %H:%M")
    et[i] = datetime.datetime.strptime(date.strftime("%Y-%m-%d ")+et[i], "%Y-%m-%d %H:%M")

df["start_time"] = st
df["end_time"] = et

# 创建新数据表
counts = np.zeros([rng.shape[0],1])

# 合并数据
d_pre = 0
for i , d in enumerate(rng):
    if i == 0:
        counts[i] = df.loc[df.start_time <= d, 'count'].sum()
    else:
        counts[i] = df.loc[(df.start_time <= d) & (df.start_time >= d_pre), 'count'].sum()
    d_pre = d

new_data = pd.DataFrame(counts)
new_data.index = rng
print(new_data)

# 写入日志文件
log_file_name = "data_processed.csv"
log_file_path = file_dir + log_file_name
dateparse = lambda dates: pd.datetime.strptime(dates, '%Y-%m-%d %H:%M:%S')
log = pd.read_csv(log_file_path,index_col=0,date_parser=dateparse)
log = log.append(new_data)
log.to_csv(log_file_path)