package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;

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
public class BeanTest
{
	public static void main(String[] args)
	{
		// 创建Spring容器
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		Hello hello = ctx.getBean("hello" , Hello.class);
		hello.foo();
		System.out.println("addUser()的返回值为："
			+ hello.addUser("孙悟空" , "7788"));
		World world = ctx.getBean("world" , World.class);
		world.bar();
	}
}