package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.AttributeCombo;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.domain.ProductItem;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/22 17:23
 * @Version 1.0
 */
public interface ProductService {

    List<Product> listForPage();

    /**
     * 根据分类id和产品id列出属性组合
     * @param categoryId
     * @param productId
     * @return
     */
    List<AttributeCombo> listCombo(long categoryId, long productId);

    /**
     * 列出某款商品所有SKU
     * @param productId
     * @return
     */
    List<ProductItem> listSku(long productId);

    void addSku(ProductItem productItem);
}
