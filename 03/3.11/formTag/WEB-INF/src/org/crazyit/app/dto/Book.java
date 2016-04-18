package org.crazyit.app.dto;

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
public class Book
{
	private String name;
	private String author;

	// 无参数的构造器
	public Book()
	{
	}
	// 初始化全部成员变量的构造器
	public Book(String name , String author)
	{
		this.name = name;
		this.author = author;
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

	// author的setter和getter方法
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
	}

}