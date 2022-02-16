# source E:\C++\Project\spring_cloud_practise-master\sql\V3__TestJmeter.sql
use microService;
DROP TABLE IF EXISTS `Goods_center`;
CREATE TABLE `Goods_center`  (


                                     #     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                     `id`int auto_increment,
                                     `num` int COMMENT '数量',

                                     `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                     PRIMARY KEY (`id`) USING BTREE


)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
INSERT INTO Goods_center(id, num) VALUES (1,10);


DROP TABLE IF EXISTS `Order_center`;
CREATE TABLE `Order_center`  (

#     @ApiModelProperty(value = "id")
#     private String id;
#     @ApiModelProperty(value = "des")
#     private String description;
#     @ApiModelProperty(value = "status")
#     private int status;
#     @ApiModelProperty(value = "userId")
#     private int UserId;
    #     `id` int CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品ID',
                                 `id`int auto_increment,
                                 `description` varchar(100) COMMENT '描述',
                                 `status` int COMMENT '状态',
                                 `user_id` int COMMENT '用户Id',

                                 `gmt_create` datetime(0) NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT  '更新时间',
                                 PRIMARY KEY (`id`) USING BTREE


)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
# INSERT INTO Goods_center(id, num) VALUES (1,10);
# INSERT INTO commodity_center(id,commodity_id, seller_id, subject_id, subject_Parent_id, commodity_title, commodity_price, commodity_time, commodity_cover, seller_amount, view_count, commodity_status, version)
#  VALUES (2,'1451','213','mac','electic','mac pro 3','2999','2021','',2999.0,'643','1','12');