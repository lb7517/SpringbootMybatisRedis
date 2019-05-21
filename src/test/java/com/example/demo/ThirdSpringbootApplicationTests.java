package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThirdSpringbootApplicationTests {

	@Autowired
	StudentService studentService;

	@Test
	public void contextLoads() {
		Student st = studentService.getStudentById(1);
		System.out.println("测试结果 st:"+st);
	}

}
