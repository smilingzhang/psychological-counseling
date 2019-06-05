# 读取数据
import pandas as pd
import numpy as np
file_name = "data_processed.csv"
dateparse = lambda dates: pd.datetime.strptime(dates, '%Y-%m-%d %H:%M:%S')
df = pd.read_csv(file_name,index_col=0,date_parser=dateparse,nrows=7153)
df.index = pd.DatetimeIndex(df.index.values,freq=df.index.inferred_freq)
print(df)

# 绘制时间序列散点图
import matplotlib.pyplot as plt
row_name = df.index
df['counts'].plot()
plt.show()

# ADF检测
from statsmodels.tsa.stattools import adfuller as ADF
print("ADF reslut:",ADF(df.dropna()[u'counts']))
# 【结果】
# -10.282038375954407,
# 3.7576286989645414e-18,
# 37,
# 8362,
# '1%': -3.4311322660309136,
# '5%': -2.861885707595172,
# '10%': -2.5669540152983044,
# 83312.3811404622
# 【分析】统计量<临界值，拒绝原假设
# 【结论】即序列平稳

# 自相关图
from statsmodels.graphics.tsaplots import plot_acf
from statsmodels.graphics.tsaplots import plot_pacf
plot_acf(df,lags=8000).savefig("acf.png")
# 偏自相关图
plot_pacf(df,lags=10).savefig("pacf.png")
# 【分析】从偏自相关图是拖尾的(10)，自相关图是拖尾的(8000)
# 【结论】序列是平稳的，建立ARMA模型