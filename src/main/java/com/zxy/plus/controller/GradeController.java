package com.zxy.plus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zxy.plus.entity.Grade;
import com.zxy.plus.entity.Page_zxy;
import com.zxy.plus.service.Impl.GradeServiceImpl;

/**
 * GradeController Description: 年级控制器
 * 
 * @author zxy
 * @date 2019年9月8日
 */
@RestController
@RequestMapping("/Grade")
public class GradeController {
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private GradeServiceImpl gradeService;

	@RequestMapping("/AddOrUpdateGrade")
	public Object AddOrUpdateGrade(Grade grade) {
		log.info("=========添加或修改===================" + grade.getName());
		return gradeService.saveOrUpdate(grade);
	}

	@RequestMapping("/getGradeList")
	public Object getGradeList(Page_zxy page_zxy) {
		log.info("=========查询年级信息==================="+page_zxy);
		if(page_zxy.getCurrentPage()!=0 && page_zxy.getPageSize()!=0) {
			Page<Grade> page = new Page<Grade>(page_zxy.getCurrentPage(), page_zxy.getPageSize());
			IPage<Grade> iPage = gradeService.page(page);
			return iPage;
		}else {
			return gradeService.list();
		}
		
	}
	@RequestMapping("/DeleteGrade")
	public Object DeleteGrade(Grade grade) {
		log.info("=========删除==================="+grade);
		return gradeService.removeById(grade.getId());
	}
}
