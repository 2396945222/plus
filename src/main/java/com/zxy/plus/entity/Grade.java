package com.zxy.plus.entity;

import java.io.Serializable;
import java.sql.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Grade Description: 年级bean
 * 
 * @author zxy
 * @date 2019年9月8日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_grade")
public class Grade extends Model<Grade> {
	private static final long serialVersionUID = 1L;
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	@TableField(value = "name")
	private String name;
	@TableField(value = "createDate")
	private Date createDate;
	@TableField(value = "updateTime")
	private Date updateTime;
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
