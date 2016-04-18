package org.crazyit.hrsystem.dao;

import java.util.*;

import org.crazyit.common.dao.BaseDao;
import org.crazyit.hrsystem.domain.*;

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
public interface EmployeeDao extends BaseDao<Employee>
{
	/**
	 * 根据用户名和密码查询员工
	 * @param emp 包含指定用户名、密码的员工
	 * @return 符合指定用户名和密码的员工集合
	 */
	List<Employee> findByNameAndPass(Employee emp);

	/**
	 * 根据用户名查询员工
	 * @param name 员工的用户名
	 * @return 符合用户名的员工
	 */
	Employee findByName(String name);
}
