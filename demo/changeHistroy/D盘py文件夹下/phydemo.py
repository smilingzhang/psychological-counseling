

import time
import sys
from math import sqrt



class CF:

    def __init__(self, ratings, k=5, n=5):



        self.train_data = ratings

        # 邻居个数

        self.k = k

        # 推荐个数

        self.n = n

        # 用户看过哪些课程
        # 数据格式{'UserID用户ID':[MovieID，课程ID]}

        self.userDict = {}

        # 看过某课程的用户

        # 数据格式：{'MovieID课程ID':[UserID,用户ID]}

        # {'1':[1,2,3..],...}

        self.ItemUser = {}

        # 邻居的信息

        self.neighbors = []

        # 推荐列表

        self.recommandList = []  # 包含dist和电影id

        self.recommand = []  # 训练集合测试集的交集，且仅有电影id

        # 用户评过电影信息

        self.train_user = []

        self.test_user = []

        # 给用户的推荐列表，仅含movieid

        self.train_rec = []

        self.test_rec = []


        # 召回率和准确率

        self.pre = [0.0, 0.0]

        self.z = [0.0, 0.0]

    '''

    userDict数据格式：

    '3': [('3421', 0.8), ('1641', 0.4), ('648', 0.6), ('1394', 0.8), ('3534', 0.6), ('104', 0.8),

    ('2735', 0.8), ('1210', 0.8), ('1431', 0.6), ('3868', 0.6), ('1079', 1.0), ('2997', 0.6),

    ('1615', 1.0), ('1291', 0.8), ('1259', 1.0), ('653', 0.8), ('2167', 1.0), ('1580', 0.6),

    ('3619', 0.4), ('260', 1.0), ('2858', 0.8), ('3114', 0.6), ('1049', 0.8), ('1261', 0.2),

    ('552', 0.8), ('480', 0.8), ('1265', 0.4), ('1266', 1.0), ('733', 1.0), ('1196', 0.8),

    ('590', 0.8), ('2355', 1.0), ('1197', 1.0), ('1198', 1.0), ('1378', 1.0), ('593', 0.6),

    ('1379', 0.8), ('3552', 1.0), ('1304', 1.0), ('1270', 0.6), ('2470', 0.8), ('3168', 0.8),

    ('2617', 0.4), ('1961', 0.8), ('3671', 1.0), ('2006', 0.8), ('2871', 0.8), ('2115', 0.8),

    ('1968', 0.8), ('1136', 1.0), ('2081', 0.8)]}

    ItemUser数据格式：

    {'42': ['8'], '2746': ['10'], '2797': ['1'], '2987': ['5'], '1653': ['5', '8', '9'],

    '194': ['5'], '3500': ['8', '10'], '3753': ['6', '7'], '1610': ['2', '5', '7'],

    '1022': ['1', '10'], '1244': ['2'], '25': ['8', '9']

    '''

    # 将ratings转换为userDict和ItemUser

    def formatRate(self, train_or_test):

        self.userDict = {}

        self.ItemUser = {}

        for i in train_or_test:  # [UserID,MovieID,Rating,Timestamp]
                                 # my [UserId,CourseId,Timestamp]



            # 计算userDict {'用户id':[(电影id,评分),(2,5)...],'2':[...]...}一个观众对每一部电影的评分集合

            if (i[0] in self.userDict):

                self.userDict[i[0]].append(i[1])

            else:

                self.userDict[i[0]] = [i[1]]

            # 计算ItemUser {'电影id',[用户id..],...}同一部电影的观众集合

            if (i[1] in self.ItemUser):

                self.ItemUser[i[1]].append(i[0])

            else:

                self.ItemUser[i[1]] = [i[0]]

    # 格式化userDict数据

    def formatuserDict(self, userId, courseId):  # userID为待查询目标，courseId为课程Id
        user = {}

        if str(courseId) in self.ItemUser.keys():
            user = self.ItemUser[str(courseId)]

        return user


    # 求交集
    def jiaoji(self,listA, listB):
        # 求交集的两种方式
        # retA = [i for i in listA if i in listB]
        retB = list(set(listA).intersection(set(listB)))
        return retB

    # 计算相似度
    # 余弦相似度
    def calcuteSimilar(self,series1, series2):
        unionLen = len(set(series1) & set(series2))
        if unionLen == 0: return 0.0
        product = len(series1) * len(series2)
        similarity = unionLen / sqrt(product)
        return similarity
    # 根据相似度得到10个相邻用户
    def getNeighbor(self, userId, courseId):
        user = self.formatuserDict(userId,courseId)
        sim = {}
        for k in user:
            # 获得userId和k用户的观看过的课程的列表
            listA = self.userDict[str(userId)]
            listB = self.userDict[str(k)]
            # ret = self.jiaoji(listA, listB)
            # Similarity = len(ret)/len(listA)
            # 计算余弦相似度
            Similarity = self.calcuteSimilar(listA, listB)
            sim[k] = Similarity
        # 根据字典的值（相似度）进行排序
        sim = sorted(sim.items(), key=lambda x: x[1], reverse=True)
        top = 10
        # total为相邻用户的个数
        total = len(sim)
        # 如果相邻用户个数小于十，有几个算几个
        if total<10: top = total
        # print('top = %d,total = %d'%(top,total))
        sim = sim[-top:]
        # print("相邻用户："+str(sim))
        # 返回前十个（不足十的有几个返几个）
        return sim,total



    def diff(self,listA,listB):
        # 求差集
        retD = list(set(listB).difference(set(listA)))
        return retD
    # 去掉列表中的重复元素
    def cutsimple(self,one_list):

        temp_list = {}
        # 推荐列表中出现次数越多的权重越大
        for one in one_list:
            if one not in temp_list:
                temp_list[one]=1
            else:
                tempnum = temp_list[one]
                temp_list[one] = int(tempnum)+1
        # 根据权重排序
        sorted(temp_list.items(), key=lambda x: x[1])

        return list(temp_list.keys())

    # 获得热门的课程的列表
    def getpopularList(self):

        dict2 = {}
        for i in self.ItemUser.items():
            a = i[0]
            b = len(i[1])
            dict2[a] = b
        newd = sorted(dict2.items(), key=lambda x: x[1], reverse=True)
        return newd


    # 获得推荐结果
    def getrecommandList(self, userId,courseId):

        # 得到由大到小排序好的相似度字典
        sim,total = self.getNeighbor(userId,courseId)

        result = []
        for i in range(len(sim)):
            # 取第i个作为推荐用户
            comuserId = sim[i][0]
            # 获得与目标用户的差集
            ret = self.diff(self.userDict[str(userId)], self.userDict[str(comuserId)])

            # 获得推荐结果集
            result += ret
        result = self.cutsimple(result)

        if len(result)>=5:
            result = result[0:5]
        else:# 推荐课程数量不足，原因是没有足够的相邻用户
            if total<10:
                # 找出最热门的课程的列表
                newd = self.getpopularList()

                # 差几个添几个
                addrecom = 5-len(result)
                for i in range(addrecom):
                    result.append(newd[i][0])

        return result









# 获取数据

def readFile(filename):
    files = open(filename, "r", encoding="utf-8")

    data = []

    for line in files.readlines():
        item = line.strip().split(",")

        data.append(item)

    return data

    files.close()


def load_dict_from_file(filepath):
    _dict = {}

    try:

        with open(filepath, 'r', encoding="utf -8") as dict_file:

            for line in dict_file.readlines():
                (key, value) = line.strip().split(':')

                _dict[key] = value

    except IOError as ioerr:

        print("文件 %s 不存在" % (filepath))

    return _dict


def save_dict_to_file(_dict, filepath):
    try:

        with open(filepath, 'w', encoding="utf - 8") as dict_file:

            for (key, value) in _dict.items():
                dict_file.write('%s:%s\n' % (key, value))



    except IOError as ioerr:

        print("文件 %s 无法创建" % (filepath))


def writeFile(data, filename):
    with open(filename, 'w', encoding="utf-8")as f:
        f.write(data)



def startcom(uid,cid):

        # 读文件
        ratings = readFile("D:/recommend.txt")

        demo = CF(ratings, k=5)

        demo.formatRate(ratings)
        # 设置参数
        userId = uid
        courseId = cid
        # 获得推荐序列
        l = demo.getrecommandList(userId,courseId)

        # 按1，2，3，4，5格式输出推荐序列
        resultstr =''
        for i in range(0,5):
            if i<4:
                resultstr += l[i]+','
            else:
                resultstr += l[i]
        print(resultstr)
if __name__ == '__main__':

    a = []
    # 接收从java传来的参数
    for i in range(1, len(sys.argv)):
        a.append((int(sys.argv[i])))
    # 调用方法计算推荐序列
    startcom(a[0],a[1])



