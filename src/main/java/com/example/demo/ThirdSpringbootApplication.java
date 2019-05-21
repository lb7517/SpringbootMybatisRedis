package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.example.demo.dao")  //扫描dao, 要么在此处加注解，要么在dao里面添加@Maper注解
//@ComponentScan("org.springframework.data.redis.cache")
public class ThirdSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdSpringbootApplication.class, args);
	}

}
