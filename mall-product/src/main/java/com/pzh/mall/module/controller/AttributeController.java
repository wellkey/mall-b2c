package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.AttributeKey;
import com.pzh.mall.module.domain.AttributeValue;
import com.pzh.mall.module.domain.CategoryAttribute;
import com.pzh.mall.module.service.AttributeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/15 16:07
 * @Version 1.0
 */
@Api(tags = "AttributeController", description = "商品属性管理")
@Controller
@RequestMapping("/attribute")
public class AttributeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AttributeController.class);

    @Autowired
    private AttributeService attributeService;

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入品牌管理首页");

        return "attribute";
    }

    @RequestMapping("/listForPage")
    @ResponseBody
    public ResultMsg listForPage(String name, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        LOGGER.info("分页列表 name:" + name + " page:" + page + " limit:" + limit);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<AttributeKey> list = attributeService.list(name);
            PageInfo<AttributeKey> pageInfo = new PageInfo<>(list);
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
            AttributeKey attributeKey = attributeService.read(id);
            resultMsg.setData(attributeKey);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResultMsg add(String name, @RequestParam(defaultValue = "0")long categoryId) {
        LOGGER.info("属性key新增 name:" + name + " categoryId:" + categoryId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            attributeService.add(name, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResultMsg edit(@RequestParam(defaultValue = "0")long id, String name, @RequestParam(defaultValue = "0")long categoryId) {
        LOGGER.info("属性key修改 id:" + id + " name:" + name + " categoryId:" + categoryId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            attributeService.edit(id, name, categoryId);
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
            attributeService.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/getCategoryAttribute")
    @ResponseBody
    public ResultMsg getCategoryAttribute(@RequestParam(defaultValue = "0")long attributeId, @RequestParam(defaultValue = "0")long categoryId) {
        LOGGER.info("attributeId:" + attributeId + " categoryId:" + categoryId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            String str = attributeService.getCategoryStr(categoryId);
            AttributeKey attributeKey = attributeService.read(attributeId);
            CategoryAttribute ca = new CategoryAttribute();
            ca.setCategoryStr(str);
            ca.setAttributeName(attributeKey.getName());
            ca.setCategoryId(attributeKey.getCategoryId());
            resultMsg.setData(ca);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/saveOrUpdateValues")
    @ResponseBody
    public ResultMsg saveOrUpdateValues(long attributeId, String values) {
        LOGGER.info("attributeId:" + attributeId + " values:" + values);
        ResultMsg resultMsg = new ResultMsg();
        try {
            if (values != null && values.length() > 0) {
                attributeService.saveOrUpdateValues(attributeId, values);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/readValues/{attributeId}")
    @ResponseBody
    public ResultMsg readValues(@PathVariable long attributeId) {
        LOGGER.info("attributeId:" + attributeId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<AttributeValue> valueList = attributeService.readValues(attributeId);
            String valueStr = "";
            if (valueList != null && valueList.size() > 0) {
                for (AttributeValue value : valueList) {
                    valueStr += value.getAttributeValue() + ",";
                }
                valueStr = valueStr.substring(0, valueStr.length() - 1);
            }
            resultMsg.setData(valueStr);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
