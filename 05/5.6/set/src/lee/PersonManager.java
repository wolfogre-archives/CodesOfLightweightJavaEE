package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;import org.crazyit.app.domain.*;

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
		Person person = new Person();
		person.setAge(20);
		person.setName("crazyit.org");
		// 向person的schools集合属性中添加两个字符串元素
		person.getSchools().add("小学");
		person.getSchools().add("中学");
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
}