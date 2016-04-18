package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Parent;
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
@Embeddable
public class Name
{
	// 定义first成员变量
	@Column(name="person_firstname")
	private String first;
	// 定义last成员变量
	@Column(name="person_lastname")
	private String last;
	// 引用拥有该Name的Person对象
	@Parent      // ①
	private Person owner;

	// 无参数的构造器
	public Name()
	{
	}
	// 初始化全部成员变量的构造器
	public Name(String first , String last)
	{
		this.first = first;
		this.last = last;
	}

	// first的setter和getter方法
	public void setFirst(String first)
	{
		this.first = first;
	}
	public String getFirst()
	{
		return this.first;
	}

	// last的setter和getter方法
	public void setLast(String last)
	{
		this.last = last;
	}
	public String getLast()
	{
		return this.last;
	}

	// owner的setter和getter方法
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

}