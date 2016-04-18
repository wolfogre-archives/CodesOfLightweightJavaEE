package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
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
public abstract class Chinese implements Person
{
	private Dog dog;
	// 定义抽象方法，该方法用于获取被依赖Bean
	public abstract Dog getDog();
	public void hunt()
	{
		System.out.println("我带着：" + getDog() + "出去打猎");
		System.out.println(getDog().run());
	}
}
