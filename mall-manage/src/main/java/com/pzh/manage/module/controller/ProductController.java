package com.pzh.manage.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.manage.common.ResultMsg;
import com.pzh.manage.module.domain.AttributeCombo;
import com.pzh.manage.module.domain.Product;
import com.pzh.manage.module.domain.ProductItem;
import com.pzh.manage.module.service.ProductService;
import com.pzh.manage.util.FileUtil;
import com.pzh.manage.util.PropertiesUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入商品管理首页");

        model.addAttribute("callUrl", "");
        return "product";
    }

    @RequestMapping("/sku")
    public String sku(Model model, long categoryId, long productId) {
        LOGGER.info("进入商品sku页 categoryId:" + categoryId + " productId:" + productId);
        List<AttributeCombo> comboList = productService.listCombo(categoryId, productId);
        model.addAttribute("comboList", comboList);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("productId", productId);

        return "sku";
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

    @RequestMapping("/add")
    @ResponseBody
    public ResultMsg add(Product product) {
        LOGGER.info("新增商品 product:" + product);
        ResultMsg resultMsg = new ResultMsg();
        try {
            productService.add(product);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/listSku")
    @ResponseBody
    public ResultMsg listSku(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "5") int limit, @RequestParam long productId) {
        LOGGER.info("列出某款商品所有SKU productId:" + productId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<ProductItem> list = productService.listSku(productId);
            PageInfo<ProductItem> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
            resultMsg.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/addSku")
    @ResponseBody
    public ResultMsg addSku(ProductItem productItem) {
        LOGGER.info("新增SKU productItem:" + productItem);
        ResultMsg resultMsg = new ResultMsg();
        try {
            productService.addSku(productItem);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/listCombo")
    @ResponseBody
    public ResultMsg listCombo(@RequestParam long categoryId, @RequestParam long productId) {
        LOGGER.info("listCombo categoryId:" + categoryId + " productId:" + productId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<AttributeCombo> comboList = productService.listCombo(categoryId, productId);
            resultMsg.setData(comboList);
            resultMsg.setCount((long) comboList.size());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }


    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(HttpServletRequest request) {
        LOGGER.info("上传图片");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/plain;charset=utf-8");
        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multiRequest.getFile("file");

        Map<String, Object> map = new HashMap<>();
        String baseUrl = PropertiesUtil.getPro("product.base_url");
//        String fileUrl = PropertiesUtil.getPro("product.image_url") + "/img";
        String fileUrl = "/img";
        // 上传
        try {
            ResultMsg resultMsg = FileUtil.uploadFile(file, baseUrl, fileUrl);
            if (resultMsg.getCode() != 0) {
                map.put("code", 1);
                map.put("msg", "图片上传失败");
                map.put("data", "");
                return map;
            }

            String path = resultMsg.getMsg();
            LOGGER.info("图片存放地址:" + path);
            map.put("code", 0);
            map.put("msg", "图片上传成功");
            map.put("data", path);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            map.put("code", -1);
            map.put("msg", "图片上传失败");
            return map;
        }
    }
}
