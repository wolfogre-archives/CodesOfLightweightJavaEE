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
@Table(name="person_inf")
public class Person
{
	@Id // 用于修饰标识属性
	// 指定该主键列的主键生成策略
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// @Column指定该属性映射的列信息，此处指定了列名、长度
	@Column(name="person_name" , length=50)
	private String name;
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(nullable=true)
	private byte[] pic;

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

	// pic的setter和getter方法
	public void setPic(byte[] pic)
	{
		this.pic = pic;
	}
	public byte[] getPic()
	{
		return this.pic;
	}
}