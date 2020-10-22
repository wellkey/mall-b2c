package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Product;
import com.pzh.mall.module.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

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
}
