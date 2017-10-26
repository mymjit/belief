package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Author : while
 * @Date : 2017/10/25
 * @Describe : SpringBoot整合SpringSession
 */

@EnableRedisHttpSession(
        //SpringSession的过期时间（单位：秒）
        maxInactiveIntervalInSeconds = 1800
)
public class HttpSessionConfig {
    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        return connection;
    }
}
