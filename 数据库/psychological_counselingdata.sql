/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : psychological_counseling

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2018-11-29 16:16:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answer`
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
`answerId`  int(11) NOT NULL AUTO_INCREMENT ,
`askId`  int(11) NULL DEFAULT NULL ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`answerContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`answerAnswerTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`answerGoodCount`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`answerId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Records of answer
-- ----------------------------
BEGIN;
INSERT INTO `answer` VALUES ('1', '1', '4', '情是1111', '2018-11-20 22:00:44', '10'), ('2', '1', '5', '情是222', '2018-11-20 22:00:45', '20'), ('3', '2', '5', '爱', '2018-11-20 22:00:47', '10'), ('4', '2', '6', '不爱', '2018-11-20 22:00:48', '11'), ('5', '2', '7', '哎什么哎', '2018-11-20 22:00:50', '12');
COMMIT;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
`articleId`  int(11) NOT NULL AUTO_INCREMENT ,
`articleName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`articleImgPath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`articleIntroduction`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`articleContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`articlePublishTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`articleLookNumber`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`articleId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of article
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES ('1', '给青少年的一封信', '4', null, '魏老师的文章', '魏谦强写文章啦', '2018-11-13 08:55:31', '10'), ('2', '婚姻中的小事', '7', null, '孙老师的文章', '孙老师带你一起探索婚姻中的那些小事', '2018-11-15 11:56:21', '20'), ('3', '正确的人生观', '5', null, '邓老师的文章', '三观端正', '2018-11-19 15:57:13', '50');
COMMIT;

-- ----------------------------
-- Table structure for `ask`
-- ----------------------------
DROP TABLE IF EXISTS `ask`;
CREATE TABLE `ask` (
`askId`  int(11) NOT NULL AUTO_INCREMENT ,
`askTitle`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`askContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`userId`  int(11) NULL DEFAULT NULL ,
`askTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`askLookNumber`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`askId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of ask
-- ----------------------------
BEGIN;
INSERT INTO `ask` VALUES ('1', '问情为何物', '情到底是什么', '1', '2018-11-20 21:59:34', '10'), ('2', '你到底爱不爱我', '爱爱爱爱爱', '2', '2018-11-20 21:59:37', '10');
COMMIT;

-- ----------------------------
-- Table structure for `authentication`
-- ----------------------------
DROP TABLE IF EXISTS `authentication`;
CREATE TABLE `authentication` (
`authenticationId`  int(11) NOT NULL AUTO_INCREMENT ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`authenticationAptitudeName`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`authenticationId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=11

;

-- ----------------------------
-- Records of authentication
-- ----------------------------
BEGIN;
INSERT INTO `authentication` VALUES ('1', '4', '国家二级咨询师'), ('2', '4', '巴拉巴拉资质一'), ('3', '4', '啦啦啦啦资质二'), ('4', '5', '国家二级咨询师'), ('5', '5', '巴拉巴拉资质一'), ('6', '5', '啦啦啦啦资质二'), ('7', '6', '国家二级咨询师'), ('8', '6', '巴拉巴拉资质一'), ('9', '7', '国家二级咨询师'), ('10', '7', '啦啦啦啦资质二');
COMMIT;

-- ----------------------------
-- Table structure for `businesstype`
-- ----------------------------
DROP TABLE IF EXISTS `businesstype`;
CREATE TABLE `businesstype` (
`businesstypeId`  int(11) NOT NULL AUTO_INCREMENT ,
`businesstypeWorkType`  int(11) NULL DEFAULT NULL ,
`businesstypeWorkId`  int(11) NULL DEFAULT NULL ,
`typetableId`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`businesstypeId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=15

;

-- ----------------------------
-- Records of businesstype
-- ----------------------------
BEGIN;
INSERT INTO `businesstype` VALUES ('1', '1', '4', '1'), ('2', '1', '4', '2'), ('3', '1', '5', '1'), ('4', '1', '5', '2'), ('5', '1', '5', '3'), ('6', '1', '6', '4'), ('7', '1', '7', '2'), ('8', '1', '7', '5'), ('9', '2', '1', '1'), ('10', '2', '2', '1'), ('11', '2', '2', '2'), ('12', '2', '2', '5'), ('13', '2', '3', '3'), ('14', '2', '4', '4');
COMMIT;

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
`collectionId`  int(11) NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL ,
`courseId`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`collectionId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of collection
-- ----------------------------
BEGIN;
INSERT INTO `collection` VALUES ('1', '1', '1'), ('2', '1', '2'), ('3', '2', '3'), ('4', '2', '2');
COMMIT;

-- ----------------------------
-- Table structure for `consultationrecord`
-- ----------------------------
DROP TABLE IF EXISTS `consultationrecord`;
CREATE TABLE `consultationrecord` (
`consultationrecordId`  int(11) NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL ,
`consultationrecordOrderTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`consultationrecordStartTime`  timestamp NULL DEFAULT '0000-00-00 00:00:00' ,
`consultationrecordEndTime`  timestamp NULL DEFAULT '0000-00-00 00:00:00' ,
`consultationrecordPrice`  float NULL DEFAULT NULL ,
`consultationrecordState`  int(11) NULL DEFAULT NULL ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`consultationrecordMethod`  int(11) NULL DEFAULT NULL ,
`consultationrecordResourcePath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`consultationrecordId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of consultationrecord
-- ----------------------------
BEGIN;
INSERT INTO `consultationrecord` VALUES ('1', '1', '2018-11-20 20:20:34', '2018-11-21 14:00:20', '2018-11-21 15:02:37', '300', '2', '5', '1', null), ('2', '2', '2018-11-13 20:20:37', '2018-11-21 20:20:46', '2018-11-13 21:21:55', '80', '1', '6', '3', null), ('3', '3', '2018-11-15 20:22:38', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '0', '3', '7', '2', null);
COMMIT;

-- ----------------------------
-- Table structure for `consultobject`
-- ----------------------------
DROP TABLE IF EXISTS `consultobject`;
CREATE TABLE `consultobject` (
`consultobjectId`  int(11) NOT NULL AUTO_INCREMENT ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`consultObject`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`consultobjectId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=9

;

-- ----------------------------
-- Records of consultobject
-- ----------------------------
BEGIN;
INSERT INTO `consultobject` VALUES ('1', '4', '中年人'), ('2', '4', '职业人士'), ('3', '5', '青少年'), ('4', '5', '幼儿'), ('5', '6', '青少年'), ('6', '6', '青年'), ('7', '7', '中年人'), ('8', '7', '婴幼儿');
COMMIT;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
`courseId`  int(11) NOT NULL AUTO_INCREMENT ,
`courseName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`coursePrice`  float NULL DEFAULT NULL ,
`courseRebate`  float NULL DEFAULT NULL ,
`courseIntroduction`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`courseImgPath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`courseStudentNumber`  int(11) NULL DEFAULT NULL ,
`courseSynopsis`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`courseId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', '如何教育孩子才能做到让孩子真正的心理成长', '4', '20', '0.9', '	每个现代人，一生中都需要接受至少一次基础心理教育，如同学习识字、算术一样。今天，心理健康已经成为人的最基本的生存条件。它使人，成为一个完整的人。心育心的心理培训，不仅仅是讲授心理学家发明、发现的理论，传授心理学知识。更重要的是，根据我们每天现实生活中出现的问题，运用这些知识，帮助每个人挖掘自身的问题与潜力。这个梳理、再造我们主观世界的过程，起初常常使人感到痛苦。但是，走过了艰难的路程以后，你会最终到达一个豁然开朗的境界。|\r\n|\r\n教学对象：|\r\n	教师：幼儿园、小学、中学、大学、职业学院教师|\r\n	家长：各年龄阶段孩子的家长|\r\n	职业人：各个层次职场人员|\r\n|\r\n教学目的：|\r\n	通过学习光盘多媒体课程辨认生活中问题的来源，在网上课堂的在线互动指导中学会处理，理解理论内化为自己解决问题的能力。最终对自己的人生带来真正的改变。|\r\n|\r\n教学作用:|\r\n	教授学员辨认自身的行为/心理模式和由此引发的各种情绪；| \r\n	学习用适当的方式接受并处理自身的情绪； |\r\n	增加对学生/孩子成长中的行为、心理变化的理解，与学生/孩子形成正向的、建设性的现代师生/亲子关系，以及正向的、建设性的现代职场/各类人际关系。|\r\n| \r\n教学方式： 行为/心理学 + 多媒体教学工具 == 在体验中学习|', 'images/course.jpg', '10', '这是魏谦强老师的一门课'), ('2', '高效学习', '5', '0', '1', '	每个现代人，一生中都需要接受至少一次基础心理教育，如同学习识字、算术一样。今天，心理健康已经成为人的最基本的生存条件。它使人，成为一个完整的人。心育心的心理培训，不仅仅是讲授心理学家发明、发现的理论，传授心理学知识。更重要的是，根据我们每天现实生活中出现的问题，运用这些知识，帮助每个人挖掘自身的问题与潜力。这个梳理、再造我们主观世界的过程，起初常常使人感到痛苦。但是，走过了艰难的路程以后，你会最终到达一个豁然开朗的境界。|\r\n|\r\n教学对象：|\r\n	教师：幼儿园、小学、中学、大学、职业学院教师|\r\n	家长：各年龄阶段孩子的家长|\r\n	职业人：各个层次职场人员|\r\n|\r\n教学目的：|\r\n	通过学习光盘多媒体课程辨认生活中问题的来源，在网上课堂的在线互动指导中学会处理，理解理论内化为自己解决问题的能力。最终对自己的人生带来真正的改变。|\r\n|\r\n教学作用:|\r\n	教授学员辨认自身的行为/心理模式和由此引发的各种情绪；| \r\n	学习用适当的方式接受并处理自身的情绪； |\r\n	增加对学生/孩子成长中的行为、心理变化的理解，与学生/孩子形成正向的、建设性的现代师生/亲子关系，以及正向的、建设性的现代职场/各类人际关系。|\r\n| \r\n教学方式： 行为/心理学 + 多媒体教学工具 == 在体验中学习|', 'images/course.jpg', '30', '这是邓旸老师的一门课'), ('3', '自我提升', '6', '0', '0.8', '	每个现代人，一生中都需要接受至少一次基础心理教育，如同学习识字、算术一样。今天，心理健康已经成为人的最基本的生存条件。它使人，成为一个完整的人。心育心的心理培训，不仅仅是讲授心理学家发明、发现的理论，传授心理学知识。更重要的是，根据我们每天现实生活中出现的问题，运用这些知识，帮助每个人挖掘自身的问题与潜力。这个梳理、再造我们主观世界的过程，起初常常使人感到痛苦。但是，走过了艰难的路程以后，你会最终到达一个豁然开朗的境界。|\r\n|\r\n教学对象：|\r\n	教师：幼儿园、小学、中学、大学、职业学院教师|\r\n	家长：各年龄阶段孩子的家长|\r\n	职业人：各个层次职场人员|\r\n|\r\n教学目的：|\r\n	通过学习光盘多媒体课程辨认生活中问题的来源，在网上课堂的在线互动指导中学会处理，理解理论内化为自己解决问题的能力。最终对自己的人生带来真正的改变。|\r\n|\r\n教学作用:|\r\n	教授学员辨认自身的行为/心理模式和由此引发的各种情绪；| \r\n	学习用适当的方式接受并处理自身的情绪； |\r\n	增加对学生/孩子成长中的行为、心理变化的理解，与学生/孩子形成正向的、建设性的现代师生/亲子关系，以及正向的、建设性的现代职场/各类人际关系。|\r\n| \r\n教学方式： 行为/心理学 + 多媒体教学工具 == 在体验中学习|', 'images/course.jpg', '20', '这是张春辉老师的一门课'), ('4', '家庭幸福', '7', '20', '0.9', '	每个现代人，一生中都需要接受至少一次基础心理教育，如同学习识字、算术一样。今天，心理健康已经成为人的最基本的生存条件。它使人，成为一个完整的人。心育心的心理培训，不仅仅是讲授心理学家发明、发现的理论，传授心理学知识。更重要的是，根据我们每天现实生活中出现的问题，运用这些知识，帮助每个人挖掘自身的问题与潜力。这个梳理、再造我们主观世界的过程，起初常常使人感到痛苦。但是，走过了艰难的路程以后，你会最终到达一个豁然开朗的境界。|\r\n|\r\n教学对象：|\r\n	教师：幼儿园、小学、中学、大学、职业学院教师|\r\n	家长：各年龄阶段孩子的家长|\r\n	职业人：各个层次职场人员|\r\n|\r\n教学目的：|\r\n	通过学习光盘多媒体课程辨认生活中问题的来源，在网上课堂的在线互动指导中学会处理，理解理论内化为自己解决问题的能力。最终对自己的人生带来真正的改变。|\r\n|\r\n教学作用:|\r\n	教授学员辨认自身的行为/心理模式和由此引发的各种情绪；| \r\n	学习用适当的方式接受并处理自身的情绪； |\r\n	增加对学生/孩子成长中的行为、心理变化的理解，与学生/孩子形成正向的、建设性的现代师生/亲子关系，以及正向的、建设性的现代职场/各类人际关系。|\r\n| \r\n教学方式： 行为/心理学 + 多媒体教学工具 == 在体验中学习|', 'images/course.jpg', '15', '这是孙明伟老师的一门课');
COMMIT;

-- ----------------------------
-- Table structure for `coursecatalog`
-- ----------------------------
DROP TABLE IF EXISTS `coursecatalog`;
CREATE TABLE `coursecatalog` (
`coursecatalogId`  int(11) NOT NULL AUTO_INCREMENT ,
`courseId`  int(11) NULL DEFAULT NULL ,
`coursecatalogParentId`  int(11) NULL DEFAULT NULL ,
`coursecatalogName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`coursecatalogResourcePath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`coursecatalogId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=14

;

-- ----------------------------
-- Records of coursecatalog
-- ----------------------------
BEGIN;
INSERT INTO `coursecatalog` VALUES ('1', '1', null, '1.1', null), ('2', '1', '1', '1.1.1', 'http://vjs.zencdn.net/v/oceans.mp4'), ('3', '1', null, '2.1', null), ('4', '1', '3', '2.1.1', 'http://vjs.zencdn.net/v/oceans.mp4'), ('5', '2', null, '1.1', null), ('6', '2', '5', '1.1.1', null), ('7', '2', null, '2.1', null), ('8', '2', '7', '2.1.1', null), ('9', '3', null, '1.1', null), ('10', '3', null, '2.1', null), ('11', '4', null, '1.1', null), ('12', '4', null, '2.1', null), ('13', '4', '12', '2.1.1', null);
COMMIT;

-- ----------------------------
-- Table structure for `courseorder`
-- ----------------------------
DROP TABLE IF EXISTS `courseorder`;
CREATE TABLE `courseorder` (
`courseorderId`  int(11) NOT NULL AUTO_INCREMENT ,
`courseId`  int(11) NULL DEFAULT NULL ,
`userId`  int(11) NULL DEFAULT NULL ,
`courseorderBuyTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`courseorderPrice`  float NULL DEFAULT NULL ,
PRIMARY KEY (`courseorderId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of courseorder
-- ----------------------------
BEGIN;
INSERT INTO `courseorder` VALUES ('1', '1', '1', '2018-11-20 21:46:22', '18'), ('2', '2', '2', '2018-11-19 21:47:11', '30'), ('3', '4', '3', '2018-11-20 21:48:17', '18');
COMMIT;

-- ----------------------------
-- Table structure for `courserecord`
-- ----------------------------
DROP TABLE IF EXISTS `courserecord`;
CREATE TABLE `courserecord` (
`courserecordId`  int(11) NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL ,
`courseId`  int(11) NULL DEFAULT NULL ,
`courserecordIsFinish`  int(11) NULL DEFAULT NULL ,
`courserecordStartTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`courserecordStopPosition`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`courserecordId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of courserecord
-- ----------------------------
BEGIN;
INSERT INTO `courserecord` VALUES ('1', '1', '1', '1', '2018-11-20 20:48:58', '10‘10'), ('2', '2', '3', '0', '2018-11-20 21:50:18', '12’30'), ('3', '3', '2', '0', '2018-11-20 21:50:24', '5‘12');
COMMIT;

-- ----------------------------
-- Table structure for `diary`
-- ----------------------------
DROP TABLE IF EXISTS `diary`;
CREATE TABLE `diary` (
`diaryId`  int(11) NOT NULL ,
`userId`  int(11) NULL DEFAULT NULL ,
`diaryRecordTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`diaryContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`diaryWeather`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`diaryId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of diary
-- ----------------------------
BEGIN;
INSERT INTO `diary` VALUES ('0', '1', '2018-11-13 16:01:08', '今天天气很好', '晴天');
COMMIT;

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
`dynamicId`  int(11) NOT NULL AUTO_INCREMENT ,
`dynamicPublishTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`dynamicTitle`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dynamicContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`dynamicImgPath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dynamicResourcePath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dynamicLink`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`dynamicId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
BEGIN;
INSERT INTO `dynamic` VALUES ('1', '2018-11-14 15:57:36', '动态一', '咚咚咚咚咚咚', null, null, null), ('2', '2018-11-17 14:58:02', '动态二', '啵啵啵啵啵啵啵啵啵', null, null, null);
COMMIT;

-- ----------------------------
-- Table structure for `evaluate`
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate` (
`evaluateId`  int(11) NOT NULL AUTO_INCREMENT ,
`evaluateWorkType`  int(11) NULL DEFAULT NULL ,
`evaluateWorkId`  int(11) NULL DEFAULT NULL ,
`evaluateComment`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`evaluateTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`evaluateStar`  int(11) NULL DEFAULT NULL ,
`userId`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`evaluateId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `goodat`
-- ----------------------------
DROP TABLE IF EXISTS `goodat`;
CREATE TABLE `goodat` (
`goodatId`  int(11) NOT NULL AUTO_INCREMENT ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`goodAt`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`goodatId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=11

;

-- ----------------------------
-- Records of goodat
-- ----------------------------
BEGIN;
INSERT INTO `goodat` VALUES ('1', '4', '亲子'), ('2', '4', '婚姻'), ('3', '4', '家庭'), ('4', '5', '青少年'), ('5', '5', '儿童成长'), ('6', '6', '注意力训练'), ('7', '6', '亲子'), ('8', '6', '青少年'), ('9', '7', '家庭'), ('10', null, '亲子');
COMMIT;

-- ----------------------------
-- Table structure for `listenrecord`
-- ----------------------------
DROP TABLE IF EXISTS `listenrecord`;
CREATE TABLE `listenrecord` (
`listenrecordId`  int(11) NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL ,
`listenrecordOrderTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`listenrecordStartTime`  timestamp NULL DEFAULT '0000-00-00 00:00:00' ,
`listenrecordEndTime`  timestamp NULL DEFAULT '0000-00-00 00:00:00' ,
`listenrecordPrice`  float NULL DEFAULT NULL ,
`listenrecordState`  int(11) NULL DEFAULT NULL ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`listenrecordResourcePath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`listenrecordId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of listenrecord
-- ----------------------------
BEGIN;
INSERT INTO `listenrecord` VALUES ('1', '1', '2018-11-19 20:23:23', '2018-11-19 20:23:23', '2018-11-19 21:30:19', '50', '1', '6', null), ('2', '2', '2018-11-12 20:25:59', '2018-11-12 20:25:59', '2018-11-12 21:26:10', '50', '1', '6', null), ('3', '3', '2018-11-15 20:24:43', '2018-11-15 20:24:43', '2018-11-15 21:24:54', '50', '1', '7', null);
COMMIT;

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
`teacherId`  int(11) NOT NULL ,
`teacherWorkTime`  int(11) NULL DEFAULT NULL ,
`teacherPraiseRate`  float NULL DEFAULT NULL ,
`teacherPrice`  float NULL DEFAULT NULL ,
`teacherIntroduction`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`teacherListenTime`  int(11) NULL DEFAULT NULL ,
`teacherAuthentication`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`teacherGoodAt`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`teacherId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('4', '1', '99', '300', '主要受训背景：\r\n首届国际危机事件压力管理个人危机干预及团体危机干预训练；\r\n第二届中美夫妻伴侣及家庭治疗项目，历经4年；\r\n第二届中英精神分析取向儿童青少年心理治疗学院制课程；美国斯坦福大学教授Brian Feldman组织的儿童心理分析研讨；\r\n乔恩.卡巴金教授正念减压项目培训；\r\n克里斯托弗•K•杰默博士内在关爱训练；\r\n东方心理研究院沙盘基础班、高级班；东方心理研究院梦的工作基础班、高级班；\r\n北大方新老师带领的行为治疗连续培训及案例督导；\r\n徐凯文老师的精神动力学连续培训；\r\n华夏心理咨询师实务操作课程；\r\n存在主义团体治疗连续课程及团体督导。\r\n', '0', '国家二级心理咨询师；\r\n儿童青少年人际关系训练师；\r\n中国心理卫生协会会员；\r\n北京市婚姻协会心理咨询师；\r\n北京市通州区妇联特邀心理专家；\r\n北京市通州区明心社工事务所创办人\r\n', '婚姻情感：恋爱指导、婚前咨询、夫妻关系、情感危机、婚外等；\r\n家庭关系：婆媳关系、家庭关系、老年心理、家庭暴力、人机交往等；\r\n亲子教育：儿童成长指导、学习困难、厌学、叛逆、考试焦虑、人际障碍等；\r\n个人成长：情感创伤修复、内在梳理整合、激活未来发展动力；\r\n'), ('5', '122', '100', '600', '服务经验：\r\n曾担任电视节目和网络平台的情感嘉宾，特约专栏。青海卫视2010年“花儿朵朵”选手心理辅导专家，湖南卫视2011“快乐女声”五强选手心理辅导专家，杭州卫视2010年“我是星主播”2011年“我是星女郎”选手的心理辅导专家，中国国际广播电台特约心理专家。《幸福来敲门》、《北京青年》剧情心理点评。《中国日报》、《中国时尚美容画报》、《昕薇杂志》、《婴儿母亲》、《小资风尚》等约稿专家。\r\n咨询感言：\r\n每个人都值得被看见，被聆听，被理解。每一个困境和问题都有解决的方向。我相信陪伴、聆听、寻找、行动的力量，愿陪你走过一段心的旅程，获得新的视角和可能性。我工作的方式是艺术和谈话方式融合。\r\n', '0', '通州区明心社会工作事务所心理咨询师\r\n中国心理学会注册心理师（注册号：X-18-054）\r\n中国舞动治疗协会注册会员（20131007113009）\r\n中国心理学会会员(S271100709M)\r\n全球职业规划师（GCDF0426-CH）\r\n国家专才委生涯规划师课程导师\r\n', '自我成长与自我管理、情绪调整与管理、女性魅力、亲密关系、亲子关系、儿童成长与发展、人际沟通、团队建设、行动力提升、生涯规划、适应、减压等方面的心理辅导和舞动体验'), ('6', '100', '100', '500', '主要受训背景：\r\n2013/11-2013/12 萨提亚家庭治疗培训 赖杞丰；\r\n2014/6-2017/3 国际后现代心理治疗新进展：活动意向治疗初级、高级培训班（NAET培训师r.Micel Y.Depeyrot）；\r\n2015/7-2015/8 “提升单次心理治疗效能”主题技术工作坊（中美家庭治疗研究所所长Dr.John K.Miller）；\r\n2015/11-2017/4第二届中英精神分析取向儿童青少年心理治疗学院制连续培训；\r\n2017/4至今 婴儿观察网络培训\r\n', '0', '国家二级心理咨询师 ', '儿童青少年咨询、亲子关系咨询、亲密关系咨询、家庭咨询、婚恋咨询、个人成长咨询、老年心理健康咨询'), ('7', '5', '100', '500', '邓旸老师.....................', '0', null, null), ('8', '10', '100', '500', '受训经历\r\n曾奇峰精神分析训练课程\r\n徐均自体心理学训练项目\r\n格式塔暨完形心理咨询实操咨询培训项目\r\n欧文•亚隆团体心理咨询与治疗体系培训\r\nIHNMA国际整体暨自然医学学会催眠培训项目\r\nIHNMA国际整体暨自然医学学会EFT情绪释放技术培训项目\r\n琳达•豪阿卡西记录阅读及疗愈培训体系\r\n\r\n个人体验及督导经历\r\n中德家庭治疗取向咨询师中期个人体验；人本主义咨询师长期个人体验；客体关系咨询师长期个人体验\r\n自体心理学案例督导小组；精神分析案例督导小组；人本主义个案督导。\r\n\r\n工作经历\r\n曾任中国社工协会心理工作援助站咨询师，从事一对一心理咨询，团体咨询工作和实习心理咨询师实操技能培训项目。\r\n培训项目包括北京德勤易才心理咨询中心心理咨询师考级培训班发展心理学，朝阳区社区心理辅导讲座等，劳动关系学院大学生人际关系小组。\r\n曾任天安文化非常教育心理部的心理咨询师、培训讲师，在海淀区以及丰台区多所学校进行过家长讲座以及青少年团体活动。\r\n', '100', '国家注册二级心理咨询师\r\n中国社工协会心理保健师\r\n中国社工协会心理工作援助站心理咨询培训讲师\r\n', '青少年心理发展；情绪管理'), ('9', '2', '98', '400', '心理学学习经历\r\n2012-2016年，意象对话疗法应用系列课程\r\n2015年，杨明磊后现代整合心理治疗连续一年工作坊\r\n2015年，李明中澳叙事疗法一年课程\r\n2016年，廖风池认知行为治疗师BCT初阶及ACT进阶课程\r\n2016年，蔺桂瑞、卫丽莉高校萨提亚课程初阶课程\r\n2017年，徐凯文咨询伦理课程\r\n2017年，赵然SFBT高效焦点解决取向治疗课程\r\n2017年3月-2018年2月，胡婷婷44周正念自我成长体验课程\r\n2017年6月，连庭嘉存在主义团体成长小组\r\n2017年7月，刘建新体验式团体沙盘心理技术课程\r\n2017年8月，廖凤池问题解决咨商模式课程\r\n2017年9月，蔡春美萨提亚冰山咨询内在探索与会谈技巧实操训练课程\r\n2017年10月，廖凤池团体历程与带领技术课程\r\n2017年至今，周婷丽人际动力团体带领者持续两年课程及督导\r\n2017年至今，唐登华家庭治疗持续一年课程\r\n2017年至今，李鸣一年精神分析师课程\r\n2018年4月，朱宏博动力性团体成长小组\r\n2018年5月，刘伟团体咨询课程\r\n\r\n企业EAP心理服务\r\n服务企业：建设银行，中国银行，国航集团，中航信，中轻，首都机场，北航食，IBM，强生集团，辽宁移动，河北建投等。\r\n服务形式：个体咨询、团体辅导、心理培训等。\r\n咨询内容：职业规划与发展、职场减压、情绪管理、职场人际关系、家庭关系、亲子教育、婚恋情感、性格测评解析及应用等。\r\n\r\n团体心理活动经历\r\n2012-2013年 HR人群、单身青年团体心理辅导\r\n2013-2015年 企业心理培训、新员工职业规划及压力管理团体辅导\r\n2015-2016 动力性成长小组及团体活动带领\r\n2017年至今 体验式团体沙盘进校园系列辅导\r\n           铁树斜街社区青少年及老年团体暑期人本团体系列活动\r\n            河北建投新员工职场适应团体活动\r\n\r\n个人咨询时数\r\n累计1000小时以上\r\n\r\n个人成长体验及督导\r\n团体成长及个人体验，累计时长400小时以上，个人及团体督导200小时以上。\r\n\r\n咨询风格：以来访者为中心，注重感受和陪伴，结合精神分析、认知行为、焦点解决和后现代取向整合应用，调整来访者认知并促进行为改变和人格成长完善。\r\n', '50', '安徽大学管理学学士\r\n国家二级心理咨询师\r\n国家危机干预师（初级）\r\n盛心阳光签约EAP咨询师 \r\n', '职业发展与规划、人际关系处理、情绪管理、个人成长与探索'), ('10', '10', '100', '500', '专业受训背景：\r\n西南大学心理学专业 心理咨询与治疗研究方向在职研究生毕业\r\n精神分析取向上海中德班初级组、中挪班中级组三年系统培训\r\n中英精神分析取向儿童青少年心理治疗学院制三年培训及婴儿观察项目督导\r\n中科院心理研究所高级心理咨询与治疗培训\r\n朱建军意象对话技术\r\n方新现代行为治疗技术操作培训\r\n中科院心理所祝卓宏教授ACT接纳与承诺疗法\r\n韦志中本会团体及李仑存在主义团体学习培训\r\nEMDR第三届心理创伤学组心理治疗连续培训项目\r\n上海同济大学国家级医学教育项目的人文医学与病人安全的培训\r\nMind in Mind 教育咨询婴儿观察项目两年\r\n接受拉康派精神分析个人体验和成长等。\r\n', null, '国家职业资格资深咨询师\r\n精神分析方向治疗师 儿童精神分析治疗师\r\n婚姻家庭指导师\r\n中国心理卫生协会会员\r\n成都心理咨询行业协会会员\r\n成都精神分析中心会员\r\n原中央国家机关大篷车现场特聘心理咨询师\r\n', '1、婚姻情感、夫妻关系、家庭关系、性心理等\r\n2、青少年心理咨询：青春期逆反、心理创伤、考试焦虑、早恋、学习障碍、情绪问题等\r\n3、儿童心理咨询：幼儿咨询、问题儿童、亲密关系、儿童心智化成长等\r\n4、个人成长：为同行咨询师提供个案督导及个人体验成长等\r\n'), ('11', '90', '99', '500', '主要受训背景：\r\n法国尼姆大学环境社会心理学专业硕士；\r\n法国第戎大学社会心理学专业学士；\r\n法国图尔大学法语强化培训500小时；\r\n北京工业大学社会工作专业法学学士；\r\n简单心理-心理咨询基础训练课程首期学员\r\n', null, '国家二级心理咨询师', '职场压力与规划、婚姻问题、恋爱困扰、情绪困扰、亲子关系'), ('12', '80', '99', '500', '主要受训背景：\r\n动力学取向心理治疗师，EFT情绪取向婚姻家庭咨询师（初级），LGBT性少数人群友善心理咨询师。\r\n接受精神分析动力学系统培训、督导及个人体验。曾在精神专科医院进修，熟悉各类心身疾病。\r\n通过扎实的理论，从多角度理解来访者；用人文主义情怀，关注来访者的个体成长；用深度浸入、尊重的共情，陪伴来访者。\r\n咨询理念：让我和你一起，寻找生命的光芒。 \r\n', null, ' 国家二级心理咨询师 ', '情绪情感障碍、亲密关系、人际关系、个人探索及成长'), ('13', '88', '100', '500', '⼯工作经验 简单⼼心理理学术运营部 — 2016/8-2018/5  先后负责咨询助理理、精神科顾问、咨询质量量的监督管理理及投诉等项⽬目。 \r\n盛⼼心阳光咨询有限公司 — 2015/1-2016/8 担任初诊咨询师，从事个案管理理，热线接听等⼯工作，积累e a p热线⼩小时数千 余。 \r\n北北京空军总医院临床⼼心理理科进修 — 2014/9-2015/1 \r\n⼼心理理咨询⻓长程系统培训 2017/2-2018/7 简单⼼心理理基础课程 — 已完成所有授课 2016/1-2017/1 施琪嘉师徒班 2015/6-2016-4 精神分析取向咨询师成⻓长课程中阶（北北京曼陀海海斯⼼心理理咨询中⼼心）', null, '兰州⼤大学哲学学⼠士，英国格拉斯哥⼤大学⼼心理学硕⼠士，国家 ⼆二级⼼心理理咨询师，简单⼼心理基础课程受训学员', '情绪情感障碍、亲密关系、人际关系、个人探索及成长'), ('14', '108', '100', '500', '主要受训背景：\r\n韩国中央大学儿童青少年心理咨询硕士；\r\n参加中美精神分析联盟（CAPA）动力学培训初级组（2年）；\r\n参加精神分析连续培训项目（1年）；\r\n性少数群体咨询师培训项目；\r\n短程焦点（SFBT）短期培训项目；\r\n', null, '国家二级心理咨询师', '儿童青少年成长及发展，亲子关系，焦虑、抑郁等情绪困扰，恋爱问题，婚姻情感问题，个人成长，职场人际关系，职场压力，危机干预');
COMMIT;

-- ----------------------------
-- Table structure for `teachertime`
-- ----------------------------
DROP TABLE IF EXISTS `teachertime`;
CREATE TABLE `teachertime` (
`teachertimeId`  int(11) NOT NULL AUTO_INCREMENT ,
`teacherId`  int(11) NULL DEFAULT NULL ,
`date`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`time8`  int(11) NULL DEFAULT NULL ,
`time9`  int(11) NULL DEFAULT NULL ,
`time10`  int(11) NULL DEFAULT NULL ,
`time11`  int(11) NULL DEFAULT NULL ,
`time12`  int(11) NULL DEFAULT NULL ,
`time13`  int(11) NULL DEFAULT NULL ,
`time14`  int(11) NULL DEFAULT NULL ,
`time15`  int(11) NULL DEFAULT NULL ,
`time16`  int(11) NULL DEFAULT NULL ,
`time17`  int(11) NULL DEFAULT NULL ,
`time18`  int(11) NULL DEFAULT NULL ,
`time19`  int(11) NULL DEFAULT NULL ,
`time20`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`teachertimeId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=5

;

-- ----------------------------
-- Records of teachertime
-- ----------------------------
BEGIN;
INSERT INTO `teachertime` VALUES ('1', '4', '2018-11-20 20:11:31', '-1', '-1', '0', '1', '0', '-1', '1', '0', '1', '1', '-1', '-1', '-1'), ('2', '5', '2018-11-20 20:11:53', '0', '1', '0', '1', '1', '0', '0', '1', '-1', '1', '-1', '-1', '-1'), ('3', '6', '2018-11-20 20:12:13', '0', '1', '1', '0', '-1', '-1', '-1', '-1', '-1', '0', '1', '0', '0'), ('4', '7', '2018-11-20 20:12:41', '0', '-1', '0', '1', '0', '0', '0', '0', '0', '0', '0', '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for `typetable`
-- ----------------------------
DROP TABLE IF EXISTS `typetable`;
CREATE TABLE `typetable` (
`typetableId`  int(11) NOT NULL AUTO_INCREMENT ,
`typetableName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`typetableId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=6

;

-- ----------------------------
-- Records of typetable
-- ----------------------------
BEGIN;
INSERT INTO `typetable` VALUES ('1', '婚姻'), ('2', '亲子'), ('3', '成长'), ('4', '育儿'), ('5', '高效');
COMMIT;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`userId`  int(11) NOT NULL AUTO_INCREMENT ,
`userHeadPath`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userNickName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userSex`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userRealName`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userIdNumber`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userAutograph`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userPhone`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userPassword`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userRegistTime`  timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
`userIdentity`  int(11) NULL DEFAULT NULL ,
`userCity`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userEmail`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`userId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=15

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'https://pan.baidu.com/s/1YRtZNQ7rTy1aL_lzm3LDnQ', '阿斯蒂芬', '男', '段智兴', '123', '去问人体', '15226570820', '111', '2018-11-20 19:59:55', '1', '大连', null), ('2', '', '枫哥哥', '男', '鲍张军', '456', '阿是法国', '15226570821', '111', '2018-11-20 20:00:06', '1', '唐山', null), ('3', null, '热风', '男', '刘田会', '789', '自行车v', '15225670822', '111', '2018-11-20 20:00:16', '1', '廊坊', null), ('4', null, '何秀琴', '男', '何秀琴', '147', '开发的夫人', '15226570823', '111', '2018-11-28 09:39:29', '2', '女儿国', null), ('5', null, '徐青林', '女', '徐青林', '258', '大二分', '15226570824', '111', '2018-11-28 09:39:33', '2', '福建', null), ('6', null, '杨丽', '女', '杨丽', '369', '韩国一号月台', '15226570825', '111', '2018-11-28 09:39:37', '2', '唐山', null), ('7', null, '都江', '男', '都江', '000', '虽然在发', '15226570826', '111', '2018-11-28 09:39:41', '2', '石家庄', null), ('8', null, '任芳和', '女', '任芳和', null, '就封杀蜂王浆佛为飞机我额加我加我就我 饿哦记得我的iwe', null, null, '2018-11-28 09:41:09', '2', null, null), ('9', null, '沈红玉', '女', '沈红玉', null, '撒发热反而跟他如果 ', null, null, '2018-11-28 09:41:09', '2', null, null), ('10', null, '叶静波', '女', '叶静波', null, '发热发热给他一个氧化亚铜聚聚谈谈个人反而', null, null, '2018-11-28 09:41:09', '2', null, null), ('11', null, '尹媛媛', '女', '尹媛媛', null, '而非法违法惹人疼跟他', null, null, '2018-11-28 09:41:09', '2', null, null), ('12', null, '邹柳', '女', '邹柳', null, '发热体狗头人哥特人', null, null, '2018-11-28 09:41:10', '2', null, null), ('13', null, '蔡其乐', '女', '蔡其乐', null, '啊哥哥他如果有途径啊法人', null, null, '2018-11-28 09:41:10', '2', null, null), ('14', null, '黄灿', '女', '黄灿', null, 'arfert656yhyrdg', null, null, '2018-11-28 09:41:17', '2', null, null);
COMMIT;

-- ----------------------------
-- Table structure for `userlabel`
-- ----------------------------
DROP TABLE IF EXISTS `userlabel`;
CREATE TABLE `userlabel` (
`labelId`  int(11) NOT NULL AUTO_INCREMENT ,
`userId`  int(11) NULL DEFAULT NULL ,
`userLabel`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`userLabelGrade`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`labelId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of userlabel
-- ----------------------------
BEGIN;
INSERT INTO `userlabel` VALUES ('1', '1', '成长', '5'), ('2', '1', '爱情', '1'), ('3', '1', '专注', '2'), ('4', '2', '成长', '3'), ('5', '2', '效率', '3'), ('6', '3', '家庭', '4');
COMMIT;

-- ----------------------------
-- Auto increment value for `answer`
-- ----------------------------
ALTER TABLE `answer` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `article`
-- ----------------------------
ALTER TABLE `article` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `ask`
-- ----------------------------
ALTER TABLE `ask` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `authentication`
-- ----------------------------
ALTER TABLE `authentication` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for `businesstype`
-- ----------------------------
ALTER TABLE `businesstype` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for `collection`
-- ----------------------------
ALTER TABLE `collection` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `consultationrecord`
-- ----------------------------
ALTER TABLE `consultationrecord` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `consultobject`
-- ----------------------------
ALTER TABLE `consultobject` AUTO_INCREMENT=9;

-- ----------------------------
-- Auto increment value for `course`
-- ----------------------------
ALTER TABLE `course` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `coursecatalog`
-- ----------------------------
ALTER TABLE `coursecatalog` AUTO_INCREMENT=14;

-- ----------------------------
-- Auto increment value for `courseorder`
-- ----------------------------
ALTER TABLE `courseorder` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `courserecord`
-- ----------------------------
ALTER TABLE `courserecord` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `dynamic`
-- ----------------------------
ALTER TABLE `dynamic` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for `evaluate`
-- ----------------------------
ALTER TABLE `evaluate` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `goodat`
-- ----------------------------
ALTER TABLE `goodat` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for `listenrecord`
-- ----------------------------
ALTER TABLE `listenrecord` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for `teachertime`
-- ----------------------------
ALTER TABLE `teachertime` AUTO_INCREMENT=5;

-- ----------------------------
-- Auto increment value for `typetable`
-- ----------------------------
ALTER TABLE `typetable` AUTO_INCREMENT=6;

-- ----------------------------
-- Auto increment value for `user`
-- ----------------------------
ALTER TABLE `user` AUTO_INCREMENT=15;

-- ----------------------------
-- Auto increment value for `userlabel`
-- ----------------------------
ALTER TABLE `userlabel` AUTO_INCREMENT=7;
