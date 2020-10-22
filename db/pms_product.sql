/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-10-22 17:44:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_product`
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '产品名',
  `pic` varchar(100) DEFAULT '' COMMENT '产品图片地址',
  `brand_id` int(16) DEFAULT NULL COMMENT '品牌id',
  `category_id` int(16) DEFAULT NULL COMMENT '分类id',
  `description` varchar(200) DEFAULT '' COMMENT '产品描述',
  `delete_status` tinyint(1) DEFAULT '0' COMMENT '删除标志 0：未删除 1：已删除',
  `verify_status` tinyint(1) DEFAULT '0' COMMENT '审核标志 0：未审核 1：已审核',
  `publish_status` tinyint(1) DEFAULT '0' COMMENT '上架标志 0：未上架 1：已上架',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES ('1', '华为 HUAWEI P20', 'default url', '1', '1', '眼界大开', '0', '0', '0', '1', '2020-10-22 14:08:14', '2020-10-22 16:45:11');
INSERT INTO `pms_product` VALUES ('2', '小米8', 'default url', '2', '1', '全面屏游戏智能手机', '0', '0', '0', '2', '2020-10-22 16:45:35', '2020-10-22 17:38:13');
