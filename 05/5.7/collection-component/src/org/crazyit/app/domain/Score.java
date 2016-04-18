package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Parent;
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
@Embeddable
public class Score
{
	// 定义first成员变量
	@Column(name="score_level")
	private String level;
	// 定义last成员变量
	@Column(name="score_mark")
	private Integer mark;
	// 引用拥有该Name的Person对象
	@Parent
	private Person owner;

	// 无参数的构造器
	public Score()
	{
	}
	// 初始化全部成员变量的构造器
	public Score(String level , Integer mark)
	{
		this.level = level;
		this.mark = mark;
	}

	// level的setter和getter方法
	public void setLevel(String level)
	{
		this.level = level;
	}
	public String getLevel()
	{
		return this.level;
	}

	// mark的setter和getter方法
	public void setMark(Integer mark)
	{
		this.mark = mark;
	}
	public Integer getMark()
	{
		return this.mark;
	}

	// owner的setter和getter方法
	public void setOwner(Person owner)
	{
		this.owner = owner;
	}
	public Person getOwner()
	{
		return this.owner;
	}

}