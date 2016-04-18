package lee;

import org.hibernate.*;
import org.hibernate.criterion.*;

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
public class DetachedCriteriaTest
{
	public static void main(String[] args)
	{
		DetachedCriteriaTest pt = new DetachedCriteriaTest();
		pt.datached();
		pt.subQuery();
		HibernateUtil.sessionFactory.close();
	}

	// 执行离线查询
	private void datached()
	{
		// 定义一个离线查询
		DetachedCriteria query = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 执行离线查询
		List list = query.getExecutableCriteria(session)
			.list();
		// 遍历查询的结果
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	// 执行子查询
	private void subQuery()
	{
		// 定义一个离线查询
		DetachedCriteria subQuery = DetachedCriteria
			.forClass(Student.class)
			.setProjection(Property.forName("name"));
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 执行子查询
		List list = session.createCriteria(Student.class)
			// 下面两行代码的作用相同，都示范了通过子查询添加查询条件
			.add( Property.forName("name").in(subQuery))
//			.add( Subqueries.propertyIn("name" , subQuery))
			.list();
		// 遍历查询的结果
		for (Object obj : list)
		{
			System.out.println(obj);
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}