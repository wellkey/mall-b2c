package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.Commodity;
import com.pzh.mall.module.service.CommodityService;
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
 * @Date 2021/3/3 11:04
 * @Version 1.0
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityService commodityService;

    @RequestMapping("/index")
    public String index(Model model) {
        LOGGER.info("进入商品首页");

        model.addAttribute("callUrl", "");
        return "commodity";
    }
    
    
    @RequestMapping("/listForPage")
    @ResponseBody
    public ResultMsg listForPage(@RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10") int limit) {
        LOGGER.info("分页列表 page:" + page + " limit:" + limit);
        ResultMsg resultMsg = new ResultMsg();
        try {
            PageHelper.startPage(page, limit);
            List<Commodity> list = commodityService.listForPage();
            PageInfo<Commodity> pageInfo = new PageInfo<>(list);
            resultMsg.setData(pageInfo.getList());
            resultMsg.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/listCartItem")
    @ResponseBody
    public ResultMsg listCartItem() {
        LOGGER.info("列出购物车所有商品");
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<Commodity> itemList = commodityService.listCartItem(1002);
            resultMsg.setData(itemList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/toCart/{itemId}")
    @ResponseBody
    public ResultMsg toCart(@PathVariable long itemId) {
        LOGGER.info("加入购物车 id:" + itemId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            commodityService.toCart(1002, itemId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/oneMore/{itemId}")
    @ResponseBody
    public ResultMsg oneMore(@PathVariable long itemId) {
        LOGGER.info("商品 " + itemId + " +1");
        ResultMsg resultMsg = new ResultMsg();
        try {
            commodityService.oneMore(1002, itemId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/oneLess/{itemId}")
    @ResponseBody
    public ResultMsg oneLess(@PathVariable long itemId) {
        LOGGER.info("商品 " + itemId + " -1");
        ResultMsg resultMsg = new ResultMsg();
        try {
            commodityService.oneLess(1002, itemId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/delItem")
    @ResponseBody
    public ResultMsg delItem(long itemId) {
        LOGGER.info("从购物车中移除商品 itemId:" + itemId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            commodityService.delItem(1002, itemId);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
