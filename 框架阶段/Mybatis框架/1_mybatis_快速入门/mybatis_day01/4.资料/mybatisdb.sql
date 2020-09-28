/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.67-community-nt : Database - mybatisdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mybatisdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mybatisdb`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `ID` int(11) NOT NULL auto_increment COMMENT '编号',
  `UID` int(11) default NULL COMMENT '用户编号',
  `MONEY` double default NULL COMMENT '金额',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `account` */

insert  into `account`(`ID`,`UID`,`MONEY`) values (1,1,1000),(2,1,2000),(3,2,3000),(4,3,5000),(5,7,8200);

/*Table structure for table `grade` */

DROP TABLE IF EXISTS `grade`;

CREATE TABLE `grade` (
  `gid` int(8) NOT NULL auto_increment,
  `gname` varchar(32) default NULL,
  `gdesc` varchar(128) default NULL,
  PRIMARY KEY  (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `grade` */

insert  into `grade`(`gid`,`gname`,`gdesc`) values (1,'黑马301','Java'),(2,'黑马302','大数据'),(3,'黑马303','产品经理');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `R_ID` int(11) NOT NULL auto_increment COMMENT '编号',
  `R_NAME` varchar(30) default NULL COMMENT '角色名称',
  `R_DESC` varchar(60) default NULL COMMENT '角色描述',
  PRIMARY KEY  (`R_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`R_ID`,`R_NAME`,`R_DESC`) values (1,'学生','梦想成为班长王的人'),(2,'英语课代表','班级里英语最好的人'),(3,'学习委员','班级里学习最好的人'),(4,'班长','班级里哪都好的人');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime default NULL COMMENT '生日',
  `sex` char(1) default NULL COMMENT '性别',
  `address` varchar(256) default NULL COMMENT '地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) values (1,'赵文明','1992-06-23 00:00:00','男','北京市海淀区中关村大街101号'),(2,'孙建国','1990-07-01 00:00:00','男','北京市朝阳区三里屯路甲1号'),(3,'王小花','1995-08-15 00:00:00','女','北京市海淀区中关村大街101号'),(4,'王跃进','1994-05-16 00:00:00','男','北京市朝阳区建设门外大街甲2号'),(5,'李奋斗','1994-05-16 00:00:00','男','北京市朝阳区建设门外大街甲2号'),(6,'王建业','1995-12-12 00:00:00','男','北京市海淀区中关村大街1300号'),(7,'陈丽丽','1997-03-21 00:00:00','女','北京市大兴区建设大街568号'),(11,'李乐乐','1993-08-11 00:00:00','女','河北省邯郸市建邺区建设大街150号'),(12,'陈丽娟','1995-10-21 00:00:00','女','湖北省武汉市长安区惠民路59号');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`UID`,`RID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`UID`,`RID`) values (1,1),(1,2),(2,1),(2,3),(3,1),(3,4);

/*Table structure for table `usertype` */

DROP TABLE IF EXISTS `usertype`;

CREATE TABLE `usertype` (
  `t_id` int(8) NOT NULL auto_increment,
  `t_name` varchar(32) default NULL,
  `t_explain` varchar(512) default NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `usertype` */

insert  into `usertype`(`t_id`,`t_name`,`t_explain`) values (1,'倔强青铜','小段位为三段：青铜3、青铜2、青铜1，每个其中每个小段位要三星才可以进阶下一个段位。青铜到白银需要9个星。'),(2,'秩序白银','小段位为三段：白银3、白银2、白银1，每个其中每个小段位要三星才可以进阶下一个段位。白银到黄金需要9个星。'),(3,'荣耀黄金','小段位为三段：黄金4、黄金3、黄金2、黄金1，每个其中每个小段位要四星才可以进阶下一个段位。黄金到铂金需要16个星。'),(4,'尊贵铂金','小段位为三段：铂金5、铂金4、铂金3、铂金2、铂金1，每个其中每个小段位要五星才可以进阶下一个段位。铂金到钻石需要25个星。'),(5,'永恒钻石','小段位为三段：钻石5、钻石4、钻石3、钻石2、钻石1，每个其中每个小段位要五星才可以进阶下一个段位。铂金到钻石需要25个星。'),(6,'至尊星耀','小段位为三段：星耀5、星耀4、星耀3、星耀2、星耀1，每个其中每个小段位要五星才可以进阶下一个段位。铂金到钻石需要25个星。'),(7,'最强王者','最强王者是按照星数来计算，并且拥有地区排名、区服排名。');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
