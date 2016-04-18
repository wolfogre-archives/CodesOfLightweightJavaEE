package org.crazyit.app.domain;

import java.util.Date;
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
	private Integer id;
	private String name;
	private int height;

	public Person()
	{
	}
	// 初始化全部成员变量的构造器
	public Person(Integer id , String name , int height)
	{
		this.id = id;
		this.name = name;
		this.height = height;
	}

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

	// height的setter和getter方法
	public void setHeight(int height)
	{
		this.height = height;
	}
	public int getHeight()
	{
		return this.height;
	}

}