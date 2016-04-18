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
// 定义命名SQL查询
@NamedNativeQueries({
// 定义一个命名SQL查询，其名称为simpleQuery
@NamedNativeQuery(name="simpleQuery"
	// 指定命名SQL查询对应的SQL语句
	, query="select s.student_id , s.name from student_inf s"
	// 指定将查询结果转换为Student实体
	, resultClass=Student.class),
// 定义一个命名SQL查询，其名称为queryTest
@NamedNativeQuery(name="queryTest"
	// 定义SQL语句
	, query="select s.*,e.*,c.* from student_inf s,enrolment_inf e,"
	+ " course_inf c where s.student_id = e.student_id and"
	+ " e.course_code = c.course_code and e.year=:targetYear"
	// 指定使用名为firstMapping的@SqlResultSetMapping完成结果映射
	, resultSetMapping = "firstMapping"),
// 定义一个调用存储过程的命名SQL查询
@NamedNativeQuery(name="callProcedure"
	, query="{call select_all_student()}"
	, resultSetMapping = "secondMapping")
})
@SqlResultSetMappings({
@SqlResultSetMapping(name="firstMapping"
	, entities={@EntityResult(entityClass=Student.class),
		@EntityResult(entityClass=Enrolment.class),
		@EntityResult(entityClass=Course.class , fields=
		{
			@FieldResult(name="courseCode" , column="c.course_code"),
			@FieldResult(name="name" , column="c.name")
		})
	}
	, columns={@ColumnResult(name="s.name" , type=String.class)}
),
@SqlResultSetMapping(name="secondMapping"
	, entities={@EntityResult(entityClass=Student.class , fields=
		{
			@FieldResult(name="studentNumber" , column="student_id"),
			@FieldResult(name="name" , column="name")
		})
	})
})
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