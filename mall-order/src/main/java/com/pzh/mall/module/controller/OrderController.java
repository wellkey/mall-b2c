package com.pzh.mall.module.controller;

import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.CartItem;
import com.pzh.mall.module.domain.Order;
import com.pzh.mall.module.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 9:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/myOrder")
public class OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    // 存储订单商品项
    private static final List<Map<Long, Integer>> itemList = new ArrayList<>();

    @Autowired
    private OrderService orderService;

    @RequestMapping("/index/{itemIds}")
    public String index(Model model, @PathVariable String itemIds) {
        LOGGER.info("进入订单确认 itemIds:" + itemIds);

        List<String> itemIdList = new ArrayList<>();
        String[] itemIdArr = itemIds.split(",");
        if (itemIdArr != null && itemIdArr.length > 0) {
            for (String id : itemIdArr) {
                itemIdList.add(id);
            }
        }
        BigDecimal amount = orderService.getAmount(1002, itemIdList);
        model.addAttribute("itemIds", itemIds);
        model.addAttribute("amount", amount);
        return "order";
    }

    @RequestMapping("/orderList")
    public String orderList(Model model) {
        LOGGER.info("进入订单列表");

        return "orderList";
    }


    @RequestMapping("/listItem")
    @ResponseBody
    public ResultMsg listItem(String itemIds) {
        LOGGER.info("购买商品列表 itemIds:" + itemIds);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<String> itemIdList = new ArrayList<>();
            String[] itemIdArr = itemIds.split(",");
            if (itemIdArr != null && itemIdArr.length > 0) {
                for (String id : itemIdArr) {
                    itemIdList.add(id);
                }
            }

            // 存储之前清空
            itemList.clear();
            // 存储订单商品
            List<CartItem> list = orderService.listItem(1002, itemIdList);
            for (CartItem cartItem : list) {
                long itemId = cartItem.getItemId();
                int num = cartItem.getQuantity();
                Map<Long, Integer> map = new HashMap<>();
                map.put(itemId, num);
                itemList.add(map);
            }

            resultMsg.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/generateOrder")
    @ResponseBody
    public ResultMsg generateOrder(BigDecimal payment, int postType, String userNote) {
        LOGGER.info("提交订单 payment:" + payment + " postType:" + postType + " userNote:" + userNote);
        ResultMsg resultMsg = new ResultMsg();
        try {
            BigDecimal postFee = new BigDecimal(0);
            if (postType == 1) {
                LOGGER.info("免邮");
            }

            orderService.saveOrder(payment, postFee, 1002, userNote, itemList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/listOrderByStatus")
    @ResponseBody
    public ResultMsg listOrderByStatus(int status) {
        LOGGER.info("根据订单状态列出所有订单 status:" + status);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<Order> orderList = orderService.listOrderByStatus(1002, status);
            resultMsg.setData(orderList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }

    @RequestMapping("/showDetail/{orderId}")
    @ResponseBody
    public ResultMsg showDetail(@PathVariable long orderId) {
        LOGGER.info("根据订单id查看商品详情 orderId:" + orderId);
        ResultMsg resultMsg = new ResultMsg();
        try {
            List<CartItem> cartItemList = orderService.showDetail(orderId);
            resultMsg.setData(cartItemList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMsg.setCode(-1);
            resultMsg.setMsg("请求失败");
        }

        return resultMsg;
    }
}
