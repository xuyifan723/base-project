package com.xuyifan.basecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = {"com.xuyifan.basedao.*","com.xuyifan.baseservice.*"
})
public class BaseControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseControllerApplication.class, args);
    }

}
