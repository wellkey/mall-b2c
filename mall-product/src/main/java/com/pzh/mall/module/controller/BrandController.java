package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Brand;
import com.pzh.mall.module.domain.Brand;
import com.pzh.mall.module.service.BrandService;
import com.pzh.mall.module.service.ProductService;
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
 * @Date 2020/7/15 16:08
 * @Version 1.0
 */
@Api(tags = "BrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class BrandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取品牌列表", notes = "获取品牌列表")
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
            List<Brand> list = brandService.list();
            PageInfo<Brand> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }

    @ApiOperation(value = "获取品牌信息", notes = "根据品牌id获取品牌信息")
    @ApiImplicitParam(name = "id", value = "品牌id", required = true, dataType = "Long")
    @GetMapping("/read/{id}")
    public ResultMsg read(@PathVariable long id) {
        LOGGER.info("id:" + id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            Brand brand = brandService.read(id);
            resultMsg.setData(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }

    @ApiOperation(value = "新增品牌信息", notes = "新增品牌信息")
    @ApiImplicitParam(name = "brand", value = "品牌", required = true, dataType = "Brand")
    @PostMapping("/add")
    public ResultMsg add(@RequestBody Brand brand) {
        LOGGER.info("Brand:" + brand);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }

    @ApiOperation(value = "修改品牌信息", notes = "修改品牌信息")
    @ApiImplicitParam(name = "brand", value = "品牌", required = true, dataType = "Brand")
    @PutMapping("/edit")
    public ResultMsg edit(@RequestBody Brand brand) {
        LOGGER.info("Brand:" + brand);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.edit(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }

    @ApiOperation(value = "删除品牌信息", notes = "根据id删除品牌信息")
    @ApiImplicitParam(name = "id", value = "品牌id", required = true, dataType = "Long")
    @DeleteMapping("/remove/{id}")
    public ResultMsg remove(@PathVariable long id) {
        LOGGER.info("id:" + id);
        ResultMsg resultMsg = new ResultMsg();
        try {
            brandService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMessage("请求失败");
        }

        return resultMsg;
    }
}
