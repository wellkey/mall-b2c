package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.AttributeKey;
import com.pzh.mall.module.domain.AttributeValue;
import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.domain.ProductItem;
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
public interface ProductDao {

    List<Product> listForPage();

    void add(Product product);

    List<AttributeKey> listAttrKey(@Param("categoryId") long categoryId);

    List<AttributeValue> listAttrValuesByKey(@Param("productId") long productId, @Param("attributeId") long attributeId);

    List<ProductItem> listSku(@Param("productId") long productId);

    String readValueName(@Param("id") long id);

    void addSku(ProductItem productItem);
}
