package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

import org.crazyit.app.domain.*;
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
	// Action类里包含一个不带泛型的List类型的成员变量
	private List users;

	// users的setter和getter方法
	public void setUsers(List users)
	{
		this.users = users;
	}
	public List getUsers()
	{
		return this.users;
	}

	public String execute() throws Exception
	{
		// 在控制台输出Struts 2封装产生的List对象
		System.out.println(getUsers());
		// 因为没有使用泛型，所以要进行强制类型转换
		User firstUser = (User)getUsers().get(0);
		// users属性的第一个User实例来决定控制逻辑
		if (firstUser.getName().equals("crazyit.org")
			&& firstUser.getPass().equals("leegang") )
		{
			addActionMessage("登录成功！");
			return SUCCESS;
		}
		addActionMessage("登录失败！！");
		return ERROR;
	}
}