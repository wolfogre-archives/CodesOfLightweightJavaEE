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
// 定义一个切面
@Aspect
public class LogAspect
{
	// 匹配org.crazyit.app.service.impl包下所有类的、
	// 所有方法的执行作为切入点
	@AfterReturning(returning="rvt"
		, pointcut="execution(* org.crazyit.app.service.impl.*.*(..))")
	// 声明rvt时指定的类型会限制目标方法必须返回指定类型的值或没有返回值
	// 此处将rvt的类型声明为Object，意味着对目标方法的返回值不加限制
	public void log(Object rvt)
	{
		System.out.println("获取目标方法返回值:" + rvt);
		System.out.println("模拟记录日志功能...");
	}
}
