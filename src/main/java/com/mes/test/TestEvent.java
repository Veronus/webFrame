package com.mes.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.EventDao;
import com.mes.meta.Event;

public class TestEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		//任务类型事件
		eventDao.insertEvent("100001","TaskDelay", "Station5", df.format(new Date()));
		eventDao.insertEvent("100002","TaskDispatch", "Station1", df.format(new Date()));
		eventDao.insertEvent("100003","TaskReady", "Station2", df.format(new Date()));
		eventDao.insertEvent("100004","TaskStart", "Station9", df.format(new Date()));
		eventDao.insertEvent("100005","TaskFinish", "Station11", df.format(new Date()));
		eventDao.insertEvent("100006","TaskCancel", "Station13", df.format(new Date()));
		eventDao.insertEvent("100007","TaskInterrupt", "Station4", df.format(new Date()));
		
		//设备类型事件
		eventDao.insertEvent("200001","DeviceRun", "Station2", df.format(new Date()));
		eventDao.insertEvent("200002","DeviceFree", "Station10", df.format(new Date()));
		eventDao.insertEvent("200003","DeviceFault", "Station7", df.format(new Date()));
		eventDao.insertEvent("200004","DeviceRepair", "Station7", df.format(new Date()));
		
		//物料类型事件
		eventDao.insertEvent("300001","MaterialApplication", "Station2", df.format(new Date()));
		eventDao.insertEvent("300002","MaterialSign", "Station10", df.format(new Date()));
		eventDao.insertEvent("300003","MaterialCheck", "Station7", df.format(new Date()));
		
		//人员类型事件
		eventDao.insertEvent("400001","WorkerReady", "Station3", df.format(new Date()));
		eventDao.insertEvent("400002","WorkerRest", "Station3", df.format(new Date()));
		eventDao.insertEvent("400003","WorkerLeave", "Station3", df.format(new Date()));//请假
		eventDao.insertEvent("400004","WorkerLeaving", "Station3", df.format(new Date()));//离职
		
		//周转箱
		eventDao.insertEvent("500001","BoxArrive", "Station2", df.format(new Date()));
		eventDao.insertEvent("500002","BoxLeave", "Station10", df.format(new Date()));
		eventDao.insertEvent("500003","BoxFault", "Station7", df.format(new Date()));
		
		*/
		long startTime=System.currentTimeMillis();   //获取开始时间
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		EventDao eventDao = context.getBean("eventDao",EventDao.class);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		List<Event> events = eventDao.getEvents();
		for (Event event : events) {
			try {
				Date d1 = df.parse(event.getStarttime());
				Date d2 = df.parse(event.DATE);
				System.out.println(d1.getTime()  +"/n this is d2:  "+ d2.getTime());
				if (d1.getTime() <= d2.getTime()) {
					System.out.println(event.toString()+"This task is delay");
				}
				System.out.println(event.toString()+event.DATE);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		((ConfigurableApplicationContext) context).close();
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	}

}
