package lee;

import org.hibernate.*;
import org.hibernate.internal.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.event.spi.*;
import org.hibernate.event.service.spi.*;
import org.hibernate.boot.registry.*;

import java.util.*;

import org.crazyit.app.domain.*;
import org.crazyit.common.hibernate.*;
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
public class UserManager
{
	static Configuration cfg = new Configuration()
		// 加载hibernate.cfg.xml配置文件
		.configure();
	// 以Configuration实例来创建SessionFactory实例
	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		.applySettings(cfg.getProperties()).build();
	static SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
	static{
		// 获取该SessionFactory的事件监听器注册器
		EventListenerRegistry elr = ((SessionFactoryImpl)sf)
			.getServiceRegistry().getService(EventListenerRegistry.class);
		// 使用用户指定的拦截器序列代替系统默认的save拦截器序列
		elr.setListeners(EventType.SAVE, MySaveListener.class);
		// 使用用户指定的拦截器序列代替系统默认的load拦截器序列
		elr.setListeners(EventType.LOAD, MyLoadListener.class);
	}
	public static void main(String[] args)
	{
		UserManager mgr = new UserManager();
		mgr.testUser();
		sf.close();
	}
	private void testUser()
	{
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个User对象
		User u1 = new User();
		// 设置基本属性
		u1.setName("crazyit.org");
		u1.setAge(30);
		u1.setNationality("china");
		// 保存一个User对象
		session.save(u1);
		// 装载一个已有的User对象
		User u = (User)session.get(User.class , 1);
		// 改变属性
		u.setName("疯狂Java联盟");
		tx.commit();
	}
}
