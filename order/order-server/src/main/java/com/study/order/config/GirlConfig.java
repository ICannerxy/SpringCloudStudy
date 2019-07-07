package com.study.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @program: SpringCloudStudy
 * @author: XuYang
 * @create: 2019-07-07 09:49
 **/
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "girl")
public class GirlConfig {
    private String name;

    private Integer age;
}
