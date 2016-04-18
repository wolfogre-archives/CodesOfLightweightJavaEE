package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
@Entity
// 指定使用每个具体类对应一张表的映射策略
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="person_inf")
public class Person
{
	// 标识属性
	@Id @Column(name="person_id")
	// 由于不能使用identity主键生成策略，故此处采用hilo主键生成策略
	@GenericGenerator(name="person_hilo" , strategy="hilo")
	@GeneratedValue(generator="person_hilo")
	private Integer id;
	private String name;
	private char gender;
	// 定义该Person实体的组件属性：address
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="detail",
		column=@Column(name="address_detail")),
		@AttributeOverride(name="zip",
		column=@Column(name="address_zip")),
		@AttributeOverride(name="country",
		column=@Column(name="address_country"))
	})
	private Address address;
	// 无参数的构造器
	public Person(){}
	// 初始化全部成员变量的构造器
	public Person(Integer id , String name , char gender)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
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

	// gender的setter和getter方法
	public void setGender(char gender)
	{
		this.gender = gender;
	}
	public char getGender()
	{
		return this.gender;
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