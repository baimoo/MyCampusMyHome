/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : mcmh

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2020-04-23 22:43:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building` (
  `bdid` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `baid` int(11) NOT NULL,
  `remark` varchar(255) NOT NULL,
  PRIMARY KEY (`bdid`),
  KEY `building_buildingAdmin_baid` (`baid`),
  CONSTRAINT `building_buildingAdmin_baid` FOREIGN KEY (`baid`) REFERENCES `buildingadmin` (`baid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of building
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of buildingadmin
-- ----------------------------

-- ----------------------------
-- Table structure for late
-- ----------------------------
DROP TABLE IF EXISTS `late`;
CREATE TABLE `late` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `remark` varchar(255) NOT NULL,
  `sid` varchar(255) NOT NULL,
  PRIMARY KEY (`lid`),
  KEY `late` (`sid`),
  CONSTRAINT `late` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of systemadmin
-- ----------------------------
