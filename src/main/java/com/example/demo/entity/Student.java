package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by lb on 2019/5/20.
 */
public class Student implements Serializable{
    private static final long serialVersionUID = -8766573186102614526L;  //对象入缓存不需要实现序列化

    private int id;

    private String name;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
