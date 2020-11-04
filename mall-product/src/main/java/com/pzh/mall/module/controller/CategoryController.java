package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Category;
import com.pzh.mall.module.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/15 16:05
 * @Version 1.0
 */
@Api(tags = "CategoryController", description = "商品分类管理")
@Controller
@RequestMapping("/category")
public class CategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取分类列表", notes = "获取分类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "第几页", dataType = "Integer", required = true),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "页大小", dataType = "Integer", required = true)
    })
    @GetMapping("/listForPage")
    public ResultMsg listForPage(@RequestParam int pageNum, @RequestParam int pageSize) {
        LOGGER.info("分页列表 pageNum:" + pageNum + " pageSize:" + pageSize);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Category> list = categoryService.list();
            PageInfo<Category> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @ApiOperation(value = "获取分类信息", notes = "根据分类id获取分类信息")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Long")
    @GetMapping("/read/{id}")
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

    @ApiOperation(value = "新增分类信息", notes = "新增分类信息")
    @ApiImplicitParam(name = "category", value = "分类", required = true, dataType = "Category")
    @PostMapping("/add")
    public ResultMsg add(@RequestBody Category category) {
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

    @ApiOperation(value = "修改分类信息", notes = "修改分类信息")
    @ApiImplicitParam(name = "category", value = "分类", required = true, dataType = "Category")
    @PutMapping("/edit")
    public ResultMsg edit(@RequestBody Category category) {
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

    @ApiOperation(value = "删除分类信息", notes = "根据id删除分类信息")
    @ApiImplicitParam(name = "id", value = "分类id", required = true, dataType = "Long")
    @DeleteMapping("/remove/{id}")
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
}
