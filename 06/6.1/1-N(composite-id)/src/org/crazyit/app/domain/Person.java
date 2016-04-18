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
@Table(name="person_inf")
public class Person
	implements java.io.Serializable
{
	// 定义first成员变量，作为标识属性的成员
	@Id
	private String first;
	// 定义last成员变量，作为标识属性的成员
	@Id
	private String last;
	private int age;
	// 记录该Person实体关联的所有Address实体
	@OneToMany(targetEntity=Address.class, mappedBy="person"
		, cascade=CascadeType.ALL)
	private Set<Address> addresses
		= new HashSet<>();

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

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// addresses的setter和getter方法
	public void setAddresses(Set<Address> addresses)
	{
		this.addresses = addresses;
	}
	public Set<Address> getAddresses()
	{
		return this.addresses;
	}

	// 重写equals()方法，根据first、last进行判断
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Person.class)
		{
			Person target = (Person)obj;
			return target.getFirst().equals(this.first)
				&& target.getLast().equals(this.last);
		}
		return false;
	}

	// 重写hashCode()方法，根据first、last计算hashCode值
	public int hashCode()
	{
		return getFirst().hashCode() * 31
			+ getLast().hashCode();
	}
}