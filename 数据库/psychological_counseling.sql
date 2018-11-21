/*
Navicat MySQL Data Transfer

Source Server         : userInformation
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : psychological_counseling

Target Server Type    : MYSQL
Target Server Version : 50599
File Encoding         : 65001

Date: 2018-11-21 09:47:21
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
INSERT INTO `course` VALUES ('1', '心理成长', '4', '20', '0.9', '这是魏谦强老师的一门课', null, '10', '这是魏谦强老师的一门课'), ('2', '高效学习', '5', '30', '1', '这是邓旸老师的一门课', null, '30', '这是邓旸老师的一门课'), ('3', '自我提升', '6', '25', '0.8', '这是张春辉老师的一门课', null, '20', '这是张春辉老师的一门课'), ('4', '家庭幸福', '7', '20', '0.9', '这是孙明伟老师的一门课', null, '15', '这是孙明伟老师的一门课');
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
INSERT INTO `coursecatalog` VALUES ('1', '1', null, '1.1', null), ('2', '1', '1', '1.1.1', null), ('3', '1', null, '2.1', null), ('4', '1', '3', '2.1.1', null), ('5', '2', null, '1.1', null), ('6', '2', '5', '1.1.1', null), ('7', '2', null, '2.1', null), ('8', '2', '7', '2.1.1', null), ('9', '3', null, '1.1', null), ('10', '3', null, '2.1', null), ('11', '4', null, '1.1', null), ('12', '4', null, '2.1', null), ('13', '4', '12', '2.1.1', null);
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
PRIMARY KEY (`teacherId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('0', '100', '0', '0', null, '0'), ('4', '1', '99', '300', '魏牵强老师....................', '0'), ('5', '5', '100', '500', '邓旸老师.....................', '0'), ('6', '10', '100', '500', '张春辉老师.......................', '100'), ('7', '2', '98', '400', '孙明伟老师...................', '50');
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
AUTO_INCREMENT=8

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'https://pan.baidu.com/s/1YRtZNQ7rTy1aL_lzm3LDnQ', '阿斯蒂芬', '男', '段智兴', '123', '去问人体', '15226570820', '111', '2018-11-20 19:59:55', '1', '大连', null), ('2', '', '枫哥哥', '男', '鲍张军', '456', '阿是法国', '15226570821', '111', '2018-11-20 20:00:06', '1', '唐山', null), ('3', null, '热风', '男', '刘田会', '789', '自行车v', '15225670822', '111', '2018-11-20 20:00:16', '1', '廊坊', null), ('4', null, '华尔道夫', '男', '魏谦强', '147', '开发的夫人', '15226570823', '111', '2018-11-20 20:00:29', '2', '女儿国', null), ('5', null, '迪士尼', '女', '邓旸', '258', '大二分', '15226570824', '111', '2018-11-20 20:00:35', '2', '福建', null), ('6', null, '碧昂斯', '女', '张春辉', '369', '韩国一号月台', '15226570825', '111', '2018-11-20 20:00:41', '3', '唐山', null), ('7', null, '克罗夫', '男', '孙明伟', '000', '虽然在发', '15226570826', '111', '2018-11-20 20:00:49', '3', '石家庄', null);
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
ALTER TABLE `user` AUTO_INCREMENT=8;

-- ----------------------------
-- Auto increment value for `userlabel`
-- ----------------------------
ALTER TABLE `userlabel` AUTO_INCREMENT=7;
