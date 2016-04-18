package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;

import java.util.*;

import org.crazyit.app.domain.*;

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
public class NewsManager
{
	static Configuration conf = new Configuration()
		.configure();
	// 以Configuration实例创建SessionFactory实例
	static ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		.applySettings(conf.getProperties()).build();
	static SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
	public static void main(String[] args) throws Exception
	{
		NewsManager mgr = new NewsManager();
		mgr.cacheQuery();
		mgr.stat();
	}

	private void noCacheQuery()
	{
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List titles  = session.createQuery("select news.title from News news")
			// 其实无需设置，默认就是关闭缓存的。
			.setCacheable(false)
			.list();
		for(Object title : titles)
		{
			System.out.println(title);
		}
		System.out.println("-------------------------");
		// 第二次查询，因为没有使用查询缓存，因此会重新发出SQL语句进行查询
		titles  = session.createQuery("select news.title from News news")
			// 其实无需设置，默认就是关闭缓存的。
			.setCacheable(false)
			.list();
		for(Object title : titles)
		{
			System.out.println(title);
		}
		session.getTransaction().commit();
	}

	private void cacheQuery()
	{
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List titles  = session.createQuery("select news.title from News news")
			// 开启查询缓存
			.setCacheable(true)
			.list();
		for(Object title : titles)
		{
			System.out.println(title);
		}
		session.getTransaction().commit();
		System.out.println("-------------------------");
		Session sess2 = sf.getCurrentSession();
		sess2.beginTransaction();
		// 第二次查询，使用查询缓存，因此不会重新发出SQL语句进行查询
		titles  = sess2.createQuery("select news.title from News news")
			// 开启查询缓存
			.setCacheable(true)
			.list();
		for(Object title : titles)
		{
			System.out.println(title);
		}
		sess2.getTransaction().commit();
	}

	// 开启查询缓存，但使用iterate()方法查询，因此也不能缓存
	public static void cacheQueryIterator()
	{
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Iterator it  = session.createQuery("select news.title from News news")
			// 开启查询缓存
			.setCacheable(true)
			.iterate();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		session.getTransaction().commit();
		System.out.println("-------------------------");
		Session sess2 = sf.getCurrentSession();
		sess2.beginTransaction();
		// 第二次查询，虽然使用了查询缓存，但由于使用iterate()获取查询结果，
		// 因此无法利用查询缓存。
		it  = sess2.createQuery("select news.title from News news")
			// 开启查询缓存
			.setCacheable(true)
			.iterate();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		sess2.getTransaction().commit();
	}
	private void stat()
	{
		//----------统计查询缓存----------
		long hitCount = sf.getStatistics()
			//查询缓存的名字与HQL语句或SQL语句相同
			.getQueryStatistics("select news.title from News news")
			.getCacheHitCount();
		System.out.println("查询缓存命中的次数：" + hitCount);
	}
}
