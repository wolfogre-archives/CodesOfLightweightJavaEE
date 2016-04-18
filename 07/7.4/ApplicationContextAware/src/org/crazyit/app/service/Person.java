package org.crazyit.app.service;

import org.springframework.context.*;
import org.springframework.beans.BeansException;
import java.util.Locale;
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

public class Person implements ApplicationContextAware
{
	// 将BeanFactory容器以成员变量保存
	private ApplicationContext ctx;

	/* Spring容器会检测容器中所有Bean，如果发现某个Bean实现了ApplicationContextAware接口，
	Spring容器会在创建该Bean之后，自动调用该方法，调用该方法时，
	会将容器本身作为参数传给该方法。*/
	public void setApplicationContext(ApplicationContext ctx)
		throws BeansException
	{
		this.ctx = ctx;
	}
	public void sayHi(String name)
	{
		System.out.println(ctx.getMessage("hello" , new String[]{name}
			, Locale.getDefault(Locale.Category.FORMAT)));
	}
}
