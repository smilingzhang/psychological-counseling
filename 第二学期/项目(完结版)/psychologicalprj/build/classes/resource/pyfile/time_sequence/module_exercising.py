# 读取数据
import pandas as pd
# 获取当前文件上级目录
file_name = "data_processed.csv"
dateparse = lambda dates: pd.datetime.strptime(dates, '%Y-%m-%d %H:%M:%S')
df = pd.read_csv(file_name,index_col=0,date_parser=dateparse)
df.index = pd.DatetimeIndex(df.index.values,freq=df.index.inferred_freq)

# 模型训练：建模
# 自动定阶
import statsmodels.api as sm
select_ic = sm.tsa.arma_order_select_ic(df,max_ar=6,max_ma=6,ic='aic')
(p, q) =(select_ic['aic_min_order'])
from statsmodels.tsa.arima_model import ARIMA
arma_model = ARIMA(df, order=(p,0,q))
result = arma_model.fit(disp=False)
# 将拟合出的小于零的数据规范至零
for i,row in enumerate(result.fittedvalues):
    if i==result.fittedvalues.shape[0]-1:break
    result.fittedvalues[i] =result.fittedvalues[i+1]
result.fittedvalues[result.fittedvalues<0] = 0
result.fittedvalues.dropna()

# 存储模型
import pickle
# 获取当前文件目录
file_dir = os.path.split(os.path.realpath(__file__))[0]
module_file = open(file_dir + r"\module.pkl",'wb')
pickle.dump(result,module_file)