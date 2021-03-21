package com.pzh.manage.module.service;

import com.pzh.manage.module.domain.AttributeCombo;
import com.pzh.manage.module.domain.Product;
import com.pzh.manage.module.domain.ProductItem;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/22 17:23
 * @Version 1.0
 */
public interface ProductService {

    /**
     * 列出所有商品
     * @return
     */
    List<Product> listForPage();

    /**
     * 新增商品
     * @param product
     */
    void add(Product product);

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

    /**
     * 新增商品SKU
     * @param productItem
     */
    void addSku(ProductItem productItem);
}
