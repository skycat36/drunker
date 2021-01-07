package com.vsu.drunker.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.vsu.drunker.web"})
@EnableFeignClients(basePackages = "com.vsu.drunker.web.bean.client")
@EntityScan("com.vsu.drunker.db.model.entity")
@ComponentScan(basePackages = {"com.vsu.drunker.web.bean"})
@EnableJpaRepositories("com.vsu.drunker.db.model.repository")
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
