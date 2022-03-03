package com.SpringCloud.redission;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Config.class)
@EnableConfigurationProperties(RedissonProperties.class)
public class RedissonAutoConfiguration {

    @Autowired
    private RedissonProperties redssionProperties;

    /**
     * Cluster模式自动装配
     * @return
     */
    /*@Bean
    RedissonClient redissonCluster() {
        Config config = new Config();
        ClusterServersConfig serverConfig = config.useClusterServers()
                .addNodeAddress(redssionProperties.getAddress()[0])
                .addNodeAddress(redssionProperties.getAddress()[1])
                .addNodeAddress(redssionProperties.getAddress()[2])
                .addNodeAddress(redssionProperties.getAddress()[3])
                .addNodeAddress(redssionProperties.getAddress()[4])
                .addNodeAddress(redssionProperties.getAddress()[5])
                .setTimeout(redssionProperties.getTimeout());

        return Redisson.create(config);
    }*/

    /**
     * 单机模式自动装配
     * @return
     */
    @Bean
    RedissonClient redissonCluster() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redssionProperties.getAddr())
                .setTimeout(redssionProperties.getTimeout())
                .setConnectionPoolSize(redssionProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redssionProperties.getConnectionMinimumIdleSize());

        return Redisson.create(config);
    }

    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     * @return
     */
    @Bean
    RedisLockUtil redissLockUtil(RedissonClient redissonClient) {
    	RedisLockUtil redissLockUtil = new RedisLockUtil();
    	redissLockUtil.setRedissonClient(redissonClient);
		return redissLockUtil;
    }

}
