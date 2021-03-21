package com.pzh.portal.module.service;


import com.pzh.portal.module.domain.Commodity;

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
     * @param cartId
     * @param itemId
     */
    void oneMore(long cartId, long itemId);

    /**
     * -1
     * @param cartId
     * @param itemId
     */
    void oneLess(long cartId, long itemId);

    /**
     * 从购物车中移除
     * @param userId
     * @param itemId
     */
    void delItem(long userId, long itemId);
}
