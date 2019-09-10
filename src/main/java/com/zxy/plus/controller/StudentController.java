package com.zxy.plus.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.plus.entity.Page_zxy;
import com.zxy.plus.entity.Student;
import com.zxy.plus.service.Impl.StudentServiceImpl;
/**
 *  @author: zxy
 *  @Date: 2019-09-05 14:18
 *  @Description: 学生表控制器
 */
@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping("/getStudentList")
    public Object getStudentList(Page_zxy page_zxy){
    	System.out.println(page_zxy.getCurrentPage());
        Page<Student> page = new Page<>(page_zxy.getCurrentPage(),page_zxy.getPageSize());
        IPage<Student>  studentList=  studentService.page(page);
        log.info("===========取出学生信息================"+studentList.getRecords());
         return  studentList;
    }
    @RequestMapping("/getStudentLike")
    public Object getStudentLike(@RequestParam Map<String, Object> json){
//    	JSONObject json = JSONObject.parseObject(request);
    	
    	log.info("===========模糊查询================"+json);
		
		int currentPage = Integer.parseInt((String)json.get("currentPage"));
		int pageSize = Integer.parseInt((String)json.get("pageSize"));
		   QueryWrapper<Student> wrapper = new  QueryWrapper<>();
		  wrapper.like("name",json.get("name")); Page<Student> page = new Page<>(currentPage,pageSize); 
		 return studentService.page(page,wrapper);
    }

    @RequestMapping("/addStudent")
    public  Object addStudent(Student student){
    	log.info("=============新增或者修改================="+student.getName());
        return  studentService.saveOrUpdate(student);
    }
    
    @RequestMapping("/deleteSudent")
    public  Object deleteSudent(Student student){
    	log.info("==========删除====================="+student.getId());
        return  studentService.removeById(student.getId());
    }

}
