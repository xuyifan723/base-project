package com.xuyifan.basecontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ComponentScan(basePackages = {"com.xuyifan.basedao.*","com.xuyifan.baseservice.*","com.xuyifan.basecontroller.*"
})
@MapperScan("com.xuyifan.basedao.mapper")
@EnableTransactionManagement
public class BaseControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseControllerApplication.class, args);
    }

}
