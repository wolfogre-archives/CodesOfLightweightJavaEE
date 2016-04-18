package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;
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
public class NewsManager
{
	public static void main(String[] args)
		throws Exception
	{
		// 实例化Configuration，
		Configuration conf = new Configuration()
		// 不带参数的configure()方法默认加载hibernate.cfg.xml文件，
		// 如果传入abc.xml作为参数，则不再加载hibernate.cfg.xml，改为加载abc.xml
			.configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(conf.getProperties()).build();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息对象
		News n = new News();
		// 设置消息标题和消息内容
		n.setTitle("疯狂Java联盟成立了");
		n.setContent("疯狂Java联盟成立了，"
			+ "网站地址http://www.crazyit.org");
		n.setHappenSeason(Season.夏季);
		// 保存消息
		sess.save(n);
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}
}
