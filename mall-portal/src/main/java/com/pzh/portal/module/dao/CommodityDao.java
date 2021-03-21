package com.pzh.portal.module.dao;

import com.pzh.portal.module.domain.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/22 17:15
 * @Version 1.0
 */
@Mapper
public interface CommodityDao {

    /**
     * 列出所有商品(分页)
     * @return
     */
    List<Commodity> listForPage();

    /**
     * 列出购物车所有商品
     * @param userId
     * @return
     */
    List<Commodity> listCartItem(long userId);

    /**
     * 加入购物车
     * @param cartId
     * @param itemId
     */
    void toCart(@Param("cartId") long cartId, @Param("itemId") long itemId);

    /**
     * +1
     * @param cartId
     * @param itemId
     */
    void oneMore(@Param("cartId") long cartId, @Param("itemId") long itemId);

    /**
     * -1
     * @param cartId
     * @param itemId
     */
    void oneLess(@Param("cartId") long cartId, @Param("itemId") long itemId);

    /**
     * 从购物车中移除
     * @param cartId
     * @param itemId
     */
    void delItem(@Param("cartId") long cartId, @Param("itemId") long itemId);

    /**
     * 根据userId获取cartId
     * @param userId
     * @return
     */
    long getCartId(long userId);

    /**
     * 获取购物车指定商品数
     * @param cartId
     * @param itemId
     * @return
     */
    Integer getQuantity(@Param("cartId") long cartId, @Param("itemId") long itemId);
}
