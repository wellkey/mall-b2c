package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.service.ProductService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/15 16:02
 * @Version 1.0
 */
@Api(tags = "ProductController", description = "商品管理")
@Controller
@RequestMapping("/pro1")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入商品管理首页");

        return "product";
    }

    @RequestMapping("/productAdd")
    public String productAdd(Model model) {
        LOGGER.info("进入商品录入页");

        return "product_add";
    }

    @RequestMapping("/listForPage")
    @ResponseBody
    public ResultMsg listForPage(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10") int limit) {
        LOGGER.info("分页列表 page:" + page + " limit:" + limit);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<Product> list = productService.listForPage();
            PageInfo<Product> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
            resultMsg.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
