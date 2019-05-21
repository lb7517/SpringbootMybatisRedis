package com.example.demo.dao;

import com.example.demo.entity.Student;
//import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lb on 2019/5/20.
 */

//@Mapper
public interface StudentDao {

    Student getStudentById(int id);

    Boolean insert(Student st);
}
