package org.crazyit.hrsystem.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
@Table(name="attend_type_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class AttendType
	implements Serializable
{
	private static final long serialVersionUID = 48L;
	// 标识属性
	@Id @Column(name="type_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 出勤类型的名称
	@Column(name="type_name", nullable=false , length=50)
	private String name;
	// 此类出勤对应的罚款
	@Column(name="amerce_amount", nullable=false)
	private double amerce;

	// 无参数的构造器
	public AttendType()
	{
	}
	// 初始化全部成员变量的构造器
	public AttendType(Integer id , String name , double amerce)
	{
		this.id = id;
		this.name = name;
		this.amerce = amerce;
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

	// amerce的setter和getter方法
	public void setAmerce(double amerce)
	{
		this.amerce = amerce;
	}
	public double getAmerce()
	{
		return this.amerce;
	}
}