package com.zxy.plus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.plus.dao.StudentMapper;
import com.zxy.plus.entity.Student;
import com.zxy.plus.service.Impl.StudentServiceImpl;
import com.zxy.plus.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusApplicationTests {
    @Autowired
    private StudentService service;
    @Test
    public void contextLoads() {
        Student student = new Student();
        student.setName("郑晓宇啊");
        student.setSex("1");
        student.setAge("20");
        Student student1 = new Student();
        student1.setName("郑晓宇22");
        student1.setSex("1");
        student1.setAge("20");
        Student student2 = new Student();
        student2.setName("郑晓宇33");
        student2.setSex("1");
        student2.setAge("20");
        Student student3 = new Student();
        student3.setName("郑晓宇44");
        student3.setSex("1");
        student3.setAge("20");
        List<Student> list = new ArrayList<>();
        service.save(student1);
        service.save(student2);
        service.save(student3);

    }



}
