import numpy
import sys
from sklearn import preprocessing

#计算欧几里德距离：
def euclidean(p,q):
#如果两数据集数目不同，计算两者之间都对应有的数
    same = 0
    for i in p:
        if i in q:
            same+=1
#计算欧几里德距离,并将其标准化
    e = sum([(p[i] - q[i])**2 for i in range(same)])
    return 1/(1+e**.5)

#归一化
def normalization(data):
    data_normal = preprocessing.scale(data)  # data是多维数据
    return data_normal
def openFile(fileName):
    # 读数据，转变为二维矩
    data = []  # 先定义存储数据的总列表,总列表的每个数据都是一个列表,各存储一行数据
    fr = open(fileName,'r',encoding="utf-8")  # 打开文件
    for line in fr.readlines():  # readlines返回一个字符串列表,每个字符串存储一行原始数据
        line = line.strip()  # 去掉换行符h
        str = line.split(',')  # 通过空格分隔开
        data.append(str)
    data.pop(0)
    array = numpy.array(data)
    array = normalization(array)
    array = array.astype('int64')
    fr.close()
    return array
if __name__=='__main__':

    #计算相似度
    arr=openFile("D:\StuyWok\study\course\BigData\Python\pythoncode\consultant.txt")
    for i in range(0,len(arr)):
        for j in range(1+i,len(arr)):
            similarity=euclidean(arr[i],arr[j])
            print(i,j,"%.4f"%similarity)
            j+=1
        i+=1


