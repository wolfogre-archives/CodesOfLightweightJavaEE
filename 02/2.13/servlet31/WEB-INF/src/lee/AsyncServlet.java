package lee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/async",asyncSupported=true)
public class AsyncServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println("<title>非阻塞IO示例</title>");
		out.println("进入Servlet的时间："
			+ new java.util.Date() + ".<br/>");
		// 创建AsyncContext，开始异步调用
		AsyncContext context = request.startAsync();
		// 设置异步调用的超时时长
		context.setTimeout(60 * 1000);
		ServletInputStream input = request.getInputStream();
		// 为输入流注册监听器
		input.setReadListener(new MyReadListener(input, context));
		out.println("结束Servlet的时间："
			+ new java.util.Date() + ".<br/>");
		out.flush();
	}
}