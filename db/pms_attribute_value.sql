/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-02-27 16:27:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_attribute_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_attribute_value`;
CREATE TABLE `pms_attribute_value` (
  `attribute_id` int(16) NOT NULL COMMENT '属性id',
  `attribute_value` varchar(100) DEFAULT NULL COMMENT '属性值',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_attribute_value
-- ----------------------------
INSERT INTO `pms_attribute_value` VALUES ('1', '黑色', '2021-02-27 11:37:29');
INSERT INTO `pms_attribute_value` VALUES ('1', '金色', '2021-02-27 11:37:29');
INSERT INTO `pms_attribute_value` VALUES ('1', '银色', '2021-02-27 11:37:29');
INSERT INTO `pms_attribute_value` VALUES ('2', '128g', '2021-02-27 11:37:59');
INSERT INTO `pms_attribute_value` VALUES ('2', '256g', '2021-02-27 11:37:59');
INSERT INTO `pms_attribute_value` VALUES ('3', '黑色', '2021-02-27 11:38:19');
INSERT INTO `pms_attribute_value` VALUES ('3', '棕色', '2021-02-27 11:38:19');
INSERT INTO `pms_attribute_value` VALUES ('4', 'S', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('4', 'M', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('4', 'L', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('4', 'XL', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('4', 'XXL', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('4', 'XXXL', '2021-02-27 11:38:33');
INSERT INTO `pms_attribute_value` VALUES ('7', '72', '2021-02-27 11:38:51');
INSERT INTO `pms_attribute_value` VALUES ('7', '78', '2021-02-27 11:38:51');
INSERT INTO `pms_attribute_value` VALUES ('7', '84', '2021-02-27 11:38:51');
INSERT INTO `pms_attribute_value` VALUES ('7', '90', '2021-02-27 11:38:51');
INSERT INTO `pms_attribute_value` VALUES ('8', '13.3', '2021-02-27 11:40:16');
INSERT INTO `pms_attribute_value` VALUES ('8', '14', '2021-02-27 11:40:16');
INSERT INTO `pms_attribute_value` VALUES ('8', '15.6', '2021-02-27 11:40:16');
