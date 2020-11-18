package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.CategoryDao;
import com.pzh.mall.module.domain.Category;
import com.pzh.mall.module.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/28 14:53
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> list(int level, long parId) {
        return categoryDao.list(level, parId);
    }

    @Override
    public Category read(long id) {
        return categoryDao.read(id);
    }

    @Override
    public void add(Category category) {
        categoryDao.add(category);
    }

    @Override
    public void edit(Category category) {
        categoryDao.edit(category);
    }

    @Override
    public void remove(long id) {
        categoryDao.remove(id);
    }
}
