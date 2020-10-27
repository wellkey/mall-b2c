package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Brand;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:11
 * @Version 1.0
 */
public interface BrandService {

    List<Brand> list();

    Brand read(long id);

    void add(Brand brand);

    void edit(Brand brand);

    void remove(long id);
}
