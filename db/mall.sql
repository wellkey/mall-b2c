/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-03-21 13:08:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oms_cart
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart`;
CREATE TABLE `oms_cart` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(16) NOT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_cart
-- ----------------------------
INSERT INTO `oms_cart` VALUES ('1', '1002', '2021-03-03 09:40:25');

-- ----------------------------
-- Table structure for oms_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_cart_item`;
CREATE TABLE `oms_cart_item` (
  `cart_id` int(16) NOT NULL COMMENT '购物车id',
  `item_id` int(16) NOT NULL COMMENT '商品sku id',
  `quantity` int(8) DEFAULT '1',
  `insert_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_cart_item
-- ----------------------------
INSERT INTO `oms_cart_item` VALUES ('1', '1006', '3', '2021-03-03 09:40:51');
INSERT INTO `oms_cart_item` VALUES ('1', '1007', '1', '2021-03-04 14:19:52');
INSERT INTO `oms_cart_item` VALUES ('1', '1003', '1', '2021-03-05 09:53:40');

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(32) NOT NULL COMMENT 'id',
  `payment` decimal(8,2) DEFAULT NULL COMMENT '实付金额',
  `payment_type` int(1) DEFAULT '1' COMMENT '支付类型：1、在线支付，2、货到付款',
  `post_fee` decimal(8,2) DEFAULT NULL COMMENT '邮费',
  `status` int(1) DEFAULT '1' COMMENT '状态：1、未付款，2、已付款，3、已发货，4、交易完成，5、交易关闭，6、订单超时过期',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
  `payment_time` datetime DEFAULT NULL,
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `user_id` int(16) DEFAULT NULL COMMENT '用户id',
  `user_note` varchar(255) DEFAULT NULL COMMENT '用户留言',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_order
-- ----------------------------
INSERT INTO `oms_order` VALUES ('1372115193995333632', '5998.00', '1', '0.00', '1', '2021-03-06 17:53:21', '2021-03-17 17:28:16', null, null, null, null, '1002', '');
INSERT INTO `oms_order` VALUES ('1372115193995333633', '5998.00', '1', '0.00', '1', '2021-03-06 17:52:53', '2021-03-17 17:28:21', null, null, null, null, '1002', '');
INSERT INTO `oms_order` VALUES ('1372122164161024000', '100.00', '1', '0.00', '6', '2021-03-17 17:46:31', '2021-03-17 17:46:51', null, null, null, null, '1002', '谢谢');
INSERT INTO `oms_order` VALUES ('1373477767856918528', '2599.00', '1', '0.00', '6', '2021-03-21 11:33:12', '2021-03-21 11:33:32', null, null, null, null, '1002', '');
INSERT INTO `oms_order` VALUES ('1373493877281001472', '2599.00', '1', '0.00', '6', '2021-03-21 12:37:13', '2021-03-21 12:37:33', null, null, null, null, '1002', '');
INSERT INTO `oms_order` VALUES ('1373494122509373440', '2399.00', '1', '0.00', '6', '2021-03-21 12:38:11', '2021-03-21 12:38:31', null, null, null, null, '1002', '问问');

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `item_id` int(16) DEFAULT NULL,
  `order_id` bigint(32) DEFAULT NULL,
  `num` int(8) DEFAULT '1' COMMENT '购买数量',
  `insert_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_order_item
-- ----------------------------
INSERT INTO `oms_order_item` VALUES ('3', '1001', '1372122164161024000', '1', '2021-03-18 10:51:50');
INSERT INTO `oms_order_item` VALUES ('4', '1007', '1372115193995333632', '2', '2021-03-18 10:52:20');
INSERT INTO `oms_order_item` VALUES ('5', '1006', '1372115193995333633', '1', '2021-03-19 10:51:50');
INSERT INTO `oms_order_item` VALUES ('6', '1006', '1372122164161024000', '3', '2021-03-19 12:11:52');
INSERT INTO `oms_order_item` VALUES ('7', '1001', '1372122164161024000', '2', '2021-03-19 12:11:52');
INSERT INTO `oms_order_item` VALUES ('8', '1003', '1372122164161024000', '4', '2021-03-19 12:11:52');
INSERT INTO `oms_order_item` VALUES ('9', '1007', '1372122164161024000', '3', '2021-03-20 10:51:50');
INSERT INTO `oms_order_item` VALUES ('10', '1004', '1372122164161024000', '1', '2021-03-20 10:51:50');
INSERT INTO `oms_order_item` VALUES ('11', '1006', '1372122164161024000', '2', '2021-03-20 10:51:50');
INSERT INTO `oms_order_item` VALUES ('12', '1001', '1372122164161024000', '5', '2021-03-20 10:51:50');
INSERT INTO `oms_order_item` VALUES ('13', '1003', '1373477767856918528', '1', '2021-03-21 11:33:12');
INSERT INTO `oms_order_item` VALUES ('14', '1003', '1373493877281001472', '1', '2021-03-21 12:37:13');
INSERT INTO `oms_order_item` VALUES ('15', '1006', '1373494122509373440', '3', '2021-03-21 12:38:11');

-- ----------------------------
-- Table structure for oms_order_shipping
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_shipping`;
CREATE TABLE `oms_order_shipping` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '收货人手机号',
  `province` int(8) DEFAULT NULL COMMENT '省份',
  `city` int(8) DEFAULT NULL COMMENT '城市',
  `district` int(8) DEFAULT NULL COMMENT '区/县',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `zip_code` varchar(255) DEFAULT NULL COMMENT '邮政编码',
  `is_default` int(1) DEFAULT '0' COMMENT '是否默认 0：非默认 1：默认',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_order_shipping
-- ----------------------------

-- ----------------------------
-- Table structure for oms_sec
-- ----------------------------
DROP TABLE IF EXISTS `oms_sec`;
CREATE TABLE `oms_sec` (
  `item_id` int(16) NOT NULL,
  `stock` int(8) DEFAULT NULL COMMENT '库存',
  `act_id` int(16) DEFAULT NULL COMMENT '活动id',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oms_sec
-- ----------------------------
INSERT INTO `oms_sec` VALUES ('1001', '5', '1001', '2021-03-11 15:28:38');
INSERT INTO `oms_sec` VALUES ('1003', '50', '1001', '2021-03-11 15:28:49');

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

-- ----------------------------
-- Table structure for pms_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '分类名',
  `par_id` smallint(4) DEFAULT '0' COMMENT '父级层级id',
  `level` smallint(4) DEFAULT NULL COMMENT '分类层级',
  `unit` varchar(4) DEFAULT '' COMMENT '计量单位',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_category
-- ----------------------------
INSERT INTO `pms_category` VALUES ('1', '手机数码', '0', '1', '件', '2020-10-22 14:13:24');
INSERT INTO `pms_category` VALUES ('2', '服装配饰', '0', '1', '件', '2020-10-22 14:13:57');
INSERT INTO `pms_category` VALUES ('1007', '手机', '1', '2', '台', '2020-11-06 16:13:28');
INSERT INTO `pms_category` VALUES ('1008', '电脑', '1', '2', '台', '2020-11-06 16:13:47');
INSERT INTO `pms_category` VALUES ('1009', '男装', '2', '2', '件', '2020-11-06 16:14:03');
INSERT INTO `pms_category` VALUES ('1010', '女装', '2', '2', '件', '2020-11-06 16:14:21');
INSERT INTO `pms_category` VALUES ('1011', '童装', '2', '2', '件', '2020-11-06 16:14:58');
INSERT INTO `pms_category` VALUES ('1012', '裙子', '1010', '3', '条', '2020-11-06 16:15:26');
INSERT INTO `pms_category` VALUES ('1013', '风衣', '1010', '3', '件', '2020-11-06 16:16:08');
INSERT INTO `pms_category` VALUES ('1014', '长裤', '1009', '3', '条', '2020-11-06 16:16:26');
INSERT INTO `pms_category` VALUES ('1015', '夹克', '1009', '3', '件', '2020-11-06 16:16:39');
INSERT INTO `pms_category` VALUES ('1018', '食品酒饮', '0', '1', '件', '2021-02-27 09:30:20');
INSERT INTO `pms_category` VALUES ('1019', '母婴', '0', '1', '件', '2021-02-27 09:40:50');
INSERT INTO `pms_category` VALUES ('1020', '休闲食品', '1018', '2', '件', '2021-02-27 09:41:20');
INSERT INTO `pms_category` VALUES ('1021', '进口食品', '1018', '2', '件', '2021-02-27 09:41:32');
INSERT INTO `pms_category` VALUES ('1022', '膨化食品', '1020', '3', '件', '2021-02-27 09:42:02');
INSERT INTO `pms_category` VALUES ('1024', '糖果/巧克力', '1021', '3', '件', '2021-02-27 09:43:08');
INSERT INTO `pms_category` VALUES ('1025', '方便食品', '1021', '3', '件', '2021-02-27 09:43:29');
INSERT INTO `pms_category` VALUES ('1026', '油', '1021', '3', '瓶', '2021-02-27 09:43:41');

-- ----------------------------
-- Table structure for pms_product
-- ----------------------------
DROP TABLE IF EXISTS `pms_product`;
CREATE TABLE `pms_product` (
  `id` int(16) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) DEFAULT '' COMMENT '产品名',
  `pic` varchar(100) DEFAULT NULL COMMENT '产品图片地址',
  `brand_id` int(16) DEFAULT NULL COMMENT '品牌id',
  `category_id` int(16) DEFAULT NULL COMMENT '分类id',
  `description` varchar(200) DEFAULT '' COMMENT '产品描述',
  `delete_status` tinyint(1) DEFAULT '0' COMMENT '删除标志 0：未删除 1：已删除',
  `verify_status` tinyint(1) DEFAULT '0' COMMENT '审核标志 0：未审核 1：已审核',
  `publish_status` tinyint(1) DEFAULT '0' COMMENT '上架标志 0：未上架 1：已上架',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product
-- ----------------------------
INSERT INTO `pms_product` VALUES ('1', '华为 HUAWEI P20', '', '1', '1007', '眼界大开', '0', '0', '0', '2020-10-22 14:08:14');
INSERT INTO `pms_product` VALUES ('2', '小米8', '', '2', '1007', '全面屏游戏智能手机', '0', '0', '0', '2020-10-22 16:45:35');
INSERT INTO `pms_product` VALUES ('4', '红米Note8', '/img2021/02/26/1614322525058.jpg', '2', '1007', 'Red MI Note8', '0', '0', '0', '2021-02-26 14:55:57');

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
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pms_product_item
-- ----------------------------
INSERT INTO `pms_product_item` VALUES ('1001', 'HW001', '1', '1,3', null, '1988.00', '100', '2020-11-09 16:58:56');
INSERT INTO `pms_product_item` VALUES ('1002', 'HW002', '1', '2,3', null, '1988.00', '102', '2020-11-09 16:58:59');
INSERT INTO `pms_product_item` VALUES ('1003', 'MI001', '2', '1,3', null, '2599.00', '235', '2020-11-09 16:59:02');
INSERT INTO `pms_product_item` VALUES ('1004', 'MI002', '2', '2,3', null, '2499.00', '246', '2020-11-09 16:59:05');
INSERT INTO `pms_product_item` VALUES ('1005', 'MI003', '2', '1,4', null, '1999.00', '300', '2020-11-11 10:59:03');
INSERT INTO `pms_product_item` VALUES ('1006', 'MI004', '2', '2,4', null, '2399.00', '213', '2020-11-11 10:59:09');
INSERT INTO `pms_product_item` VALUES ('1007', 'HW003', '1', '1,4', '', '3599.00', '120', '2020-11-25 09:20:48');

-- ----------------------------
-- Table structure for ums_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_resource`;
CREATE TABLE `ums_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
  `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='后台资源表';

-- ----------------------------
-- Records of ums_resource
-- ----------------------------
INSERT INTO `ums_resource` VALUES ('31', 'user:list', '/user/list', null, null);
INSERT INTO `ums_resource` VALUES ('32', 'user:add', '/user/add', null, null);
INSERT INTO `ums_resource` VALUES ('33', 'user:delete', '/user/delete', null, null);

-- ----------------------------
-- Table structure for ums_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_role`;
CREATE TABLE `ums_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `description` varchar(500) DEFAULT NULL COMMENT '描述',
  `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='后台用户角色表';

-- ----------------------------
-- Records of ums_role
-- ----------------------------
INSERT INTO `ums_role` VALUES ('8', '平台管理员', null, null, null, '1', '0');
INSERT INTO `ums_role` VALUES ('9', '商品管理员', null, null, null, '1', '0');
INSERT INTO `ums_role` VALUES ('10', '订单管理员', null, null, null, '1', '0');

-- ----------------------------
-- Table structure for ums_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `ums_role_resource`;
CREATE TABLE `ums_role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后台角色资源关系表';

-- ----------------------------
-- Records of ums_role_resource
-- ----------------------------
INSERT INTO `ums_role_resource` VALUES ('1', '8', '31');
INSERT INTO `ums_role_resource` VALUES ('2', '8', '32');

-- ----------------------------
-- Table structure for ums_user
-- ----------------------------
DROP TABLE IF EXISTS `ums_user`;
CREATE TABLE `ums_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 COMMENT='后台用户表';

-- ----------------------------
-- Records of ums_user
-- ----------------------------
INSERT INTO `ums_user` VALUES ('1001', 'admin', 'f60e7eb417913dad39fb378cbb0dfc5c', null, null, '超级管理员', null, '2021-03-02 09:33:30', null, '1');
INSERT INTO `ums_user` VALUES ('1002', 'pzh', 'f60e7eb417913dad39fb378cbb0dfc5c', null, null, 'pzh', null, '2021-03-02 09:33:40', null, '1');

-- ----------------------------
-- Table structure for ums_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ums_user_role`;
CREATE TABLE `ums_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of ums_user_role
-- ----------------------------
INSERT INTO `ums_user_role` VALUES ('31', '1001', '8');
