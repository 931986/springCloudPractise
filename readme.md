测试的时候
打开 redis  nacos
  redis-server
 打开nacos
 e:    cd E:\C++\dependences\nacos\bin
startup.cmd -m standalone
在   http://192.168.43.251:8848/nacos/index.html看nacos中心

rabbitmq:
cd E:\C++\dependences\RabbitMQ\RabbitMQ\rabbitmq_server-3.9.13\sbin

fingBykey(name)
读写分离


mysql 更新sql 
mysql -uroot -p931986 -Dmicroservice <e:\C++\Project\spring_cloud_practise-master\sql\V1__init.sql
mysql -uroot -p931986 -Dmicroservice_slave1 <e:\C++\Project\spring_cloud_practise-master\sql\V2__AddConfiguration.sql





每次git push都要 进行 git config --global --unset http.proxy和 git config --global --unset https.proxy
这墙越来越厚了
通过复制collageParent的pom的配置，解决了依赖搭不上的不足


@Autowired 默认先按照type查找，后按照name查找，然后进行注入。@Resource与其相反。

在线地址：https://github.com/931986/spring_cloud_practise/tree/master


git上传 步骤：
cd E:/C++/Project/spring_cloud_practise-master
git  add *
git commit -m "...v1"
git push https://github.com/931986/springCloudPractise


Commodity测试数据，
seller_id unique，其余不是unique
{

    "commodity_title":"测试",
    "sellerId":"28",
    "subject_id":"Draft_",
    "seller_amount":"1999",
    "commodityPrice":"1999"
}

person测试数据
    {
                 "id":2,
            "name": "test",
           "intro": "xidian student",
             "des": "普通男性，欢迎关注",
            "level": 1,
             "avatar": "",

           "sort": 1,
           "deleted": false
            }ies（a,b）左边的变量a给右边的b赋值
登录测试数据
path:http://localhost:9000/api/Ucenter/login
{
"userInfo":"18192642680",
"pass":"931986"

}

代码里面 gmt_create和gmt_update两种自动更新的代码实现
一种是直接在数据库上加   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
一种是在entity的地方继承baseEntity，baseEntity里面设置gmt

gateway不支持下划线的命名方式，

mybatis：
命名建议： 数据对象全用驼峰，数据库全用横杠
# 开启驼峰命名转换，如：Table(create_time) -> Entity(createTime)
配置加上这一句：
    map-underscore-to-camel-case: true


功能需求：
1-高并发读取与写入（涉及到集群，负载，读写分离，分库分表等操作）
2-性能优化（玩转降级、限流、拒绝服务这三件法宝）




7. 本地标记 + redis预处理 + RabbitMQ异步下单 + 客户端轮询
   描述：通过三级缓冲保护，1、本地标记 2、redis预处理 3、RabbitMQ异步下单，最后才会访问数据库，这样做是为了最大力度减少对数据库的访问。

实现：

在秒杀阶段使用本地标记对用户秒杀过的商品做标记，若被标记过直接返回重复秒杀，未被标记才查询redis，通过本地标记来减少对redis的访问
抢购开始前，将商品和库存数据同步到redis中，所有的抢购操作都在redis中进行处理，通过Redis预减少库存减少数据库访问
为了保护系统不受高流量的冲击而导致系统崩溃的问题，使用RabbitMQ用异步队列处理下单，实际做了一层缓冲保护，做了一个窗口模型，窗口模型会实时的刷新用户秒杀的状态。
client端用js轮询一个接口，用来获取处理状态
8. 解决超卖
   描述：比如某商品的库存为1，此时用户1和用户2并发购买该商品，用户1提交订单后该商品的库存被修改为0，而此时用户2并不知道的情况下提交订单，该商品的库存再次被修改为-1，这就是超卖现象

实现：
mysql级别的操作
对库存更新时，先对库存判断，只有当库存大于0才能更新库存
对用户id和商品id建立一个唯一索引，通过这种约束避免同一用户发同时两个请求秒杀到两件相同商品
实现乐观锁，给商品信息表增加一个version字段，为每一条数据加上版本。每次更新的时候version+1，并且更新时候带上版本号，当提交前版本号等于更新前版本号，说明此时没有被其他线程影响到，正常更新，如果冲突了则不会进行提交更新。当库存是足够的情况下发生乐观锁冲突就进行一定次数的重试。






