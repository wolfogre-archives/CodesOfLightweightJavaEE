package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

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
public class PersonManager
{
	public static void main(String[] args)
	{
		PersonManager mgr = new PersonManager();
		mgr.createAndStorePerson();
		HibernateUtil.sessionFactory.close();
	}

private void createAndStorePerson()
{
	Session session = HibernateUtil.currentSession();
	Transaction tx = session.beginTransaction();
	// 创建Person对象
	Person wawa = new Person();
	wawa.setAge(21);
	wawa.setName("crazyit.org");
	// 为trainings集合属性添加2个元素
	wawa.getTrainings().add("Wild Java Camp");
	wawa.getTrainings().add("Sun SCJP");
	session.save(wawa);
	Person p = (Person)session.get(Person.class , 1);
	// 再次添加一个集合元素
	p.getTrainings().add("CCNP");
	tx.commit();
	HibernateUtil.closeSession();
}
}