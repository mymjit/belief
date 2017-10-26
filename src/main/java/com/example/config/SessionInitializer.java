package com.example.config;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @Date : 2017/10/26
 * @Author : while
 * @Describe : SpringSession 分布式
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {

    public SessionInitializer(){
        super(HttpSessionConfig.class);
    }
}
