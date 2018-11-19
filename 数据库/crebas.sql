/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/19 21:04:38                          */
/*==============================================================*/


drop table if exists answer;

drop table if exists article;

drop table if exists ask;

drop table if exists authentication;

drop table if exists businesstype;

drop table if exists consultationrecord;

drop table if exists consultobject;

drop table if exists course;

drop table if exists coursecatalog;

drop table if exists courseorder;

drop table if exists courserecord;

drop table if exists diary;

drop table if exists dynamic;

drop table if exists evaluate;

drop table if exists goodat;

drop table if exists listenrecord;

drop table if exists teacher;

drop table if exists teachertime;

drop table if exists typetable;

drop table if exists user;

drop table if exists userlabel;

/*==============================================================*/
/* Table: answer                                                */
/*==============================================================*/
create table answer
(
   answerId             int not null auto_increment,
   askId                int,
   teacherId            int,
   answerContent        text,
   answerAnswerTime     timestamp,
   answerGoodCount      int,
   primary key (answerId)
);

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   articleId            int not null auto_increment,
   articleName          varchar(100),
   teacherId            int,
   articleImgPath       varchar(1024),
   articleIntroduction  varchar(1024),
   articleContent       text,
   articlePublishTime   timestamp,
   articleLookNumber    int,
   primary key (articleId)
);

/*==============================================================*/
/* Table: ask                                                   */
/*==============================================================*/
create table ask
(
   askId                int not null auto_increment,
   askTitle             varchar(100),
   askContent           text,
   userId               int,
   askTime              timestamp,
   askLookNumber        int,
   primary key (askId)
);

/*==============================================================*/
/* Table: authentication                                        */
/*==============================================================*/
create table authentication
(
   authenticationId     int not null auto_increment,
   teacherId            int,
   authenticationAptitudeName varchar(100),
   primary key (authenticationId)
);

/*==============================================================*/
/* Table: businesstype                                          */
/*==============================================================*/
create table businesstype
(
   businesstypeId       int not null auto_increment,
   businesstypeWorkType int,
   businesstypeWorkId   int,
   typetableId          int,
   primary key (businesstypeId)
);

/*==============================================================*/
/* Table: consultationrecord                                    */
/*==============================================================*/
create table consultationrecord
(
   consultationrecordId int not null auto_increment,
   userId               int,
   consultationrecordOrderTime timestamp,
   consultationrecordStartTime timestamp,
   consultationrecordEndTime timestamp,
   consultationrecordPrice float,
   consultationrecordState int,
   teacherId            int,
   consultationrecordMethod int,
   consultationrecordResourcePath varchar(1024),
   primary key (consultationrecordId)
);

/*==============================================================*/
/* Table: consultobject                                         */
/*==============================================================*/
create table consultobject
(
   consultobjectId      int not null auto_increment,
   teacherId            int,
   consultObject        varchar(100),
   primary key (consultobjectId)
);

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course
(
   courseId             int not null auto_increment,
   courseName           varchar(50),
   teacherId            int,
   coursePrice          float,
   courseRebate         float,
   courseIntroduction   text,
   courseImgPath        varchar(1024),
   courseStudentNumber  int,
   courseSynopsis       varchar(1024),
   primary key (courseId)
);

/*==============================================================*/
/* Table: coursecatalog                                         */
/*==============================================================*/
create table coursecatalog
(
   coursecatalogId      int not null auto_increment,
   courseId             int,
   coursecatalogParentId int,
   coursecatalogName    varchar(50),
   coursecatalogResourcePath varchar(1024),
   primary key (coursecatalogId)
);

/*==============================================================*/
/* Table: courseorder                                           */
/*==============================================================*/
create table courseorder
(
   courseorderId        int not null auto_increment,
   courseId             int,
   userId               int,
   courseorderBuyTime   timestamp,
   courseorderPrice     float,
   primary key (courseorderId)
);

/*==============================================================*/
/* Table: courserecord                                          */
/*==============================================================*/
create table courserecord
(
   courserecordId       int not null auto_increment,
   userId               int,
   courseId             int,
   courserecordIsFinish int,
   courserecordStartTime timestamp,
   courserecordStopPosition varchar(50),
   primary key (courserecordId)
);

/*==============================================================*/
/* Table: diary                                                 */
/*==============================================================*/
create table diary
(
   diaryId              int not null,
   userId               int,
   diaryRecordTime      timestamp,
   diaryContent         text,
   diaryWeather         varchar(100),
   primary key (diaryId)
);

/*==============================================================*/
/* Table: dynamic                                               */
/*==============================================================*/
create table dynamic
(
   dynamicId            int not null auto_increment,
   dynamicPublishTime   timestamp,
   dynamicTitle         varchar(100),
   dynamicContent       text,
   dynamicImgPath       varchar(1024),
   dynamicResourcePath  varchar(1024),
   dynamicLink          varchar(1024),
   primary key (dynamicId)
);

/*==============================================================*/
/* Table: evaluate                                              */
/*==============================================================*/
create table evaluate
(
   evaluateId           int not null auto_increment,
   evaluateWorkType     int,
   evaluateWorkId       int,
   evaluateComment      varchar(1024),
   evaluateTime         timestamp,
   evaluateStar         int,
   userId               int,
   primary key (evaluateId)
);

/*==============================================================*/
/* Table: goodat                                                */
/*==============================================================*/
create table goodat
(
   goodatId             int not null auto_increment,
   teacherId            int,
   goodAt               varchar(100),
   primary key (goodatId)
);

/*==============================================================*/
/* Table: listenrecord                                          */
/*==============================================================*/
create table listenrecord
(
   listenrecordId       int not null auto_increment,
   userId               int,
   listenrecordOrderTime timestamp,
   listenrecordStartTime timestamp,
   listenrecordEndTime  timestamp,
   listenrecordPrice    float,
   listenrecordState    int,
   teacherId            int,
   listenrecordResourcePath varchar(1024),
   primary key (listenrecordId)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher
(
   teacherId            int not null,
   teacherWorkTime      int,
   teacherPraiseRate    float,
   teacherPrice         float,
   teacherIntroduction  text,
   teacherListenTime    int,
   primary key (teacherId)
);

/*==============================================================*/
/* Table: teachertime                                           */
/*==============================================================*/
create table teachertime
(
   teachertimeId        int not null auto_increment,
   teacherId            int,
   date                 timestamp,
   time8                int,
   time9                int,
   time10               int,
   time11               int,
   time12               int,
   time13               int,
   time14               int,
   time15               int,
   time16               int,
   time17               int,
   time18               int,
   time19               int,
   time20               int,
   primary key (teachertimeId)
);

/*==============================================================*/
/* Table: typetable                                             */
/*==============================================================*/
create table typetable
(
   typetableId          int not null auto_increment,
   typetableName        varchar(50),
   primary key (typetableId)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   userId               int not null auto_increment,
   userHeadPath         varchar(1024),
   userNickName         varchar(50),
   userSex              varchar(10),
   userRealName         varchar(50),
   userIdNumber         varchar(50),
   userAutograph        varchar(1024),
   userPhone            varchar(50),
   userPassword         varchar(50),
   userRegistTime       timestamp,
   userIdentity         int,
   userCity             varchar(50),
   userEmail            varchar(50),
   primary key (userId)
);

/*==============================================================*/
/* Table: userlabel                                             */
/*==============================================================*/
create table userlabel
(
   labelId              int not null auto_increment,
   userId               int,
   userLabel            varchar(1024),
   userLabelGrade       int,
   primary key (labelId)
);

