package com.vsu.drunker.web.bean.client;

import org.springframework.context.annotation.Bean;

public class FileControllerConfigClient {

    @Bean
    public FileControllerInterceptor fileControllerInterceptor() {
        return new FileControllerInterceptor();
    }
}
