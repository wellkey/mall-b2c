/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-10-22 17:44:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_category`
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '分类名',
  `level` smallint(4) DEFAULT NULL COMMENT '分类层级',
  `unit` varchar(4) DEFAULT '' COMMENT '计量单位',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_category
-- ----------------------------
INSERT INTO `pms_category` VALUES ('1', '手机数码', '1', '件', '1', '2020-10-22 14:13:24', '2020-10-22 16:32:14');
INSERT INTO `pms_category` VALUES ('2', '服装配饰', '1', '件', '2', '2020-10-22 14:13:57', '2020-10-22 16:32:16');
INSERT INTO `pms_category` VALUES ('3', '家用电器', '1', '件', '3', '2020-10-22 14:14:12', '2020-10-22 16:32:21');
