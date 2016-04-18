package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.Filters;


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
@FilterDefs({
// 定义名为effectiveDate的过滤器，该过滤器支持1个date类型的参数
@FilterDef(name="effectiveDate"
	, parameters={@ParamDef(name="asOfDate" , type="date")}),
// 定义名为category的过滤器，该过滤器支持1个int类型的参数
@FilterDef(name="category"
	, parameters={@ParamDef(name="catId" , type="int")})
})
@Entity
@Table(name="product_inf")
// 使用effectiveDate过滤器对Product实体使用数据过滤
@Filter(name="effectiveDate"
	, condition=":asOfDate BETWEEN eff_start_date AND eff_end_date")

public class Product
{
	@Id @Column(name="product_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 定义产品名
	@Column(name="product_name")
	private String name;
	// 定义股票号属性，该属性可标识该产品
	@Column(name="stock_number")
	private int stockNumber;
	// 定义生效开始的时间
	@Column(name="eff_start_date")
	private Date effectiveStartDate;
	// 定义失效时间
	@Column(name="eff_end_date")
	private Date effectiveEndDate;
	// 定义该产品所属的种类
	@ManyToMany(targetEntity=Category.class)
	@JoinTable(name="product_category"
		, joinColumns=@JoinColumn(name="product_id")
		, inverseJoinColumns=@JoinColumn(name="category_id"))
	// 对该关联实体的抓取使用effectiveDate、category进行数据过滤
	@Filters({
		@Filter(name="effectiveDate"
			, condition=":asOfDate BETWEEN eff_start_date and eff_end_date"),
		@Filter(name="category"
			, condition="category_id = :catId")
	})
	private Set<Category> categories
		= new HashSet<>();

	// 无参数的构造器
	public Product()
	{
	}
	// 初始化全部成员变量的构造器
	public Product(String name , int stockNumber
		, Date effectiveStartDate , Date effectiveEndDate)
	{
		this.name = name;
		this.stockNumber = stockNumber;
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

	// stockNumber的setter和getter方法
	public void setStockNumber(int stockNumber)
	{
		this.stockNumber = stockNumber;
	}
	public int getStockNumber()
	{
		return this.stockNumber;
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

	// categories的setter和getter方法
	public void setCategories(Set<Category> categories)
	{
		this.categories = categories;
	}
	public Set<Category> getCategories()
	{
		return this.categories;
	}

	// 根据stockNumber来重写hashCode()方法
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == Product.class)
		{
			Product target = (Product)obj;
			return target.getStockNumber() == stockNumber;
		}
		return false;
	}

	// 根据stockNumber来重写hashCode()方法
	public int hashCode()
	{
		return stockNumber;
	}

	// 为产品添加一个所属的种类
	public void addCategory(Category category)
	{
		if ( category == null )
		{
			return;
		}
		this.categories.add(category);
		category.getProducts().add(this);
	}
}