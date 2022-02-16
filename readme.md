测试的时候
打开 redis  nacos
  redis-server
 打开nacos
 e:    cd E:\C++\nacos-server-2.0.3\nacos\bin
startup.cmd -m standalone
在   http://192.168.43.251:8848/nacos/index.html看nacos中心

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


功能需求：
1-高并发读取与写入（涉及到集群，负载，读写分离，分库分表等操作）
2-性能优化（玩转降级、限流、拒绝服务这三件法宝）






