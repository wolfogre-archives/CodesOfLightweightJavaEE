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
public class Chinese implements Person
{
	private Axe axe;
	private String name;
	public void setAxe(Axe axe)
	{
		System.out.println("Spring执行依赖关系注入...");
		this.axe = axe;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void useAxe()
	{
		System.out.println("我是中国人：名字为：" + name
			+ "。正在用斧头" + axe.chop());
	}
}