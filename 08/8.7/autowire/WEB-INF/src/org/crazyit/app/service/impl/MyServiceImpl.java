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
public class MyServiceImpl implements MyService
{
	public int validLogin(String username , String pass)
	{
		// 此处只是简单示范，故直接判断用户名、密码是否符合要求
		if ( username.equals("crazyit.org")
			&& pass.equals("leegang") )
		{
			return 99;
		}
		return -1;
	}
}
