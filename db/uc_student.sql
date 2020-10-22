/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-10-22 17:44:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `uc_student`
-- ----------------------------
DROP TABLE IF EXISTS `uc_student`;
CREATE TABLE `uc_student` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `student_no` varchar(20) DEFAULT '' COMMENT '学号',
  `student_name` varchar(10) DEFAULT '' COMMENT '姓名',
  `sex` smallint(2) DEFAULT NULL COMMENT '性别',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  `is_del` tinyint(1) DEFAULT '0' COMMENT '是否删除：0未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uc_student
-- ----------------------------
INSERT INTO `uc_student` VALUES ('1', '1001', '沈泉灵', '2', '2020-10-22 10:37:07', '0');
INSERT INTO `uc_student` VALUES ('2', '1002', '何天宇', '1', '2020-10-22 10:37:48', '0');
