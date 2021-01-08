package com.vsu.drunker.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.vsu.drunker"})
@EnableFeignClients(basePackages = "com.vsu.drunker.web.bean.client")
@EntityScan("com.vsu.drunker.db.model.entity")
@EnableJpaRepositories("com.vsu.drunker.db.model.repository")
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
