package com.zxy.plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxy.plus.entity.Student;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentService extends IService<Student> {
}
