package com.f;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.f.domain")
@MapperScans(@MapperScan("com.f.mapper"))
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
