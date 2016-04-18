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
{
	// 标识属性
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int age;
	// 定义该Person实体关联的Address实体
	@OneToOne(targetEntity=Address.class)
	// 映射底层连接表，表名为person_address
	@JoinTable(name="person_address",
		// 映射连接表的外键列，增加unique=true表明是1-1关联
		joinColumns=@JoinColumn(name="person_id"
			, referencedColumnName="person_id" , unique=true),
		// 映射连接表的外键列，增加unique=true表明是1-1关联
		inverseJoinColumns=@JoinColumn(name="address_id"
			, referencedColumnName="address_id", unique=true)
	)
	private Address address;

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

	// address的setter和getter方法
	public void setAddress(Address address)
	{
		this.address = address;
	}
	public Address getAddress()
	{
		return this.address;
	}
}