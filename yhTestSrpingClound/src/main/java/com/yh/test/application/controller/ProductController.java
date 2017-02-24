package com.yh.test.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.test.application.product.vo.ProductVO;
import com.yh.test.application.service.ProductService;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/12.
 */
@Controller
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list")
    public String list( Model model) {
        model.addAttribute("name","yh");
        return "/product/list";
    }

    @RequestMapping(value = "/listDate")
    @ResponseBody
    public ProductVO listDate() {
        ProductVO vo= productService.find();
        return vo;
    }


}
