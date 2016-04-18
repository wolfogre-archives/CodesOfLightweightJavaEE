package org.crazyit.app.domain;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
// 经理类继承员工类
@Entity
// 指定Manager实体对应的记录在辨别者列的值为"经理"
@DiscriminatorValue("经理")
@Table(name="manager_inf")
public class  Manager extends Employee
{
	// 定义经理管辖部门的属性
	private String department;
	// 定义和该经理保持关联的Employee关联实体
	@OneToMany(cascade=CascadeType.ALL
		, mappedBy="manager" , targetEntity=Employee.class)
	private Set<Employee> employees
		= new HashSet<>();
	// 无参数的构造器
	public Manager()
	{
	}
	// 初始化全部成员变量的构造器
	public Manager(String department)
	{
		this.department = department;
	}

	// department的setter和getter方法
	public void setDepartment(String department)
	{
		this.department = department;
	}
	public String getDepartment()
	{
		return this.department;
	}

	// employees的setter和getter方法
	public void setEmployees(Set<Employee> employees)
	{
		this.employees = employees;
	}
	public Set<Employee> getEmployees()
	{
		return this.employees;
	}
}