/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : mybatisdb_63

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2018-09-16 19:54:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` float(6,2) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1000.00', '1');
INSERT INTO `account` VALUES ('2', '9999.00', '12');
INSERT INTO `account` VALUES ('3', '200.00', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(20) DEFAULT NULL,
  `roleDesc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'user', '用户');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '北京市顺义区', '2018-09-13 00:00:00', '男');
INSERT INTO `user` VALUES ('2', '李四', '北京市昌平区', '2018-09-14 00:00:00', '女');
INSERT INTO `user` VALUES ('5', '王五1', '北京市海淀区', '2018-09-14 09:48:14', '男');
INSERT INTO `user` VALUES ('6', '王飞', '北京市海淀区', '2018-09-14 09:48:24', '男');
INSERT INTO `user` VALUES ('10', '老王', '北京市海淀区', '2018-01-01 00:00:00', '男');
INSERT INTO `user` VALUES ('11', '张龙', '北京市昌平区', '2018-09-16 09:59:27', '男');
INSERT INTO `user` VALUES ('12', '张龙', '北京市昌平区', '2018-09-16 10:02:55', '女');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`_id`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
INSERT INTO `user_role` VALUES ('2', '1');
INSERT INTO `user_role` VALUES ('12', '2');
