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
public aspect TxAspect
{
	//  指定执行Hello.sayHello()方法时执行下面代码块
	Object around():call(* org.crazyit.app.service.*.*(..))
	{
		System.out.println("模拟开启事务...");
		// 回调原来的目标方法
		Object rvt = proceed();
		System.out.println("模拟结束事务...");
		return rvt;
	}
}