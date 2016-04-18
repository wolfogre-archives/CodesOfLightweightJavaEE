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
		// 第一次调用us对象的方法时会执行该方法，并缓存方法的结果
		User u1 = us.getUsersByNameAndAge("孙悟空", 500);
		// 第二次调用us对象的方法时直接利用缓存的数据，并不真正执行该方法
		User u2 = us.getAnotherUser("孙悟空", 500);
		System.out.println(u1 == u2); // 输出true
	}
}
