package org.crazyit.app.domain;

import java.util.*;
import javax.persistence.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
@Table(name="student_inf")
public class Student
{
	// 代表学生学号的成员变量，将作为标识属性
	@Id @Column(name="student_id")
	private Integer studentNumber;
	// 代表学生姓名的成员变量
	private String name;
	// 该学生的所有选课记录对应的关联实体
	@OneToMany(targetEntity=Enrolment.class
		, mappedBy="student" , cascade=CascadeType.REMOVE)
	private Set<Enrolment> enrolments
		= new HashSet<>();

	// 无参数的构造器
	public Student()
	{
	}
	// 初始化全部成员变量的构造器
	public Student(Integer studentNumber , String name)
	{
		this.studentNumber = studentNumber;
		this.name = name;
	}

	// studentNumber的setter和getter方法
	public void setStudentNumber(Integer studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	public Integer getStudentNumber()
	{
		return this.studentNumber;
	}

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// enrolments的setter和getter方法
	public void setEnrolments(Set<Enrolment> enrolments)
	{
		this.enrolments = enrolments;
	}
	public Set<Enrolment> getEnrolments()
	{
		return this.enrolments;
	}
}