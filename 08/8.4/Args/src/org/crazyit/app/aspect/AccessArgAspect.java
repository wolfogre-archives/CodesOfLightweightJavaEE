package org.crazyit.app.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

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
@Aspect
public class AccessArgAspect
{
	// 下面的args(arg0,arg1)会限制目标方法必须有2个形参
	@AfterReturning(returning="rvt" , pointcut=
		"execution(* org.crazyit.app.service.impl.*.*(..)) && args(arg0,arg1)")
	// 此处指定arg0、arg1为String类型
	// 则args(arg0,arg1)还要求目标方法的两个形参都是String类型
	public void access(Object rvt, String arg0 , String arg1)
	{
		System.out.println("调用目标方法第1个参数为:" + arg0);
		System.out.println("调用目标方法第2个参数为:" + arg1);
		System.out.println("获取目标方法返回值:" + rvt);
		System.out.println("模拟记录日志功能...");
	}
}
