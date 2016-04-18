package org.crazyit.app.aspect;
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
public aspect LogAspect
{
	// 定义一个PointCut，其名为logPointcut，
	// 该Pointcut代表了后面给出的切入点表达式，这样可复用该切入点表达式
	pointcut logPointcut()
		:execution(* org.crazyit.app.service.*.*(..));
	after():logPointcut()
	{
		System.out.println("模拟记录日志...");
	}
}
