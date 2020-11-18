package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.AttributeDao;
import com.pzh.mall.module.dao.CategoryDao;
import com.pzh.mall.module.domain.Attribute;
import com.pzh.mall.module.domain.AttributeValue;
import com.pzh.mall.module.domain.Category;
import com.pzh.mall.module.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:12
 * @Version 1.0
 */
@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeDao attributeDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Attribute> list(String name) {
        return attributeDao.list(name);
    }

    @Override
    public Attribute read(long id) {
        return attributeDao.read(id);
    }

    @Override
    public void add(Attribute attribute) {
        attributeDao.add(attribute);
    }

    @Override
    public void edit(Attribute attribute) {
        attributeDao.edit(attribute);
    }

    @Override
    public void remove(long id) {
        attributeDao.remove(id);
    }

    @Override
    public String getCategoryStr(Long categoryId) {
        String categoryStr = "";
        Category c1 = categoryDao.read(categoryId);
        if (c1 != null) {
            categoryStr += c1.getName();
            int l1 = c1.getLevel();
            long p1 = c1.getParId();
            if (l1 == 3) {
                Category c2 = categoryDao.read(p1);
                if (c2 != null) {
                    categoryStr += "-" + c2.getName();
                    int l2 = c1.getLevel();
                    long p2 = c1.getParId();
                    if (l2 == 2) {
                        Category c3 = categoryDao.read(p2);
                        if (c3 != null) {
                            categoryStr += "-" + c3.getName();
                        }
                    }
                }
            } else if (l1 == 2) {
                Category c4 = categoryDao.read(p1);
                if (c4 != null) {
                    categoryStr += "-" + c4.getName();
                }
            }
        }

        return categoryStr;
    }

    @Override
    public AttributeValue saveOrUpdateValues(AttributeValue value) {
        return attributeDao.saveOrUpdateValues(value);
    }

    @Override
    public List<AttributeValue> readValues(long attributeId) {
        List<AttributeValue> valueList = attributeDao.readValues(attributeId);
        return valueList;
    }


}
