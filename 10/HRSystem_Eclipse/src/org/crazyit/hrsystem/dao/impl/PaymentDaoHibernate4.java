package org.crazyit.hrsystem.dao.impl;

import java.util.*;

import org.crazyit.hrsystem.domain.*;
import org.crazyit.common.dao.impl.BaseDaoHibernate4;
import org.crazyit.hrsystem.dao.*;

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
public class PaymentDaoHibernate4 extends BaseDaoHibernate4<Payment>
	implements PaymentDao
{

	/**
	 * 根据员工查询月结薪水
	 * @return 该员工对应的月结薪水集合
	 */
	public List<Payment> findByEmp(Employee emp)
	{
		return find("select p from Payment as p where p.employee=?0" , emp);
	}


	/**
	 * 根据员工和发薪月份来查询月结薪水
	 * @param payMonth 发薪月份
	 * @param emp 领薪的员工
	 * @return 指定员工、指定月份的月结薪水
	 */
	public Payment findByMonthAndEmp(String payMonth
		 , Employee emp)
	{
		List<Payment> pays = find("select p from Payment as p where"
			+ " p.employee=?0 and p.payMonth=?1" , emp , payMonth);
		if (pays != null && pays.size() > 0)
		{
			return pays.get(0);
		}
		return null;
	}
}
