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
@Table(name="product_inf")
public class Product
{
	// 定义标识属性
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	private String name;

	// 无参数的构造器
	public Product(){}
	// 初始化全部属性的构造器
	public Product(String name)
	{
		this.name = name;
	}

	// productId的setter和getter方法
	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}
	public Integer getProductId()
	{
		return this.productId;
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
}