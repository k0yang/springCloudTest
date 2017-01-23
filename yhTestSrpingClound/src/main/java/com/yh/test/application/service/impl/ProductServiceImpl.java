package com.yh.test.application.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yh.test.application.product.vo.ProductVO;
import com.yh.test.application.service.EurekaServiceClient;
import com.yh.test.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/22.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private EurekaServiceClient eurekaServiceClient;

    @HystrixCommand(fallbackMethod = "findFail")
    public ProductVO find() {
        if(1 ==1){
//            throw new RuntimeException("test error");
        }
        return eurekaServiceClient.findProduct(1);
    }

    private ProductVO findFail(){
        return new ProductVO();
    }

}
