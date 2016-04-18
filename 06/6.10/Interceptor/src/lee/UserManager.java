package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;

import java.util.*;

import org.crazyit.app.domain.*;
import org.crazyit.common.hibernate.interceptor.MyInterceptor;

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
		.configure()
		// 设置启用全局拦截器
		.setInterceptor(new MyInterceptor());
	// 以Configuration实例创建SessionFactory实例
	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		.applySettings(cfg.getProperties()).build();
	static SessionFactory sf = cfg.buildSessionFactory(serviceRegistry);
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
		u1.setName("crazyit.org");
		u1.setAge(30);
		u1.setNationality("china");
		session.save(u1);
		User u = (User)session.load(User.class , 1);
		u.setName("疯狂Java联盟");
		tx.commit();
	}
}
