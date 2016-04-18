package org.crazyit.hrsystem.domain;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javax.persistence.*;
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
@Entity
@Table(name="attend_inf")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Attend
	implements Serializable
{
	private static final long serialVersionUID = 48L;

	// 代表标识属性
	@Id @Column(name="attend_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	// 出勤日期
	@Column(name="duty_day", nullable=false, length=50)
	private String dutyDay;
	// 打卡时间
	@Column(name="punch_time")
	private Date punchTime;
	// 代表本次打卡是否为上班打卡
	@Column(name="is_come" , nullable=false)
	private boolean isCome;
	// 本次出勤的类型
	@ManyToOne(targetEntity=AttendType.class)
	@JoinColumn(name="type_id", nullable=false)
	private AttendType type;
	// 本次出勤关联的员工
	@ManyToOne(targetEntity=Employee.class)
	@JoinColumn(name="emp_id", nullable=false)
	private Employee employee;

	// 无参数的构造器
	public Attend()
	{
	}
	// 初始化全部成员变量的构造器
	public Attend(Integer id , String dutyDay ,
		Date punchTime , boolean isCome ,
		AttendType type , Employee employee)
	{
		this.id = id;
		this.dutyDay = dutyDay;
		this.punchTime = punchTime;
		this.isCome = isCome;
		this.type = type;
		this.employee = employee;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// dutyDay的setter和getter方法
	public void setDutyDay(String dutyDay)
	{
		this.dutyDay = dutyDay;
	}
	public String getDutyDay()
	{
		return this.dutyDay;
	}

	// punchTime的setter和getter方法
	public void setPunchTime(Date punchTime)
	{
		this.punchTime = punchTime;
	}
	public Date getPunchTime()
	{
		return this.punchTime;
	}

	// isCome的setter和getter方法
	public void setIsCome(boolean isCome)
	{
		this.isCome = isCome;
	}
	public boolean getIsCome()
	{
		return this.isCome;
	}

	// type的setter和getter方法
	public void setType(AttendType type)
	{
		this.type = type;
	}
	public AttendType getType()
	{
		return this.type;
	}

	// employee的setter和getter方法
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public Employee getEmployee()
	{
		return this.employee;
	}

	// 根据employee、isCome、dutyDay来重写hashCode()方法
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
			+ ((dutyDay == null) ? 0 : dutyDay.hashCode());
		result = prime * result
			+ ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (isCome ? 1231 : 1237);
		return result;
	}
	// 根据employee、isCome、dutyDay来重写equals()方法
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Attend other = (Attend) obj;
		if (dutyDay == null)
		{
			if (other.dutyDay != null) return false;
		}
		else if (!dutyDay.equals(other.dutyDay)) return false;
		if (employee == null)
		{
			if (other.employee != null) return false;
		}
		else if (!employee.equals(other.employee)) return false;
		if (isCome != other.isCome) return false;
		return true;
	}
}