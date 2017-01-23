package com.yh.test.application.controller;

import com.yh.test.application.project.vo.ProductVO;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/16.
 */
@RestController
@RequestMapping("/add")
public class AddController {

    @RequestMapping("/add/{userId}")
    public String add(@PathVariable("userId") long userId){
        return "add"+userId;
    }

    @RequestMapping("/find/{productId}")
    public ProductVO findProduct(@PathVariable("productId") long productId){
        ProductVO vo = new ProductVO();
        vo.setId(String.valueOf(productId));
        vo.setName("product1");
        vo.setSerialNo("serialNo1");
        return vo;
    }

    @RequestMapping("/save")
    public ProductVO save(ProductVO vo){
        vo.setId(String.valueOf(2));
        vo.setName("product2");
        vo.setSerialNo("serialNo2");
        return vo;
    }

    @RequestMapping("/saveFile")
    public File saveFile(@RequestParam("file") MultipartFile file){
        File f = new File("d://2.txt");
        try {
            FileUtils.writeByteArrayToFile(f,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    @RequestMapping("/saveFile2")
    public File saveFile2(@RequestParam("file") File file){
        File f = new File("d://2.txt");
//        try {
//            FileUtils.writeByteArrayToFile(f,file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return f;
    }


    @RequestMapping(value = "/testManyArgus/{s}/{b}/{l}/{i}")
    @ResponseBody
    public String testManyArgus(@PathVariable("s")String s, @PathVariable("b") boolean b, @PathVariable("l")long l, @PathVariable("i")int i){
        System.out.println(" s:"+s+" b:"+b+" l:"+l+" i:"+i);
        return "Hello World! :";
    }

}
