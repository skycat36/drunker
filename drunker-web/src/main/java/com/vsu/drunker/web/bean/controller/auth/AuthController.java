package com.vsu.drunker.web.bean.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
