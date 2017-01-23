package com.yh.test.application.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yh.test.application.product.vo.ProductVO;

import feign.Param;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/16.
 */
@FeignClient(name ="yh-test-eureka-service")
public interface Eureka2ServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/add/save",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    ProductVO save(@Param("productVO") ProductVO vo);


}
