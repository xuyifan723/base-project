package com.xuyifan.basecontroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ComponentScan(basePackages = {"com.xuyifan.basedao.*","com.xuyifan.baseservice.*"
})
@MapperScan("com.xuyifan.basedao.mapper")
public class BaseControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseControllerApplication.class, args);
    }

}
