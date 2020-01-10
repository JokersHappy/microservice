package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2020/1/10 0010.
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudAppConfig_3344 {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppConfig_3344.class,args);
    }
}
