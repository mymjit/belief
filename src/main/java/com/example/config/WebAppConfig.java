package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author   : while
 * @date     : 2017/11/7
 * @describe : 对静态资源进行映射
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebAppConfig.class);

    @Value("${fileUploadPath}")
    private String fileUploadPath;

    /**
     *@param    : [registry]
     *@method   : addResourceHandlers
     *@return   : void
     *@describe : 访问 /images/text.ipg  映射成 file:D:/file/text.jpg  配置文件 :  .yml -> fileUploadPath
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations(fileUploadPath);
        super.addResourceHandlers(registry);
    }

}
