package org.crazyit.app.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;
import org.hibernate.annotations.CollectionType;
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
	@Id @Column(name="person_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// 标识属性
	private Integer id;
	private String name;
	private int age;
	// 集合属性，保留该对象关联的考试成绩
	@ElementCollection(targetClass=Float.class)
	// 映射保存集合属性的表
	@CollectionTable(name="score_inf", // 指定表名为score_inf
		joinColumns=@JoinColumn(name="person_id" , nullable=false))
	@MapKeyColumn(name="subject_name")
	// 指定Map key的类型为String类型
	@MapKeyClass(String.class)
	// 映射保存Map value的数据列
	@Column(name="mark")
	private Map<String , Float> scores
		= new HashMap<>();

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

	// scores的setter和getter方法
	public void setScores(Map<String , Float> age)
	{
		this.scores = scores;
	}
	public Map<String , Float> getScores()
	{
		return this.scores;
	}
}