package lee;

import javax.sql.DataSource;
import java.sql.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		throws Exception
	{
		// 实例化Spring容器。Spring容器负责实例化Bean
		ApplicationContext ctx =
			new ClassPathXmlApplicationContext("beans.xml");
		// 获取容器中id为dataSource的Bean
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		// 通过DataSource来获取数据库连接
		Connection conn = ds.getConnection();
		// 通过数据库连接获取PreparedStatement
		PreparedStatement pstmt = conn.prepareStatement(
			"insert into news_inf values(null , ? , ?)");
		pstmt.setString(1 , "疯狂Java联盟成立了");
		pstmt.setString(2 , "疯狂Java地址：www.crazyit.org");
		// 执行SQL语句
		pstmt.executeUpdate();
		// 清理资源，回收数据库连接资源。
		if (pstmt != null)pstmt.close();
		if (conn != null)conn.close();
	}
}