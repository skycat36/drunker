package com.vsu.drunker.web.bean.client;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FileControllerInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("authorization", "auth-file");
    }
}
