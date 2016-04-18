package lee;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.*;
import javax.websocket.server.*;

//import util.HTMLFilter;
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
@ServerEndpoint(value = "/websocket/chat")
public class ChatEntpoint
{
	private static final String GUEST_PREFIX = "访客";
	private static final AtomicInteger connectionIds = new AtomicInteger(0);
	// 定义一个集合，用于保存所有接入的WebSocket客户端
	private static final Set<ChatEntpoint> clientSet =
		new CopyOnWriteArraySet<>();
	// 定义一个成员变量，记录WebSocket客户端的聊天昵称
	private final String nickname;
	// 定义一个成员变量，记录与WebSocket之间的会话
	private Session session;
	public ChatEntpoint()
	{
		nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
	}
	// 当客户端连接进来时自动激发该方法
	@OnOpen
	public void start(Session session)
	{
		this.session = session;
		// 将WebSocket客户端会话添加到集合中
		clientSet.add(this);
		String message = String.format("【%s %s】"
			, nickname, "加入了聊天室！");
		// 发送消息
		broadcast(message);
	}
	// 当客户端断开连接时自动激发该方法
	@OnClose
	public void end()
	{
		clientSet.remove(this);
		String message = String.format("【%s %s】"
			, nickname, "离开了聊天室！");
		// 发送消息
		broadcast(message);
	}
	// 每当收到客户端消息时自动激发该方法
	@OnMessage
	public void incoming(String message)
	{
		String filteredMessage = String.format("%s: %s"
			, nickname, filter(message));
		// 发送消息
		broadcast(filteredMessage);
	}
	// 当客户端通信出现错误时，激发该方法
	@OnError
	public void onError(Throwable t) throws Throwable
	{
		System.out.println("WebSocket服务端错误 " + t);
	}
	// 实现广播消息的工具方法
	private static void broadcast(String msg)
	{
		// 遍历服务器关联的所有客户端
		for (ChatEntpoint client : clientSet)
		{
			try
			{
				synchronized (client)
				{
					// 发送消息
					client.session.getBasicRemote().sendText(msg);
				}
			}
			catch (IOException e)
			{
				System.out.println("聊天错误，向客户端 "
					+ client + " 发送消息出现错误。");
				clientSet.remove(client);
				try
				{
					client.session.close();
				}
				catch (IOException e1){}
				String message = String.format("【%s %s】",
					client.nickname, "已经被断开了连接。");
				broadcast(message);
			}
		}
	}
	// 定义一个工具方法，用于对字符串中的HTML字符标签进行转义
	private static String filter(String message)
	{
		if (message == null)
			return null;
		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuilder result = new StringBuilder(content.length + 50);
		for (int i = 0; i < content.length; i++)
		{
			// 控制对尖括号等特殊字符进行转义
			switch (content[i])
			{
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case '&':
					result.append("&amp;");
					break;
				case '"':
					result.append("&quot;");
					break;
				default:
					result.append(content[i]);
			}
		}
		return (result.toString());
	}
}
