package com.xuyifan.projectinit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xuyifan.projectinit.*"})
@MapperScan("com.xuyifan.projectinit.mapper")
@EnableTransactionManagement
public class ProjectinitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectinitApplication.class, args);
    }

}
