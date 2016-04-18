package lee;
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
public class Computer
{
	private Output out;
	private String name;

	public Computer(){}

	// out的setter和getter方法
	public void setOut(Output out)
	{
		this.out = out;
	}
	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	// 定义一个模拟获取字符串输入的方法
	public void keyIn(String msg)
	{
		out.getData(msg);
	}
	// 定义一个模拟打印的方法
	public void print()
	{
		System.out.println(name + "开始打印...");
		out.out();
	}
}