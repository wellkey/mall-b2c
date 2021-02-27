package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.AttributeDao;
import com.pzh.mall.module.dao.CategoryDao;
import com.pzh.mall.module.domain.AttributeKey;
import com.pzh.mall.module.domain.AttributeValue;
import com.pzh.mall.module.domain.Category;
import com.pzh.mall.module.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<AttributeKey> list(String name) {
        return attributeDao.list(name);
    }

    @Override
    public AttributeKey read(long id) {
        return attributeDao.read(id);
    }

    @Override
    public void add(String name, long categoryId) {
        attributeDao.add(name, categoryId);
    }

    @Override
    public void edit(long id, String name, long categoryId) {
        attributeDao.edit(id, name, categoryId);
    }

    @Override
    public void remove(long id) {
        attributeDao.remove(id);
    }

    @Override
    public String getCategoryStr(Long categoryId) {
        List<String> strList = new ArrayList<>();
        Category c1 = categoryDao.read(categoryId);
        if (c1 != null) {
            strList.add(c1.getName());
            int l1 = c1.getLevel();
            long p1 = c1.getParId();
            if (l1 == 3) {
                Category c2 = categoryDao.read(p1);
                if (c2 != null) {
                    strList.add(0, c2.getName());
                    int l2 = c2.getLevel();
                    long p2 = c2.getParId();
                    if (l2 == 2) {
                        Category c3 = categoryDao.read(p2);
                        if (c3 != null) {
                            strList.add(0, c3.getName());
                        }
                    }
                }
            } else if (l1 == 2) {
                Category c4 = categoryDao.read(p1);
                if (c4 != null) {
                    strList.add(0, c4.getName());
                }
            }
        }

        return String.join("-", strList);
    }

    @Transactional
    @Override
    public void saveOrUpdateValues(long attributeId, String values) {
        attributeDao.removeValues(attributeId);
        // 插入新数据
        String[] strs = values.split(",");
        if (strs.length > 0) {
            for (String str : strs) {
                attributeDao.saveOrUpdateValues(attributeId, str);
            }
        }
    }

    @Override
    public List<AttributeValue> readValues(long attributeId) {
        List<AttributeValue> valueList = attributeDao.readValues(attributeId);
        return valueList;
    }


}
