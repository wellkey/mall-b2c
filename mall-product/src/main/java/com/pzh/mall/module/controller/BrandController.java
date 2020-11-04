package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Brand;
import com.pzh.mall.module.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/15 16:08
 * @Version 1.0
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入品牌管理首页");

        return "brand";
    }

    @RequestMapping("/listForPage")
    @ResponseBody
    public ResultMsg listForPage(String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        LOGGER.info("分页列表 name:" + name + " page:" + page + " limit:" + limit);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<Brand> list = brandService.list(name);
            PageInfo<Brand> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
            resultMsg.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/read/{id}")
    @ResponseBody
    public ResultMsg read(@PathVariable long id) {
        LOGGER.info("id:" + id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            Brand brand = brandService.read(id);
            resultMsg.setData(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultMsg add(Brand brand) {
        LOGGER.info("brand:" + brand);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResultMsg edit(Brand brand) {
        LOGGER.info("Brand:" + brand);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.edit(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public ResultMsg remove(@PathVariable long id) {
        LOGGER.info("id:" + id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
