package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.baizhi.dao")
@ServletComponentScan("com.baizhi.filter")
public class CmfzApp {
    public static void main(String[] args) {
        SpringApplication.run(com.baizhi.CmfzApp.class, args);
    }
}
