package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Commodity;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/3 11:02
 * @Version 1.0
 */
public interface CommodityService {

    List<Commodity> listForPage();

    /**
     * 列出购物车所有商品
     * @param userId
     * @return
     */
    List<Commodity> listCartItem(long userId);

    /**
     * 加入购物车
     * @param userId
     * @param itemId
     */
    void toCart(long userId, long itemId);

    /**
     * +1
     * @param itemId
     */
    void oneMore(long itemId);

    /**
     * -1
     * @param itemId
     */
    void oneLess(long itemId);

    /**
     * 从购物车中移除
     * @param userId
     * @param itemId
     */
    void delItem(long userId, long itemId);
}
