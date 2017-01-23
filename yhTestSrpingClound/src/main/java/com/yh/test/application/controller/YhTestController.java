package com.yh.test.application.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.yh.test.application.service.Eureka2ServiceClient;
import feign.Feign;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.yh.test.application.product.vo.ProductVO;
import com.yh.test.application.service.EurekaFileServiceClient;
import com.yh.test.application.service.EurekaServiceClient;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/12.
 */
@Controller
@RequestMapping(value = "yhTest")
public class YhTestController {

    @Value("${myname}")
    private String myname="123";
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private EurekaServiceClient eurekaServiceClient;
    @Autowired
    private Eureka2ServiceClient eureka2ServiceClient;
    @Autowired
    private EurekaFileServiceClient eurekaFileServiceClient;


    @RequestMapping(value = "/home")
    @ResponseBody
    public String home() {
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" );
        return "Hello World! :" +myname;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add() {
        List<ServiceInstance> si = client.getInstances("yh-test-eureka-service");
        if(CollectionUtils.isEmpty(si)){
            return "";
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resultStr = restTemplate.getForEntity(si.get(0).getUri()+"/add/add/1", String.class);
        System.out.println("resultStr.getBody():"+resultStr.getBody());
        return "Hello World! :" +resultStr.getBody();
    }

    @RequestMapping(value = "/add2")
    @ResponseBody
    public String add2() {
        String result = eurekaServiceClient.add(2l);
        System.out.println("result:"+result);
        return "Hello World! :" +result;
    }

    @RequestMapping(value = "/findProduct")
    @ResponseBody
    public String findProduct() {
        ProductVO pvo = eurekaServiceClient.findProduct(1);
        System.out.println("result:"+pvo.getId());
        System.out.println("result:"+pvo.getName());
        System.out.println("result:"+pvo.getSerialNo());
        return "Hello World! :" +pvo.getName();
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public String svae() {
        ProductVO pvo = eurekaServiceClient.save(new ProductVO());
        System.out.println("result:"+pvo.getId());
        System.out.println("result:"+pvo.getName());
        System.out.println("result:"+pvo.getSerialNo());
        return "Hello World! :" +pvo.getName();
    }

    @RequestMapping(value = "/save2")
    @ResponseBody
    public String svae2() {
        ProductVO pvo = eureka2ServiceClient.save(new ProductVO());
        System.out.println("result:"+pvo.getId());
        System.out.println("result:"+pvo.getName());
        System.out.println("result:"+pvo.getSerialNo());
        return "Hello World! :" +pvo.getName();
    }


    @RequestMapping(value = "/saveFile")
    @ResponseBody
    public String saveFile(MultipartFile file){
        File f = eurekaFileServiceClient.saveFile(file);
        System.out.println("result:"+f.getName());
        System.out.println("result:"+f.getAbsolutePath());
        return "Hello World! :" +f.getName();
    }

    @RequestMapping(value = "/saveFile2")
    @ResponseBody
    public String saveFile2() throws IOException {
        File f = eurekaServiceClient.saveFile2(new File("d://1.txt"));
        System.out.println("result:"+f.getName());
        System.out.println("result:"+f.getAbsolutePath());
        return "Hello World! :" +f.getName();
    }


    @RequestMapping("/testManyArgus")
    @ResponseBody
    public String testManyArgus(){
        eurekaServiceClient.testManyArgus("s",false,1l,1);
        return "5678";
    }

}
