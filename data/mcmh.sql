/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : mcmh

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-04-25 01:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `bdid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `baid` int(11) NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`bdid`),
  KEY `building_buildingAdmin_baid` (`baid`),
  CONSTRAINT `building_buildingAdmin_baid` FOREIGN KEY (`baid`) REFERENCES `buildingadmin` (`baid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES ('1', 'A栋', '1', '靠近操场，开运动会时会被吵醒');
INSERT INTO `building` VALUES ('2', 'B栋', '2', '靠近校门，出校方便，有活动时一样吵闹');
INSERT INTO `building` VALUES ('3', 'C栋', '3', '接近食堂，当心长胖');
INSERT INTO `building` VALUES ('4', 'D栋', '4', '接近快递点，建议“富家子弟”居住');
INSERT INTO `building` VALUES ('5', 'E栋', '5', '靠近校后门，嗯，你懂的');

-- ----------------------------
-- Table structure for buildingadmin
-- ----------------------------
DROP TABLE IF EXISTS `buildingadmin`;
CREATE TABLE `buildingadmin` (
  `baid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `sex` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  PRIMARY KEY (`baid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buildingadmin
-- ----------------------------
INSERT INTO `buildingadmin` VALUES ('1', 'QQ老冰', 'lilang', '123', '1', '18888888888');
INSERT INTO `buildingadmin` VALUES ('2', '白墨', 'baimo', '123', '1', '18888888888');
INSERT INTO `buildingadmin` VALUES ('3', 'QQ大冰', 'baofuqi', '123', '1', '15555555555');
INSERT INTO `buildingadmin` VALUES ('4', 'QQ巨冰', 'chenfeng', '123', '0', '16666666666');
INSERT INTO `buildingadmin` VALUES ('5', 'QQ小冰', 'yangxiaojun', '123', '1', '17777777777');

-- ----------------------------
-- Table structure for late
-- ----------------------------
DROP TABLE IF EXISTS `late`;
CREATE TABLE `late` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `remark` varchar(255) NOT NULL,
  `sid` varchar(255) NOT NULL,
  `baid` int(11) NOT NULL,
  PRIMARY KEY (`lid`),
  KEY `late_student_sid` (`sid`),
  KEY `late_buildingadmin_baid` (`baid`),
  CONSTRAINT `late_buildingadmin_baid` FOREIGN KEY (`baid`) REFERENCES `buildingadmin` (`baid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `late_student_sid` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of late
-- ----------------------------

-- ----------------------------
-- Table structure for quit
-- ----------------------------
DROP TABLE IF EXISTS `quit`;
CREATE TABLE `quit` (
  `qid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` varchar(10) NOT NULL,
  `date` date NOT NULL,
  `quitRemark` varchar(255) DEFAULT NULL,
  `baid` int(11) NOT NULL,
  PRIMARY KEY (`qid`),
  KEY `quit_student_sid` (`sid`),
  KEY `quit_buildingAdmin_baid` (`baid`),
  CONSTRAINT `quit_buildingAdmin_baid` FOREIGN KEY (`baid`) REFERENCES `buildingadmin` (`baid`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `quit_student_sid` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quit
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `bdid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `u_code` (`code`),
  KEY `room_building_bdid` (`bdid`),
  CONSTRAINT `room_building_bdid` FOREIGN KEY (`bdid`) REFERENCES `building` (`bdid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', 'A1001', '1', '4', '15807472192', '四人间');
INSERT INTO `room` VALUES ('2', 'A1002', '1', '4', '15606198839', '四人间');
INSERT INTO `room` VALUES ('3', 'A1003', '1', '4', '13604422899', '四人间');
INSERT INTO `room` VALUES ('4', 'A1004', '1', '4', '15107727635', '四人间');
INSERT INTO `room` VALUES ('5', 'B1001', '2', '4', '15501314543', '四人间');
INSERT INTO `room` VALUES ('6', 'B1002', '2', '4', '15707315995', '四人间');
INSERT INTO `room` VALUES ('7', 'B1003', '2', '4', '15305720673', '四人间');
INSERT INTO `room` VALUES ('8', 'B1004', '2', '4', '15704470563', '四人间');
INSERT INTO `room` VALUES ('9', 'C1001', '3', '4', '13408431838', '四人间');
INSERT INTO `room` VALUES ('10', 'C1002', '3', '4', '15008419041', '四人间');
INSERT INTO `room` VALUES ('11', 'C1003', '3', '4', '13605062762', '四人间');
INSERT INTO `room` VALUES ('12', 'C1004', '3', '4', '13603324866', '四人间');
INSERT INTO `room` VALUES ('13', 'D1001', '4', '4', '13003863705', '四人间');
INSERT INTO `room` VALUES ('14', 'D1002', '4', '4', '13708160322', '四人间');
INSERT INTO `room` VALUES ('15', 'D1003', '4', '4', '15303473851', '四人间');
INSERT INTO `room` VALUES ('16', 'D1004', '4', '4', '13408855266', '四人间');
INSERT INTO `room` VALUES ('17', 'E1001', '5', '4', '13706624513', '四人间');
INSERT INTO `room` VALUES ('18', 'E1002', '5', '4', '13603846149', '四人间');
INSERT INTO `room` VALUES ('19', 'E1003', '5', '4', '15803022596', '四人间');
INSERT INTO `room` VALUES ('20', 'E1004', '5', '4', '13903982479', '四人间');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` varchar(10) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` int(11) NOT NULL,
  `cName` varchar(20) NOT NULL,
  `state` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  KEY `student_room_rid` (`rid`),
  CONSTRAINT `student_room_rid` FOREIGN KEY (`rid`) REFERENCES `room` (`rid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for systemadmin
-- ----------------------------
DROP TABLE IF EXISTS `systemadmin`;
CREATE TABLE `systemadmin` (
  `said` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `uid` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  PRIMARY KEY (`said`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemadmin
-- ----------------------------
INSERT INTO `systemadmin` VALUES ('1', '白墨', 'baimo', '123', '1');
INSERT INTO `systemadmin` VALUES ('2', 'QQ大冰', 'baofuqi', '123', '1');
INSERT INTO `systemadmin` VALUES ('3', 'QQ巨冰', 'chenfeng', '123', '0');
INSERT INTO `systemadmin` VALUES ('4', 'QQ小冰', 'yangxiaojun', '123', '1');
INSERT INTO `systemadmin` VALUES ('5', 'QQ老冰', 'lilang', '123', '1');
