package org.crazyit.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.crazyit.common.dao.BaseDao;

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
public class BaseDaoJpa<T> implements BaseDao<T>
{
	@PersistenceContext
	protected EntityManager entityManager;

	// 根据ID加载实体
	public T get(Class<T> entityClazz , Serializable id)
	{
		return (T)entityManager.find(entityClazz , id);
	}
	// 保存实体
	public Serializable save(T entity)
	{
		entityManager.persist(entity);
		try
		{
			return (Serializable) entity.getClass()
				.getMethod("getId").invoke(entity);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(entity + "必须提供getId（）方法！");
		}
	}
	// 更新实体
	public void update(T entity)
	{
		entityManager.merge(entity);
	}
	// 删除实体
	public void delete(T entity)
	{
		entityManager.remove(entity);
	}
	// 根据ID删除实体
	public void delete(Class<T> entityClazz , Serializable id)
	{
		entityManager.createQuery("delete " + entityClazz.getSimpleName()
				+ " en where en.id = ?0")
			.setParameter(0 , id)
			.executeUpdate();
	}
	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz)
	{
		return find("select en from "
			+ entityClazz.getSimpleName() + " en");
	}
	// 获取实体总数
	public long findCount(Class<T> entityClazz)
	{
		List<?> l = find("select count(*) from "
			+ entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1 )
		{
			return (Long)l.get(0);
		}
		return 0;
	}

	// 根据JPQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql)
	{
		return (List<T>)entityManager.createQuery(jpql)
			.getResultList();
	}
	// 根据带占位符参数JPQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql , Object... params)
	{
		// 创建查询
		Query query = entityManager.createQuery(jpql);
		// 为包含占位符的JPQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i , params[i]);
		}
		return (List<T>)query.getResultList();
	}
	/**
	 * 使用JPQL语句进行分页查询操作
	 * @param jpql 需要查询的JPQL语句
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql,
		 int pageNo, int pageSize)
	{
		// 创建查询
		return entityManager.createQuery(jpql)
			// 执行分页
			.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}
	/**
	 * 使用JPQL语句进行分页查询操作
	 * @param jpql 需要查询的JPQL语句
	 * @param params 如果jpql带占位符参数，params用于传入占位符参数
	 * @param pageNo 查询第pageNo页的记录
	 * @param pageSize 每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql , int pageNo, int pageSize
		, Object... params)
	{
		// 创建查询
		Query query = entityManager.createQuery(jpql);
		// 为包含占位符的JPQL语句设置参数
		for(int i = 0 , len = params.length ; i < len ; i++)
		{
			query.setParameter(i , params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.getResultList();
	}
}
