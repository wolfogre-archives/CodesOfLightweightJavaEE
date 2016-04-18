package org.crazyit.booksys.domain;

import javax.persistence.*;

/**
 * Description:
 * <br/>利嫋: <a href="http://www.crazyit.org">決髄Java選男</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Entity
@Table(name="book_inf")
public class Book
{
	@Id @Column(name="book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="book_name")
	private String name;
	private double price;
	private String author;
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
}
