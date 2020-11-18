package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Category;
import com.pzh.mall.module.service.CategoryService;
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
 * @Date 2020/7/15 16:05
 * @Version 1.0
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入分类管理首页");

        return "category";
    }

    @RequestMapping("/listForPage")
    @ResponseBody
    public ResultMsg listForPage(@RequestParam int page, @RequestParam int limit) {
        LOGGER.info("分页列表 page:" + page + " limit:" + limit);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<Category> list = categoryService.list(1, 0);
            PageInfo<Category> pageInfo = new PageInfo<>(list);
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
            Category category = categoryService.read(id);
            resultMsg.setData(category);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultMsg add(Category category) {
        LOGGER.info("Category:" + category);
        ResultMsg resultMsg = new ResultMsg();
        try {
            categoryService.add(category);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResultMsg edit(Category category) {
        LOGGER.info("Category:" + category);
        ResultMsg resultMsg = new ResultMsg();
        try {
            categoryService.edit(category);
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
            categoryService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/listByLevel")
    @ResponseBody
    public ResultMsg listByLevel(@RequestParam int level, @RequestParam long parId) {
        LOGGER.info("根据层级列出所有分类 level:" + level + " parId:" + parId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<Category> list = categoryService.list(level, parId);
            resultMsg.setData(list);
            resultMsg.setCount((long) list.size());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
