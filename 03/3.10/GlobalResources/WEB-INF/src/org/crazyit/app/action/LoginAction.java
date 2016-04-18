package org.crazyit.app.action;

import com.opensymphony.xwork2.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class LoginAction extends ActionSupport
{
	// 下面定义了两个成员变量，用于封装请求参数
	private String username;
	private String password;

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
		ActionContext ctx = ActionContext.getContext();
		if (getUsername().equals("crazyit.org")
			&& getPassword().equals("leegang"))
		{
			ctx.getSession().put("user" , getUsername());
			// 获取国际化消息
			ctx.put("tip" , getText("succTip"));
			return SUCCESS;
		}
		// 获取国际化消息
		ctx.put("tip" , getText("failTip"));
		return ERROR;
	}
}