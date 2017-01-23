package com.yh.test.application.service;

import java.io.File;

import feign.Client;
import feign.Headers;
import feign.RequestLine;
import feign.form.FormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import feign.Param;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/16.
 */
@FeignClient(name ="yh-test-eureka-service",configuration = {EurekaFile2ServiceClient.FileSupportConfig.class})
public interface EurekaFile2ServiceClient {

//    feign-form
    @RequestMapping(method = RequestMethod.POST, value = "/add/saveFile2")
    File saveFile2(@RequestParam("file") File file);


    @Configuration
    class FileSupportConfig {
        @Bean
        @Scope("prototype")
        public Encoder feignFormEncoder() {
            return new FormEncoder();
        }
    }

}
