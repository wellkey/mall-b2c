package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.ProductDao;
import com.pzh.mall.module.domain.*;
import com.pzh.mall.module.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/22 17:24
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> listForPage() {
        return productDao.listForPage();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }


    @Override
    public List<AttributeCombo> listCombo(long categoryId, long productId) {
        List<AttributeCombo> comboList = new ArrayList<>();

        LOGGER.info("列出所有key categoryId:" + categoryId);
        List<Attribute> attributeList = productDao.listAttrKey(categoryId);
        if (attributeList != null && attributeList.size() > 0) {
            for (Attribute attr : attributeList) {
                AttributeCombo combo = new AttributeCombo();
                combo.setAttributeKeyId(attr.getId());
                combo.setAttributeKeyValue(attr.getName());

                long attrId = attr.getId();
                LOGGER.info("列出所有key对应的value productId:" + productId + " attrId:" + attrId);
                List<AttributeValue> valueList = productDao.listAttrValuesByKey(productId, attrId);
                combo.setValueList(valueList);

                comboList.add(combo);
            }
        }

        return comboList;
    }


    @Override
    public List<ProductItem> listSku(long productId) {
        List<ProductItem> itemList = productDao.listSku(productId);
        if (itemList != null && itemList.size() > 0) {
            for (ProductItem item : itemList) {
                String[] ss = item.getProductSpecs().split(",");
                String specs = "";
                for (String s : ss) {
                    specs += " " + productDao.readValueName(Long.parseLong(s));
                }
                item.setProductSpecs(specs);
            }
        }
        return itemList;
    }


    @Override
    public void addSku(ProductItem productItem) {
        productDao.addSku(productItem);
    }


}
