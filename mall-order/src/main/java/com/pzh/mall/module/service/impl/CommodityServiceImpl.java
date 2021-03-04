package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.CommodityDao;
import com.pzh.mall.module.domain.Commodity;
import com.pzh.mall.module.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        commodityDao.toCart(cartId, itemId);
    }


    @Override
    public void oneMore(long itemId) {
        commodityDao.oneMore(itemId);
    }

    @Override
    public void oneLess(long itemId) {
        commodityDao.oneLess(itemId);
    }

    @Transactional
    @Override
    public void delItem(long userId, long itemId) {
        long cartId = commodityDao.getCartId(userId);
        commodityDao.delItem(cartId, itemId);
    }

}
