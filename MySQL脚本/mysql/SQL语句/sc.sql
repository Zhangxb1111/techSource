/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-20 13:55:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `sno` char(9) DEFAULT NULL,
  `cno` char(4) DEFAULT NULL,
  `grade` double(20,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('150312101', '1', '90.00');
INSERT INTO `sc` VALUES ('150312101', '2', '80.00');
INSERT INTO `sc` VALUES ('150312101', '3', '70.00');
INSERT INTO `sc` VALUES ('150312101', '5', '60.00');
INSERT INTO `sc` VALUES ('150312101', '6', '85.00');
INSERT INTO `sc` VALUES ('150312101', '7', '75.00');
INSERT INTO `sc` VALUES ('150312102', '4', '35.00');
INSERT INTO `sc` VALUES ('150312102', '6', '46.00');
INSERT INTO `sc` VALUES ('150312102', '7', '72.00');
