# source E:\C++\Project\spring_cloud_practise-master\sql\V3__TestJmeter.sql
use microService;
DROP TABLE IF EXISTS `Goods_seckill_center`;
CREATE TABLE `Goods_seckill_center` (


                                     #     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                     `id`int auto_increment,
                                     `goods_id` int,
                                     `num` int COMMENT '数量',

                                     `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                     `seckill_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',

                                     `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
                                     `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
                                     `version` int(11) DEFAULT NULL COMMENT '并发版本控制',
                                     PRIMARY KEY (`id`) USING BTREE


)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
# INSERT INTO Goods_center(id, num) VALUES (1,10);
INSERT INTO `Goods_seckill_center`(id,goods_id, num,seckill_price,start_date,end_date,version)
 VALUES ('10','1' ,'2','0.01',  '2018-05-22 17:22:52', '2018-05-22 18:23:00', '0');
INSERT INTO `Goods_seckill_center`(id,goods_id, num,seckill_price,start_date,end_date,version)
 VALUES ('11', '2','5', '0.01',  '2018-04-29 22:56:10', '2018-05-01 22:56:15', '0');



DROP TABLE IF EXISTS `Goods_center`;
CREATE TABLE `Goods_center` (


    #     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
                                `goods_name` varchar(30) DEFAULT NULL COMMENT '商品名称',
                                `goods_title` varchar(64) DEFAULT NULL COMMENT '商品标题',
                                `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片',
                                `goods_detail` longtext COMMENT '商品详情',
                                `goods_price` decimal(10,2) DEFAULT NULL,
                                `num` int(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
                                PRIMARY KEY (`id`) USING BTREE


)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
# INSERT INTO Goods_center(id, num) VALUES (1,10);
INSERT INTO `Goods_center`
VALUES ('1', 'iphoneX', 'Apple', '/img/iphonex.png', 'Apple', '7788.00', '2');
INSERT INTO `Goods_center`
VALUES ('2', 'Mate 10', 'Huawei', '/img/meta10.png', 'Huawei', '4199.00', '5');













DROP TABLE IF EXISTS `OrderInfo_center`;
CREATE TABLE `OrderInfo_center` (
                                 `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                 `user_id` bigint(20) DEFAULT NULL,
                                 `goods_id` bigint(20) DEFAULT NULL,
                                 `delivery_addr_id` bigint(20) DEFAULT NULL,
                                 `goods_name` varchar(30) DEFAULT NULL,
                                 `description` varchar(100) DEFAULT NULL,
                                 `goods_count` int(11) DEFAULT NULL,
                                 `goods_price` decimal(10,2) DEFAULT NULL,
                                 `order_channel` tinyint(4) DEFAULT NULL COMMENT '订单渠道，1在线，2android，3ios',
                                 `status` tinyint(4) DEFAULT NULL COMMENT '订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退款，5已完成',




                                 `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                 PRIMARY KEY (`id`) USING BTREE


)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
# INSERT INTO Goods_center(id, num) VALUES (1,10);
# INSERT INTO commodity_center(id,commodity_id, seller_id, subject_id, subject_Parent_id, commodity_title, commodity_price, commodity_time, commodity_cover, seller_amount, view_count, commodity_status, version)
#  VALUES (2,'1451','213','mac','electic','mac pro 3','2999','2021','',2999.0,'643','1','12');