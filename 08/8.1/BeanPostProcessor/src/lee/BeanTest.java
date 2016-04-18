package lee;

import org.springframework.core.io.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.crazyit.app.service.*;
import org.crazyit.app.util.*;
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
	public static void main(String[] args)throws Exception
	{
		// 以类加载路径下的beans.xml文件来创建Spring容器
//		ApplicationContext ctx = new
//			ClassPathXmlApplicationContext("beans.xml");
//		Person p = (Person)ctx.getBean("chinese");

		// 搜索类加载路径下的beans.xml文件创建Resource对象
		Resource isr = new ClassPathResource("beans.xml");
		// 创建默认的BeanFactory容器
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 让默认的BeanFactory容器加载isr对应的XML配置文件
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions(isr);
		// 获取容器中的Bean后处理器
		BeanPostProcessor bp = (BeanPostProcessor)beanFactory.getBean("bp");
		// 注册Bean后处理器
		beanFactory.addBeanPostProcessor(bp);
		Person p = (Person)beanFactory.getBean("chinese");

		p.useAxe();
	}
}