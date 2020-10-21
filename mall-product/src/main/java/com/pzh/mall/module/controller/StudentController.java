package com.pzh.mall.module.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pzh.mall.module.domain.Student;
import com.pzh.mall.module.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/4 20:28
 * @Version 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping( value = "/queryStudentBySno", method = RequestMethod.GET)
    @ResponseBody
    public Student queryStudentBySno(String sno) {
        LOGGER.info("根据学号查询学生 sno:" + sno);
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping( value = "/listForPage", method = RequestMethod.GET)
    @ResponseBody
    public List<Student> listForPage(int pageNum, int pageSize) {
        LOGGER.info("分页列表 pageNum:" + pageNum + " pageSize:" + pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<Student> list = studentService.queryAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo.getList();
    }
}
