package org.crazyit.app.aspect;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
// ����һ������
@Aspect
public class LogAspect
{
	// ƥ��org.crazyit.app.service.impl����������ġ�
	// ���з�����ִ����Ϊ�����
	@AfterReturning(returning="rvt"
		, pointcut="execution(* org.crazyit.app.service.impl.*.*(..))")
	// ����rvtʱָ�������ͻ�����Ŀ�귽�����뷵��ָ�����͵�ֵ��û�з���ֵ
	// �˴���rvt����������ΪObject����ζ�Ŷ�Ŀ�귽���ķ���ֵ��������
	public void log(Object rvt)
	{
		System.out.println("��ȡĿ�귽������ֵ:" + rvt);
		System.out.println("ģ���¼��־����...");
	}
}