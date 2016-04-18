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
public class SpringTest
{
	public static void main(String[] args)
	{
		// 以类加载路径下的beans.xml作为配置文件，创建Spring容器
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		Person p1 = ctx.getBean("chinese" , Person.class);
		Person p2 = ctx.getBean("chinese" , Person.class);
		// 由于chinese Bean是singleton行为，
		// 因此程序两次获取的chinese Bean是同一个实例。
		System.out.println(p1 == p2);
		p1.hunt();
		p2.hunt();
	}
}