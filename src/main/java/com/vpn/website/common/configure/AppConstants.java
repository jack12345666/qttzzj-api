package com.vpn.website.common.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 接口配置
 */
@Data
@Configuration
public class AppConstants {
    //是否测试
    @Value("${app.fortest}")
    private boolean fortest;

    @Value("${app.filepath}")
    private String filepath;

    @Value("${app.fileMax}")
    private Integer fileMax;
}
