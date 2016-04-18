package lee;

import org.crazyit.app.service.UserService;
import org.crazyit.app.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class SpringTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx =
			new ClassPathXmlApplicationContext("beans.xml");
		UserService us = ctx.getBean("userService" , UserService.class);
		// 调用方法时age参数不小于100，因此不会缓存，
		// 所以下面两次方法调用都会真正执行这些方法。
		User u1 = us.getUsersByNameAndAge("孙悟空", 500);
		User u2 = us.getAnotherUser("孙悟空", 500);
		System.out.println(u1 == u2); // 输出false
		// 调用方法时age参数小于100，因此会缓存，
		// 所以下面第二次方法调用时不会真正执行该方法，而是直接使用缓存数据。
		User u3 = us.getUsersByNameAndAge("孙悟空", 50);
		User u4 = us.getAnotherUser("孙悟空", 50);
		System.out.println(u3 == u4); // 输出true
	}
}
