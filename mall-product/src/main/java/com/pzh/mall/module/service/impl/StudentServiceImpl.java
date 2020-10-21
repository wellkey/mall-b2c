package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.StudentDao;
import com.pzh.mall.module.domain.Student;
import com.pzh.mall.module.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:23
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public int add(Student student) {
        return this.studentDao.add(student);
    }

    @Transactional
    @Override
    public int update(Student student) {
        return this.studentDao.update(student);
    }

    @Transactional
    @Override
    public int deleteBySno(String sno) {
        return this.studentDao.deleteBySno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentDao.queryStudentBySno(sno);
    }

    @Override
    public List<Student> queryAllStudents() {
        return this.studentDao.queryAllStudents();
    }
}
