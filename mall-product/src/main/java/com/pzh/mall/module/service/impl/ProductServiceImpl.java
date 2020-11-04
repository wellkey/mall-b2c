package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.ProductDao;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/22 17:24
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> listForPage() {
        return productDao.listForPage();
    }
}
