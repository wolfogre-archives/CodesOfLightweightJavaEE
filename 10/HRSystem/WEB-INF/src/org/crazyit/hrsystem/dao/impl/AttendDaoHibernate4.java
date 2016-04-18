package org.crazyit.hrsystem.dao.impl;

import java.util.*;
import java.text.*;

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
public class AttendDaoHibernate4 extends BaseDaoHibernate4<Attend>
	implements AttendDao
{
	/**
	 * 根据员工、月份查询该员工的出勤记录
	 * @param emp 员工
	 * @param month 月份，月份是形如"2012-02"格式的字符串
	 * @return 该员工、指定月份的全部出勤记录
	 */
	public List<Attend> findByEmpAndMonth(Employee emp , String month)
	{
		return find("from Attend as a where a.employee=?0 " +
			"and substring(a.dutyDay , 0 , 7)=?1" , emp , month);
	}

	/**
	 * 根据员工、日期查询该员工的打卡记录集合
	 * @param emp 员工
	 * @param dutyDay 日期
	 * @return 该员工的某天的打卡记录集合
	 */
	public List<Attend> findByEmpAndDutyDay(Employee emp
		, String dutyDay)
	{
		return find("from Attend as a where a.employee=?0 and "
			+ "a.dutyDay=?1" , emp , dutyDay);
	}

	/**
	 * 根据员工、日期 、上下班查询该员工的打卡记录集合
	 * @param emp 员工
	 * @param dutyDay 日期
	 * @param isCome 是否上班
	 * @return 该员工的某天上班或下班的打卡记录
	 */
	public Attend findByEmpAndDutyDayAndCome(Employee emp ,
		String dutyDay , boolean isCome)
	{
		List<Attend> al = findByEmpAndDutyDay(emp , dutyDay);
		if (al != null || al.size() > 1)
		{
			for (Attend attend : al)
			{
				if (attend.getIsCome() == isCome )
				{
					return attend;
				}
			}
		}
		return null;
	}

	/**
	 * 查看员工前三天的非正常打卡
	 * @param emp 员工
	 * @return 该员工的前三天的非正常打卡
	 */
	public List<Attend> findByEmpUnAttend(Employee emp
		, AttendType type)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		String end = sdf.format(c.getTime());
		c.add(Calendar.DAY_OF_MONTH, -3);
		String start = sdf.format(c.getTime());
		return find("from Attend as a where a.employee=?0 and "
			+ "a.type != ?1 and a.dutyDay between ?2 and ?3" ,
			emp , type , start , end);
	}
}
