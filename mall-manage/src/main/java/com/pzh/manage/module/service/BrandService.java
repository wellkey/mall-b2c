package com.pzh.manage.module.service;

import com.pzh.manage.module.domain.Brand;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:11
 * @Version 1.0
 */
public interface BrandService {

    List<Brand> list(String name);

    Brand read(long id);

    void add(Brand brand);

    void edit(Brand brand);

    void remove(long id);
}
