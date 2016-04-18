package org.crazyit.app.service.impl;

import org.springframework.stereotype.*;

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
@Component
public class Chinese
	implements Person
{
	private Axe axe;
	// axe的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// 实现Person接口的useAxe()方法
	public void useAxe()
	{
		System.out.println(axe.chop());
	}
}