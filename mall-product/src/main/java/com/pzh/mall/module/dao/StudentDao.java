package com.pzh.mall.module.dao;


import com.pzh.mall.module.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:01
 * @Version 1.0
 */
@Mapper
public interface StudentDao {

    int add(Student student);

    int update(Student student);

    int deleteBySno(String sno);

    Student queryStudentBySno(String sno);

    List<Student> queryAllStudents();

    List<Student> listForPage();
}
