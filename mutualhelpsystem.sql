/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : mutualhelpsystem

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2019-06-02 19:39:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `phone` char(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', '13420109611', 'aa@163.com', '123456', '2019-05-16 19:36:59', 'aa');

-- ----------------------------
-- Table structure for tb_express
-- ----------------------------
DROP TABLE IF EXISTS `tb_express`;
CREATE TABLE `tb_express` (
  `express_id` int(11) NOT NULL AUTO_INCREMENT,
  `publish_id` char(11) DEFAULT NULL,
  `accept_id` char(11) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `express_detail_id` char(30) DEFAULT NULL,
  PRIMARY KEY (`express_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_express
-- ----------------------------
INSERT INTO `tb_express` VALUES ('9', '13420109679', '13420109677', '101', '1002', '1558080239096');
INSERT INTO `tb_express` VALUES ('10', '13420109679', null, '101', '1004', '1558080349277');
INSERT INTO `tb_express` VALUES ('11', '13420109679', '13713397457', '101', '1002', '1558080683881');
INSERT INTO `tb_express` VALUES ('12', '13420109677', null, '101', '1001', '1558081439202');
INSERT INTO `tb_express` VALUES ('13', '13420109677', null, '101', '1001', '1558082403288');
INSERT INTO `tb_express` VALUES ('14', '13420109670', null, '101', '1001', '1558082772509');
INSERT INTO `tb_express` VALUES ('15', '13420109670', null, '101', '1001', '1558082838617');
INSERT INTO `tb_express` VALUES ('16', '13713397456', null, '101', '1001', '1558315469117');
INSERT INTO `tb_express` VALUES ('17', '13713397456', '13713397457', '101', '1003', '1558315522156');
INSERT INTO `tb_express` VALUES ('18', '13713397456', null, '101', '1001', '1558315576689');
INSERT INTO `tb_express` VALUES ('19', '13713397457', null, '101', '1001', '1558316049187');
INSERT INTO `tb_express` VALUES ('20', '13713397457', null, '101', '1001', '1558316093167');
INSERT INTO `tb_express` VALUES ('21', '13420109679', null, '101', '1001', '1558316806177');
INSERT INTO `tb_express` VALUES ('22', '13420109679', null, '101', '1001', '1558316858760');
INSERT INTO `tb_express` VALUES ('23', '13420109678', null, '101', '1001', '1558317722929');
INSERT INTO `tb_express` VALUES ('24', '13420109678', null, '101', '1001', '1558317774439');
INSERT INTO `tb_express` VALUES ('25', '13420109679', '13411112222', '101', '1002', '1558341642430');
INSERT INTO `tb_express` VALUES ('26', '13420109679', '13420109678', '101', '1003', '1559292968364');

-- ----------------------------
-- Table structure for tb_expressdetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_expressdetail`;
CREATE TABLE `tb_expressdetail` (
  `express_detail_id` char(30) NOT NULL,
  `express_publishtime` datetime DEFAULT NULL,
  `express_campany` varchar(255) DEFAULT NULL,
  `express_message` varchar(255) DEFAULT NULL,
  `express_phone` char(11) DEFAULT NULL,
  `express_site` varchar(255) DEFAULT NULL,
  `express_reward` decimal(10,0) DEFAULT NULL,
  `express_contact` char(11) DEFAULT NULL,
  `express_note` varchar(255) DEFAULT NULL,
  `express_finishtime` datetime DEFAULT NULL,
  PRIMARY KEY (`express_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_expressdetail
-- ----------------------------
INSERT INTO `tb_expressdetail` VALUES ('1558080239096', '2019-05-17 16:03:59', '京东快递', '您好，您12月31日的快递已到达海大游泳池旁物流中心，请20点前到（小件货架）取件，电联：15361942449', '13420109679', '海湛B311', '3', '13420109679', '1234', null);
INSERT INTO `tb_expressdetail` VALUES ('1558080349277', '2019-05-17 16:05:49', '圆通快递', '【妈妈驿站】取货码 0536032圆通快递广东海洋大学门口小食街超市隔壁暑假上班时间：10:00-18:30，18022632609。上门收件：18820438397（67）。', '13420109679', '海湛B210', '2', '13420109679', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558080683881', '2019-05-17 16:11:24', '顺丰速运', '【顺丰速运】亲，您有快件放置于面对校门左侧直走80米顺丰现已爆仓，货号75，请20:00前持有效证件取件，收派员18022662206。\n', '13420109679', '海湛A201', '2', '13420109679', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558081439202', '2019-05-17 16:23:59', '顺丰速运', '【顺丰速运】亲，您有快件放置于学校门口左侧益丰超市直走20米顺丰，货号513，请17:00前持有效证件取件，收派员18022662206。\n', '13420109677', '海湛B302', '2', '13420109677', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558082403288', '2019-05-17 16:40:03', '韵达快递', '【好递讯美】韵达快递海大对面飞宏商城楼，8日A架袋子件按号码尾数找请今天22点前取走，请尽快取件逾期不取退回，咨询18666712798\n', '13420109677', '海湛B101', '2', '13420109677', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558082772509', '2019-05-17 16:46:13', '韵达快递', '【好递讯美】韵达快递海大对面飞宏商城楼，8日A架袋子件按号码尾数找请今天22点前取走，请尽快取件逾期不取退回，咨询18666712798\n', '13420109670', '海湛A120', '2', '13420109670', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558082838617', '2019-05-17 16:47:19', '圆通快递', '【妈妈驿站】取货码 0536032圆通快递广东海洋大学门口小食街超市隔壁暑假上班时间：10:00-18:30，18022632609。上门收件：18820438397（67）.', '13420109670', '海湛A509', '1', '13420109670', '尽快', null);
INSERT INTO `tb_expressdetail` VALUES ('1558315469117', '2019-05-20 09:24:29', '韵达快递', '【好递讯美】韵达快递海大对面飞宏商城楼，8日A架袋子件按号码尾数找请今天22点前取走，请尽快取件逾期不取退回，咨询18666712798\n', '13713397456', '海湛A101', '2', '13713397456', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558315522156', '2019-05-20 09:25:22', '圆通快递', '【妈妈驿站】取货码 0536032圆通快递广东海洋大学门口小食街超市隔壁暑假上班时间：10:00-18:30，18022632609。上门收件：18820438397（67）.\n', '13713397456', '海湛A210', '1', '13713397456', '', '2019-05-20 09:42:01');
INSERT INTO `tb_expressdetail` VALUES ('1558315576689', '2019-05-20 09:26:17', '顺丰速运', '【顺丰速运】亲，您有快件放置于面对校门左侧直走80米顺丰现已爆仓，货号75，请20:00前持有效证件取件，收派员18022662206。\n', '13713397456', '海蓝A101', '3', '13713397456', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558316049187', '2019-05-20 09:34:09', '申通快递', '【申通快递】2月27日(B1货架)您的快递已到达海大游泳池旁物流中心，请在当天21：00前尽快领取！系统显示签收不影响取件哈！\n', '13713397456', '海蓝B102', '2', '13713397456', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558316093167', '2019-05-20 09:34:53', '京东快递', '【京东快递】您好，您12月31日的快递已到达海大游泳池旁物流中心，请20点前到（小件货架）取件，电联：15361942449\n', '13713397457', '海湛A310', '2', '13713397457', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558316806177', '2019-05-20 09:46:46', '京东快递', '【京东快递】您好，您12月31日的快递已到达海大游泳池旁物流中心，请20点前到（小件货架）取件，电联：15361942449\n', '13420109679', '海湛A201', '2', '13420109679', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558316858760', '2019-05-20 09:47:39', '圆通快递', '【妈妈驿站】取货码 0536032圆通快递广东海洋大学门口小食街超市隔壁暑假上班时间：10:00-18:30，18022632609。上门收件：18820438397（67）.\n', '13420109679', '海湛A210', '2', '13420109679', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558317722929', '2019-05-20 10:02:03', '京东快递', '【京东快递】您好，您12月31日的快递已到达海大游泳池旁物流中心，请20点前到（小件货架）取件，电联：15361942449\n', '13420109678', '海湛B211', '2', '13420109678', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558317774439', '2019-05-20 10:02:54', '顺丰速运', '【顺丰速运】亲，您有快件放置于学校门口左侧益丰超市直走20米顺丰，货号513，请17:00前持有效证件取件，收派员18022662206。\n', '13420109678', '海湛A208', '2', '13420109678', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1558341642430', '2019-05-20 16:40:42', '京东快递', 'asdfsad', '12222222222', '12', '12', '12222222222', '', null);
INSERT INTO `tb_expressdetail` VALUES ('1559292968364', '2019-05-31 16:56:08', '1', '2', '11111111111', '4', '5', '11111111111', '', '2019-05-31 16:59:02');

-- ----------------------------
-- Table structure for tb_used
-- ----------------------------
DROP TABLE IF EXISTS `tb_used`;
CREATE TABLE `tb_used` (
  `used_id` int(11) NOT NULL AUTO_INCREMENT,
  `publish_id` char(11) DEFAULT NULL,
  `accept_id` char(11) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `used_detail_id` char(30) DEFAULT NULL,
  PRIMARY KEY (`used_id`),
  KEY `pk_used_useddetail` (`used_detail_id`),
  CONSTRAINT `pk_used_useddetail` FOREIGN KEY (`used_detail_id`) REFERENCES `tb_useddetail` (`used_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_used
-- ----------------------------
INSERT INTO `tb_used` VALUES ('11', '13420109679', null, '102', '1001', '1558080929993');
INSERT INTO `tb_used` VALUES ('12', '13420109677', null, '102', '1001', '1558082028742');
INSERT INTO `tb_used` VALUES ('13', '13420109677', null, '102', '1001', '1558082272290');
INSERT INTO `tb_used` VALUES ('14', '13420109670', null, '102', '1001', '1558083115015');
INSERT INTO `tb_used` VALUES ('15', '13713397456', '13713397457', '102', '1002', '1558315735149');
INSERT INTO `tb_used` VALUES ('16', '13713397456', null, '102', '1001', '1558315830731');
INSERT INTO `tb_used` VALUES ('17', '13713397456', null, '102', '1001', '1558315945472');
INSERT INTO `tb_used` VALUES ('18', '13713397457', null, '102', '1001', '1558316183517');
INSERT INTO `tb_used` VALUES ('19', '13713397457', null, '102', '1001', '1558316347360');
INSERT INTO `tb_used` VALUES ('20', '13420109678', null, '102', '1001', '1558317886660');

-- ----------------------------
-- Table structure for tb_useddetail
-- ----------------------------
DROP TABLE IF EXISTS `tb_useddetail`;
CREATE TABLE `tb_useddetail` (
  `used_detail_id` char(30) NOT NULL,
  `used_publishtime` datetime DEFAULT NULL,
  `used_title` varchar(255) DEFAULT NULL,
  `used_message` varchar(255) DEFAULT NULL,
  `used_contact` varchar(255) DEFAULT NULL,
  `used_price` decimal(10,0) DEFAULT NULL,
  `used_note` varchar(255) DEFAULT NULL,
  `used_img` varchar(255) DEFAULT NULL,
  `used_finishtime` datetime DEFAULT NULL,
  PRIMARY KEY (`used_detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_useddetail
-- ----------------------------
INSERT INTO `tb_useddetail` VALUES ('1558080929993', '2019-05-17 16:15:30', '洗衣机', 'TCL 洗衣机5公斤 5成新，有意者私聊。', 'wx: xyj22333', '260', '1235', '1558080928097wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.okXHD2fmm1AMba7beac6a48544471075f6af63ccf39c.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558082028742', '2019-05-17 16:33:49', '小米手机', '小米9SE骁龙712低价出售', 'wx: xmxl323', '860', '', '1558082027138wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.Q1HvUbigg0FO403463de4f7a83ef08ecec28b302bcc0.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558082272290', '2019-05-17 16:37:52', '戴尔笔记本', 'Mx150 独显2G 18.10月起保 14寸金属银色 1920.1080高分屏 新旧程度:看图 有些瑕疵 顺丰到付 带电源', 'wx: debjb1234', '3800', '', '1558082270531wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.ofFxVm3Ot3os873cc5f70b3d24992578c4c202a66a90.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558083115015', '2019-05-17 16:51:55', 'hp笔记本', '惠普商务机I7.4G120G固态.15寸9成新价格可咨询谢谢', 'wx: hp33222', '1999', '', '1558083113405wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.n7KHAMDYQfDN9ed3b628e63c5dbf74d6ecf84b361aaa.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558315735149', '2019-05-20 09:28:55', '网球拍', '新旧程度:九成新转手原因:闲置入手渠道:因为现在没空玩了！', 'wx: ksd123', '60', '', '1558315733408wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.At5dyZtPLGtA15ce352817fd963ae2a23807bf1d8c84.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558315830731', '2019-05-20 09:30:31', '美图手机', '美图v6 6+128g 双卡全网通无拆修无任何质量问题 前置双摄 后置双摄 红色真皮 配置可以！非常好看的机器[流泪] 成色一般，备用完美！特价1100编号19050608', 'qq: 283467823', '1100', '', '1558315829024wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.zQqEqoBmZRJxd450a1a3a9b28a4453633b99c2309eb7.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558315945472', '2019-05-20 09:32:25', '苹果手机', '手机是无锁滴不是什么黑解卡贴机！手机是128G内存，指纹解锁灵敏。功能全正常，无修无暗病。支持移动4g联通4g，手机收到手插卡既用，无需要插卡贴。 可任意还原、升级、刷机。没暗病，没隐藏ID。 成色很棒。欢迎咨询，问问又不会怀孕。本交易仅支持自提、当面交易、邮寄', 'qq: 239847823', '2300', '', '1558315943701wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.vdODJJHdIZ8R95e69ee27fe2b26dbcf99274ef6b49f6.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558316183517', '2019-05-20 09:36:24', 'oppo手机', 'oppo 型号a59s，4+32，屏幕有裂痕四条大的，贴上钢化膜不明显，还有一张多的钢化膜赠送，有原装的2a充电头，触碰灵敏，一直带壳使用，成色不错换新手机闲置卖了，看上的来，不议价，邮费任你选到付', 'wx: la12333', '360', '', '1558316182087wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.jbnzW7bMS1Zl855e1fdb13190e3ccb839ea0e6d9d3c3.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558316347360', '2019-05-20 09:39:07', '技嘉GTX1060', '技嘉GTX1060 6G ITX 小机箱适用，不玩游戏了，转给有需要的朋友吧！', 'wx：12312312', '1299', '', '1558316346007wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.stqfE4JomPB64d97a3c2bc364d7c8ff0c4f85da3daac.jpg', null);
INSERT INTO `tb_useddetail` VALUES ('1558317886660', '2019-05-20 10:04:47', 'AOC曲面屏', 'AOC 2K144HZ 曲面屏，自用，七成新，因为工作原因得出手，手续齐全。', 'wx: 123456li', '1700', '', '1558317884406wxac9bcc0e5fa7f464.o6zAJsxMiieAeTMza4c6lkLD6Yik.Vmvlj2DKBxG3b8c91c805fc52677511d39ada48845d4.jpg', null);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `account` char(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('13411112222', 'e10adc3949ba59abbe56e057f20f883e', 'jkl', 'jkl@qq.com', '2019-05-18 15:55:10');
INSERT INTO `tb_user` VALUES ('13420109600', 'e10adc3949ba59abbe56e057f20f883e', 'df', 'df@qq.com', '2019-05-18 15:55:33');
INSERT INTO `tb_user` VALUES ('13420109612', 'e10adc3949ba59abbe56e057f20f883e', 'ty', 'aa@163.com', '2019-05-18 15:51:19');
INSERT INTO `tb_user` VALUES ('13420109633', 'e10adc3949ba59abbe56e057f20f883e', '1234', '123@12.com', '2019-05-18 15:52:43');
INSERT INTO `tb_user` VALUES ('13420109670', 'e10adc3949ba59abbe56e057f20f883e', 'kj', 'kj@qq.com', '2019-05-17 16:43:51');
INSERT INTO `tb_user` VALUES ('13420109671', 'e10adc3949ba59abbe56e057f20f883e', 'wq', 'wq@126.com', '2019-05-17 16:42:43');
INSERT INTO `tb_user` VALUES ('13420109672', 'e10adc3949ba59abbe56e057f20f883e', 'li', 'aa@163.com', '2019-05-18 09:42:53');
INSERT INTO `tb_user` VALUES ('13420109677', 'e10adc3949ba59abbe56e057f20f883e', 'ae', 'a@a.com', '2019-05-15 10:03:23');
INSERT INTO `tb_user` VALUES ('13420109678', 'e10adc3949ba59abbe56e057f20f883e', 'aw', 'aw@126.com', '2019-05-11 17:01:34');
INSERT INTO `tb_user` VALUES ('13420109679', 'e10adc3949ba59abbe56e057f20f883e', 'fire', 'fire@foxmail.com', '2019-05-17 15:47:09');
INSERT INTO `tb_user` VALUES ('13420119677', '827ccb0eea8a706c4c34a16891f84e7b', 'ty', 'ty@126.com', '2019-05-21 20:57:55');
INSERT INTO `tb_user` VALUES ('13429098766', 'e10adc3949ba59abbe56e057f20f883e', 'gh', 'gh@qq.com', '2019-05-18 15:24:43');
INSERT INTO `tb_user` VALUES ('13713397456', 'e10adc3949ba59abbe56e057f20f883e', 'kl', 'kl@123.com', '2019-05-20 09:22:58');
INSERT INTO `tb_user` VALUES ('13713397457', 'e10adc3949ba59abbe56e057f20f883e', 'jiaa', 'ji@aa.com', '2019-05-20 09:33:06');
