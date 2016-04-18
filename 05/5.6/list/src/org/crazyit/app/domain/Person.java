package org.crazyit.app.domain;

import java.util.List;
import java.util.ArrayList;

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
@Table(name="person_inf")
public class Person
{
	@Id @Column(name="perosn_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// 标识属性
	private Integer id;
	private String name;
	private int age;
	// 集合属性，保留该对象关联的学校
	@ElementCollection(targetClass=String.class)
	// 映射保存集合属性的表
	@CollectionTable(name="school_inf", // 指定表名为school_inf
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	// 指定保存集合元素的列为 school_name
	@Column(name="school_name")
	// 映射集合元素索引的列
	@OrderColumn(name="list_order")
	private List<String> schools
		= new ArrayList<>();

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
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

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// schools的setter和getter方法
	public void setSchools(List<String> schools)
	{
		this.schools = schools;
	}
	public List<String> getSchools()
	{
		return this.schools;
	}
}