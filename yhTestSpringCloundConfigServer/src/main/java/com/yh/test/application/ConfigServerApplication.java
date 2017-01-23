package com.yh.test.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/12.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String args[]){
        new SpringApplicationBuilder(ConfigServerApplication.class).run(args);
    }
}
