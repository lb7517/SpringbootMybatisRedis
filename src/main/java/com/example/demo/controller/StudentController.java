package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lb on 2019/5/20.
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    //解析参数方式一
    @RequestMapping("/getStudent")
    public Student getStudentById1(@RequestParam("id") int id){
        log.info("获取用户信息");
        Student st = studentService.getStudentById(id);
        return st;
    }

    //解析参数方式二
    @RequestMapping("/getStudent/{id}")
    public Student getStudentById2(@PathVariable("id") int id){
        Student st = studentService.getStudentById(id);
        return st;
    }

    @RequestMapping("/insert")
    public Boolean insert(Student st){
        Boolean result = studentService.insert(st);
        return result;
    }

}
