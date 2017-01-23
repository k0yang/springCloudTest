package com.yh.test.application.service;

import java.io.File;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import feign.Param;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/16.
 */
@FeignClient(name ="yh-test-eureka-service" )
public interface EurekaFileServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/add/saveFile",headers = {"Content-Type=multipart/form-data"})
    File saveFile(@Param("file") MultipartFile file);

}
