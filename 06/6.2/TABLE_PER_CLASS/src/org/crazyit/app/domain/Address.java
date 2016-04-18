package org.crazyit.app.domain;

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
public class Address
{
	// 定义代表该Address详细信息的成员变量
	private String detail;
	// 定义代表该Address邮编信息的成员变量
	private String zip;
	// 定义代表该Address国家信息的成员变量
	private String country;

	// 无参数的构造器
	public Address()
	{
	}
	// 初始化全部成员变量的构造器
	public Address(String detail , String zip , String country)
	{
		this.detail = detail;
		this.zip = zip;
		this.country = country;
	}

	// detail的setter和getter方法
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public String getDetail()
	{
		return this.detail;
	}

	// zip的setter和getter方法
	public void setZip(String zip)
	{
		this.zip = zip;
	}
	public String getZip()
	{
		return this.zip;
	}

	// country的setter和getter方法
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getCountry()
	{
		return this.country;
	}
}