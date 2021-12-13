SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for trade_order
-- ----------------------------
DROP TABLE IF EXISTS `trade_order`;
CREATE TABLE `trade_order`  (
#                                 `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                                id int auto_increment,
                                `commodity_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品id',
                                `commodity_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
                                `commodity_cover` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品封面',

                                `order_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '订单id',
                                `order_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单名称',
                                `order_cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单封面',
                                `order_amount`   decimal(20, 2) NULL DEFAULT NULL COMMENT '订单金额（分）',
                                `buyer_id` varchar(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 0 COMMENT '会员id',
                                `buyer_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员昵称',
                                `buyer_phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '会员手机',
                                `pay_choice` tinyint(0) NULL DEFAULT NULL COMMENT '支付类型（1：微信 2：支付宝）',
                                `pay_status` tinyint(0) NULL DEFAULT NULL COMMENT '订单状态（0：未支付 1：已支付）',
                                `logic_delete` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
                                `seller_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '讲师名称',
                                `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE  `idx_order_id`(`id`) USING  BTREE,
                            INDEX  `idx_commodity_id`(`commodity_id`) USING BTREE,
                            INDEX  `idx_buyer_id`(`buyer_id`) USING  BTREE

#                                 INDEX  `idx_course_id`(`commodityId`) USING BTREE,
#                                 INDEX  `idx_member_id`(`buyerId`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
# ) ENGINE =InnoDB CHARSET= utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;
# ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;






#
#     @ApiModelProperty(value = "负责人id")    private String sellerId;
# @ApiModelProperty(value = "commodity所属小类别")   private String subjectId;
# @ApiModelProperty(value = "commodity所属大类")    private String subjectParentId;
# @ApiModelProperty(value = "commodity标题")    private String commodityTitle;
# @ApiModelProperty(value = "commodity价格")   private String commodityPrice;
# @ApiModelProperty(value = "时间统计(这个是备用属性)") private String commodityTime;
# @ApiModelProperty(value = "commodity封面")  private String commodityCover;
# @ApiModelProperty(value = "销售数量")     private String sellerAmount;
# @ApiModelProperty(value = "浏览数量")     private String viewCount;
# @ApiModelProperty(value = "乐观锁/版本")
#     private String version;
# @ApiModelProperty(value = "commodity状态")
#     private String commodityStatus;

DROP TABLE IF EXISTS `commodity_center`;
CREATE TABLE `commodity_center`  (


#     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                     `id`int auto_increment,
                                   `seller_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品id',
                                   `subject_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
                                   `subject_Parent_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品封面',

                                   `commodity_title` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',

                                   `commodity_price` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT 10.00 COMMENT '商品id',
                                   `commodity_time` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT 0 COMMENT '商品名称',
                                   `commodity_cover` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '卖的数量',
                                   `seller_amount` decimal(20, 2) NULL DEFAULT 0 COMMENT '订单金额（分）',
                                   `view_count` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT 1 COMMENT '浏览量',
                                   `commodity_status` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT 1 COMMENT '状态',

                                   `version` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 1 COMMENT '乐观锁',
                                   `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                   PRIMARY KEY (`id`) USING BTREE,
                                  INDEX  `idx_order_id`(`seller_id`) USING  BTREE,
                                   INDEX  `idx_commodity_id`(`commodity_title`) USING BTREE
#                                    INDEX  `idx_buyer_id`(`buye`) USING  BTREE

#                                 INDEX  `idx_course_id`(`commodityId`) USING BTREE,
#                                 INDEX  `idx_member_id`(`buyerId`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
INSERT INTO commodity_center(id, seller_id, subject_id, subject_Parent_id, commodity_title, commodity_price, commodity_time, commodity_cover, seller_amount, view_count, commodity_status, version)
VALUES (1,'1','phone','electic','mi 3','1999','2021','',1999.0,'243','1','12');
# {
#
#     "commodity_title":"测试",
#     "sellerId":"28",
#     "subject_id":"Draft_",
#     "seller_amount":"1999",
#     "commodityPrice":"1999"
# }




DROP TABLE IF EXISTS `person_center`;
CREATE TABLE `person_center`  (


#     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
#
#     // String   个人姓名  name  个人简介 intro  个人描述  des
# //    String 个人头像 avatar
# //int    个人权限  level   排序 sort
# //    Boolean 逻辑删除  is_deleted
# //    注册时间和更新时间
                                     `id`int auto_increment,
                                     `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'name',
                                     `intro` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '个人简介',
                                     `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '个人描述',


                                     `avatar` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '个人头像',
                                     `sort` int NULL DEFAULT 0 COMMENT '排序',
                                     `level` int NULL DEFAULT 0 COMMENT '个人权限',
                                     `is_deleted` boolean NULL default false COLLATE utf8mb4_0900_ai_ci   COMMENT '逻辑删除',
#                                      `is_deleted` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',

                                     `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                     PRIMARY KEY (`id`) USING BTREE,
                                     INDEX  `idx_order_id`(`name`) USING  BTREE
#                                      INDEX  `idx_commodity_id`(`des`) USING BTREE
#                                    INDEX  `idx_buyer_id`(`buye`) USING  BTREE

#                                 INDEX  `idx_course_id`(`commodityId`) USING BTREE,
#                                 INDEX  `idx_member_id`(`buyerId`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
INSERT INTO person_center(id, name, intro, des, avatar, sort, level, `is_deleted`)
VALUES (1,'sun','xidian student','普通男性，欢迎关注','',1,1,false);









DROP TABLE IF EXISTS `User_Center`;
CREATE TABLE `User_Center`  (


#     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
# //    用户:id name  phone，pass,email,t,
# //      des,wechat,  avatar
# //    是否禁用  逻辑删除 个人权限 control  account sex age
                                  `id`int auto_increment,
                                  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'name',
                                  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '电话',
                                  `pass` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
                                  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',

                                  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '个人描述',

                                  `wechat` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT 'wechat',

                                  `avatar` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '个人头像',
                                  `level` int NULL DEFAULT 0 COMMENT '个人权限',
                                  `age` int NULL DEFAULT 18 COMMENT '年龄',
                                  `sex` int NULL DEFAULT 0 COMMENT '年龄(0 男 1 女)',
                                  `account` double NULL DEFAULT 0 COMMENT '个人余额',


                                  `is_deleted` boolean NULL default false COLLATE utf8mb4_0900_ai_ci   COMMENT '逻辑删除',
                                  `is_disabled` boolean NULL default false COLLATE utf8mb4_0900_ai_ci   COMMENT '逻辑禁用',

                                  `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX  `idx_order_name`(`name`) USING  BTREE,
                                INDEX  `idx_order_phone`(`phone`) USING  BTREE
#                                      INDEX  `idx_commodity_id`(`des`) USING BTREE
#                                    INDEX  `idx_buyer_id`(`buye`) USING  BTREE

#                                 INDEX  `idx_course_id`(`commodityId`) USING BTREE,
#                                 INDEX  `idx_member_id`(`buyerId`) USING BTREE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO User_Center(id, name, phone, pass, email, des, wechat, avatar, level, age, sex, account, is_deleted, is_disabled)
VALUES (1,'sun','18192642680','931986','syf57336928','sun的个人主页','18192642680','',4,21,0,0,false,false);







