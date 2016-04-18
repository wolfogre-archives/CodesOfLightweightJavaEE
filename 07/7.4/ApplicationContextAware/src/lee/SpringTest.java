package lee;

import java.io.*;
import org.springframework.context.*;
import org.springframework.context.support.*;

import org.crazyit.app.service.*;
/**
 * Description:
 * <br/>ÍøÕ¾: <a href="http://www.crazyit.org">·è¿ñJavaÁªÃË</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class SpringTest
{
	public static void main(String[] args)throws Exception
	{
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		Person p = ctx.getBean("person" , Person.class);
		p.sayHi("ËïÎò¿Õ");
	}
}