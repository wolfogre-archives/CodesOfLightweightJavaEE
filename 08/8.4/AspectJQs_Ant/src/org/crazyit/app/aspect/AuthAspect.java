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
public aspect AuthAspect
{
	// 指定在执行org.crazyit.app.service包中任意类的、任意方法之前执行下面代码块
	// 第一个星号表示返回值不限；第二个星号表示类名不限；
	// 第三个星号表示方法名不限；圆括号中..代表任意个数、类型不限的形参
	before(): execution(* org.crazyit.app.service.*.*(..))
	{
		System.out.println("模拟进行权限检查...");
	}
}
