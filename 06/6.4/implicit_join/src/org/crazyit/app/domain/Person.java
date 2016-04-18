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
@Table(name = "person_inf")
public class Person
{
	// 定义标识属性
	@Id @Column(name = "person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 定义Person实例的name成员变量
	private String name;
	// 定义Person实例的age成员变量
	private int age;
	// 定义该Person实体关联的MyEvent实体
	@ManyToOne(targetEntity=MyEvent.class)
	@JoinColumn(name = "event_id" , referencedColumnName="event_id")
	private MyEvent myEvent;
	// 定义一个集合属性
	// 集合属性，保留该对象关联的学校
	@ElementCollection(targetClass=String.class)
	@CollectionTable(name="person_email_inf",
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@Column(name="email_detail" , nullable=false)
	private Set<String> emails
		= new HashSet<>();

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

	// myEvent的setter和getter方法
	public void setMyEvent(MyEvent myEvent)
	{
		this.myEvent = myEvent;
	}
	public MyEvent getMyEvent()
	{
		return this.myEvent;
	}

	// emails的setter和getter方法
	public void setEmails(Set<String> emails)
	{
		this.emails = emails;
	}
	public Set<String> getEmails()
	{
		return this.emails;
	}

}