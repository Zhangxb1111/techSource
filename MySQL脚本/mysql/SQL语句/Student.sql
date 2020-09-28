/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-20 13:55:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for Student
-- ----------------------------
DROP TABLE IF EXISTS `Student`;
CREATE TABLE `Student` (
  `sno` char(9) DEFAULT NULL,
  `sname` varchar(20) DEFAULT NULL,
  `sex` char(4) DEFAULT NULL,
  `age` tinyint(10) DEFAULT NULL,
  `depart` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Student
-- ----------------------------
INSERT INTO `Student` VALUES ('150312101', '魏云鹏', '男', '20', '计算机');
INSERT INTO `Student` VALUES ('150312102', '李立波', '男', '19', '计算机');
INSERT INTO `Student` VALUES ('150312103', '牛校波', '男', '18', '机械');
INSERT INTO `Student` VALUES ('150312104', '王美霞', '女', '20', '计算机');
INSERT INTO `Student` VALUES ('150312105', '郭晓丽', '女', '19', '机械');
INSERT INTO `Student` VALUES ('150312106', '陈俊峰', '男', '21', '生物');
