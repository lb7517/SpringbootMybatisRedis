package com.example.demo.service;

import com.example.demo.entity.Student;

/**
 * Created by lb on 2019/5/20.
 */
public interface StudentService {

    Student getStudentById(int id);

    boolean insert(Student st);
}
