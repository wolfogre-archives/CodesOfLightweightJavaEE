package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;

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
	public static void main(String[] args)throws Exception
	{
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// 下面2行代码获取的FactoryBean的产品
		System.out.println(ctx.getBean("north"));
		System.out.println(ctx.getBean("theValue"));
		// 下面代码可获取的FactoryBean本身
		System.out.println(ctx.getBean("&theValue"));
	}
}