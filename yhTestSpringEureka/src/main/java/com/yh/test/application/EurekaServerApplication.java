package com.yh.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/13.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String args[]){
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }

}
