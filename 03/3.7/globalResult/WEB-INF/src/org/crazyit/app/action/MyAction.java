package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
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

public class MyAction extends ActionSupport
{
	// 封装请求参数的target成员变量
	private String target;

	// target的setter和getter方法
	public void setTarget(String target)
	{
		this.target = target;
	}
	public String getTarget()
	{
		return this.target;
	}

	public String execute()
		throws Exception
	{
		addActionMessage("恭喜您,您已经成功转向");
		return SUCCESS;
	}
}