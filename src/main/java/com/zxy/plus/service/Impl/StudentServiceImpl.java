package com.zxy.plus.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxy.plus.dao.StudentMapper;
import com.zxy.plus.entity.Student;
import com.zxy.plus.service.StudentService;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService{



}
