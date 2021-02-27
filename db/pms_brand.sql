/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-02-27 16:27:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '品牌名',
  `logo` varchar(200) DEFAULT '' COMMENT '品牌logo',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_brand
-- ----------------------------
INSERT INTO `pms_brand` VALUES ('1', '华为', 'HUAWEI', '2020-10-22 14:08:58');
INSERT INTO `pms_brand` VALUES ('2', '小米', 'MI', '2020-10-22 14:09:23');
INSERT INTO `pms_brand` VALUES ('104', '苹果', 'APPLE', '2020-10-27 14:13:36');
INSERT INTO `pms_brand` VALUES ('105', '三星', 'SAMSUNG', '2020-10-27 14:14:16');
INSERT INTO `pms_brand` VALUES ('106', 'oppo', 'OPPO', '2020-11-02 16:19:15');
INSERT INTO `pms_brand` VALUES ('108', 'vivo', 'VIVO', '2020-11-02 16:47:18');
INSERT INTO `pms_brand` VALUES ('109', '一加', 'ONEPLUS', '2020-11-02 16:48:44');
