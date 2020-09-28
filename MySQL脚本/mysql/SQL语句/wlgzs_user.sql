/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wlgzs_user

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-15 11:05:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_domain
-- ----------------------------
DROP TABLE IF EXISTS `tb_domain`;
CREATE TABLE `tb_domain` (
  `id` int(50) NOT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_domain
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(50) NOT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `describe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `grades` varchar(255) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `roleId` varchar(255) DEFAULT NULL,
  `studyDirect` varchar(255) DEFAULT NULL,
  `headPhoto` varchar(255) DEFAULT NULL,
  `blogUrl` varchar(255) DEFAULT NULL,
  `lastLoginDate` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zjg', '张金高', '1234', '97A55F32BB0EBB66CCECFFD0DF1D2DA7683C67A8CDAD9ECCF50B3AF10763CF6DDDA470BA0DE6BC20058692F32B3BE744', '男', '18738357910', '大二', '计科163', '1', 'JavaWeb', '', '', '', '');
INSERT INTO `tb_user` VALUES ('2', 'zhangxubin', '张绪宾', '1234', 'C108BA403A2B4F435FF7704CDE28995518CDE39EEED99DBCC41F87973B8EF75EDDA470BA0DE6BC20058692F32B3BE744', '男', '18738357910', '大二', '计科163', '1', 'JavaWeb', '', '', '', '');
