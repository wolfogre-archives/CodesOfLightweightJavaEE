package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

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
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.testPerson();
		HibernateUtil.sessionFactory.close();
	}

	private void testPerson()
	{
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 创建一个瞬态的Person对象
		Person p = new Person();
		// 设置Person的name为crazyit字符串
		p.setName("crazyit");
		p.setAge(21);
		// 创建一个瞬态的Address对象
		Address a = new Address("广州天河");
		// 设置Person和Address之间的关联关系
		a.setPerson(p);
		//创建一个瞬态的Address对象
		Address a2 = new Address("上海虹口");
		// 设置Person和Address之间的关联关系
		p.getAddresses().add(a2);
		// 由于采用了连接表来维护1-N关联关系，因此不存在主从表关系，
		// 程序可以随意控制先持久化哪个实体。
		// 持久化Address对象
		session.persist(a2);
		// 持久化Person对象
		session.save(p);
		// 持久化Address对象
		session.persist(a);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
