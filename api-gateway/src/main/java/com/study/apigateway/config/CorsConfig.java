package com.study.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author XuYang
 * @description: 跨域配置
 * @date 2019/7/10  17:14
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 是否支持cookie跨域
        config.setAllowedOrigins(Collections.singletonList("*")); //http://www.a.com
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setAllowedMethods(Collections.singletonList("GET,POST,PUT,DELETE"));
        config.setMaxAge(30L); // 30秒内对相同的请求不再重复检查
        source.registerCorsConfiguration("/**", config); // 对哪些域名做配置
        return new CorsFilter(source);
    }

}
