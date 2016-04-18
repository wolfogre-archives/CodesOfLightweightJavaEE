package org.crazyit.app.service.impl;

import org.crazyit.app.service.UserService;
import org.crazyit.app.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

/**
 * Description: <br/>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a> <br/>
 * Copyright (C), 2001-2014, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Service("userService")
@Cacheable(value = "users")
public class UserServiceImpl implements UserService
{
	public User getUsersByNameAndAge(String name, int age)
	{
		System.out.println("--正在执行findUsersByNameAndAge()查询方法--");
		return new User(name, age);
	}
	public User getAnotherUser(String name, int age)
	{
		System.out.println("--正在执行findAnotherUser()查询方法--");
		return new User(name, age);
	}
	// 指定根据name、age参数清除缓存
	@CacheEvict(value = "users")
	public void evictUser(String name, int age)
	{
		System.out.println("--正在清空"+ name
			+ " , " + age + "对应的缓存--");
	}
	// 指定清除user缓存区所有缓存数据
	@CacheEvict(value = "users" , allEntries=true)
	public void evictAll()
	{
		System.out.println("--正在清空整个缓存--");
	}
}