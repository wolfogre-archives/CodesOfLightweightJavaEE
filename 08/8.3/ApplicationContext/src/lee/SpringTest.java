package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.core.io.*;

import org.dom4j.io.*;
import org.dom4j.*;
import java.util.*;
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
	public static void main(String[] args) throws Exception
	{
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("beans.xml");
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("classpath:beans.xml");
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("classpath*:beans.xml");
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans*.xml");
//		ApplicationContext ctx = new
//			ClassPathXmlApplicationContext("classpath*:beans*.xml");
//		ApplicationContext ctx = new
//			FileSystemXmlApplicationContext("classpath:beans2.xml");
		System.out.println("----" + ctx);
//		Resource r = ctx.getResource("book.xml");
//		Resource r = ctx.getResource("classpath:book.xml");
//		System.out.println(r.getClass());
//		System.out.println(r.getDescription());
	}
}
