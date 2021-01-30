package com.vpn.website.common.configure;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 使用CORS，用于解决ajax跨域访问问题
 */
@Configuration
public class GlobalCorsConfig {

    // 设置允许跨域的源
    private static String[] originsVal = new String[]{
            "127.0.0.1:8888",
            "localhost:8888",
            "127.0.0.1:8899",
            "localhost:8899",
    };

    @Bean
    public FilterRegistrationBean corsFilter() {
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        //config.addAllowedOrigin("http://manage.leyou.com");
        // config.addAllowedOrigin("http://localhost:8989");

        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedHeader("*");
        config.setAllowedMethods(Arrays.asList("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS"));;
      //  config.addAllowedOrigin("*");
        config.setMaxAge(3600L);
        this.addAllowedOrigins(config);

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
 
        //3.返回新的CorsFilter.
//        return new CorsFilter(configSource);
 
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(configSource));
        bean.setFilter(new LoginFilter());
        bean.setOrder(0);
        return bean;
    }

    private void addAllowedOrigins(CorsConfiguration corsConfiguration) {
        for (String origin : originsVal) {
            corsConfiguration.addAllowedOrigin("http://" + origin);
            corsConfiguration.addAllowedOrigin("https://" + origin);
        }
    }
}