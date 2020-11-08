package com.yuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.yuan.mapper")
@ServletComponentScan(basePackages = "com.yuan")
@SpringBootApplication
public class SoulWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoulWebApplication.class, args);
        System.out.println("启动成功！！");
    }
}
