package com.pzh.portal.module.service;


import com.pzh.portal.module.domain.CartItem;
import com.pzh.portal.module.domain.Order;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/5 10:00
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 列出所有结算商品
     * @param userId
     * @param itemIdList
     * @return
     */
    List<CartItem> listItem(long userId, List<String> itemIdList);

    /**
     * 计算结算金额
     * @param userId
     * @param itemIdList
     * @return
     */
    BigDecimal getAmount(long userId, List<String> itemIdList);

    /**
     * 保存订单
     * @param id
     * @param payment
     * @param postFee
     * @param userId
     * @param userNote
     * @param itemList
     */
    void saveOrder(long id, BigDecimal payment, BigDecimal postFee, long userId, String userNote, List<Map<Long, Integer>> itemList);

    /**
     * 根据订单状态列出所有订单
     * @param status
     * @return
     */
    List<Order> listOrderByStatus(long userId, int status);

    /**
     * 查看订单商品详情
     * @param orderId
     * @return
     */
    List<CartItem> showDetail(long orderId);
}
