package org.crazyit.app.event;

import org.springframework.context.ApplicationEvent;
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
public class EmailEvent extends ApplicationEvent
{
	private String address;
	private String text;

	public EmailEvent(Object source)
	{
		super(source);
	}
	// 初始化全部成员变量的构造器
	public EmailEvent(Object source , String address , String text)
	{
		super(source);
		this.address = address;
		this.text = text;
	}

	// address的setter和getter方法
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAddress()
	{
		return this.address;
	}

	// text的setter和getter方法
	public void setText(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return this.text;
	}
}