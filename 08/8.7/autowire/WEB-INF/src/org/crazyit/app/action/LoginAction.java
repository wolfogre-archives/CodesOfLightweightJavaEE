package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;

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
public class LoginAction extends ActionSupport
{
	// 下面是用于封装用户请求参数的两个成员变量
	private String username;
	private String password;
	// 系统所用的业务逻辑组件
	private MyService ms;
	// 设值注入业务逻辑组件所必需的setter方法
	public void setMs(MyService ms)
	{
		this.ms = ms;
	}
	// username的setter和getter方法
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}
	// password的setter和getter方法
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		// 调用业务逻辑组件的validLogin()方法
		// 验证用户输入的用户名和密码是否正确
		if (ms.validLogin(getUsername(), getPassword()) > 0)
		{
			addActionMessage("哈哈，整合成功！");
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}
