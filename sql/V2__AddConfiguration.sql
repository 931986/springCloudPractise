
# 插入示例数据
# 创建分库实现user center的读写分离

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
VALUES (1,'sun','18192642680','931986','syf57336928','sun page','18192642680','',4,21,0,0,false,false);

