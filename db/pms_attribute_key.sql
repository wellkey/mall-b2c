/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-02-27 16:27:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_attribute_key
-- ----------------------------
DROP TABLE IF EXISTS `pms_attribute_key`;
CREATE TABLE `pms_attribute_key` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `category_id` int(16) DEFAULT NULL COMMENT '一级分类id',
  `name` varchar(100) DEFAULT NULL COMMENT '属性key',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_attribute_key
-- ----------------------------
INSERT INTO `pms_attribute_key` VALUES ('1', '1007', '颜色', '2020-11-09 16:00:40');
INSERT INTO `pms_attribute_key` VALUES ('2', '1007', '内存', '2020-11-09 16:00:49');
INSERT INTO `pms_attribute_key` VALUES ('3', '1015', '颜色', '2020-11-09 16:00:52');
INSERT INTO `pms_attribute_key` VALUES ('4', '1009', '尺寸', '2020-11-09 16:00:56');
INSERT INTO `pms_attribute_key` VALUES ('7', '1009', '腰围', '2020-11-16 17:37:51');
INSERT INTO `pms_attribute_key` VALUES ('8', '1008', '屏幕尺寸', '2020-11-16 17:38:30');
INSERT INTO `pms_attribute_key` VALUES ('10', '1022', '重量', '2021-02-27 16:14:52');
INSERT INTO `pms_attribute_key` VALUES ('11', '1012', '裙长', '2021-02-27 16:20:26');
