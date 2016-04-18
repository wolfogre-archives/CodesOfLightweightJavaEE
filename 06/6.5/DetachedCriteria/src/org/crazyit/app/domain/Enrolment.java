package org.crazyit.app.domain;

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
@Table(name="enrolment_inf")
public class Enrolment

{
	// 定义标识属性
	@Id @Column(name="enrolment_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer enrolmentId;
	// 定义选课记录所属的学年
	private int year;
	
// 定义选课记录所属的学期
	private int semester;
	// 定义选课记录关联的学生实体
	@ManyToOne(targetEntity=Student.class)
	@JoinColumn(name="student_id")
	private Student student;
	// 定义选课记录关联的课程实体
	@ManyToOne(targetEntity=Course.class)
	@JoinColumn(name="course_code")
	private Course course;

	// enrolmentId的setter和getter方法
	public void setEnrolmentId(Integer enrolmentId)
	{
		this.enrolmentId = enrolmentId;
	}
	public Integer getEnrolmentId()
	{
		return this.enrolmentId;
	}

	// year的setter和getter方法
	public void setYear(int year)
	{
		this.year = year;
	}
	public int getYear()
	{
		return this.year;
	}

	// semester的setter和getter方法
	public void setSemester(int semester)
	{
		this.semester = semester;
	}
	public int getSemester()
	{
		return this.semester;
	}

	// student的setter和getter方法
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public Student getStudent()
	{
		return this.student;
	}

	// course的setter和getter方法
	public void setCourse(Course course)
	{
		this.course = course;
	}
	public Course getCourse()
	{
		return this.course;
	}
}