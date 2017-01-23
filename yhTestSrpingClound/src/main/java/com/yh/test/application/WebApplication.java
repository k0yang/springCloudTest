package com.yh.test.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/12.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//启用断路器
@EnableHystrix
public class WebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebApplication.class).web(true).run(args);
    }
}
