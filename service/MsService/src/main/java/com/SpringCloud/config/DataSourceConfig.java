package com.SpringCloud.config;//package com.SpringCloud.config;
//
//
//import com.SpringCloud.config.DataBase.DataMasterConfig;
//import com.SpringCloud.config.DataBase.DataSlave1Config;
//import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
//import org.apache.shardingsphere.core.rule.ShardingRule;
//import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
//import org.apache.shardingsphere.spi.algorithm.masterslave.MasterSlaveLoadBalanceAlgorithmServiceLoader;
//import org.apache.shardingsphere.spi.masterslave.MasterSlaveLoadBalanceAlgorithm;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.SQLFeatureNotSupportedException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//import java.util.logging.Logger;
//
//@Configuration
//public class DataSourceConfig {
//    @Autowired
//    private DataMasterConfig dataMasterConfig;
//    @Autowired
//    private DataSlave1Config dataSlave1Config;
//
//
//
//
////    @Bean
////    public DataSourceRule dataSourceRule(@Qualifier("dataSource0") DataSource dataSource0,
////                                         @Qualifier("dataSource1") DataSource dataSource1){
////        Map<String, DataSource> dataSourceMap = new HashMap<>();
////        dataSourceMap.put("dataSource0", dataSource0);
////        dataSourceMap.put("dataSource1", dataSource1);
////        return new DataSourceRule(dataSourceMap, "dataSource0");
////    }
//
//
//
//
//
//
//    @Bean
//    public DataSource GetDataSource() throws SQLException {
//        return buildDataSource();
//    }
//    public  DataSource buildDataSource() throws SQLException {
//        // 配置真实数据源
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//        // 配置主库
//         DataSource dataSource_master=dataMasterConfig.createDataSource();
////        BasicDataSource masterDataSource = new BasicDataSource();
////        masterDataSource.setDriverClassName("com.mysql.jdbc.Driver");
////        masterDataSource.setUrl("jdbc:mysql://localhost:3306/ds_master");
////        masterDataSource.setUsername("root");
////        masterDataSource.setPassword("");
//        dataSourceMap.put("ds_master", dataSource_master);
//        DataSource dataSource_slave1=dataMasterConfig.createDataSource();
//
//        dataSourceMap.put("ds_slave1", dataSource_slave1);
//
//
//        // 配置读写分离规则
//        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave1"));
//
//        // 获取数据源对象
////        createDataSourceMap(), masterSlaveRuleConfig, new HashMap<String, Object>(), new Properties()
//        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap,masterSlaveRuleConfig,new Properties());
//    }
//
//
//
//}
