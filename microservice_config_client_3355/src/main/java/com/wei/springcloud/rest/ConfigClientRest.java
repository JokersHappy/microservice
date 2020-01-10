package com.wei.springcloud.rest;

/**
 * Created by Administrator on 2020/1/10 0010.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @Value("${server.port}")
    private String port;


    @RequestMapping("/config")
    public String getConfig(){
        String s = "applicationName : " + applicationName + " eurekaServer:" + eurekaServer;
        System.out.println(s);
        return s;
    }


}
