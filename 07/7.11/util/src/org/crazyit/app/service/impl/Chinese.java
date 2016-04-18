package org.crazyit.app.service.impl;

import java.util.*;
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
public class Chinese implements Person
{
	private Axe axe;
	private int age;
	private List schools;
	private Map scores;
	private Set axes;

	// axe的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// age的setter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	// schools的setter方法
	public void setSchools(List schools)
	{
		this.schools = schools;
	}
	// scores的setter方法
	public void setScores(Map scores)
	{
		this.scores = scores;
	}
	// axes的setter方法
	public void setAxes(Set axes)
	{
		this.axes = axes;
	}
	// 实现Person接口的useAxe()方法
	public void useAxe()
	{
		System.out.println(axe.chop());
		System.out.println("age属性值：" + age);
		System.out.println(schools);
		System.out.println(scores);
		System.out.println(axes);
	}
}