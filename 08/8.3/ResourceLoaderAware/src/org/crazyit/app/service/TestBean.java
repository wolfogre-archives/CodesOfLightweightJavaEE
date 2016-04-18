package org.crazyit.app.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

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
public class TestBean implements ResourceLoaderAware
{
	private ResourceLoader rd;
	// 实现ResourceLoaderAware接口必须实现的方法
	// 如果把该Bean部署在Spring容器中，该方法将会由Spring容器负责调用
	// Spring容器调用该方法时，Spring会将自身作为参数传给该方法
	public void setResourceLoader(ResourceLoader resourceLoader)
	{
		this.rd = resourceLoader;
	}
	// 返回ResourceLoader对象的引用
	public ResourceLoader getResourceLoader()
	{
		return rd;
	}
}