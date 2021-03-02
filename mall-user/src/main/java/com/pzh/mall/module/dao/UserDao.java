package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/1 16:50
 * @Version 1.0
 */
@Mapper
public interface UserDao {
    User findByUserName(String userName);

    /**
     * 列出所有用户
     * @return
     */
    List<User> list();

    /**
     * 新增用户
     * @param userName
     * @param password
     * @param icon
     * @param email
     * @param nickName
     */
    void add(@RequestParam String userName, @RequestParam String password, @RequestParam String icon, @RequestParam String email, @RequestParam String nickName);

    /**
     * 删除用户
     * @param id
     */
    void delete(long id);
}
