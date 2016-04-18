package org.crazyit.app.factory;

import java.lang.reflect.*;
import org.springframework.beans.factory.FactoryBean;
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
public class GetFieldFactoryBean implements FactoryBean<Object>
{
	private String targetClass;
	private String targetField;
	// targetClass的setter方法
	public void setTargetClass(String targetClass)
	{
		this.targetClass = targetClass;
	}

	// targetField的setter方法
	public void setTargetField(String targetField)
	{
		this.targetField = targetField;
	}
	// 返回工厂Bean所生产的产品
	public Object getObject() throws Exception
	{
		Class<?> clazz = Class.forName(targetClass);
		Field field = clazz.getField(targetField);
		return field.get(null);
	}
	// 获取工厂Bean所生产的产品的类型
	public Class<? extends Object> getObjectType()
	{
		return Object.class;
	}
	// 返回该工厂Bean所生成的产品是否为单例
	public boolean isSingleton()
	{
		return false;
	}
}