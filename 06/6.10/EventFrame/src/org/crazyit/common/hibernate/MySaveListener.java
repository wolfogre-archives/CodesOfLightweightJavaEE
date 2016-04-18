package org.crazyit.common.hibernate;

import java.io.Serializable;

import org.hibernate.event.internal.DefaultSaveEventListener;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.LoadEventListener;

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
// Hibernate的默认事件监听器类都被声明成non-final的了。
public class MySaveListener extends DefaultSaveEventListener
{
	public Serializable performSaveOrUpdate(SaveOrUpdateEvent event)
	{
		System.out.println("自定义的save事件");
		System.out.println(event.getObject());
		return super.performSaveOrUpdate(event);
	}
}