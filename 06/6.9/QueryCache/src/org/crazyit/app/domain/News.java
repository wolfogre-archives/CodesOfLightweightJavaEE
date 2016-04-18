package org.crazyit.app.domain;

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
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Entity
@Table(name="news_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class News
{
	// 消息类的标识属性
	@Id @Column(name="news_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;

	// 无参数的构造器
	public News()
	{
	}
	// 初始化全部成员变量的构造器
	public News(Integer id , String title , String content)
	{
		this.id = id;
		this.title = title;
		this.content = content;
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

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content的setter和getter方法
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}
}