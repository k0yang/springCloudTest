package com.yh.test.application.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.netflix.hystrix.HystrixCommand;
import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.*;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yh.test.application.product.vo.ProductVO;

import feign.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/16.
 */
@FeignClient(name ="yh-test-eureka-service")
public interface EurekaServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add/add/{userId}")
    String add(@PathVariable("userId") long userId);

    @RequestMapping(method = RequestMethod.GET, value = "/add/find/{productId}")
    ProductVO findProduct(@PathVariable("productId") long productId);

    @RequestMapping(method = RequestMethod.POST, value = "/add/save",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
    ProductVO save( @Param("productVO") ProductVO vo);

    @RequestMapping(method = RequestMethod.GET, value = "/add/testManyArgus/{s}/{b}/{l}/{i}")
    void testManyArgus(@PathVariable("s")String s,@PathVariable("b") boolean b, @PathVariable("l")long l, @PathVariable("i")int i);

    @RequestMapping(method = RequestMethod.POST, value = "/add/saveFile2")
    File saveFile2(@RequestParam("file") File file);

}
