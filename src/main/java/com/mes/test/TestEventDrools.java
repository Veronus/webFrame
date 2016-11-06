package com.mes.test;

import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.EventDao;
import com.mes.meta.Event;
import com.mes.utils.KnowledgeSessionHelper;
import com.mes.utils.OutputDisplay;


public class TestEventDrools {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-ruleDelay");
        	
        	OutputDisplay outputDisplay = new OutputDisplay();
            // go !
        	long startTime=System.currentTimeMillis();   //获取开始时间
        	ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
    		EventDao eventDao = context.getBean("eventDao",EventDao.class);
    		
    		List<Event> events = eventDao.getEvents();

    		for (Event event : events) {
    			
    			System.out.println(event.toString()+event.DATE);
    			
    			kSession.insert(event);
    			kSession.fireAllRules();
    			
    		}
    		
    		((ConfigurableApplicationContext) context).close();
    		
    		long endTime=System.currentTimeMillis(); //获取结束时间
    		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
       
        } catch (Throwable t) {
            t.printStackTrace();
        }
		
		
		
		
		
		
	}

}
