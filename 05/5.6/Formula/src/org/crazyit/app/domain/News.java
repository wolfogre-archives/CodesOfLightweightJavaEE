package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.Formula;
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
	// 消息类的标识属性
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 消息标题
	private String title;
	// 消息内容
	private String content;
	// 消息全部内容，由系统根据公式生成
	@Formula("(select concat(nt.title,nt.content)"
		+ "from news_inf nt where nt.id= id)")
	private String fullContent;

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

	// fullContent的setter和getter方法
	public void setFullContent(String fullContent)
	{
		this.fullContent = fullContent;
	}
	public String getFullContent()
	{
		return this.fullContent;
	}
}