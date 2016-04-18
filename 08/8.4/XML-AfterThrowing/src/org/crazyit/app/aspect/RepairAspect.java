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
public class RepairAspect
{
	// 定义一个普通方法作为Advice方法
	// 形参ex用于访问目标方法中抛出的异常
	public void doRecoveryActions(Throwable ex)
	{
		System.out.println("目标方法中抛出的异常:" + ex);
		System.out.println("模拟Advice对异常的修复...");
	}
}


