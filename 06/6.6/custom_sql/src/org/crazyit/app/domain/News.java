package org.crazyit.app.domain;

import javax.persistence.*;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Loader;
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
// 定制insert的SQL语句
@SQLInsert(sql="insert into news_inf(content , title) values(upper(?), ?)")
// 定制update的SQL语句
@SQLUpdate(sql="update news_inf set content=upper(?), title=? where news_id=?")
// 定制delete的SQL语句
@SQLDelete(sql="delete from news_inf where news_id=?")
// 定制删除所有实体的SQL语句
@SQLDeleteAll(sql="delete from news_inf")
// 指定使用news_loader命名查询作为定制查询的查询语句
@Loader(namedQuery = "news_loader")
// 定义一个命名SQL查询
@NamedNativeQuery(name="news_loader"
	, query="select news_id , concat('===' , concat(title , '===')) as title"
		+ " , content from news_inf n where news_id=?"
	, resultClass = News.class)
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