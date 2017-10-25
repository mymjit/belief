package com.example.config;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;


/**
 * @Author : while
 * @Date : 2017/10/25
 * @Describe : redisCache的配置类
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {


    /**
     *@Describe : 定义缓存数据的key生成策略 包名类名方法名参数
     *@Method   : keyGenerator
     *@Param    : []
     *@Return   : org.springframework.cache.interceptor.KeyGenerator
     */
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(o.getClass().getName());
                stringBuffer.append(method.getName());
                for (Object obj : objects ){
                    stringBuffer.append(obj.toString());
                }
                return stringBuffer.toString();
            }
        };
    }

    /**
     *@Describe : 要启用spring缓存支持需创建一个 CacheManager 的Bean, CacheManager接口有很多实现
     *  这里Redis的集成用 RedisCacheManager这个实现类。
     *@Method   : cacheManager
     *@Param    : [redisTemplate]
     *@Return   : org.springframework.cache.CacheManager
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        return redisCacheManager;
    }

    /**
     *@Describe : 项目启动该方法注册成Bean交由Spring管理
     *@Method   : redisTemplate
     *@Param    : [connectionFactory]
     *@Return   : org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.String>
     */
    @Bean
    public RedisTemplate<String , String > redisTemplate(RedisConnectionFactory connectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(connectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper =new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        stringRedisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        stringRedisTemplate.afterPropertiesSet();
        return stringRedisTemplate;
    }
}
