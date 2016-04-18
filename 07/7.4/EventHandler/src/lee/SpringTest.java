package lee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.crazyit.app.event.*;
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
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// 创建一个ApplicationEvent对象
		EmailEvent ele = new EmailEvent("test" ,
			"spring_test@163.com" , "this is a test");
		// 发布容器事件
		ctx.publishEvent(ele);
	}
}