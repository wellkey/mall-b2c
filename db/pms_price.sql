/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2020-10-22 17:44:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_price`
-- ----------------------------
DROP TABLE IF EXISTS `pms_price`;
CREATE TABLE `pms_price` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `product_id` int(16) DEFAULT NULL,
  `product_no` varchar(20) DEFAULT '' COMMENT '货号',
  `value` varchar(20) DEFAULT '' COMMENT '属性值',
  `price` double(20,2) DEFAULT NULL COMMENT '价格',
  `sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_price
-- ----------------------------
INSERT INTO `pms_price` VALUES ('1', '1', 'hw001', '黑色,64g', '3788.00', '1', '2020-10-22 15:20:14', '2020-10-22 16:50:39');
INSERT INTO `pms_price` VALUES ('2', '1', 'hw002', '白色,64g', '3788.00', '2', '2020-10-22 15:21:00', '2020-10-22 16:50:41');
INSERT INTO `pms_price` VALUES ('3', '1', 'hw003', '金色,64g', '3899.00', '3', '2020-10-22 15:21:18', '2020-10-22 16:51:14');
INSERT INTO `pms_price` VALUES ('4', '1', 'hw004', '黑色,128g', '3988.00', '4', '2020-10-22 15:22:03', '2020-10-22 16:50:53');
INSERT INTO `pms_price` VALUES ('5', '1', 'hw005', '白色,128g', '3988.00', '5', '2020-10-22 15:22:13', '2020-10-22 16:50:55');
INSERT INTO `pms_price` VALUES ('6', '1', 'hw006', '金色,128g', '3999.00', '6', '2020-10-22 16:38:53', '2020-10-22 16:50:59');
INSERT INTO `pms_price` VALUES ('7', '2', 'xm002', '银白色,256g', '3299.00', '2', '2020-10-22 16:51:31', '2020-10-22 16:52:29');
INSERT INTO `pms_price` VALUES ('8', '2', 'xm001', '银白色,128g', '2699.00', '1', '2020-10-22 16:51:36', '2020-10-22 16:52:27');
