package com.wei.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by Administrator on 2020/1/7 0007.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dept_Consumer_DashBoard_App {

    public static void main(String[] args) {
        SpringApplication.run(Dept_Consumer_DashBoard_App.class,args);
    }
}
