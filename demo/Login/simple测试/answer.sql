/*
Navicat MySQL Data Transfer

Source Server         : zch
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : psychological

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2018-12-25 17:21:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `answerId` int(11) NOT NULL AUTO_INCREMENT,
  `askId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `answerContent` text,
  `answerAnswerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `answerGoodCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '1', '4', '情是1111', '2018-11-20 22:00:44', '10');
INSERT INTO `answer` VALUES ('2', '1', '5', '情是222', '2018-11-20 22:00:45', '20');
INSERT INTO `answer` VALUES ('3', '2', '5', '爱', '2018-11-20 22:00:47', '10');
INSERT INTO `answer` VALUES ('4', '2', '6', '不爱', '2018-11-20 22:00:48', '11');
INSERT INTO `answer` VALUES ('5', '2', '7', '哎什么哎', '2018-11-20 22:00:50', '12');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(11) NOT NULL AUTO_INCREMENT,
  `articleName` varchar(100) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `articleImgPath` varchar(1024) DEFAULT NULL,
  `articleIntroduction` varchar(1024) DEFAULT NULL,
  `articleContent` text,
  `articlePublishTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `articleLookNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '给青少年的一封信', '4', 'passage.jpeg', '魏老师的文章', '<p>听众故事：</p> ', '2018-12-17 15:32:52', '98');
INSERT INTO `article` VALUES ('2', '婚姻中的小事', '7', 'passage.jpeg', '孙老师的文章', '孙老师带你一起探索婚姻中的那些小事', '2018-12-17 14:39:04', '79');
INSERT INTO `article` VALUES ('3', '正确的人生观', '5', 'passage.jpeg', '邓老师的文章', '三观端正', '2018-12-17 14:48:13', '60');
INSERT INTO `article` VALUES ('4', '计算机', '4', 'passage.jpeg', '萨达是的范德萨', '<p>暗室逢灯三</p>', '2018-12-21 16:24:26', '317');
INSERT INTO `article` VALUES ('5', '蔚蓝', '5', 'passage.jpeg', '作为一名入党积极分子，我一直以一名党员的准则要求自己。严格规范自己的行为，同时也在思想上提高自己的觉', '<p style=\"text-indent:28px\"><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">首先，作为大学生，要树立正确的人生观、价值观，做有理想的人，有了远大的理想，我们的人生追求才能更高，人生步履才能更坚实，人生价值才能更美好，才能更好地为人民服务。那什么是理想呢?理想是人们对美好未来的向往和追求。对于我们来说，理想是人生的指路明灯。如果把人生比作在茫茫大海中航行，那么，理想就是前进的灯塔。有了崇高的理想，我们才能志存高远，心地宽广，跳出个人的小圈子，摆脱种种忧虑和烦恼，始终沿着正确的方向扬帆远航。理想又是人生前进的动力。在奋斗进取的征程中，谁都不可能万事如意，一帆风顺。</span></p><p style=\"text-indent:28px\"><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\"><img src=\"/psychologicalcounseling/images/20181204/1543903341201034202.png\" title=\"1543903341201034202.png\" alt=\"捕获3.png\"/></span></p><p><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">我们党从诞生的那天起，就把实现共产主义作为崇高的奋斗目标。按照革命导师马克思的描述，未来的共产主义社会，是没有阶级，没有剥削，社会产品极大丰富，劳动成为生活的第一需要的社会，社会在自己的旗帜上写着“各尽所能、按需分配”八个大字。这样的社会，是人类历史上最美好、最进步的社会。从资本主义走向社会主义、共产主义，是人类社会发展的必然规律。实现共产主义的伟大理想，需要一代又一代人长期不懈奋斗。我们年青人是共产主义理想的实践者，不能因为目标遥远，就放松今日的努力。要牢记这个大目标，脚踏实地、锲而不舍地努力学习、工作，为实现共产主义贡献自己毕生的光和热。</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 其次，<span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">要加强党性修养，要学会用自己的头脑来思考问题。要阅读马列原著，毛泽东选集和邓小平理论，培养自己的党员修养。今天的社会是一个变化的社会，我们身边的人、事、物都会不时地发生变化，但是真理是不变的，大学生党员要学会以不变应万变。平时注意党性修养的培养，才能抵挡住不良诱惑的影响，适应复杂的社会。一个党员的形象，直接影响着党的形象，影响着党在人民群众中的威信，影响着党的性质和战斗力，我们作为学生党员要十分重视发挥自己身为党员的作用，以此来影响周围的同学。从自身抓起，从小事做起，对学习刻苦努力，对工作有创新精神，注重思想上的学习，全心全意地为同学和他人服务，敢于进行批评和自我批评，在不断地学习中完善自我。同时，只能独善其身，而不会做群众工作和不善于做群众工作，认为只要自己管好自己就行了，别人怎样不用去管，或根本不想管，其实这是不正确的，也是不符合作为积极分子要求的。作为一个学生积极分子，不仅要保持自己的先进性，同时，要用先进性来带动并作为开展工作的基础。要在自己不断进取的同时，坚持与同学共勉，互帮互学，共同进步。</span></p><p><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\"><img src=\"/psychologicalcounseling/images/20181204/1543903378043066974.png\" title=\"1543903378043066974.png\" alt=\"捕获.png\" width=\"1060\" height=\"389\"/></span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 最后，<span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">作为一名积极分子，我们应有高度的政治觉悟。虽然现在我国经济各方面都有空前的发展，但仍然有很多敌视社会主义尤其是社会主义中国的敌对势力存在，而且，我国当今的社会正处于一个转型时期，很多人的政治立场和价值观难免会发生偏移，这一切都要求我们入党积极分子因该旗帜鲜明，摆正我们的政治立场，拥有崇高的政治追求，积极入党，积极地投身于社会主义中国的现代化建设中去。要想成为一名合格的党员，提高自身的综合素质，加强党员的修养，很有必要性，我们每一位入党积极分子都应该努力学习，不断地提高自身的修养，争取早日成为一名合格的共产党员。所以这次学习是对于我个人灵魂的洗礼。现在我认识到了入党不仅是一种光荣，更重要的是应该有坚定的信仰，为我们党的事业出谋划策，用更多的热情和更好的务实精神支持党的共产主义伟大事业，要坦率真诚，相信党组织。经常开展批评与自我批评，使自己在思想上与党组织靠近，加强自己在社会实践各方面的锻炼，严格要求自己的一言一行，争取早日加入我们的中国共产党并且成为其优秀的一员，用党的思想来武装自己，深刻理解里面的精髓，用于指导实际行动</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">　这就是我成为积极分子这一季度的思想汇报，有不足之处，希望组织予以批评。我一定全力改正，争取早日成为一名合格的共产党员。</span></p><p><br/></p>', '2018-12-24 16:33:12', '131');
INSERT INTO `article` VALUES ('6', '智障', '7', 'passage.jpeg', '首先，作为大学生，要树立正确的人生观、价值观，做有理想的人，有了远大的理想，我们的人生', '<p style=\"margin-top: 0px; margin-bottom: 10px; box-sizing: border-box; color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; white-space: normal; background-color: rgba(255, 255, 255, 0.6);\"><span style=\"margin: 0px auto; box-sizing: border-box; font-family: 微软雅黑, sans-serif; color: rgb(102, 102, 102);\">我们党从诞生的那天起，就把实现共产主义作为崇高的奋斗目标。按照革命导师马克思的描述，未来的共产主义社会，是没有阶级，没有剥削，社会产品极大丰富，劳动成为生活的第一需要的社会，社会在自己的旗帜上写着“各尽所能、按需分配”八个大字。这样的社会，是人类历史上最美好、最进步的社会。从资本主义走向社会主义、共产主义，是人类社会发展的必然规律。实现共产主义的伟大理想，需要一代又一代人长期不懈奋斗。我们年青人是共产主义理想的实践者，不能因为目标遥远，就放松今日的努力。要牢记这个大目标，脚踏实地、锲而不舍地努力学习、工作，为实现共产主义贡献自己毕生的光和热。</span></p><p style=\"margin-top: 0px; margin-bottom: 10px; box-sizing: border-box; color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; white-space: normal; background-color: rgba(255, 255, 255, 0.6);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 其次，<span style=\"margin: 0px auto; box-sizing: border-box; font-family: 微软雅黑, sans-serif; color: rgb(102, 102, 102);\">要加强党性修养，要学会用自己的头脑来思考问题。要阅读马列原著，毛泽东选集和邓小平理论，培养自己的党员修养。今天的社会是一个变化的社会，我们身边的人、事、物都会不时地发生变化，但是真理是不变的，大学生党员要学会以不变应万变。平时注意党性修养的培养，才能抵挡住不良诱惑的影响，适应复杂的社会。一个党员的形象，直接影响着党的形象，影响着党在人民群众中的威信，影响着党的性质和战斗力，我们作为学生党员要十分重视发挥自己身为党员的作用，以此来影响周围的同学。从自身抓起，从小事做起，对学习刻苦努力，对工作有创新精神，注重思想上的学习，全心全意地为同学和他人服务，敢于进行批评和自我批评，在不断地学习中完善自我。同时，只能独善其身，而不会做群众工作和不善于做群众工作，认为只要自己管好自己就行了，别人怎样不用去管，或根本不想管，其实这是不正确的，也是不符合作为积极分子要求的。作为一个学生积极分子，不仅要保持自己的先进性，同时，要用先进性来带动并作为开展工作的基础。要在自己不断进取的同时，坚持与同学共勉，互帮互学，共同进步。</span></p><p style=\"margin-top: 0px; margin-bottom: 10px; box-sizing: border-box; color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; white-space: normal; background-color: rgba(255, 255, 255, 0.6);\"><span style=\"margin: 0px auto; box-sizing: border-box; font-family: 微软雅黑, sans-serif; color: rgb(102, 102, 102);\"><img src=\"/psychologicalcounseling/images/20181205/1543968884306089853.png\" title=\"1543968884306089853.png\" alt=\"捕获3.png\" width=\"918\" height=\"563\"/></span></p><p style=\"margin-top: 0px; margin-bottom: 10px; box-sizing: border-box; color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; white-space: normal; background-color: rgba(255, 255, 255, 0.6);\">&nbsp;最后，<span style=\"margin: 0px auto; box-sizing: border-box; font-family: 微软雅黑, sans-serif; color: rgb(102, 102, 102);\">作为一名积极分子，我们应有高度的政治觉悟。虽然现在我国经济各方面都有空前的发展，但仍然有很多敌视社会主义尤其是社会主义中国的敌对势力存在，而且，我国当今的社会正处于一个转型时期，很多人的政治立场和价值观难免会发生偏移，这一切都要求我们入党积极分子因该旗帜鲜明，摆正我们的政治立场，拥有崇高的政治追求，积极入党，积极地投身于社会主义中国的现代化建设中去。要想成为一名合格的党员，提高自身的综合素质，加强党员的修养，很有必要性，我们每一位入党积极分子都应该努力学习，不断地提高自身的修养，争取早日成为一名合格的共产党员。所以这次学习是对于我个人灵魂的洗礼。现在我认识到了入党不仅是一种光荣，更重要的是应该有坚定的信仰，为我们党的事业出谋划策，用更多的热情和更好的务实精神支持党的共产主义伟大事业，要坦率真诚，相信党组织。经常开展批评与自我批评，使自己在思想上与党组织靠近，加强自己在社会实践各方面的锻炼，严格要求自己的一言一行，争取早日加入我们的中国共产党并且成为其优秀的一员，用党的思想来武装自己，深刻理解里面的精髓，用于指导实际行动</span></p><p style=\"margin-top: 0px; margin-bottom: 10px; box-sizing: border-box; color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; white-space: normal; background-color: rgba(255, 255, 255, 0.6);\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"margin: 0px auto; box-sizing: border-box; font-family: 微软雅黑, sans-serif; color: rgb(102, 102, 102);\">　这就是我成为积极分子这一季度的思想汇报，有不足之处，希望组织予以批评。我一定全力改正，争取早日成为一名合格的共产党员。</span></p><p><br/></p>', '2018-12-17 15:32:44', '119');
INSERT INTO `article` VALUES ('8', 'dasfs', '4', 'passage.jpeg', '杀掉对方是', '<p>发的说法</p>', '2018-12-17 13:52:44', '0');
INSERT INTO `article` VALUES ('9', '发的', '7', 'passage.jpeg', '发生', '<p>浮点数</p>', '2018-12-17 13:52:40', '0');
INSERT INTO `article` VALUES ('10', '魏智障', '7', 'passage.jpeg', '水电费卡拉拉', '<p><img src=\"/psychologicalcounseling/images/20181206/1544056867870091741.png\" title=\"1544056867870091741.png\" alt=\"捕获2.png\"/></p><p>阿斯蒂芬甲氨蝶呤开发会计师对方哈看见东方航空</p>', '2018-12-17 15:32:49', '53');
INSERT INTO `article` VALUES ('11', '师范大学', '7', 'passage.jpeg', '煞风景爱丽丝看风景', '<p><img src=\"/psychologicalcounseling/images/20181208/1544269989303045201.png\" title=\"1544269989303045201.png\" alt=\"捕获2.png\"/></p>', '2018-12-17 13:52:45', '0');
INSERT INTO `article` VALUES ('12', '法撒旦法', '7', 'passage.jpeg', '是发送到', '<p>萨法</p>', '2018-12-17 14:48:16', '2');
INSERT INTO `article` VALUES ('13', '计算机', '6', 'passage.jpeg', '计算机网络原理', '<p><img src=\"/psychologicalcounseling/images/20181213/1544661441346099737.jpg\" title=\"1544661441346099737.jpg\" alt=\"蓝莲花.jpg\"/></p>', '2018-12-17 14:46:52', '4');
INSERT INTO `article` VALUES ('14', '孙明伟', '7', 'passage.jpeg', '敬爱的华东师范看见爱上电话费卡数据的', '<p><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">作为一名入党积极分子，我一直以一名党员的准则要求自己。严格规范自己的行为，同时也在思想上提高自己的觉悟，积极为成为一名光荣的共产党员而准备着。因为我知道，党对于她的成员的要求是非常严格的。下面是我这一季度中的思想转变，请组织审核。</span></p><p style=\"text-indent:28px\"><a><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">首先，作为大学生，要树立正确的人生观、价值观，做有理想的人，有了远大的理想，我们的人生追求才能更高，人生步履才能更坚实，人生价值才能更美好，才能更好地为人民服务。那什么是理想呢?理想是人们对美好未来的向往和追求。对于我们来说，理想是人生的指路明灯。如果把人生比作在茫茫大海中航行，那么，理想就是前进的灯塔。有了崇高的理想，我们才能志存高远，心地宽广，跳出个人的小圈子，摆脱种种忧虑和烦恼，始终沿着正确的方向扬帆远航。理想又是人生前进的动力。在奋斗进取的征程中，谁都不可能万事如意，一帆风顺。</span></a></p><p><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">我们党从诞生的那天起，就把实现共产主义作为崇高的奋斗目标。按照革命导师马克思的描述，未来的共产主义社会，是没有阶级，没有剥削，社会产品极大丰富，劳动成为生活的第一需要的社会，社会在自己的旗帜上写着“各尽所能、按需分配”八个大字。这样的社会，是人类历史上最美好、最进步的社会。从资本主义走向社会主义、共产主义，是人类社会发展的必然规律。实现共产主义的伟大理想，需要一代又一代人长期不懈奋斗。我们年青人是共产主义理想的实践者，不能因为目标遥远，就放松今日的努力。要牢记这个大目标，脚踏实地、锲而不舍地努力学习、工作，为实现共产主义贡献自己毕生的光和热。</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 其次，<span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">要加强党性修养，要学会用自己的头脑来思考问题。要阅读马列原著，毛泽东选集和邓小平理论，培养自己的党员修养。今天的社会是一个变化的社会，我们身边的人、事、物都会不时地发生变化，但是真理是不变的，大学生党员要学会以不变应万变。平时注意党性修养的培养，才能抵挡住不良诱惑的影响，适应复杂的社会。一个党员的形象，直接影响着党的形象，影响着党在人民群众中的威信，影响着党的性质和战斗力，我们作为学生党员要十分重视发挥自己身为党员的作用，以此来影响周围的同学。从自身抓起，从小事做起，对学习刻苦努力，对工作有创新精神，注重思想上的学习，全心全意地为同学和他人服务，敢于进行批评和自我批评，在不断地学习中完善自我。同时，只能独善其身，而不会做群众工作和不善于做群众工作，认为只要自己管好自己就行了，别人怎样不用去管，或根本不想管，其实这是不正确的，也是不符合作为积极分子要求的。作为一个学生积极分子，不仅要保持自己的先进性，同时，要用先进性来带动并作为开展工作的基础。要在自己不断进取的同时，坚持与同学共勉，互帮互学，共同进步。</span></p><p><span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\"><img src=\"/psychologicalcounseling/images/20181213/1544664312238059606.jpg\" title=\"1544664312238059606.jpg\" alt=\"蓝莲花.jpg\"/></span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 最后，<span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">作为一名积极分子，我们应有高度的政治觉悟。虽然现在我国经济各方面都有空前的发展，但仍然有很多敌视社会主义尤其是社会主义中国的敌对势力存在，而且，我国当今的社会正处于一个转型时期，很多人的政治立场和价值观难免会发生偏移，这一切都要求我们入党积极分子因该旗帜鲜明，摆正我们的政治立场，拥有崇高的政治追求，积极入党，积极地投身于社会主义中国的现代化建设中去。要想成为一名合格的党员，提高自身的综合素质，加强党员的修养，很有必要性，我们每一位入党积极分子都应该努力学习，不断地提高自身的修养，争取早日成为一名合格的共产党员。所以这次学习是对于我个人灵魂的洗礼。现在我认识到了入党不仅是一种光荣，更重要的是应该有坚定的信仰，为我们党的事业出谋划策，用更多的热情和更好的务实精神支持党的共产主义伟大事业，要坦率真诚，相信党组织。经常开展批评与自我批评，使自己在思想上与党组织靠近，加强自己在社会实践各方面的锻炼，严格要求自己的一言一行，争取早日加入我们的中国共产党并且成为其优秀的一员，用党的思想来武装自己，深刻理解里面的精髓，用于指导实际行动</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style=\"font-family:&#39;微软雅黑&#39;,sans-serif;color:#666666\">　这就是我成为积极分子这一季度的思想汇报，有不足之处，希望组织予以批评。我一定全力改正，争取早日成为一名合格的共产党员。</span></p><p>&nbsp;</p><p>汇报人：孙明伟</p><p>&nbsp;&nbsp; 年&nbsp; 月&nbsp; 日</p><p>&nbsp;</p><p>&nbsp;</p><p style=\"margin-left:24px\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <span style=\"font-size: 16px\">&nbsp;</span><span style=\"font-size: 16px\">思想汇报</span></p><p><span style=\"font-size:16px\">敬爱的党组织：</span></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 　<span style=\"font-size:16px;color:#666666\">自科学发展观提出以来</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">越来越显示出强大的真理力量</span><span style=\"font-size: 16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">越来越得到全党全国人民的高度认同。新世纪新阶段</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">我们必须立足当前国际国内形势的发展变化和党的建设面临的新情况</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">进一步增强学习实践科学发展观的自觉性和坚定性。　　</span></p><p style=\"text-indent:28px\"><span style=\"font-size:16px;color:#666666\">一、科学发展观第一要义是发展。　但是</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">在学习领会科学发展观的时候</span><span style=\"font-size: 16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">要注意我们所讲的发展是包括而又不等同于经济增长的发展。科学发展观的第一要义是发展</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">不讲发展的发展观绝不是科学发展观</span><span style=\"font-size: 16px;font-family:&#39;simsun&#39;,serif;color:#666666\">;</span><span style=\"font-size:16px;color:#666666\">发展要坚持以经济建设为中心</span><span style=\"font-size: 16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">只有不断解放和发展社会生产力</span><span style=\"font-size: 16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">才能为社会全面进步和人的全面发展奠定坚实的物质基础。　　</span></p><p style=\"text-indent:28px\"><span style=\"font-size:16px;color:#666666\">二、以人为本是科学发展观的本质和核心。　　坚持以人为本，就要始终坚持人民在中国特色社会主义事业中的主体发展愿望和多样性需求，关心人的价值、权益和自由，关注人们的生活质量、发展潜能和幸福指数，体现社会主义的人道主义和人文关怀，促进人的全面发展。落实科学发展观，必须坚持以人为本，切实维护广大人民群众的根本利益。坚持以人为本，是党的先进性的重要体现。　　三、全面协调可持续是科学发展观的基本要求。　　过去发达国家的发展之路往往是以破坏或掠夺地球资源而付出惨痛代价的。因此，我们现在要以新时代、新理念，从更高的层次上描绘的我们的发展之路：</span></p><p style=\"text-indent:28px\"><span style=\"font-size:16px;color:#666666\">通过不间断的学习，我认为，提高学习实践科学发展观的自觉性和坚定性</span><span style=\"font-size:16px;font-family:&#39;simsun&#39;,serif;color:#666666\">,</span><span style=\"font-size:16px;color:#666666\">是适应国内新形势、新任务的需要。　</span></p><p></p>', '2018-12-17 14:41:25', '4');
INSERT INTO `article` VALUES ('15', '魏智障', '7', 'passage.jpeg', '士大夫撒发生', '<p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">听别人的故事，解自己的疑惑，这里是由心理FM&amp;壹心理咨询联合出品的心事博物馆，如果你有解不开的困惑，点击“心事铺”写下你的心事，听听咨询师们用专业且温暖的话给你一点点小建议。下载心理FM APP搜索“心事博物馆”就能找到我们的全部节目。<br/>\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">今天我们邀请到心理咨询师广梅芳老师和我们一起倾听心事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">听众故事：</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">老师您好，我是男生，正在一段即将走进婚姻的恋情里，但近期我和女友矛盾越来越多，开始感觉身心疲惫，甚至想要终止这段感情以获得解脱。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友是南方人，我是北方人，在一起四年。女友为了我放弃了原来的工作来到北京。但我家担心我俩结合生活压力过大反对我们在一起，后来因为我坚持家人同意。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友和我家人关系不好，第一次见家长和后面接触都有矛盾，女友通常不高兴就会躲着所有人，我们经常都不知道为什么。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我父母因病因伤有残疾，筹备婚礼颇为费力。我在外地帮不上通常会按照他们的意思来，女友也表示入乡随俗。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友对婚礼过问很少，对筹备的大小事情都不关心，少数事情上又特别坚持，我家人有些不高兴。我和她商量婚礼她都不耐烦，我性情火爆有时跟她争辩，她就冷处理一星期不说话，对我家人的态度也越来越抵触。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我当下十分困惑，我和女友龃龉时她倾向于冷处理，不说话，长时间不回家，拒绝沟通；而我尝试平静沟通无果后就会十分焦躁，会忍不住发脾气，可能潜意识里希望通过这种方式得到回应，于是她更不愿意沟通，如此恶性循环。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">当下的主要矛盾是她和我家人关系很僵，我家人频繁示好她都回避，和我父母接触时她会刻意躲避，我不知道如何调和。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">她告诉我她与我家人意见不同或者生活习惯冲突时我总是倾向于站在我家人这边，要求她迁就，她背井离乡没有安全感；我父母没有劳动和生活能力也让她压力很大。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">近期已经数次提出分手，并且都很认真，感觉对结婚不抱有期待。最近我俩冷战频繁，我也完全没有要结婚了的喜悦心情。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我该如何处理我、女友和家人的关系，如何能打破无法沟通的僵局？</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">经历了四年的风风雨雨，克服了异地、家人反对等种种困难，最后终于决定一起走进婚姻，却在结婚前发生了矛盾。怎样解决这些矛盾呢？接下来我们听听咨询师广梅芳老师的回信。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">一段感情走了这么久，经过许多风风雨雨，直到要进入婚姻的殿堂，是非常不容易的。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我可以从信中看到你对这份感情的珍惜，但也能看到你深深的挫折感。你鼓起勇气写这封信，是希望再一次试着为这份关系和为你自己努力一次。根据你的来信，给你以下3点建议。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">首先，筹备结婚是一个压力指数非常大的事情，这个压力的程度不亚于生老病死和失业搬家，许多许多人都在结婚前情绪起伏非常大，会感觉到前无未有的压力。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">但因为结婚是一件喜事，所以很多人会忽略【准备结婚】其实是一段需要特别注意的【高压情绪危险期】。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">除了很多婚礼细节要操办，更让人紧张的是，结婚代表了两个人从此是不离不弃的亲人，同时也要和对方的家人成为家人，这么多的人生变化，怎么能让人不情绪紧绷呢？更何况你女友来自远方，身边没有太多的亲人和闺蜜，感受到的压力就又要更大些。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">从你的文中可以看到，你的女友其实算大致是配合你家人的筹备，只是【少数事情特别坚持】。那你要想想是什么事情她特别坚持呢？如果她只有少数事情特别有要求，这代表这些事应该是她特别在意的。当一个人特别坚持的时候，通常是戳中她的一些核心价值和痛处，基于对她的爱和尊重，在这些事情上是否能听一下她的想法呢？</p><p style=\"text-align: center;\"><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://localhost:8080/psychologicalcounseling/images/20181213/1544669891216015018.jpg\" title=\"1544669891216015018.jpg\" alt=\"蓝莲花.jpg\"/></span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">第二点，是关于细节讨论的部分，这涉及到每个人不同的沟通方式。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">看起来，你的女朋友是比较内向而不善于讨论的人，尤其是在她情绪激动的时候，她会选择不说话和不回应一阵子，这可以从她躲避你的家人，以及一星期不说话来处理。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">而你是热火脾气，恨不得马上摊开来讲，所以遇到她这样的冷态度，会特别的难受和愤怒，反应就会更为火爆，而这样她就躲更远。建议你们找一个大家都心平气和的时候，找出一个双方都同意的沟通方式：一个不以【我觉得】和【我认为】为开头语的讲话方式，而是以表达【爱】和【尊重】为主的交流。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">用一些方法避免因过于激动导致吵架，比如说当你声音越来愈大的时候，她可以举起右手，希望你降低声量。而当她又开始不说话的时候，你也可以举起右手，希望她可以说或者写十个字以内的句子给你。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">重点在于，双方都要尊重对方的沟通方式，但是不能过度挥洒自己的既定模式，不要大声的言语暴力，但也不要不理不睬的冷暴力。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">最后一个你提出的问题是：怎么处理女友和家人的关系</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我的建议是，既然女友对于和你家人相处有压力，那就先尽量减少两边相处的机会，慢慢来。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">你和你的家人相处融洽，除了血亲之外，还有几十年的相处默契，她作为一个新加入的人，要让她用她自己的节奏慢慢熟悉这个新的家庭。毕竟亲人相处是【质】比【量】要更重要，先用一些短而美好的相处，让她放松再慢慢培养之后的关系。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">最后，希望你们之间可以往美好的方向前进。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">那以上就是心事博物馆里收藏的第35个心事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">如果你也有自己的心事，欢迎点击“心事铺”告诉我们关于你的故事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">愿每个孤独的灵魂都被拥抱，每段心事都被温柔抚平，这里是心理FM&amp;壹心理咨询联合出品的心事博物馆，我们下期再见。</p><p><br/></p>', '2018-12-17 13:52:52', '0');
INSERT INTO `article` VALUES ('16', '魏智障', '7', 'passage.jpeg', '士大夫撒发生', '<p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">听别人的故事，解自己的疑惑，这里是由心理FM&amp;壹心理咨询联合出品的心事博物馆，如果你有解不开的困惑，点击“心事铺”写下你的心事，听听咨询师们用专业且温暖的话给你一点点小建议。下载心理FM APP搜索“心事博物馆”就能找到我们的全部节目。<br/>\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">今天我们邀请到心理咨询师广梅芳老师和我们一起倾听心事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">听众故事：</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">老师您好，我是男生，正在一段即将走进婚姻的恋情里，但近期我和女友矛盾越来越多，开始感觉身心疲惫，甚至想要终止这段感情以获得解脱。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友是南方人，我是北方人，在一起四年。女友为了我放弃了原来的工作来到北京。但我家担心我俩结合生活压力过大反对我们在一起，后来因为我坚持家人同意。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友和我家人关系不好，第一次见家长和后面接触都有矛盾，女友通常不高兴就会躲着所有人，我们经常都不知道为什么。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我父母因病因伤有残疾，筹备婚礼颇为费力。我在外地帮不上通常会按照他们的意思来，女友也表示入乡随俗。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">女友对婚礼过问很少，对筹备的大小事情都不关心，少数事情上又特别坚持，我家人有些不高兴。我和她商量婚礼她都不耐烦，我性情火爆有时跟她争辩，她就冷处理一星期不说话，对我家人的态度也越来越抵触。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我当下十分困惑，我和女友龃龉时她倾向于冷处理，不说话，长时间不回家，拒绝沟通；而我尝试平静沟通无果后就会十分焦躁，会忍不住发脾气，可能潜意识里希望通过这种方式得到回应，于是她更不愿意沟通，如此恶性循环。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">当下的主要矛盾是她和我家人关系很僵，我家人频繁示好她都回避，和我父母接触时她会刻意躲避，我不知道如何调和。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">她告诉我她与我家人意见不同或者生活习惯冲突时我总是倾向于站在我家人这边，要求她迁就，她背井离乡没有安全感；我父母没有劳动和生活能力也让她压力很大。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">近期已经数次提出分手，并且都很认真，感觉对结婚不抱有期待。最近我俩冷战频繁，我也完全没有要结婚了的喜悦心情。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我该如何处理我、女友和家人的关系，如何能打破无法沟通的僵局？</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">经历了四年的风风雨雨，克服了异地、家人反对等种种困难，最后终于决定一起走进婚姻，却在结婚前发生了矛盾。怎样解决这些矛盾呢？接下来我们听听咨询师广梅芳老师的回信。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">一段感情走了这么久，经过许多风风雨雨，直到要进入婚姻的殿堂，是非常不容易的。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我可以从信中看到你对这份感情的珍惜，但也能看到你深深的挫折感。你鼓起勇气写这封信，是希望再一次试着为这份关系和为你自己努力一次。根据你的来信，给你以下3点建议。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">首先，筹备结婚是一个压力指数非常大的事情，这个压力的程度不亚于生老病死和失业搬家，许多许多人都在结婚前情绪起伏非常大，会感觉到前无未有的压力。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">但因为结婚是一件喜事，所以很多人会忽略【准备结婚】其实是一段需要特别注意的【高压情绪危险期】。</p><p style=\"text-align: center;\"><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://localhost:8080/psychologicalcounseling/images/20181213/1544670011987065592.jpg\" title=\"1544670011987065592.jpg\" alt=\"蓝莲花.jpg\"/></span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">除了很多婚礼细节要操办，更让人紧张的是，结婚代表了两个人从此是不离不弃的亲人，同时也要和对方的家人成为家人，这么多的人生变化，怎么能让人不情绪紧绷呢？更何况你女友来自远方，身边没有太多的亲人和闺蜜，感受到的压力就又要更大些。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">从你的文中可以看到，你的女友其实算大致是配合你家人的筹备，只是【少数事情特别坚持】。那你要想想是什么事情她特别坚持呢？如果她只有少数事情特别有要求，这代表这些事应该是她特别在意的。当一个人特别坚持的时候，通常是戳中她的一些核心价值和痛处，基于对她的爱和尊重，在这些事情上是否能听一下她的想法呢？</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">第二点，是关于细节讨论的部分，这涉及到每个人不同的沟通方式。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">看起来，你的女朋友是比较内向而不善于讨论的人，尤其是在她情绪激动的时候，她会选择不说话和不回应一阵子，这可以从她躲避你的家人，以及一星期不说话来处理。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">而你是热火脾气，恨不得马上摊开来讲，所以遇到她这样的冷态度，会特别的难受和愤怒，反应就会更为火爆，而这样她就躲更远。建议你们找一个大家都心平气和的时候，找出一个双方都同意的沟通方式：一个不以【我觉得】和【我认为】为开头语的讲话方式，而是以表达【爱】和【尊重】为主的交流。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">用一些方法避免因过于激动导致吵架，比如说当你声音越来愈大的时候，她可以举起右手，希望你降低声量。而当她又开始不说话的时候，你也可以举起右手，希望她可以说或者写十个字以内的句子给你。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">重点在于，双方都要尊重对方的沟通方式，但是不能过度挥洒自己的既定模式，不要大声的言语暴力，但也不要不理不睬的冷暴力。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">最后一个你提出的问题是：怎么处理女友和家人的关系</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">我的建议是，既然女友对于和你家人相处有压力，那就先尽量减少两边相处的机会，慢慢来。</p><p style=\"text-align: center;\"><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">你和你的家人相处融洽，除了血亲之外，还有几十年的相处默契，她作为一个新加入的人，要让她用她自己的节奏慢慢熟悉这个新的家庭。毕竟亲人相处是【质】比【量】要更重要，先用一些短而美好的相处，让她放松再慢慢培养之后的关系。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">最后，希望你们之间可以往美好的方向前进。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">那以上就是心事博物馆里收藏的第35个心事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">如果你也有自己的心事，欢迎点击“心事铺”告诉我们关于你的故事。</p><p><span style=\"color: rgb(70, 70, 70); font-family: &quot;Helvetica Neue&quot;, Helvetica, Tahoma, Arial, &quot;Microsoft Yahei&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 14px; letter-spacing: 1.4px; text-indent: 28px; text-shadow: none;\">\r\n &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p><p style=\"background-attachment: scroll; background-clip: border-box; background-image: none; background-origin: padding-box; background-position: 0% 0%; background-repeat: repeat; background-size: auto; box-sizing: border-box; color: rgb(70, 70, 70); font-size: 14px; letter-spacing: 1.4px; margin-bottom: 10px; margin-top: 0px; text-indent: 28px; text-shadow: none; white-space: normal;\">愿每个孤独的灵魂都被拥抱，每段心事都被温柔抚平，这里是心理FM&amp;壹心理咨询联合出品的心事博物馆，我们下期再见。</p><p><br/></p>', '2018-12-17 13:52:53', '0');
INSERT INTO `article` VALUES ('17', '魏智障', '7', 'passage.jpeg', '士大夫撒发生', '和大家发生口角客家话艰苦的 和实践活动福建省加快', '2018-12-24 10:51:41', '0');
INSERT INTO `article` VALUES ('18', '发发地方所得税地方', '7', 'passage.jpeg', '法撒旦法', '<p>从许昌阿范德萨发士大夫撒地方的萨芬撒地方士大夫撒是打发撒大发送到发送到发<br/></p>', '2018-12-17 14:48:09', '2');
INSERT INTO `article` VALUES ('19', '地方都是格式的', '7', 'passage.jpeg', '法发顺丰的', '<p>大</p>', '2018-12-17 15:32:55', '9');
INSERT INTO `article` VALUES ('20', '地方都是格式的', '7', 'passage.jpeg', '法发顺丰的', '<p>大</p>', '2018-12-17 13:55:20', '0');
INSERT INTO `article` VALUES ('21', '发达的第三方', '4', 'passage.jpeg', '法发顺丰的', '<p><img src=\"/psychologicalcounseling/images/20181214/1544777127745088194.jpg\" title=\"1544777127745088194.jpg\" alt=\"蓝莲花.jpg\"/></p></p>', '2018-12-17 15:32:58', '6');
INSERT INTO `article` VALUES ('22', '发达的第三方', '4', 'passage.jpeg', '法发顺丰的', '<p><img src=\"/psychologicalcounseling/images/20181214/1544777127745088194.jpg\" title=\"1544777127745088194.jpg\" alt=\"蓝莲花.jpg\"/></p><p><img src=\"/psychologicalcounseling/images/20181214/1544777139310086405.jpg\" title=\"1544777139310086405.jpg\" alt=\"hua.jpg\"/></p>', '2018-12-17 13:55:33', '0');
INSERT INTO `article` VALUES ('23', '法撒旦法', '7', 'passage.jpeg', '第三方', '<p><img src=\"/psychologicalcounseling/images/20181214/1544777272599025550.jpg\" title=\"1544777272599025550.jpg\" alt=\"形式与政策.jpg\"/></p>', '2018-12-17 13:55:34', '0');
INSERT INTO `article` VALUES ('24', '法撒旦法是打发', '7', 'passage.jpeg', '第三方', '<p><img src=\"/psychologicalcounseling/images/20181214/1544777295949033863.jpg\" title=\"1544777295949033863.jpg\" alt=\"课表.jpg\"/></p>', '2018-12-17 15:33:04', '4');
INSERT INTO `article` VALUES ('25', '范德萨发顺丰', '6', 'passage.jpeg', '孙菲菲付付付付付付付付付付付付付付付付', '<p><img src=\"/psychologicalcounseling/images/20181214/1544778590009065316.jpg\" title=\"1544778590009065316.jpg\" alt=\"课表.jpg\"/></p>', '2018-12-17 15:33:12', '3');
INSERT INTO `article` VALUES ('26', '地方', '7', 'passage.jpeg', '是打发', '<p>的点点滴滴多多多淡定淡定<br/><img src=\"/psychologicalcounseling/images/20181214/1544782431120024166.jpg\" title=\"1544782431120024166.jpg\" alt=\"形式与政策.jpg\"/></p>', '2018-12-17 15:33:15', '3');
INSERT INTO `article` VALUES ('27', '师大', '7', 'passage.jpeg', '骚动得到的多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多', '<p>的点点滴滴多多多淡定淡定多多多多多多多多<img src=\"/psychologicalcounseling/images/20181217/1545013909265054471.jpg\" title=\"1545013909265054471.jpg\" alt=\"形式与政策.jpg\"/></p>', '2018-12-17 15:33:19', '3');
INSERT INTO `article` VALUES ('28', '师大', '7', 'passage.jpeg', '骚动得到的多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多多', '<p>的点点滴滴多多多淡定淡定多多多多多多多多<img src=\"/psychologicalcounseling/images/20181217/1545013909265054471.jpg\" title=\"1545013909265054471.jpg\" alt=\"形式与政策.jpg\"/></p>', '2018-12-17 13:55:52', '0');

-- ----------------------------
-- Table structure for `ask`
-- ----------------------------
DROP TABLE IF EXISTS `ask`;
CREATE TABLE `ask` (
  `askId` int(11) NOT NULL AUTO_INCREMENT,
  `askTitle` varchar(100) DEFAULT NULL,
  `askContent` text,
  `userId` int(11) DEFAULT NULL,
  `askTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `askLookNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`askId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ask
-- ----------------------------
INSERT INTO `ask` VALUES ('1', '问情为何物', '情到底是什么', '1', '2018-11-20 21:59:34', '10');
INSERT INTO `ask` VALUES ('2', '你到底爱不爱我', '爱爱爱爱爱', '2', '2018-11-20 21:59:37', '10');

-- ----------------------------
-- Table structure for `businesstype`
-- ----------------------------
DROP TABLE IF EXISTS `businesstype`;
CREATE TABLE `businesstype` (
  `businesstypeId` int(11) NOT NULL AUTO_INCREMENT,
  `businesstypeWorkType` int(11) DEFAULT NULL,
  `businesstypeWorkId` int(11) DEFAULT NULL,
  `typetableId` int(11) DEFAULT NULL,
  PRIMARY KEY (`businesstypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of businesstype
-- ----------------------------
INSERT INTO `businesstype` VALUES ('1', '1', '4', '1');
INSERT INTO `businesstype` VALUES ('2', '1', '4', '2');
INSERT INTO `businesstype` VALUES ('3', '1', '5', '1');
INSERT INTO `businesstype` VALUES ('4', '1', '5', '2');
INSERT INTO `businesstype` VALUES ('5', '1', '5', '3');
INSERT INTO `businesstype` VALUES ('6', '1', '6', '4');
INSERT INTO `businesstype` VALUES ('7', '1', '7', '2');
INSERT INTO `businesstype` VALUES ('8', '1', '7', '5');
INSERT INTO `businesstype` VALUES ('9', '2', '1', '1');
INSERT INTO `businesstype` VALUES ('10', '2', '2', '1');
INSERT INTO `businesstype` VALUES ('11', '2', '2', '2');
INSERT INTO `businesstype` VALUES ('12', '2', '2', '5');
INSERT INTO `businesstype` VALUES ('13', '2', '3', '3');
INSERT INTO `businesstype` VALUES ('14', '2', '4', '4');
INSERT INTO `businesstype` VALUES ('15', '3', '1', '1');
INSERT INTO `businesstype` VALUES ('16', '3', '2', '2');
INSERT INTO `businesstype` VALUES ('17', '3', '3', '3');
INSERT INTO `businesstype` VALUES ('18', '3', '4', '4');
INSERT INTO `businesstype` VALUES ('19', '3', '5', '5');
INSERT INTO `businesstype` VALUES ('20', '3', '6', '5');
INSERT INTO `businesstype` VALUES ('21', '3', '7', '5');
INSERT INTO `businesstype` VALUES ('22', '3', '8', '3');
INSERT INTO `businesstype` VALUES ('23', '3', '9', '5');
INSERT INTO `businesstype` VALUES ('24', '3', '10', '1');
INSERT INTO `businesstype` VALUES ('25', '3', '11', '1');
INSERT INTO `businesstype` VALUES ('26', '3', '12', '1');
INSERT INTO `businesstype` VALUES ('27', '3', '13', '3');
INSERT INTO `businesstype` VALUES ('28', '3', '14', '3');
INSERT INTO `businesstype` VALUES ('29', '3', '15', '4');
INSERT INTO `businesstype` VALUES ('30', '3', '16', '4');
INSERT INTO `businesstype` VALUES ('31', '3', '17', '4');
INSERT INTO `businesstype` VALUES ('32', '3', '18', '1');
INSERT INTO `businesstype` VALUES ('33', '3', '19', '2');
INSERT INTO `businesstype` VALUES ('34', '3', '20', '3');
INSERT INTO `businesstype` VALUES ('35', '3', '21', '4');
INSERT INTO `businesstype` VALUES ('36', '3', '22', '5');
INSERT INTO `businesstype` VALUES ('37', '3', '23', '1');
INSERT INTO `businesstype` VALUES ('38', '3', '24', '2');
INSERT INTO `businesstype` VALUES ('39', '3', '25', '3');
INSERT INTO `businesstype` VALUES ('40', '3', '26', '4');
INSERT INTO `businesstype` VALUES ('41', '3', '27', '5');
INSERT INTO `businesstype` VALUES ('42', '5', '4', '2');
INSERT INTO `businesstype` VALUES ('43', '5', '5', '1');
INSERT INTO `businesstype` VALUES ('44', '5', '5', '2');
INSERT INTO `businesstype` VALUES ('45', '5', '5', '3');
INSERT INTO `businesstype` VALUES ('46', '5', '6', '1');
INSERT INTO `businesstype` VALUES ('47', '5', '4', '1');
INSERT INTO `businesstype` VALUES ('48', '5', '12', '2');
INSERT INTO `businesstype` VALUES ('49', '5', '10', '1');
INSERT INTO `businesstype` VALUES ('50', '5', '1', '1');
INSERT INTO `businesstype` VALUES ('51', '5', '2', '1');
INSERT INTO `businesstype` VALUES ('52', '5', '3', '2');
INSERT INTO `businesstype` VALUES ('53', '5', '2', '5');
INSERT INTO `businesstype` VALUES ('54', '5', '3', '3');
INSERT INTO `businesstype` VALUES ('55', '5', '2', '4');
INSERT INTO `businesstype` VALUES ('56', '5', '13', '3');
INSERT INTO `businesstype` VALUES ('57', '5', '14', '4');
INSERT INTO `businesstype` VALUES ('58', '5', '18', '2');
INSERT INTO `businesstype` VALUES ('59', '5', '19', '1');
INSERT INTO `businesstype` VALUES ('60', '5', '21', '1');
INSERT INTO `businesstype` VALUES ('61', '5', '24', '1');
INSERT INTO `businesstype` VALUES ('62', '5', '25', '1');
INSERT INTO `businesstype` VALUES ('63', '5', '26', '1');
INSERT INTO `businesstype` VALUES ('64', '5', '27', '1');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1');
INSERT INTO `collection` VALUES ('2', '1', '2');
INSERT INTO `collection` VALUES ('3', '2', '3');
INSERT INTO `collection` VALUES ('4', '2', '2');
INSERT INTO `collection` VALUES ('5', '6', '1');

-- ----------------------------
-- Table structure for `consultationrecord`
-- ----------------------------
DROP TABLE IF EXISTS `consultationrecord`;
CREATE TABLE `consultationrecord` (
  `consultationrecordId` int(11) NOT NULL AUTO_INCREMENT,
  `randomNum` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT '0',
  `teacherId` int(11) DEFAULT '0',
  `consultationrecordOrderTime` varchar(50) NOT NULL,
  `consultationrecordStartTime` varchar(50) DEFAULT NULL,
  `consultationrecordEndTime` varchar(50) DEFAULT NULL,
  `consultationrecordPrice` float DEFAULT NULL,
  `consultationrecordState` varchar(50) DEFAULT NULL,
  `consultState` varchar(50) DEFAULT NULL,
  `consultationrecordMethod` varchar(50) DEFAULT NULL,
  `consultationrecordResourcePath` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`consultationrecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consultationrecord
-- ----------------------------
INSERT INTO `consultationrecord` VALUES ('7', '0436805377', '1', '2', '2018-11-29', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('8', '0627508341', '1', '2', '2018-11-29', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('9', '6737147867', '1', '2', '2018-11-29', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('10', '1950069224', '1', '2', '2018-11-29', '15:00', '16:00', '666', null, null, 'vedio', null);
INSERT INTO `consultationrecord` VALUES ('12', '4480217550', '1', '2', '2018-11-30', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('14', '8849305351', '1', '6', '2018-11-30', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('15', '7643771114', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('16', '2528564352', '1', '2', '2018-11-27', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('17', '9213709607', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'faceToFace', null);
INSERT INTO `consultationrecord` VALUES ('18', '0310542754', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('19', '1786028107', '1', '5', '2018-11-20', '9:00', '10:00', '500', '已支付', null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('20', '5028303375', '1', '2', '2018-11-30', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('21', '5017692220', '1', '2', '2018-11-30', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('22', '6509491400', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('23', '6321832607', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('24', '7771822101', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('25', '1909523646', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('26', '6871384353', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('27', '5152983354', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('28', '7123251264', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('29', '6863629570', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('30', '1321763622', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('31', '5352204704', '1', '2', '2018-11-27', '19:00', '20:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('32', '2005405153', '1', '4', '2018-11-30', '19:00', '20:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('33', '3501322022', '1', '4', '2018-11-30', '19:00', '20:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('34', '9783633191', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('35', '0082966278', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('36', '9062377497', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('37', '4764743097', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('38', '5744346747', '1', '6', '2018-11-30', '10:00', '11:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('39', '4790852436', '1', '6', '2018-11-30', '10:00', '11:00', '500', '已支付', null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('40', '4414787597', '1', '4', '2018-11-30', '12:00', '13:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('41', '5879316832', '1', '2', '2018-11-30', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('42', '5783756535', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('43', '4293348080', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('44', '3866643513', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('45', '2272830959', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('46', '6677634189', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('47', '8689463869', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('48', '5509781606', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('49', '3010445979', '1', '2', '2018-11-27', '18:00', '19:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('50', '2951435709', '1', '4', '2018-11-27', '8:00', '9:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('51', '9857622391', '1', '5', '2018-12-01', '9:00', '10:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('52', '0169647057', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('53', '3991335605', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('54', '4879640091', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('55', '6136805795', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('56', '1670587241', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('57', '0279845294', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('58', '9436427582', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('59', '3252099163', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('60', '6210076848', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('61', '5248043291', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('62', '7269357751', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('63', '7870938462', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('64', '9925643911', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('65', '6587424081', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('66', '7253936842', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('67', '5796289104', '1', '4', '2018-11-27', '13:00', '14:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('68', '5302008392', '1', '4', '2018-11-27', '15:00', '16:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('69', '4060258228', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('70', '8416690623', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('71', '0766526134', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('72', '0309615567', '1', '2', '2018-12-01', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('73', '0050441026', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('74', '0175063165', '1', '4', '2018-12-01', '8:00', '9:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('75', '2859611090', '1', '2', '2018-12-01', '14:00', '15:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('76', '4574095003', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('77', '6002850425', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('78', '5445417180', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('79', '8414529488', '1', '2', '2018-12-01', '8:00', '9:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('80', '1495134702', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('81', '4831603766', '1', '2', '2018-12-01', '16:00', '17:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('82', '2138051982', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('83', '4433692298', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('84', '4645267058', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('85', '3666039336', '1', '2', '2018-12-01', '14:00', '15:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('86', '6221640478', '1', '2', '2018-12-01', '14:00', '15:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('87', '1507842664', '1', '2', '2018-12-01', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('88', '0317779205', '1', '2', '2018-12-01', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('89', '0245480643', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('90', '3921669717', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('91', '8612599761', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('92', '1201113422', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('93', '2940525447', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('94', '4238077506', '1', '2', '2018-12-01', '17:00', '18:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('95', '7046070180', '1', '2', '2018-12-01', '17:00', '18:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('96', '2514386292', '1', '2', '2018-12-01', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('97', '8209629793', '1', '4', '2018-12-01', '8:00', '9:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('98', '9281693576', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('99', '9727664345', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('100', '1722667405', '1', '2', '2018-12-01', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('101', '3708008239', '1', '2', '2018-12-01', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('102', '8980151882', '1', '4', '2018-12-01', '18:00', '19:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('103', '2226633994', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('104', '1923979845', '1', '4', '2018-11-27', '14:00', '15:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('105', '2593839764', '1', '2', '2018-12-03', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('106', '8784251553', '1', '2', '2018-12-03', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('107', '2744568179', '1', '2', '2018-12-03', '14:00', '15:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('108', '3475745120', '1', '2', '2018-12-03', '9:00', '10:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('109', '0724876157', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('110', '9217842432', '1', '2', '2018-12-03', '8:00', '9:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('111', '1319306565', '1', '2', '2018-12-03', '9:00', '10:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('112', '6583157286', '1', '2', '2018-12-03', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('113', '2641374370', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('114', '5486739417', '1', '2', '2018-12-03', '15:00', '16:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('115', '2781991786', '1', '2', '2018-12-03', '16:00', '17:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('116', '6532996166', '1', '2', '2018-12-03', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('117', '2873566683', '1', '2', '2018-12-03', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('118', '1535356732', '1', '4', '2018-12-03', '15:00', '16:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('119', '4665522247', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('120', '3744943362', '1', '4', '2018-11-27', '19:00', '20:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('121', '5527637799', '1', '2', '2018-12-03', '17:00', '18:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('122', '8591242943', '1', '2', '2018-12-03', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('123', '5407980351', '1', '2', '2018-12-03', '15:00', '16:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('124', '7294896546', '1', '4', '2018-12-03', '19:00', '20:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('125', '1975733893', '1', '4', '2018-12-03', '18:00', '19:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('126', '3306026748', '1', '4', '2018-12-03', '12:00', '13:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('127', '1970925218', '1', '6', '2018-12-03', '10:00', '11:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('128', '3009244129', '1', '6', '2018-12-03', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('129', '7527788839', '1', '4', '2018-12-03', '15:00', '16:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('130', '8475552112', '1', '2', '2018-12-03', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('131', '0468294444', '1', '4', '2018-11-27', '17:00', '18:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('132', '6352463321', '1', '4', '2018-11-27', '14:00', '15:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('133', '4170465783', '1', '4', '2018-12-03', '14:00', '15:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('134', '4174860808', '1', '4', '2018-12-03', '15:00', '16:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('135', '6171959419', '1', '2', '2018-12-03', '13:00', '14:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('136', '9052978938', '1', '4', '2018-12-03', '11:00', '12:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('137', '2588572450', '1', '2', '2018-11-27', '9:00', '10:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('138', '1266667744', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('139', '2473180148', '1', '4', '2018-11-27', '8:00', '9:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('140', '9423724108', '1', '1', '2018-11-27', '17:00', '18:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('141', '2594185905', '1', '2', '2018-11-27', '19:00', '20:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('142', '0405508246', '1', '4', '2018-11-27', '8:00', '9:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('143', '0339126596', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('144', '3046847488', '1', '5', '2018-11-27', '17:00', '18:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('145', '6798274869', '1', '6', '2018-11-27', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('146', '9138848109', '1', '2', '2018-11-27', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('147', '1172436840', '1', '2', '2018-11-27', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('148', '1992638976', '1', '2', '2018-11-27', '8:00', '9:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('149', '7054031644', '1', '1', '2018-11-27', '11:00', '12:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('150', '7747842807', '1', '6', '2018-11-27', '18:00', '19:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('151', '0477143848', '1', '1', '2018-11-27', '11:00', '12:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('152', '6993468271', '1', '1', '2018-11-27', '11:00', '12:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('153', '2496330959', '1', '4', '2018-12-04', '13:00', '14:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('154', '5088529214', '1', '4', '2018-12-04', '13:00', '14:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('155', '4832617566', '1', '4', '2018-12-04', '13:00', '14:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('156', '5867407991', '1', '4', '2018-12-04', '13:00', '14:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('157', '1085600153', '1', '4', '2018-12-04', '13:00', '14:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('158', '9695307677', '1', '4', '2018-12-04', '13:00', '14:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('159', '6285172142', '1', '2', '2018-11-27', '19:00', '20:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('160', '4762820830', '1', '5', '2018-12-04', '17:00', '18:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('161', '5304666479', '1', '5', '2018-12-04', '17:00', '18:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('162', '2392291211', '1', '1', '2018-12-05', '12:00', '13:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('163', '9161985886', '1', '4', '2018-12-05', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('164', '4377736307', '1', '5', '2018-12-05', '12:00', '13:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('165', '8441780716', '1', '5', '2018-12-05', '12:00', '13:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('166', '2742944625', '1', '5', '2018-12-05', '12:00', '13:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('167', '7571099181', '1', '1', '2018-12-05', '11:00', '12:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('168', '9812191567', '1', '6', '2018-12-05', '18:00', '19:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('169', '1239888314', '1', '6', '2018-12-05', '9:00', '10:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('170', '3859948748', '1', '5', '2018-11-20', '17:00', '18:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('171', '6300868370', '1', '5', '2018-11-20', '17:00', '18:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('172', '7926396791', '1', '5', '2018-11-20', '17:00', '18:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('173', '6687185490', '1', '5', '2018-11-20', '17:00', '18:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('176', '0377264124', '1', '5', '2018-12-05', '17:00', '18:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('177', '0420579640', '1', '2', '2018-12-05', '19:00', '20:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('179', '6534303006', '1', '5', '2018-11-27', '9:00', '10:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('180', '7958185241', '1', '6', '2018-11-27', '9:00', '10:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('181', '2032012462', '1', '1', '2018-12-05', '17:00', '18:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('183', '5331980907', '1', '2', '2018-11-20', '14:00', '15:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('184', null, '1', '1', '2018-11-20', '11:00', '12:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('185', '9942332438', '1', '1', '2018-11-20', '11:00', '12:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('187', '6308502036', '1', '2', '2018-11-20', '13:00', '14:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('188', '0757299837', '1', '5', '2018-11-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('190', '4349924455', '1', '2', '2018-11-27', '14:00', '15:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('200', '4349924467', '2', '6', '2018-12-13', '11:00', '13:00', '555', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('201', '7661273877', '2', '6', '2018-12-17', '8:00', '12:00', '400', '已支付', '已咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('202', '5098650636', '1', '2', '2018-12-17', '8:00', '9:00', '666', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('203', '0113284026', '1', '4', '2018-12-17', '9:00', '10:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('204', '3520931169', '1', '4', '2018-12-17', '8:00', '9:00', '300', null, null, null, null);
INSERT INTO `consultationrecord` VALUES ('205', '4144717138', '1', '2', '2018-12-17', '18:00', '19:00', '666', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('208', '4128603323', '1', '6', '2018-12-17', '18:00', '19:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('211', '8371404956', '1', '6', '2018-11-27', '10:00', '11:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('212', '0026526900', '2', '6', '2018-12-17', '7:00', '17:00', '888', '已支付', '未咨询咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('213', '8030607760', '1', '1', '2018-12-18', '17:00', '18:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('214', '7645824178', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('215', '5818650896', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('216', '1361514600', '1', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('217', '4179593421', '1', '1', '2018-12-19', '11:00', '12:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('218', '1443063342', '6', '6', '2018-12-19', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('219', '8314005013', '6', '6', '2018-12-19', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('220', '1802198693', '6', '1', '2018-12-19', '12:00', '13:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('221', '1217222346', '6', '1', '2018-12-19', '12:00', '13:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('222', '7857098290', '6', '1', '2018-12-19', '12:00', '13:00', '888', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('223', '4727493648', '6', '1', '2018-12-19', '12:00', '13:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('224', '8783477638', '6', '1', '2018-12-19', '11:00', '12:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('227', '0305962973', '6', '5', '2018-12-19', '12:00', '13:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('228', '4327618819', '6', '5', '2018-12-19', '9:00', '10:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('229', '2362913196', '6', '4', '2018-12-19', '9:00', '10:00', '300', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('230', '8493855910', '6', '1', '2018-12-19', '15:00', '16:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('231', '2198964640', '6', '1', '2018-12-19', '18:00', '19:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('232', '1913076538', '6', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('233', '8376577436', '6', '1', '2018-12-20', '6:00', '11:00', '888', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('234', '7088520541', '6', '6', '2018-12-20', '10:00', '11:00', '500', '已支付', '未咨询', 'audio', null);
INSERT INTO `consultationrecord` VALUES ('235', '0566155287', '6', '6', '2018-12-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('236', '9935820348', '6', '6', '2018-12-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('237', '3297038232', '6', '6', '2018-12-20', '9:00', '10:00', '500', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('238', '5687978166', '6', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('239', '4953390197', '6', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('240', '9808953084', '6', '4', '2018-11-27', '16:00', '17:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('242', '3125071069', '6', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);
INSERT INTO `consultationrecord` VALUES ('243', '7923563963', '6', '4', '2018-11-27', '17:00', '18:00', '300', null, null, 'audio', null);

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `coursePrice` float DEFAULT '0',
  `courseRebate` float DEFAULT '0',
  `courseIntroduction` text,
  `courseImgPath` varchar(1024) DEFAULT NULL,
  `courseStudentNumber` int(11) DEFAULT '0',
  `courseSynopsis` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '心理成长', '4', '0', '0.9', '<p>\r\n                    <table>\r\n                        <tr>\r\n                            <th>适用人群</th>\r\n                            <td>零基础即可</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <th>教学老师</th>\r\n                            <td>高淑贞（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;彰化师大辅导与谘商学系教授&nbsp;彰化师大教育学院院长&nbsp;台湾游戏治疗学会创会、第一、二届理事长&nbsp;台湾青少年犯罪防治研究学会谘询顾问<br/>\r\n                                曾仁美（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;台南大学辅导与咨商学系硕士班兼任助理教授&nbsp;台湾沙游治疗学会常务理事&nbsp;台南市谘商心理师公会理事&nbsp;台湾游戏治疗学会监事&nbsp;高雄师范大学复健与咨商研究所博士班实习督导<br/>\r\n                                林清文（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;国立彰化师大师资培育中心主任&nbsp;国立台中教育大学谘商与应用心理学系兼任教授&nbsp;国立彰化师大辅导与谘商学系教授兼学生事务长&nbsp;国立彰化师大辅导学系副教授兼任代理系主任<br/>\r\n                                吴丽云（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;新竹生命线员工协助服务中心谘商心理师/讲师&nbsp;台南市家扶中心谘商心理师&nbsp;台南市政府家庭暴力暨性侵害防治中心谘商心理师&nbsp;台南市家庭教育咨询委员<br/>\r\n                                陈静怡（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;卫生署精神疾病强制鉴定、强制社区治疗审查会委员&nbsp;台湾游戏治疗学会监事、教育与专业训练组委员&nbsp;基隆市警察局心理辅导顾问&nbsp;台湾游戏治疗学会秘书长<br/>\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                    课程目标：<br/>\r\n                    <ol>\r\n                        <li>不限工作和职业，不限基础，对心理学感兴趣者；</li>\r\n                        <li>聆听国内权威老师精彩讲授，摒弃单一理论学习，获得更多实操经验分享者；</li>\r\n                        <li>想在心理咨询方面有所建树，学以致用，并顺利获得职业资格证书者；</li>\r\n                        <li>自我心灵放松，启迪心智者均可参与学习。</li>\r\n                    </ol>\r\n                    课程特色：<br/>\r\n                    <ol>\r\n                        <li>教材精讲：基础知识、技能知识与案例分析结合。</li>\r\n                        <li>综合水平提升：知识、研究与实践综合运用水平的整体提升。</li>\r\n                        <li>应用能力与情景训练：案例分析与研究、模拟咨询练习指导、总结与讲评。</li>\r\n                        <li>全方位辅导：含考前串讲、试题分析、应试指导、模拟考试等，帮助学员顺利取证。</li>\r\n                        <li>咨询实践（见习）：学习课程结束后，具备一定的实战咨询技能。</li>\r\n                    </ol>\r\n                    </p>', 'images/course.jpg', '16', '这是魏谦强老师的一门课');
INSERT INTO `course` VALUES ('2', '高效学习', '2', '30', '1', '<p>\r\n                    <table>\r\n                        <tr>\r\n                            <th>适用人群</th>\r\n                            <td>零基础即可</td>\r\n                        </tr>\r\n                        <tr>\r\n                            <th>教学老师</th>\r\n                            <td>高淑贞（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;彰化师大辅导与谘商学系教授&nbsp;彰化师大教育学院院长&nbsp;台湾游戏治疗学会创会、第一、二届理事长&nbsp;台湾青少年犯罪防治研究学会谘询顾问<br/>\r\n                                曾仁美（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;台南大学辅导与咨商学系硕士班兼任助理教授&nbsp;台湾沙游治疗学会常务理事&nbsp;台南市谘商心理师公会理事&nbsp;台湾游戏治疗学会监事&nbsp;高雄师范大学复健与咨商研究所博士班实习督导<br/>\r\n                                林清文（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;国立彰化师大师资培育中心主任&nbsp;国立台中教育大学谘商与应用心理学系兼任教授&nbsp;国立彰化师大辅导与谘商学系教授兼学生事务长&nbsp;国立彰化师大辅导学系副教授兼任代理系主任<br/>\r\n                                吴丽云（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;新竹生命线员工协助服务中心谘商心理师/讲师&nbsp;台南市家扶中心谘商心理师&nbsp;台南市政府家庭暴力暨性侵害防治中心谘商心理师&nbsp;台南市家庭教育咨询委员<br/>\r\n                                陈静怡（中国台湾）<br/>\r\n                                心理谘商学博士&nbsp;卫生署精神疾病强制鉴定、强制社区治疗审查会委员&nbsp;台湾游戏治疗学会监事、教育与专业训练组委员&nbsp;基隆市警察局心理辅导顾问&nbsp;台湾游戏治疗学会秘书长<br/>\r\n                            </td>\r\n                        </tr>\r\n                    </table>\r\n                    课程目标：<br/>\r\n                    <ol>\r\n                        <li>不限工作和职业，不限基础，对心理学感兴趣者；</li>\r\n                        <li>聆听国内权威老师精彩讲授，摒弃单一理论学习，获得更多实操经验分享者；</li>\r\n                        <li>想在心理咨询方面有所建树，学以致用，并顺利获得职业资格证书者；</li>\r\n                        <li>自我心灵放松，启迪心智者均可参与学习。</li>\r\n                    </ol>\r\n                    课程特色：<br/>\r\n                    <ol>\r\n                        <li>教材精讲：基础知识、技能知识与案例分析结合。</li>\r\n                        <li>综合水平提升：知识、研究与实践综合运用水平的整体提升。</li>\r\n                        <li>应用能力与情景训练：案例分析与研究、模拟咨询练习指导、总结与讲评。</li>\r\n                        <li>全方位辅导：含考前串讲、试题分析、应试指导、模拟考试等，帮助学员顺利取证。</li>\r\n                        <li>咨询实践（见习）：学习课程结束后，具备一定的实战咨询技能。</li>\r\n                    </ol>\r\n                    </p>', 'images/course.jpg', '33', '这是邓旸老师的一门课');
INSERT INTO `course` VALUES ('3', '自我提升', '8', '25', '0.8', '这是王颖老师的一门课', 'images/course.jpg', '22', '王颖好好学c');
INSERT INTO `course` VALUES ('4', '家庭幸福', '7', '52', '0.9', '这是孙明伟老师的一门课', 'images/course.jpg', '15', '这是孙明伟老师的一门课');
INSERT INTO `course` VALUES ('5', '学习成长', '6', '89', '0.7', '好课', 'images/course.jpg', '100', '好课');
INSERT INTO `course` VALUES ('6', 'java学习', '6', '56', '0.3', '不错', 'images/course.jpg', '800', '不错');
INSERT INTO `course` VALUES ('7', 'java开发', '5', '100', '0.6', '好好', 'images/course.jpg', '455', '好好');
INSERT INTO `course` VALUES ('8', 'javaweb', '6', '200', '0.9', '嗯嗯呢', 'images/course.jpg', '455', '嗯嗯呢');
INSERT INTO `course` VALUES ('9', 'PHP', '6', '555', '0.65', '哈哈', 'images/course.jpg', '555', '哈哈');
INSERT INTO `course` VALUES ('10', '强迫症', '4', '5555', '0.3', '啊啊原来强迫症', 'images/course.jpg', '553', '强迫症可不错');
INSERT INTO `course` VALUES ('11', '焦虑症', '7', '88', '0.32', '啊啊焦虑症', 'images/course.jpg', '855', '焦虑症可不错');
INSERT INTO `course` VALUES ('12', '恐惧症', '7', '555', '0.65', '啊啊原来恐惧症', 'images/course.jpg', '8888', '恐惧症可不错');
INSERT INTO `course` VALUES ('13', '神经衰弱', '7', '55', '0.63', 'w(ﾟДﾟ)w神经衰弱', 'images/course.jpg', '555', '神金谁若');
INSERT INTO `course` VALUES ('14', '精神分裂', '4', '55', '0.53', '精神分裂', 'images/course.jpg', '444', '精神分裂');
INSERT INTO `course` VALUES ('15', '抑郁症', '5', '66', '0.62', '抑郁症', 'images/course.jpg', '111', '抑郁症');
INSERT INTO `course` VALUES ('16', '妄想症', '4', '55', '0.65', '妄想症', 'images/course.jpg', '11', '妄想症');
INSERT INTO `course` VALUES ('17', '自闭症', '4', '66', '0.32', '自闭症', 'images/course.jpg', '55', '自闭症');
INSERT INTO `course` VALUES ('18', '自卑', '4', '55', '0.5', '自闭', 'images/course.jpg', '55', '自闭');
INSERT INTO `course` VALUES ('19', 'Python', '6', '555', '0.3', 'Python', 'images/course.jpg', '44', 'python');
INSERT INTO `course` VALUES ('20', 'c#', '5', '58', '0.6', 'jjjk,', 'images/course.jpg', '45', 'hhjj');
INSERT INTO `course` VALUES ('21', 'ajax', '5', '0', '0.5', 'hhjj', 'images/course.jpg', '557', 'jnijom');
INSERT INTO `course` VALUES ('22', 'jjjjkj', '5', '4455', '0.2555', 'nnmm', 'images/course.jpg', '2222', 'kkkkkk');
INSERT INTO `course` VALUES ('23', 'ggggg', '6', '0', '0.5655', 'jjkkk', 'images/course.jpg', '68', 'njjj');
INSERT INTO `course` VALUES ('24', 'gyhhj', '7', '0', '0.555', 'llkjhhh', 'images/course.jpg', '5556', 'gghh');
INSERT INTO `course` VALUES ('25', 'hjjjjjk', '6', '0', '0.5552', 'bghghh', 'images/course.jpg', '11113', 'njjjjjj');
INSERT INTO `course` VALUES ('26', 'nnjmmm', '7', '0', '0.3', 'ujjkkkk', 'images/course.jpg', '2223', 'jkkkk');
INSERT INTO `course` VALUES ('27', 'hhhjjj', '6', '0', '0.555', 'kkkkk', 'images/course.jpg', '2222', 'kkjjj');

-- ----------------------------
-- Table structure for `coursecatalog`
-- ----------------------------
DROP TABLE IF EXISTS `coursecatalog`;
CREATE TABLE `coursecatalog` (
  `coursecatalogId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `coursecatalogParentId` int(11) DEFAULT NULL,
  `coursecatalogName` varchar(50) DEFAULT NULL,
  `coursecatalogResourcePath` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`coursecatalogId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coursecatalog
-- ----------------------------
INSERT INTO `coursecatalog` VALUES ('1', '1', null, '第一章：基础心理学', null);
INSERT INTO `coursecatalog` VALUES ('2', '1', '1', '1.1 婴儿的认知发展', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('3', '1', '1', '1.2 幼儿的学前教育', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/09/04/1010477884_8fccc6a565e848d69d92bf9a07390d17_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a593d4bbdf2a2b666dbd94336e60455bea3059f726dc7bb86b92adbc3d5b34b1325cf74072d623f6188bed1ebbc7a0b79cb8ae77e29788836745b7125f174b3914');
INSERT INTO `coursecatalog` VALUES ('4', '1', null, '第二章：基础心理学', '');
INSERT INTO `coursecatalog` VALUES ('5', '1', '4', '2.1 婴儿的认知发展', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/09/04/1010477882_b965686b6e564c3a9229ccadd339a01b_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a51d097fb9867a7aa6243f0519857c50e13059f726dc7bb86b92adbc3d5b34b1325cf74072d623f6188bed1ebbc7a0b79c4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('6', '1', '4', '2.2 幼儿的学前教育', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/09/04/1010486015_cc15bba21cc14d02ac7cb9a5c4043a9a_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5570117617aac5e629c9cdc21627838ed3059f726dc7bb86b92adbc3d5b34b1324c67ddeab0c4e37f31a2942a0c7bb1a3aabef62f6a5b7f74a41ca7132f31ab87');
INSERT INTO `coursecatalog` VALUES ('7', '2', null, '第一章：意象对话', null);
INSERT INTO `coursecatalog` VALUES ('8', '2', '7', '1.1 意向对话心理咨询-概述', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010612760_08e77d43028f4a92b627d41ef3970b73_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a504119a2de5d60baf3472b9fad36fa5873059f726dc7bb86b92adbc3d5b34b1324ce9d6820d38d07b6cb7afbe834cd05adf69454fe54d63664bd5297860cdfa3d');
INSERT INTO `coursecatalog` VALUES ('9', '2', '7', '1.2 意向对话心理咨询-原理', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010610766_288dfb6867da4f3590859f8905b0d366_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5f82c9c44ef6395e1b8e3e357a03b23063059f726dc7bb86b92adbc3d5b34b13237c7ee85137dca7b921e526532bd994a4cca709eeec35724f15d3e6a182e04cb');
INSERT INTO `coursecatalog` VALUES ('10', '2', '7', '1.3 意向对话心理咨询-技术操作', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010608900_ecfcf555310840c5a7673d7a6561847e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5483cd4d332b74e02324a2e5b47aee7d03059f726dc7bb86b92adbc3d5b34b1322cc607d2ea4bc4f3c79d241a2af5a99bdf69454fe54d63664bd5297860cdfa3d');
INSERT INTO `coursecatalog` VALUES ('11', '2', '7', '1.4 意向对话心理咨询-组织管理', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010608906_7a4984088f5146d1ae5d9fcf63b8ee67_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5fa3490f70093d0087e343a03c32feb723059f726dc7bb86b92adbc3d5b34b1322cc607d2ea4bc4f3c79d241a2af5a99b4cca709eeec35724f15d3e6a182e04cb');
INSERT INTO `coursecatalog` VALUES ('12', '2', null, '第二章：绘画分析', null);
INSERT INTO `coursecatalog` VALUES ('13', '2', '12', '2.1 绘画治疗的定义', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/11/07/1010718262_4c73de19cdd94154bbe280266d46c57e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a51a1590d33ff974a180ee8e6cc14095203059f726dc7bb86b92adbc3d5b34b13245641fd16b5cc47d693d98535233e06e4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('14', '2', '12', '2.2 三个核心概念', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/11/07/1010717286_9cfbc3ff85f04e19bbfdc3a7885f0214_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5ed78f9b7b1cee2a06d857ed663938e523059f726dc7bb86b92adbc3d5b34b132476889fd863cceb03e9023d5eb244da54cca709eeec35724f15d3e6a182e04cb');
INSERT INTO `coursecatalog` VALUES ('15', '2', '12', '2.3 关于表征', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/11/07/1010720261_b59710f8661741c0a8bdde5edddf0ea0_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5b7a258ec9f03aaae2de065c15258fa353059f726dc7bb86b92adbc3d5b34b132157ff834ac9d3eaf93f3934cf0cd32e9623591d5e74d0640a136e4a4f0e4eb71');
INSERT INTO `coursecatalog` VALUES ('16', '2', '12', '2.4 绘画符号的心理表征', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/11/07/1010718266_750ff7b169f54f34bdadd97eae0d0c21_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5f2c671b1d49d0d64647e1e4cf60b29833059f726dc7bb86b92adbc3d5b34b13245641fd16b5cc47d693d98535233e06e4cca709eeec35724f15d3e6a182e04cb');
INSERT INTO `coursecatalog` VALUES ('17', '2', null, '第三章：家庭治疗', null);
INSERT INTO `coursecatalog` VALUES ('18', '2', '17', '3.1 什么是家庭治疗', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('19', '2', '17', '3.2 家庭治疗的历史', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('20', '2', '17', '3.3 家庭治疗的工作概念', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('21', '2', '17', '3.4 家庭治疗的常用技术', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('22', '2', null, '第四章：沙盘游戏疗法', null);
INSERT INTO `coursecatalog` VALUES ('23', '2', '22', '4.1 沙盘游戏疗法的定义', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('24', '2', '22', '4.2 沙盘游戏的内涵', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('25', '2', '22', '4.3 沙盘游戏疗法的发展历史', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('26', '2', '22', '4.4 沙盘游戏疗法如何促进', 'https://jdvodrvfb210d.vod.126.net/jdvodrvfb210d/nos/mp4/2018/10/15/1010609862_9aebaf677add4c1b80f5192fbcccd18e_sd.mp4?ak=7909bff134372bffca53cdc2c17adc27a4c38c6336120510aea1ae1790819de82bd4939104d411e269051c346826a9a5c8da070ad32efbbbc2247686cdfe59973059f726dc7bb86b92adbc3d5b34b132a35fda214a45e684586c6100c4ba189b4426afeac364f76a817da3b2623cd41e');
INSERT INTO `coursecatalog` VALUES ('27', '4', null, '第一章：交际心理学', null);
INSERT INTO `coursecatalog` VALUES ('28', '4', '27', '1.1 如何与人相处', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('29', '4', '27', '1.2 广交朋友', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('30', '4', null, '第二章：交友的好处', null);
INSERT INTO `coursecatalog` VALUES ('31', '4', '30', '2.1 朋友多好办事', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('32', '4', '30', '2.2 朋友也是你的一种财富', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('33', '4', null, '第三章：如何交友', null);
INSERT INTO `coursecatalog` VALUES ('34', '4', '33', '3.1 真心待人，将心比心', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('35', '4', '33', '3.2 诚信为本', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('36', '4', '33', '3.3 兴趣相投', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('37', '3', null, '第一章：高效学习的重要性', null);
INSERT INTO `coursecatalog` VALUES ('38', '3', '37', '1.1 为什么要高效学习', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('39', '3', '37', '1.2 高效学习有什么好处', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('40', '3', '37', '1.3 高效学习对学生成长的影响', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('41', '3', null, '第二章：如何高效学习', null);
INSERT INTO `coursecatalog` VALUES ('42', '3', '41', '2.1 专心，专注', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('43', '3', '41', '2.2 有明确的目标', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('44', '3', '41', '2.3 有前进的动力', '/psychologicalcounseling/videos/test.mp4');
INSERT INTO `coursecatalog` VALUES ('45', '1', '1', '1.3服刚刚更换', '/psychologicalcounseling/videos/test.mp4');

-- ----------------------------
-- Table structure for `courseorder`
-- ----------------------------
DROP TABLE IF EXISTS `courseorder`;
CREATE TABLE `courseorder` (
  `courseorderId` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `courseorderBuyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `courseorderPrice` float DEFAULT NULL,
  `courseorderRandomId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseorderId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courseorder
-- ----------------------------
INSERT INTO `courseorder` VALUES ('1', '1', '1', '2018-11-20 21:46:22', '18', null);
INSERT INTO `courseorder` VALUES ('2', '2', '2', '2018-11-19 21:47:11', '30', null);
INSERT INTO `courseorder` VALUES ('3', '4', '3', '2018-11-20 21:48:17', '18', null);
INSERT INTO `courseorder` VALUES ('4', '2', '6', '2018-12-25 17:19:24', '30', '1765165287');

-- ----------------------------
-- Table structure for `courserecord`
-- ----------------------------
DROP TABLE IF EXISTS `courserecord`;
CREATE TABLE `courserecord` (
  `courserecordId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `courserecordIsFinish` int(11) DEFAULT NULL,
  `courserecordStartTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `courserecordStopPosition` int(11) DEFAULT NULL,
  `coursecatalogId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courserecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of courserecord
-- ----------------------------
INSERT INTO `courserecord` VALUES ('1', '1', '1', '1', '2018-11-20 20:48:58', '10', null);
INSERT INTO `courserecord` VALUES ('2', '2', '3', '0', '2018-11-20 21:50:18', '12', null);
INSERT INTO `courserecord` VALUES ('3', '3', '2', '0', '2018-11-20 21:50:24', '5', null);
INSERT INTO `courserecord` VALUES ('4', '6', '1', '0', '2018-12-20 11:08:50', '0', '2');
INSERT INTO `courserecord` VALUES ('5', '6', '1', '43', '2018-12-20 17:13:30', '110', '2');
INSERT INTO `courserecord` VALUES ('6', '6', '1', '1', '2018-12-20 17:16:40', '5', '2');
INSERT INTO `courserecord` VALUES ('7', '6', '1', '0', '2018-12-20 17:41:34', '0', '2');
INSERT INTO `courserecord` VALUES ('8', '6', '1', '0', '2018-12-20 17:41:33', '0', '2');
INSERT INTO `courserecord` VALUES ('9', '6', '1', '0', '2018-12-21 16:30:31', '0', '2');
INSERT INTO `courserecord` VALUES ('10', '6', '1', '19', '2018-12-21 16:37:00', '49', '2');
INSERT INTO `courserecord` VALUES ('11', '6', '1', '0', '2018-12-21 16:46:35', '0', '2');
INSERT INTO `courserecord` VALUES ('12', '6', '1', '0', '2018-12-25 16:03:08', '0', '2');
INSERT INTO `courserecord` VALUES ('13', '6', '1', '10', '2018-12-25 16:03:49', '27', '2');
INSERT INTO `courserecord` VALUES ('14', '6', '1', '0', '2018-12-25 16:03:49', '0', '2');
INSERT INTO `courserecord` VALUES ('15', '6', '1', '0', '2018-12-25 16:07:59', '0', '2');
INSERT INTO `courserecord` VALUES ('16', '6', '1', '0', '2018-12-25 16:13:56', '0', '2');
INSERT INTO `courserecord` VALUES ('17', '6', '1', '4', '2018-12-25 16:14:59', '11', '2');
INSERT INTO `courserecord` VALUES ('18', '6', '1', '10', '2018-12-25 16:19:45', '26', '2');
INSERT INTO `courserecord` VALUES ('19', '6', '1', '1', '2018-12-25 16:20:42', '3', '2');
INSERT INTO `courserecord` VALUES ('20', '6', '2', '2', '2018-12-25 16:36:13', '22', '8');
INSERT INTO `courserecord` VALUES ('21', '6', '2', '20', '2018-12-25 17:00:34', '180', '8');
INSERT INTO `courserecord` VALUES ('22', '6', '2', '20', '2018-12-25 17:01:58', '180', '8');
INSERT INTO `courserecord` VALUES ('23', '6', '2', '0', '2018-12-25 17:01:58', '0', '8');
INSERT INTO `courserecord` VALUES ('24', '6', '2', '20', '2018-12-25 17:02:39', '180', '8');
INSERT INTO `courserecord` VALUES ('25', '6', '2', '20', '2018-12-25 17:04:13', '180', '8');
INSERT INTO `courserecord` VALUES ('26', '6', '2', '0', '2018-12-25 17:04:12', '0', '8');
INSERT INTO `courserecord` VALUES ('27', '6', '2', '0', '2018-12-25 17:08:09', '0', '8');
INSERT INTO `courserecord` VALUES ('28', '6', '2', '0', '2018-12-25 17:09:39', '0', '8');
INSERT INTO `courserecord` VALUES ('29', '6', '2', '0', '2018-12-25 17:18:09', '0', '8');
INSERT INTO `courserecord` VALUES ('30', '6', '2', '20', '2018-12-25 17:18:14', '180', '8');

-- ----------------------------
-- Table structure for `diary`
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
  `diaryId` int(11) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `diaryRecordTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `diaryContent` text,
  `diaryWeather` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`diaryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of diary
-- ----------------------------
INSERT INTO `diary` VALUES ('0', '1', '2018-11-13 16:01:08', '今天天气很好', '晴天');

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `dynamicId` int(11) NOT NULL AUTO_INCREMENT,
  `dynamicPublishTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dynamicTitle` varchar(100) DEFAULT NULL,
  `dynamicContent` text,
  `dynamicImgPath` varchar(1024) DEFAULT NULL,
  `dynamicResourcePath` varchar(1024) DEFAULT NULL,
  `dynamicLink` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`dynamicId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('1', '2018-11-14 15:57:36', '动态一', '咚咚咚咚咚咚', null, null, null);
INSERT INTO `dynamic` VALUES ('2', '2018-11-17 14:58:02', '动态二', '啵啵啵啵啵啵啵啵啵', null, null, null);

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
  `evaluateId` int(11) NOT NULL AUTO_INCREMENT,
  `evaluateWorkType` int(11) DEFAULT NULL,
  `evaluateWorkId` int(11) DEFAULT NULL,
  `evaluateComment` varchar(1024) DEFAULT NULL,
  `evaluateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `evaluateStar` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`evaluateId`)
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES ('1', '5', '4', 'jkkkkkkkk', '2018-12-12 14:50:33', '0', '7');
INSERT INTO `evaluate` VALUES ('2', '5', '4', '魏谦强', '2018-12-12 14:50:59', '0', '7');
INSERT INTO `evaluate` VALUES ('3', '5', '4', '孙明伟', '2018-12-12 14:51:35', '0', '7');
INSERT INTO `evaluate` VALUES ('4', '5', '4', 'ghh', '2018-12-12 14:52:07', '0', '7');
INSERT INTO `evaluate` VALUES ('5', '5', '4', 'YY与美女', '2018-12-12 14:52:33', '0', '7');
INSERT INTO `evaluate` VALUES ('6', '5', '4', 'a', '2018-12-12 15:44:34', '0', '2');
INSERT INTO `evaluate` VALUES ('7', '5', '4', '好', '2018-12-12 15:44:50', '0', '2');
INSERT INTO `evaluate` VALUES ('8', '5', '4', '可怜了', '2018-12-12 15:44:56', '0', '2');
INSERT INTO `evaluate` VALUES ('9', '5', '4', '街季节', '2018-12-12 15:45:24', '0', '2');
INSERT INTO `evaluate` VALUES ('10', '5', '4', '坎坎坷坷', '2018-12-12 15:46:54', '0', '2');
INSERT INTO `evaluate` VALUES ('11', '5', '4', 'jjjjjj', '2018-12-12 15:47:21', '0', '2');
INSERT INTO `evaluate` VALUES ('12', '5', '4', '姐姐', '2018-12-12 15:48:04', '0', '7');
INSERT INTO `evaluate` VALUES ('13', '5', '4', '借鉴借鉴', '2018-12-12 15:48:17', '0', '2');
INSERT INTO `evaluate` VALUES ('166', '5', '4', '<p></p><p>能看见哪考</p><p><br></p>', '2018-12-12 18:57:38', '0', '2');
INSERT INTO `evaluate` VALUES ('167', '5', '4', '<p></p><p>jjjj</p><p>mmmmmm</p>', '2018-12-12 18:58:57', '0', '2');
INSERT INTO `evaluate` VALUES ('168', '5', '4', '<p></p><p>借鉴借鉴军</p>', '2018-12-12 19:29:03', '0', '2');
INSERT INTO `evaluate` VALUES ('169', '5', '4', '<p></p><p>借鉴借鉴军</p>', '2018-12-12 19:29:11', '0', '2');
INSERT INTO `evaluate` VALUES ('170', '5', '4', '<p></p><p>借鉴借鉴军</p>', '2018-12-12 19:29:18', '0', '2');
INSERT INTO `evaluate` VALUES ('171', '5', '4', '<p></p><p>借鉴借鉴军</p>', '2018-12-12 19:29:25', '0', '2');
INSERT INTO `evaluate` VALUES ('172', '3', '4', '风高放火个', '2018-12-12 21:27:06', '0', '7');
INSERT INTO `evaluate` VALUES ('173', '3', '4', '风高放火个', '2018-12-12 21:27:25', '0', '7');
INSERT INTO `evaluate` VALUES ('174', '3', '4', '风高放火个', '2018-12-12 21:27:29', '0', '7');
INSERT INTO `evaluate` VALUES ('175', '3', '4', '风高放火个', '2018-12-12 21:27:59', '0', '7');
INSERT INTO `evaluate` VALUES ('176', '3', '4', '风高放火个', '2018-12-12 21:29:27', '0', '7');
INSERT INTO `evaluate` VALUES ('177', '3', '4', 'UK扩扩扩扩', '2018-12-12 21:31:04', '0', '7');
INSERT INTO `evaluate` VALUES ('178', '3', '4', 'UK扩扩扩扩', '2018-12-12 21:31:09', '0', '7');
INSERT INTO `evaluate` VALUES ('179', '3', '2', '红花及', '2018-12-12 21:31:51', '0', '7');
INSERT INTO `evaluate` VALUES ('180', '3', '3', '好姐姐', '2018-12-12 21:32:04', '0', '7');
INSERT INTO `evaluate` VALUES ('181', '3', '2', '2', '2018-12-17 10:54:12', '0', '7');
INSERT INTO `evaluate` VALUES ('182', '3', '2', '2', '2018-12-17 10:54:13', '0', '7');
INSERT INTO `evaluate` VALUES ('183', '3', '2', '2', '2018-12-17 10:54:13', '0', '7');
INSERT INTO `evaluate` VALUES ('184', '3', '2', '2', '2018-12-17 10:54:14', '0', '7');
INSERT INTO `evaluate` VALUES ('185', '3', '2', '2', '2018-12-17 10:54:15', '0', '7');
INSERT INTO `evaluate` VALUES ('186', '3', '2', 'hh', '2018-12-17 10:55:32', '0', '7');
INSERT INTO `evaluate` VALUES ('187', '3', '2', 'hh', '2018-12-17 10:55:33', '0', '7');
INSERT INTO `evaluate` VALUES ('188', '3', '2', 'hh', '2018-12-17 10:55:34', '0', '7');
INSERT INTO `evaluate` VALUES ('189', '3', '2', 'hh', '2018-12-17 10:55:35', '0', '7');
INSERT INTO `evaluate` VALUES ('190', '3', '2', 'd', '2018-12-17 10:57:00', '0', '7');
INSERT INTO `evaluate` VALUES ('191', '3', '2', 'd', '2018-12-17 10:57:05', '0', '7');
INSERT INTO `evaluate` VALUES ('192', '3', '2', 'd', '2018-12-17 10:57:05', '0', '7');
INSERT INTO `evaluate` VALUES ('193', '3', '2', 'd', '2018-12-17 10:57:37', '0', '7');
INSERT INTO `evaluate` VALUES ('194', '3', '2', 'd', '2018-12-17 10:58:21', '0', '7');
INSERT INTO `evaluate` VALUES ('195', '3', '2', 'd', '2018-12-17 10:58:48', '0', '7');
INSERT INTO `evaluate` VALUES ('196', '3', '2', 'd', '2018-12-17 10:59:42', '0', '7');
INSERT INTO `evaluate` VALUES ('197', '3', '2', 'd', '2018-12-17 10:59:53', '0', '7');
INSERT INTO `evaluate` VALUES ('198', '3', '2', 'd', '2018-12-17 11:00:25', '0', '7');
INSERT INTO `evaluate` VALUES ('199', '3', '1', '1', '2018-12-17 11:11:30', '0', '7');
INSERT INTO `evaluate` VALUES ('200', '3', '1', '1', '2018-12-17 11:11:34', '0', '7');
INSERT INTO `evaluate` VALUES ('201', '3', '1', '1', '2018-12-17 11:11:37', '0', '7');
INSERT INTO `evaluate` VALUES ('202', '3', '1', '1', '2018-12-17 11:11:41', '0', '7');
INSERT INTO `evaluate` VALUES ('203', '3', '1', '1', '2018-12-17 11:11:43', '0', '7');
INSERT INTO `evaluate` VALUES ('204', '3', '1', '1', '2018-12-17 11:11:46', '0', '7');
INSERT INTO `evaluate` VALUES ('205', '3', '1', '1', '2018-12-17 11:11:49', '0', '7');
INSERT INTO `evaluate` VALUES ('206', '3', '1', '1', '2018-12-17 11:11:52', '0', '7');
INSERT INTO `evaluate` VALUES ('207', '3', '1', '1', '2018-12-17 11:11:55', '0', '7');
INSERT INTO `evaluate` VALUES ('208', '3', '1', '1', '2018-12-17 11:11:58', '0', '7');
INSERT INTO `evaluate` VALUES ('209', '3', '1', '1', '2018-12-17 11:12:01', '0', '7');
INSERT INTO `evaluate` VALUES ('210', '3', '1', '1', '2018-12-17 11:12:05', '0', '7');
INSERT INTO `evaluate` VALUES ('211', '3', '1', '1', '2018-12-17 11:12:08', '0', '7');
INSERT INTO `evaluate` VALUES ('212', '3', '1', '1', '2018-12-17 11:12:12', '0', '7');
INSERT INTO `evaluate` VALUES ('213', '3', '1', '1', '2018-12-17 11:12:23', '0', '7');
INSERT INTO `evaluate` VALUES ('214', '3', '1', '1', '2018-12-17 11:12:27', '0', '7');
INSERT INTO `evaluate` VALUES ('215', '3', '1', '1', '2018-12-17 11:12:34', '0', '7');
INSERT INTO `evaluate` VALUES ('216', '3', '1', '1', '2018-12-17 11:12:41', '0', '7');
INSERT INTO `evaluate` VALUES ('217', '3', '1', 'jjj', '2018-12-17 11:17:41', '0', '7');
INSERT INTO `evaluate` VALUES ('218', '3', '3', '1', '2018-12-17 11:31:31', '0', '7');
INSERT INTO `evaluate` VALUES ('219', '3', '3', '1', '2018-12-17 11:33:43', '0', '7');
INSERT INTO `evaluate` VALUES ('220', '3', '3', '', '2018-12-17 11:33:53', '0', '7');
INSERT INTO `evaluate` VALUES ('221', '3', '3', '2', '2018-12-17 11:33:57', '0', '7');
INSERT INTO `evaluate` VALUES ('222', '3', '3', '2', '2018-12-17 11:33:57', '0', '7');
INSERT INTO `evaluate` VALUES ('223', '3', '3', '2', '2018-12-17 11:33:57', '0', '7');
INSERT INTO `evaluate` VALUES ('224', '3', '3', '2', '2018-12-17 11:33:58', '0', '7');
INSERT INTO `evaluate` VALUES ('225', '3', '3', '2', '2018-12-17 11:33:59', '0', '7');
INSERT INTO `evaluate` VALUES ('226', '3', '3', '2', '2018-12-17 11:34:04', '0', '7');
INSERT INTO `evaluate` VALUES ('227', '3', '3', '2', '2018-12-17 11:34:05', '0', '7');
INSERT INTO `evaluate` VALUES ('228', '3', '3', '2', '2018-12-17 11:34:05', '0', '7');
INSERT INTO `evaluate` VALUES ('229', '3', '3', '2', '2018-12-17 11:34:05', '0', '7');
INSERT INTO `evaluate` VALUES ('230', '3', '3', '2', '2018-12-17 11:34:06', '0', '7');
INSERT INTO `evaluate` VALUES ('231', '3', '3', '2', '2018-12-17 11:34:06', '0', '7');
INSERT INTO `evaluate` VALUES ('232', '3', '3', '2', '2018-12-17 11:34:06', '0', '7');
INSERT INTO `evaluate` VALUES ('233', '3', '3', '2', '2018-12-17 11:34:06', '0', '7');
INSERT INTO `evaluate` VALUES ('234', '3', '3', '2', '2018-12-17 11:34:06', '0', '7');
INSERT INTO `evaluate` VALUES ('235', '3', '3', '2', '2018-12-17 11:34:07', '0', '7');
INSERT INTO `evaluate` VALUES ('236', '3', '3', '2', '2018-12-17 11:34:12', '0', '7');
INSERT INTO `evaluate` VALUES ('237', '3', '3', '2', '2018-12-17 11:34:13', '0', '7');
INSERT INTO `evaluate` VALUES ('238', '3', '1', 'sdfsf', '2018-12-17 13:54:05', '0', '7');
INSERT INTO `evaluate` VALUES ('239', '3', '1', 'sdfsfsfdffds', '2018-12-17 13:54:14', '0', '7');
INSERT INTO `evaluate` VALUES ('240', '3', '1', 'jjjjjj', '2018-12-17 13:57:20', '0', '7');
INSERT INTO `evaluate` VALUES ('241', '3', '2', '犯得上发生', '2018-12-17 14:00:03', '0', '7');
INSERT INTO `evaluate` VALUES ('242', '3', '2', '', '2018-12-17 14:00:09', '0', '7');
INSERT INTO `evaluate` VALUES ('243', '3', '1', '发顺丰', '2018-12-17 14:14:35', '0', '7');
INSERT INTO `evaluate` VALUES ('244', '3', '1', 'jjj', '2018-12-17 14:51:33', '0', '7');
INSERT INTO `evaluate` VALUES ('245', '3', '1', '撒地方', '2018-12-17 14:52:29', '0', '7');
INSERT INTO `evaluate` VALUES ('246', '3', '1', '撒旦哇塞', '2018-12-17 14:53:16', '0', '7');
INSERT INTO `evaluate` VALUES ('247', '3', '1', 'jjjjjjj', '2018-12-17 14:54:19', '0', '7');
INSERT INTO `evaluate` VALUES ('248', '3', '1', 'jjj', '2018-12-17 14:54:41', '0', '7');
INSERT INTO `evaluate` VALUES ('249', '3', '1', '太让人', '2018-12-17 14:54:53', '0', '7');
INSERT INTO `evaluate` VALUES ('250', '3', '1', '太让人 热风', '2018-12-17 14:55:02', '0', '7');
INSERT INTO `evaluate` VALUES ('251', '3', '1', 'nn', '2018-12-17 14:55:41', '0', '7');
INSERT INTO `evaluate` VALUES ('252', '3', '1', 'nn', '2018-12-17 14:55:51', '0', '7');
INSERT INTO `evaluate` VALUES ('253', '3', '1', '阿斯蒂芬', '2018-12-17 15:03:58', '0', '7');
INSERT INTO `evaluate` VALUES ('254', '3', '1', '阿斯蒂芬发士大夫', '2018-12-17 15:04:09', '0', '7');
INSERT INTO `evaluate` VALUES ('255', '3', '1', 'hhhhhh', '2018-12-17 15:04:40', '0', '7');
INSERT INTO `evaluate` VALUES ('256', '3', '1', 'jjjjjj', '2018-12-17 15:04:51', '0', '7');
INSERT INTO `evaluate` VALUES ('257', '3', '1', 'jjjjjj', '2018-12-17 15:08:42', '0', '7');
INSERT INTO `evaluate` VALUES ('258', '3', '1', 'jjjj', '2018-12-17 15:16:04', '0', '7');
INSERT INTO `evaluate` VALUES ('259', '3', '1', '发士大夫我', '2018-12-17 15:16:41', '0', '7');
INSERT INTO `evaluate` VALUES ('260', '3', '1', '给', '2018-12-17 15:35:50', '0', '7');
INSERT INTO `evaluate` VALUES ('261', '3', '2', '', '2018-12-17 15:54:59', '0', '7');
INSERT INTO `evaluate` VALUES ('262', '3', '2', '', '2018-12-17 15:55:13', '0', '7');
INSERT INTO `evaluate` VALUES ('263', '3', '1', '但是都是富人', '2018-12-17 15:55:31', '0', '7');
INSERT INTO `evaluate` VALUES ('264', '3', '2', '哼哼唧唧', '2018-12-17 15:56:03', '0', '7');
INSERT INTO `evaluate` VALUES ('265', '3', '2', '哼哼唧唧', '2018-12-17 15:56:12', '0', '7');
INSERT INTO `evaluate` VALUES ('266', '3', '2', '哼哼唧唧 卡罗拉', '2018-12-17 15:56:55', '0', '7');
INSERT INTO `evaluate` VALUES ('267', '3', '2', '', '2018-12-17 16:09:40', '0', '7');
INSERT INTO `evaluate` VALUES ('268', '3', '1', '我', '2018-12-17 16:10:08', '0', '7');
INSERT INTO `evaluate` VALUES ('269', '3', '2', '法法师的', '2018-12-17 16:14:10', '0', '7');
INSERT INTO `evaluate` VALUES ('270', '3', '1', '对方的丰富的', '2018-12-17 16:14:24', '0', '7');
INSERT INTO `evaluate` VALUES ('271', '3', '1', '撒旦发射点发射点', '2018-12-17 16:14:41', '0', '7');
INSERT INTO `evaluate` VALUES ('272', '3', '1', '', '2018-12-17 16:20:37', '0', '7');
INSERT INTO `evaluate` VALUES ('273', '3', '1', '哈哈哈哈', '2018-12-17 16:22:39', '0', '7');
INSERT INTO `evaluate` VALUES ('274', '3', '1', '哈哈哈哈', '2018-12-17 16:22:52', '0', '7');
INSERT INTO `evaluate` VALUES ('275', '3', '1', '', '2018-12-17 16:23:08', '0', '7');
INSERT INTO `evaluate` VALUES ('276', '3', '1', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-17 16:23:30', '0', '7');
INSERT INTO `evaluate` VALUES ('277', '3', '1', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\" style=\"letter-spacing: 0.1em;\"><br></p>', '2018-12-17 16:23:48', '0', '7');
INSERT INTO `evaluate` VALUES ('278', '3', '1', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-17 16:24:54', '0', '7');
INSERT INTO `evaluate` VALUES ('279', '3', '1', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-17 16:25:06', '0', '7');
INSERT INTO `evaluate` VALUES ('280', '3', '1', '<p></p><p><br></p>', '2018-12-17 16:26:33', '0', '7');
INSERT INTO `evaluate` VALUES ('281', '3', '1', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/3c/pcmoren_wu_org.png\" alt=\"[污]\" data-w-e=\"1\"><br></p>', '2018-12-17 16:28:09', '0', '7');
INSERT INTO `evaluate` VALUES ('282', '3', '1', '<p></p><p>好听好听</p>', '2018-12-20 17:13:20', '0', '6');
INSERT INTO `evaluate` VALUES ('283', '3', '1', '<p></p><p>好听好听</p>', '2018-12-20 17:13:28', '0', '6');
INSERT INTO `evaluate` VALUES ('284', '3', '1', '<p></p><p>可以</p>', '2018-12-20 17:13:43', '0', '6');
INSERT INTO `evaluate` VALUES ('285', '3', '1', '<p></p><p>好听</p>', '2018-12-20 17:15:52', '0', '6');
INSERT INTO `evaluate` VALUES ('286', '3', '1', '<p></p><p>好听</p>', '2018-12-20 17:15:55', '0', '6');
INSERT INTO `evaluate` VALUES ('287', '3', '1', '<p></p><p>好听</p>', '2018-12-20 17:15:56', '0', '6');
INSERT INTO `evaluate` VALUES ('288', '3', '1', '<p></p><p>好听</p>', '2018-12-20 17:15:56', '0', '6');
INSERT INTO `evaluate` VALUES ('289', '3', '1', '<p></p><p>出错了</p>', '2018-12-20 17:39:50', '0', '6');
INSERT INTO `evaluate` VALUES ('300', '3', '5', '就缓解缓解', '2018-12-13 07:50:42', '0', '7');
INSERT INTO `evaluate` VALUES ('301', '3', '5', '', '2018-12-13 07:55:27', '0', '7');
INSERT INTO `evaluate` VALUES ('302', '3', '5', '', '2018-12-13 07:56:07', '0', '7');
INSERT INTO `evaluate` VALUES ('303', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-13 08:03:21', '0', '7');
INSERT INTO `evaluate` VALUES ('304', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\">计算机<br></p>', '2018-12-13 08:03:48', '0', '7');
INSERT INTO `evaluate` VALUES ('305', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\">计算机<br>互联网</p>', '2018-12-13 08:04:47', '0', '7');
INSERT INTO `evaluate` VALUES ('306', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-13 08:10:38', '0', '7');
INSERT INTO `evaluate` VALUES ('307', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-13 08:13:02', '0', '7');
INSERT INTO `evaluate` VALUES ('308', '3', '5', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-13 08:13:26', '0', '7');
INSERT INTO `evaluate` VALUES ('309', '3', '2', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\"><br></p>', '2018-12-13 09:17:53', '0', '7');
INSERT INTO `evaluate` VALUES ('310', '3', '2', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\">文峰大沙发123<br></p>', '2018-12-13 09:18:00', '0', '7');
INSERT INTO `evaluate` VALUES ('311', '3', '2', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\">文峰大沙发123<br></p>', '2018-12-13 09:18:39', '0', '7');
INSERT INTO `evaluate` VALUES ('312', '3', '2', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\">文峰大沙发123反对党爽肤水<br></p>', '2018-12-13 09:18:49', '0', '7');
INSERT INTO `evaluate` VALUES ('313', '3', '14', '<p></p><p>的冯绍峰</p>', '2018-12-13 09:27:17', '0', '7');
INSERT INTO `evaluate` VALUES ('314', '3', '14', '<p></p><p>蛊惑江湖赶紧改</p>', '2018-12-13 09:31:39', '0', '7');
INSERT INTO `evaluate` VALUES ('315', '3', '2', '<p></p><p>sdjl;afkjal;skjfa;lsdjfl;asdkjflkadj</p>', '2018-12-13 20:11:31', '0', '7');
INSERT INTO `evaluate` VALUES ('316', '3', '18', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-13 20:23:49', '0', '7');
INSERT INTO `evaluate` VALUES ('317', '3', '19', '<p></p><p>打发第三方</p>', '2018-12-14 21:53:06', '0', '7');
INSERT INTO `evaluate` VALUES ('318', '3', '19', '<p></p><p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\"><br></p>', '2018-12-14 22:08:57', '0', '7');
INSERT INTO `evaluate` VALUES ('319', '3', '24', '<p></p><p><br></p>', '2018-12-14 22:09:52', '0', '7');
INSERT INTO `evaluate` VALUES ('320', '3', '25', '<p></p><p>士大夫撒地方</p>', '2018-12-15 22:06:07', '0', '7');
INSERT INTO `evaluate` VALUES ('321', '3', '6', '<p></p><p>我么十九点九分</p>', '2018-12-17 11:20:30', '0', '7');
INSERT INTO `evaluate` VALUES ('322', '3', '6', '<p></p><p>搞好该活动十分艰苦了</p>', '2018-12-17 11:20:49', '0', '7');
INSERT INTO `evaluate` VALUES ('323', '3', '6', '<p></p><p>1225566322</p>', '2018-12-17 11:21:03', '0', '7');
INSERT INTO `evaluate` VALUES ('324', '3', '6', '<p></p><p>asdas</p>', '2018-12-17 14:11:00', '0', '7');
INSERT INTO `evaluate` VALUES ('325', '3', '5', '<p></p><p>房贷首付</p>', '2018-12-17 14:24:15', '0', '7');
INSERT INTO `evaluate` VALUES ('326', '3', '5', '<p></p><p>士大夫顶顶顶顶</p>', '2018-12-17 15:03:27', '0', '7');
INSERT INTO `evaluate` VALUES ('327', '3', '5', '<p></p><p>烦烦烦顶顶顶</p>', '2018-12-17 15:03:38', '0', '7');
INSERT INTO `evaluate` VALUES ('328', '3', '5', '<p></p><p>繁多的高度发达地方</p>', '2018-12-17 15:04:28', '0', '7');
INSERT INTO `evaluate` VALUES ('329', '3', '4', '<p>孙明伟好傻啊</p><p><br></p>', '2018-12-17 15:24:36', '0', '7');
INSERT INTO `evaluate` VALUES ('330', '3', '4', '<p></p><p>孙明伟傻</p>', '2018-12-17 15:26:12', '0', '7');
INSERT INTO `evaluate` VALUES ('331', '3', '4', '<p></p><p>孙明伟傻</p>', '2018-12-17 15:26:42', '0', '7');
INSERT INTO `evaluate` VALUES ('332', '3', '4', '<p></p><p>孙明伟傻</p>', '2018-12-17 15:27:06', '0', '7');
INSERT INTO `evaluate` VALUES ('333', '3', '4', '<p></p><p>sdf', '2018-12-17 15:28:45', '0', '7');
INSERT INTO `evaluate` VALUES ('334', '3', '4', '<p></p><p>王家辉</p>', '2018-12-17 15:29:02', '0', '7');
INSERT INTO `evaluate` VALUES ('335', '3', '5', '<p></p><p>我们好棒</p>', '2018-12-17 15:33:39', '0', '7');
INSERT INTO `evaluate` VALUES ('336', '3', '5', '<p></p><p>范德萨范德萨</p>', '2018-12-17 15:49:46', '0', '7');
INSERT INTO `evaluate` VALUES ('337', '3', '5', '<p></p><p>撒打算</p>', '2018-12-17 16:15:17', '0', '7');
INSERT INTO `evaluate` VALUES ('338', '3', '4', '<p></p><p>是范德萨发</p>', '2018-12-17 16:17:33', '0', '7');
INSERT INTO `evaluate` VALUES ('339', '3', '4', '<p></p><p>是范德萨发<img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/50/pcmoren_huaixiao_org.png\" alt=\"[坏笑]\" data-w-e=\"1\" style=\"letter-spacing: 0.1em;\"></p>', '2018-12-17 16:17:55', '0', '7');
INSERT INTO `evaluate` VALUES ('340', '3', '5', '<p></p><p>撒旦发射点</p>', '2018-12-17 16:18:16', '0', '7');
INSERT INTO `evaluate` VALUES ('341', '3', '5', '<p></p><p>sdsf</p>', '2018-12-21 16:24:41', '0', '6');
INSERT INTO `evaluate` VALUES ('342', '3', '5', '<p>可以的</p>', '2018-12-21 16:24:51', '0', '6');
INSERT INTO `evaluate` VALUES ('343', '3', '5', '<p>可以的</p>', '2018-12-21 16:25:50', '0', '6');
INSERT INTO `evaluate` VALUES ('344', '3', '1', '<p></p><p>圣诞节</p>', '2018-12-21 16:33:58', '0', '6');
INSERT INTO `evaluate` VALUES ('345', '3', '5', '<p></p><p>ok<br></p>', '2018-12-21 16:46:17', '0', '6');
INSERT INTO `evaluate` VALUES ('346', '3', '5', '<p></p><p>欧克</p>', '2018-12-21 17:55:18', '0', '6');
INSERT INTO `evaluate` VALUES ('347', '3', '5', '<p></p><p>sdfs</p>', '2018-12-24 08:46:52', '0', '6');
INSERT INTO `evaluate` VALUES ('348', '3', '5', '<p>fffff</p>', '2018-12-24 08:46:56', '0', '6');
INSERT INTO `evaluate` VALUES ('349', '3', '1', '<p></p><p>SDFS</p>', '2018-12-24 13:44:12', '0', '6');
INSERT INTO `evaluate` VALUES ('350', '3', '5', '<p></p><p>SDFS</p>', '2018-12-24 13:45:35', '0', '6');
INSERT INTO `evaluate` VALUES ('351', '3', '5', '<p></p><p>两科</p>', '2018-12-24 16:28:42', '0', '6');
INSERT INTO `evaluate` VALUES ('352', '3', '1', '<p></p><p>胜多负少</p>', '2018-12-25 16:02:29', '0', '6');
INSERT INTO `evaluate` VALUES ('353', '3', '1', '<p></p><p>胜多负少</p>', '2018-12-25 16:02:41', '0', '6');
INSERT INTO `evaluate` VALUES ('354', '3', '1', '<p></p><p>大是大非</p>', '2018-12-25 16:03:15', '0', '6');
INSERT INTO `evaluate` VALUES ('355', '3', '1', '<p></p><p>适当放宽就是</p>', '2018-12-25 16:03:40', '0', '6');
INSERT INTO `evaluate` VALUES ('356', '3', '1', '<p></p><p>适当放宽就是</p>', '2018-12-25 16:03:48', '0', '6');
INSERT INTO `evaluate` VALUES ('357', '3', '1', '<p></p><p>的方法的</p>', '2018-12-25 16:05:13', '0', '6');
INSERT INTO `evaluate` VALUES ('358', '3', '1', '<p></p><p>胜多负少烦烦烦</p>', '2018-12-25 16:05:28', '0', '6');
INSERT INTO `evaluate` VALUES ('359', '3', '1', '<p></p><p>收到复</p>', '2018-12-25 16:14:36', '0', '6');
INSERT INTO `evaluate` VALUES ('360', '3', '1', '<p></p><p>士大夫但是</p>', '2018-12-25 16:14:53', '0', '6');
INSERT INTO `evaluate` VALUES ('361', '3', '2', '<p></p><p>上帝是', '2018-12-25 16:35:59', '0', '6');

-- ----------------------------
-- Table structure for `listenrecord`
-- ----------------------------
DROP TABLE IF EXISTS `listenrecord`;
CREATE TABLE `listenrecord` (
  `listenrecordId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `listenrecordOrderTime` varchar(50) NOT NULL,
  `listenrecordStartTime` varchar(50) DEFAULT NULL,
  `listenrecordEndTime` varchar(50) DEFAULT NULL,
  `listenrecordPrice` float(20,0) DEFAULT NULL,
  `listenrecordState` varchar(50) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `listenrecordResourcePath` varchar(1024) DEFAULT NULL,
  `randomNum` varchar(50) DEFAULT NULL,
  `listenState` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`listenrecordId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of listenrecord
-- ----------------------------
INSERT INTO `listenrecord` VALUES ('1', '2', '2018-12-21', '6:00', '23:00', '12', '已支付', '6', null, '1245236584', '未倾听');
INSERT INTO `listenrecord` VALUES ('2', '6', '2018-12-21', '7:00', '15:00', '12', '已支付', '4', null, '1235212365', '未倾听');
INSERT INTO `listenrecord` VALUES ('31', '6', '2018-12-20', null, null, '20', null, '6', null, '7702262005', null);
INSERT INTO `listenrecord` VALUES ('32', '6', '2018-12-21', null, null, '20', null, '1', null, '8033120395', null);

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacherId` int(11) NOT NULL,
  `teacherWorkTime` int(11) DEFAULT NULL,
  `teacherPraiseRate` float DEFAULT NULL,
  `teacherPrice` float DEFAULT NULL,
  `teacherIntroduction` text,
  `authenticationAptitudeName` varchar(1024) DEFAULT NULL,
  `goodats` varchar(1024) DEFAULT NULL,
  `teacherListenTime` int(11) DEFAULT '0',
  `age` int(11) DEFAULT NULL,
  `canListen` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '4', '99', '888', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家二级心理咨询师 \r\n儿童青少年人际关 \r\n中国心理卫生协会会员 \r\n北京市婚姻协会心理咨询师 \r\n北京市通州区妇联特邀心理专家 \r\n北京市通州区明心社工事务所创办人', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '30', '1');
INSERT INTO `teacher` VALUES ('2', '8', '96', '666', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家一级222 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '35', '0');
INSERT INTO `teacher` VALUES ('3', '5', '97.1', '536', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家二级咨询师 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '28', '0');
INSERT INTO `teacher` VALUES ('4', '1', '99', '300', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家一级666 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');
INSERT INTO `teacher` VALUES ('5', '5', '100', '500', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家一级999 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');
INSERT INTO `teacher` VALUES ('6', '10', '100', '500', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家一级888 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '112', '12', '1');
INSERT INTO `teacher` VALUES ('7', '2', '98', '400', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家一级555 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '50', '12', '0');
INSERT INTO `teacher` VALUES ('8', '6', '99.9', '886', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家二级666 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');
INSERT INTO `teacher` VALUES ('9', '5', '96.2', '586', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家特级咨询师 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');
INSERT INTO `teacher` VALUES ('10', '9', '89', '365', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '7级咨询师 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');
INSERT INTO `teacher` VALUES ('11', '8', '86.2', '868', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '心理咨询师 心理咨询师', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '1');
INSERT INTO `teacher` VALUES ('12', '12', '99.9', '568', '北京师范大学心理学（学术型）硕士；北京高校专职心理教师，心理健康工作室负责人。目前临床专业工作累计2500以上小时，13年的心理学研究与应用，10年的被督导经验，督导累计900小时以上，舞动督导150多小时，个人体验300小时，并继续专业理论学习。专业受训超3000学时；舞动受训1200学时以上，舞动团体带领1000学时以上，个体咨询工作近1000小时。吾爱舞舞动身心灵团队核心成员、舞动同辈督导流程研发者，某平台心理产品研发者。|\r\n中德舞动治疗职业训练，2012年至今舞动受训包括：舞动治疗理论与实务、拉班动作分析、凯斯腾伯格动作分析、巴特尼夫基本动作、切斯技法、真实动作技法、心理动能舞动、舞动团体进程、舞动家庭重塑、美国儿童舞动治疗项目“Way of seeing”、老年人舞动、舞动用于身心疾病、舞动论文写作、舞动自我体验、舞动督导等。|\r\n心理咨询与治疗的相关训练：|\r\n完形治疗系统培训       2012-2014年|\r\n人际沟通分析系统培训   2011-2012年|\r\n萨提亚家庭治疗系统培训 2014-2016年|\r\n全球职业规划师         2012年|\r\n精神分析—中间学派     2018—至今|\r\n舞动治疗中方导师选拔班 2018—至今|\r\n个体心理咨询过程与方法、心理剧、绘画治疗、音乐治疗、身体取向治疗、声音动作、邓肯舞集、游戏治疗、本体治疗、人际动力团体、欧文亚龙团体治疗、咨询伦理、焦点解决取向等受训。|\r\n舞动实践|\r\n主要对象：儿童、青少年、家长、亲子、家庭、大学生、成人|\r\n工作领域：自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验。长期带领“放飞自我舞动小组”“生涯规划舞动小组”“亲密关系成长舞动小组”“女性自我成长工作坊”“情绪管理舞动小组”“儿童游戏舞动团体”等。|\r\n曾经服务的对象|\r\n幼儿园：北京国防一幼、北京农大西幼、北京平谷二幼、北京福怡苑幼儿园等|\r\n中小学：北京小学翡翠城、北京中关村一小、北京中关村四小、北京黄城根小学、农大附中（北京）、西安博文学校等|\r\n大学：北师大、中戏、农大、北科大、北工大、北建大、北交大、北舞、北电、传媒大学、首师大等|\r\n企事业：北京联通、首都机场、北京朝阳电力、北京建工修复、诺华制药、北京东城审计局等|\r\n其他专业服务经验|\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n', '国家特高咨询师698 心理咨询师666', '婚姻情感|家庭关系|亲子教育|个人成长', '0', '12', '0');

-- ----------------------------
-- Table structure for `teachertime`
-- ----------------------------
DROP TABLE IF EXISTS `teachertime`;
CREATE TABLE `teachertime` (
  `teachertimeId` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL,
  `date` varchar(50) NOT NULL,
  `time8` int(11) DEFAULT NULL,
  `time9` int(11) DEFAULT NULL,
  `time10` int(11) DEFAULT NULL,
  `time11` int(11) DEFAULT NULL,
  `time12` int(11) DEFAULT NULL,
  `time13` int(11) DEFAULT NULL,
  `time14` int(11) DEFAULT NULL,
  `time15` int(11) DEFAULT NULL,
  `time16` int(11) DEFAULT NULL,
  `time17` int(11) DEFAULT NULL,
  `time18` int(11) DEFAULT NULL,
  `time19` int(11) DEFAULT NULL,
  PRIMARY KEY (`teachertimeId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachertime
-- ----------------------------
INSERT INTO `teachertime` VALUES ('1', '4', '2018-11-27', '1', '1', '0', '0', '-1', '1', '0', '-1', '1', '1', '-1', '-1');
INSERT INTO `teachertime` VALUES ('2', '5', '2018-11-27', '0', '1', '0', '1', '1', '0', '0', '1', '-1', '1', '-1', '-1');
INSERT INTO `teachertime` VALUES ('3', '6', '2018-12-20', '0', '1', '0', '0', '-1', '-1', '-1', '-1', '-1', '0', '1', '0');
INSERT INTO `teachertime` VALUES ('4', '7', '2018-11-27', '0', '-1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1');
INSERT INTO `teachertime` VALUES ('5', '2', '2018-11-27', '1', '1', '0', '0', '-1', '1', '1', '0', '-1', '0', '1', '1');
INSERT INTO `teachertime` VALUES ('6', '1', '2018-12-02', '0', '-1', '0', '1', '1', '0', '-1', '0', '-1', '1', '0', '0');
INSERT INTO `teachertime` VALUES ('7', '1', '2018-11-28', '0', '-1', '0', '1', '0', '1', '1', '-1', '-1', '0', '0', '0');
INSERT INTO `teachertime` VALUES ('8', '1', '2018-12-19', '0', '1', '1', '0', '1', '0', '0', '1', '1', '1', '0', '1');
INSERT INTO `teachertime` VALUES ('9', '4', '2018-12-19', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '-1');

-- ----------------------------
-- Table structure for `typetable`
-- ----------------------------
DROP TABLE IF EXISTS `typetable`;
CREATE TABLE `typetable` (
  `typetableId` int(11) NOT NULL AUTO_INCREMENT,
  `typetableName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`typetableId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of typetable
-- ----------------------------
INSERT INTO `typetable` VALUES ('1', '婚姻');
INSERT INTO `typetable` VALUES ('2', '亲子');
INSERT INTO `typetable` VALUES ('3', '职场');
INSERT INTO `typetable` VALUES ('4', '健康');
INSERT INTO `typetable` VALUES ('5', '高效');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userHeadPath` varchar(1024) DEFAULT NULL,
  `userNickName` varchar(50) DEFAULT NULL,
  `userSex` varchar(10) DEFAULT NULL,
  `userRealName` varchar(50) DEFAULT NULL,
  `userIdNumber` varchar(50) DEFAULT NULL,
  `userAutograph` varchar(1024) DEFAULT NULL,
  `userPhone` varchar(50) DEFAULT NULL,
  `userPassword` varchar(50) DEFAULT NULL,
  `userRegistTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userIdentity` int(11) DEFAULT NULL,
  `userCity` varchar(50) DEFAULT NULL,
  `userEmail` varchar(50) DEFAULT NULL,
  `userProvince` varchar(255) DEFAULT NULL,
  `alipayUserId` varchar(255) DEFAULT NULL,
  `weiboUid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'images\\default-avatar.png', '阿斯蒂芬', '男', '段智兴', '123', '人只活一次，去自己尝试没体验过的1', '15226502952', '111', '2018-12-24 10:42:41', '1', '大连', null, null, null, null);
INSERT INTO `user` VALUES ('2', 'images\\default-avatar.png', '鲍张军', '男', '鲍张军', '456', '人只活一次，去自己尝试没体验过的2', '15226570821', '111', '2018-12-24 10:42:43', '1', '唐山', null, null, null, null);
INSERT INTO `user` VALUES ('3', 'images\\default-avatar.png', '热风', '男', '刘田会', '789', '人只活一次，去自己尝试没体验过的3', '15225670822', '111', '2018-12-25 16:05:03', '1', '廊坊', null, null, null, null);
INSERT INTO `user` VALUES ('4', 'images\\default-avatar.png', '华尔道夫', '男', '魏谦强', '147', '人只活一次，去自己尝试没体验过的4', '15226570823', '111', '2018-12-24 10:42:48', '2', '女儿国', null, null, null, null);
INSERT INTO `user` VALUES ('5', 'images\\default-avatar.png', '迪士尼', '女', '邓旸', '258', '人只活一次，去自己尝试没体验过的5', '15226570824', '111', '2018-12-24 10:42:49', '1', '福建', null, null, null, null);
INSERT INTO `user` VALUES ('6', 'images\\default-avatar.png', '热风', '女', '张春辉', '369', '人只活一次，去自己尝试没体验过的6', '15226502915', '52712666', '2018-12-25 16:05:01', '2', '唐山', null, null, null, null);
INSERT INTO `user` VALUES ('7', 'images\\default-avatar.png', '克罗夫', '男', '孙明伟', '000', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:42:53', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('8', 'images\\default-avatar.png', '克罗夫', '男', '孙明伟', '120', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:42:55', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('9', 'images\\default-avatar.png', '克罗夫', '男', '孙明伟', '666', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:42:57', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('10', 'images\\default-avatar.png', '克罗夫', '男', '邓旸', '66', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:43:00', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('11', 'images\\default-avatar.png', '克罗夫', '男', '邓旸', '666', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:43:02', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('12', 'images\\default-avatar.png', '克罗夫', '男', '张春辉', '66', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:43:04', '3', '石家庄', null, null, null, null);
INSERT INTO `user` VALUES ('13', 'images\\default-avatar.png', '克罗夫', '男', '张春辉', '66', '人只活一次，去自己尝试没体验过的7', '15226570826', '111', '2018-12-24 10:43:06', '3', '石家庄', null, null, null, null);

-- ----------------------------
-- Table structure for `userlabel`
-- ----------------------------
DROP TABLE IF EXISTS `userlabel`;
CREATE TABLE `userlabel` (
  `labelId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `userLabel` varchar(1024) DEFAULT NULL,
  `userLabelGrade` int(11) DEFAULT NULL,
  PRIMARY KEY (`labelId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userlabel
-- ----------------------------
INSERT INTO `userlabel` VALUES ('1', '1', '成长', '5');
INSERT INTO `userlabel` VALUES ('2', '1', '爱情', '1');
INSERT INTO `userlabel` VALUES ('3', '1', '专注', '2');
INSERT INTO `userlabel` VALUES ('4', '2', '成长', '3');
INSERT INTO `userlabel` VALUES ('5', '2', '效率', '3');
INSERT INTO `userlabel` VALUES ('6', '3', '家庭', '4');
