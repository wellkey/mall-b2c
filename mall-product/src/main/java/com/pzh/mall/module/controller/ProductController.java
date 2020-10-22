package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.service.ProductService;
import com.pzh.mall.module.service.StudentService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping( value = "/listForPage", method = RequestMethod.GET)
    @ResponseBody
    public ResultMsg listForPage(int pageNum, int pageSize) {
        LOGGER.info("分页列表 pageNum:" + pageNum + " pageSize:" + pageSize);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Product> list = productService.listForPage();
            PageInfo<Product> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }
}
