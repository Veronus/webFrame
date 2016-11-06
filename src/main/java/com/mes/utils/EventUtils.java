package com.mes.utils;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.EventDao;
import com.mes.meta.Event;

public class EventUtils {
	
	/**
	 * 
	 * @return event list
	 */
	public List<Event> getEvents() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		EventDao eventDao = context.getBean("eventDao",EventDao.class);
		List<Event> events = eventDao.getEvents();
		((ConfigurableApplicationContext) context).close();
		return events;
	}

}
