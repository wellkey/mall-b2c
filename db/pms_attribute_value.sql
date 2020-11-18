/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-11-18 15:23:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_attribute_value`;
CREATE TABLE `pms_attribute_value` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attribute_id` int(16) DEFAULT NULL COMMENT '属性id',
  `attribute_value` varchar(100) DEFAULT NULL COMMENT '属性值',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_attribute_value
-- ----------------------------
INSERT INTO `pms_attribute_value` VALUES ('1', '1', '金色', '2020-11-12 11:14:53');
INSERT INTO `pms_attribute_value` VALUES ('2', '1', '黑色', '2020-11-12 11:15:03');
INSERT INTO `pms_attribute_value` VALUES ('3', '2', '128g', '2020-11-12 11:15:34');
INSERT INTO `pms_attribute_value` VALUES ('4', '2', '256g', '2020-11-12 11:15:45');
