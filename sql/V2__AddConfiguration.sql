use microservice_slave1;



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
INSERT INTO User_Center(id, name, phone, pass, email, des, wechat, avatar, level, age, sex, account, is_deleted, is_disabled)
VALUES (2,'admin','15936931986','root','none','root的个人主页','none','',4,21,0,0,false,false);

DROP TABLE IF EXISTS `commodityCollect`;
CREATE TABLE `commodityCollect`  (
                                       `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏ID',
                                       `commodity_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                       `member_id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户id',
                                       `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程收藏' ROW_FORMAT = Compact;
INSERT INTO commodityCollect (id, commodity_id,member_id) VALUES
(1,'1451',1);
INSERT INTO commodityCollect (id, commodity_id,member_id) VALUES
    (2,'1450',2);
# INSERT INTO commodity_center(id, seller_id, subject_id, subject_Parent_id, commodity_title, commodity_price, commodity_time, commodity_cover, seller_amount, view_count, commodity_status, version)
# VALUES (2,'1451','mac','electic','mac pro 3','2999','2021','',2999.0,'643','1','12');
