package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lb on 2019/5/20.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public Student getStudentById(int id) {
        //string 格式存储
        /*String key = "student_"+id;
        String stStr = redisUtil.getStringOpts(key);
        if(stStr != null && !("null".equals(stStr))){
            Student st = JSON.parseObject(stStr, Student.class);
            return st;
        }
        Student st = studentDao.getStudentById(id);
        redisUtil.setStringOpts(key, st, 10);*/


        //hash 格式存储
        String key = "student";
        String smallKey = String.valueOf(id);
        String stStr = redisUtil.getObjectOpts(key, smallKey);
        if(stStr != null && !("null".equals(stStr))){
            Student st = JSON.parseObject(stStr, Student.class);
            return st;
        }
        Student st = studentDao.getStudentById(id);
        redisUtil.putObjectOpts(key, String.valueOf(id), st);


        return st;
    }

    @Override
    public boolean insert(Student st) {
        return studentDao.insert(st);
    }

    //原始
    /*@Override
    public Student getStudentById(int id) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String key = "student_"+id;
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            Student st = (Student)valueOperations.get(key);
            return st;
        }


        Student st = studentDao.getStudentById(id);
        valueOperations.set(key, st, 10, TimeUnit.SECONDS); //设置过期时间10s
//        valueOperations.set(key, st); //没有这只过期时间
        return st;
    }*/
}
