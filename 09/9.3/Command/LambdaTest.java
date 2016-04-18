

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
public class LambdaTest
{
	public static void main(String[] args)
	{
		ProcessArray pa = new ProcessArray();
		int[] target = {3, -4, 6, 4};
		// 第一次处理数组，具体处理行为取决于Lambda表达式
		pa.each(target , array -> {
			for (int tmp : array )
			{
				System.out.println("迭代输出目标数组的元素:" + tmp);
			}
		});
		System.out.println("------------------");
		// 第二次处理数组，具体处理行为取决于Lambda表达式
		pa.each(target , array -> {
			int sum = 0;
			for (int tmp : array )
			{
				sum += tmp;
			}
			System.out.println("数组元素的总和是:" + sum);
		});
	}
}
