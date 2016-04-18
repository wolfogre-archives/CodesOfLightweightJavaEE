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
@Table(name="address_inf")
public class Address
{
	// 标识属性
	@Id @Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	// 定义代表地址详细信息的成员变量
	private String addressDetail;
	// 记录该Address实体关联的Person实体
	@ManyToOne(targetEntity=Person.class)
	// 使用@JoinColumns包含多个@JoinColumn定义外键列
	@JoinColumns({
		// 由于主表使用了复合主键（有多个主键列）
		// 因此需要使用多个@JoinColumn定义外键列来参照person_inf表的多个主键列
		@JoinColumn(name="person_first"
			, referencedColumnName="first" , nullable=false),
		@JoinColumn(name="person_last"
			, referencedColumnName="last" , nullable=false)
	})
	private Person person;
	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}

	// addressId的setter和getter方法
	public void setAddressId(int addressId)
	{
		this.addressId = addressId;
	}
	public int getAddressId()
	{
		return this.addressId;
	}

	// addressDetail的setter和getter方法
	public void setAddressDetail(String addressDetail)
	{
		this.addressDetail = addressDetail;
	}
	public String getAddressDetail()
	{
		return this.addressDetail;
	}

	// person的setter和getter方法
	public void setPerson(Person person)
	{
		this.person = person;
	}
	public Person getPerson()
	{
		return this.person;
	}
}