package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
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
	@Id @Column(name="news_id")
	// 使用@GenericGenerator定义主键生成器。
	// 该主键生成器名为fk_hilo，使用Hibernate的hilo策略，
	@GenericGenerator(name="fk_hilo" , strategy="hilo")
	// 指定使用fk_hilo主键生成器
	@GeneratedValue(generator="fk_hilo")
	private Integer id;
	// 消息标题
	private String title;
	// 消息内容
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