package lee;import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;import java.util.*;
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
		// 实例化ApplicationContext
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		// 使用getMessage()方法获取本地化消息。
		// Locale的getDefault方法返回计算机环境的默认Locale
		String hello = ctx.getMessage("hello" , new String[]{"孙悟空"}
			, Locale.getDefault(Locale.Category.FORMAT));
		String now = ctx.getMessage("now" , new Object[]{new Date()}
			, Locale.getDefault(Locale.Category.FORMAT));
		// 打印出两条本地化消息
		System.out.println(hello);
		System.out.println(now);
	}
}