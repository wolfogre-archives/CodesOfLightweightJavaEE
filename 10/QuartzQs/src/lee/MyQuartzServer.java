package lee;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

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
public class MyQuartzServer
{
	public static void main(String[] args)
	{
		MyQuartzServer server = new MyQuartzServer();
		try
		{
			server.startScheduler();
		}
		catch (SchedulerException ex)
		{
			ex.printStackTrace();
		}
	}
	// 执行调度
	private void startScheduler() throws SchedulerException
	{
		// 使用工厂创建调度器实例
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		// 以Job实现类创建JobDetail实例
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class)
			.withIdentity("fkJob").build();
		// 创建Trigger对象，该对象代表一个简单的调度器
		// 指定该任务被重复调度50次，每次间隔60秒
		Trigger trigger = TriggerBuilder.newTrigger()
             .withIdentity(TriggerKey.triggerKey("fkTrigger" , "fkTriggerGroup"))
             .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                 .withIntervalInSeconds(60)
                 .repeatForever())
             .startNow()
             .build();

		// 调度器将作业与trigger关联起来
		scheduler.scheduleJob(jobDetail, trigger );
		// 开始调度
		scheduler.start();
	}
}