package com.pzh.manage.module.service.impl;

import com.pzh.manage.module.dao.CategoryDao;
import com.pzh.manage.module.domain.Category;
import com.pzh.manage.module.service.CategoryService;
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
    public List<Category> list(int level, long parId, String name) {
        return categoryDao.list(level, parId, name);
    }

    @Override
    public Category read(long id) {
        return categoryDao.read(id);
    }

    @Override
    public void add(String name, long parId, int level, String unit) {
        categoryDao.add(name, parId, level, unit);
    }

    @Override
    public void edit(long id, String name, long parId, int level, String unit) {
        categoryDao.edit(id, name, parId, level, unit);
    }

    @Override
    public void remove(long id) {
        categoryDao.remove(id);
    }
}
