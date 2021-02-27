/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-02-27 16:27:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pms_product_item
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_item`;
CREATE TABLE `pms_product_item` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT,
  `product_no` varchar(255) DEFAULT NULL COMMENT '货号',
  `product_id` int(16) DEFAULT NULL COMMENT '所属商品spu',
  `product_specs` varchar(200) DEFAULT NULL COMMENT '规格(用于页面展示)',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `stock` int(20) DEFAULT NULL COMMENT '库存',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_item
-- ----------------------------
INSERT INTO `pms_product_item` VALUES ('1', 'HW001', '1', '1,3', null, '1988.00', '100', '2020-11-09 16:58:56');
INSERT INTO `pms_product_item` VALUES ('2', 'HW002', '1', '2,3', null, '1988.00', '102', '2020-11-09 16:58:59');
INSERT INTO `pms_product_item` VALUES ('3', 'MI001', '2', '1,3', null, '2599.00', '235', '2020-11-09 16:59:02');
INSERT INTO `pms_product_item` VALUES ('4', 'MI002', '2', '2,3', null, '2499.00', '246', '2020-11-09 16:59:05');
INSERT INTO `pms_product_item` VALUES ('5', 'MI003', '2', '1,4', null, '1999.00', '300', '2020-11-11 10:59:03');
INSERT INTO `pms_product_item` VALUES ('6', 'MI004', '2', '2,4', null, '2399.00', '213', '2020-11-11 10:59:09');
INSERT INTO `pms_product_item` VALUES ('7', 'HW003', '1', '1,4', '', '3599.00', '120', '2020-11-25 09:20:48');
