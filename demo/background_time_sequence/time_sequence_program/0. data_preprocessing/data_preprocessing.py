import numpy as np
import pandas as pd
import datetime
filename = "original_data.data"
# 4/10/2005 0:50
dateparse = lambda dates: pd.datetime.strptime(dates, '%m/%d/%Y %H:%M')
df = pd.read_csv(filename,index_col=None,header=None,date_parser=dateparse)
df.columns=['date','counts']
# 将缺失值改用0填充
df.ix[df.counts==-1,1] = 0
for x in range(0,df.shape[0]):
    d_s_1 = df.ix[int(x),0].split(" ")[0]
    d_s_2 = df.ix[x, 0].split(" ")[1]
    if len(d_s_1)<10:
        date = d_s_1.split('/')
        if len(date[0])<2:
            date[0] = str(0)+date[0]
        if len(date[1])<2:
            date[1] = str(0) + date[1]
        # 改造数据：修改年份为2019年
        date[2] = str(int(date[2])+14)
        d_s_1 = date[0]+'/'+date[1]+'/'+date[2]
    if len(d_s_2)<5:
        d_s_2 = str(0)+d_s_2
    df.ix[x,0] = d_s_1+' '+d_s_2


# 将字符串转化为时间戳索引
df['date'] = pd.to_datetime(df['date'],format='%m/%d/%Y %H:%M')
df.set_index('date',inplace=True)
df.index = pd.DatetimeIndex(df.index)

# 合并数据，调整时间间隔为半小时：原间隔为五分钟
# 取时间区间
row_name = df.index
start_time = row_name[0]
end_time = row_name[row_name.shape[0]-1]
# 生成时间区间
p = pd.date_range(start=str(start_time),end=str(end_time),freq='30min')
# print(p)
t_data =np.zeros((p.shape[0],1),dtype=int)
new_df = pd.DataFrame(data=t_data,index=p,columns=['counts'],dtype=int)
for row_index in range(0,df.shape[0]):
    new_df.ix[row_index//7,0] += df.ix[row_index,0]
# print(new_df)

# 删除工作时间之外的数据：为保证数据连续性，不删除
# 工作时间：8:00-20:00
# row_name = df.index
# rows=[row for row in row_name if row.hour>20 or row.hour<8]
# # print(cols)
# df = df.drop(rows,axis=0)

# 将业务时间外的统计数据用0填充
# 将所有数据除以10
# 工作时间：8:00-20:00
row_name = df.index
rows=[row for row in row_name if row.hour>20 or row.hour<8]
for row in rows:
    new_df.loc[row,'counts'] = 0

# 将数据缩小10倍
for row_name in df.index:
    print(df.loc[row_name,'counts'])
    df.loc[row_name,'counts'] /= 10
# print(new_df.head())

# 输出到文件
new_filename = "data_processed.csv"
new_df.to_csv(new_filename,index=True)