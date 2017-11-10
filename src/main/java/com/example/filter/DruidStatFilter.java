package com.example.filter;


import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 * @Author : while
 * @Date : 2017/10/18
 * @Describe :druid过滤器.对图片文件等类型过滤
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                // 忽略资源
                @WebInitParam(name = "exclusions", value = "*.map,*.woff2," +
                        "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        }
)
public class DruidStatFilter extends WebStatFilter {
}
