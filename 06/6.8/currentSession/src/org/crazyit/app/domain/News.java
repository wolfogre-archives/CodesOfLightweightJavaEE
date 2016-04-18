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
@Table(name="news_inf")
public class News
{
	@Id @Column(name="news_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String content;

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