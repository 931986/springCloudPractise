package com.SpringCloud.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

@Configuration
        @EnableCaching
public class RedisConfig {


   @Bean
public  RedisTemplate<String,Serializable> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory){
  RedisTemplate<String,Serializable> redisTemplate=new RedisTemplate<>();
  redisTemplate.setKeySerializer(new StringRedisSerializer());
  redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
  redisTemplate.setConnectionFactory(lettuceConnectionFactory);
  return redisTemplate;

    }

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory){
        RedisCacheConfiguration cacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                        .disableCachingNullValues();
        RedisCacheManager manager= RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfiguration).build();
        return manager;

    }

}

//    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
//
//
//    }
