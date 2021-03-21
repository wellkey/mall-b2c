package com.pzh.portal.module.service.impl;

import com.pzh.portal.module.dao.CommodityDao;
import com.pzh.portal.module.domain.Commodity;
import com.pzh.portal.module.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/3 11:02
 * @Version 1.0
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public List<Commodity> listForPage() {
        return commodityDao.listForPage();
    }

    @Override
    public List<Commodity> listCartItem(long userId) {
        return commodityDao.listCartItem(userId);
    }

    @Override
    public void toCart(long userId, long itemId) {
        long cartId = commodityDao.getCartId(userId);
        Integer tmp = commodityDao.getQuantity(cartId, itemId);
        int quantity = tmp == null ? 0 : tmp;
        if (quantity < 1) {
            commodityDao.toCart(cartId, itemId);
        } else {
            commodityDao.oneMore(cartId, itemId);
        }
    }


    @Override
    public void oneMore(long userId, long itemId) {
        long cartId = commodityDao.getCartId(userId);
        commodityDao.oneMore(cartId, itemId);
    }

    @Override
    public void oneLess(long userId, long itemId) {
        long cartId = commodityDao.getCartId(userId);
        Integer tmp = commodityDao.getQuantity(cartId, itemId);
        int quantity = tmp == null ? 0 : tmp;
        if (quantity > 1) {
            commodityDao.oneLess(cartId, itemId);
        }
    }

    @Override
    public void delItem(long userId, long itemId) {
        long cartId = commodityDao.getCartId(userId);
        commodityDao.delItem(cartId, itemId);
    }

}
