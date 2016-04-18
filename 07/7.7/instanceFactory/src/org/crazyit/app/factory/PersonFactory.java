package org.crazyit.app.factory;

import org.crazyit.app.service.*;
import org.crazyit.app.service.impl.*;
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
public class PersonFactory
{
	// 获得Person实例的实例工厂方法
	// ethnic参数决定返回哪个Person实现类的实例
	public Person getPerson(String ethnic)
	{
		if (ethnic.equalsIgnoreCase("chin"))
		{
			return new Chinese();
		}
		else
		{
			return new American();
		}
	}
}
