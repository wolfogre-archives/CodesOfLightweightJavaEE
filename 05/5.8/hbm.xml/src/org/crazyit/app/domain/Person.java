package org.crazyit.app.domain;

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
public class Person
{
	// 使用Name组件作为复合主键
	private Name name;
	// 普通属性
	private String email;
	// 组件属性，代表此人拥有的宠物
	private Cat pet;

	// 无参数的构造器
	public Person()
	{
	}
	// 初始化全部成员变量的构造器
	public Person(Name name , String email , Cat pet)
	{
		this.name = name;
		this.email = email;
		this.pet = pet;
	}

	// name的setter和getter方法
	public void setName(Name name)
	{
		this.name = name;
	}
	public Name getName()
	{
		return this.name;
	}

	// email的setter和getter方法
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	// pet的setter和getter方法
	public void setPet(Cat pet)
	{
		this.pet = pet;
	}
	public Cat getPet()
	{
		return this.pet;
	}
}