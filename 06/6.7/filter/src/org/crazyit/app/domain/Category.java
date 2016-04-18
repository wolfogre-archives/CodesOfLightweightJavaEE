package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Filter;

import java.util.*;
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
@Table(name="category_inf")
// 对Category实体使用数据过滤
@Filter(name="effectiveDate"
	, condition=":asOfDate BETWEEN eff_start_date and eff_end_date")
public class Category
{
	@Id @Column(name="category_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name="eff_start_date")
	private Date effectiveStartDate;
	@Column(name="eff_end_date")
	private Date effectiveEndDate;
	@ManyToMany(targetEntity=Product.class, mappedBy="categories")
	private Set<Product> products
		= new HashSet<>();

	// 无参数的构造器
	public Category()
	{
	}
	// 初始化全部成员变量的构造器
	public Category(String name , Date effectiveStartDate , Date effectiveEndDate)
	{
		this.name = name;
		this.effectiveStartDate = effectiveStartDate;
		this.effectiveEndDate = effectiveEndDate;
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

	// effectiveStartDate的setter和getter方法
	public void setEffectiveStartDate(Date effectiveStartDate)
	{
		this.effectiveStartDate = effectiveStartDate;
	}
	public Date getEffectiveStartDate()
	{
		return this.effectiveStartDate;
	}

	// effectiveEndDate的setter和getter方法
	public void setEffectiveEndDate(Date effectiveEndDate)
	{
		this.effectiveEndDate = effectiveEndDate;
	}
	public Date getEffectiveEndDate()
	{
		return this.effectiveEndDate;
	}

	// products的setter和getter方法
	public void setProducts(Set<Product> products)
	{
		this.products = products;
	}
	public Set<Product> getProducts()
	{
		return this.products;
	}

	// 判断两个种类是否相等
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if(obj.getClass() == Category.class)
		{
			Category target = (Category)obj;
			return name.equals(target.getName())
				&& effectiveStartDate.equals(target.getEffectiveStartDate())
				&& effectiveEndDate.equals(target.getEffectiveEndDate());
		}
		return false;
	}

	// 生成hashCode的方式以名字的hashCode加上
	// 生效开始日期hashCode，再加生效结束日期的hashCode
	public int hashCode()
	{
		int result;
		result = name.hashCode();
		result = 29 * result + (effectiveStartDate != null ?
			effectiveStartDate.hashCode() : 0);
		result = 29 * result + (effectiveEndDate != null ?
			effectiveEndDate.hashCode() : 0);
		return result;
	}


}