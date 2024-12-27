package com.score.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication // SpringBoot启动类注解
@MapperScan("com.score.boot.dao") // MyBatis的接口扫描包
@EntityScan("com.score.boot.model.pojo") // 实体类扫描包（如果需要）
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
