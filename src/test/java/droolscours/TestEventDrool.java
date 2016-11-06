package droolscours;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mes.dao.EventDao;
import com.mes.meta.Event;
import com.mes.utils.KnowledgeSessionHelper;
import com.mes.utils.OutputDisplay;

@SuppressWarnings("restriction")
public class TestEventDrool {

	StatelessKieSession sessionStation = null;
	KieSession sessionStatefull = null;
	static KieContainer kieContainer;

	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Before
	public void setUp()throws Exception {
		System.out.println("--------------Before-----------------");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("--------------After------------------");
	}
	
	@Test
	public void test() {
		long startTime=System.currentTimeMillis();   //获取开始时间
		
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-ruleDelay");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-dao.xml");
		EventDao eventDao = context.getBean("eventDao",EventDao.class);
		
		List<Event> events = eventDao.getEvents();

		for (Event event : events) {
			
			System.out.println(event.toString()+event.DATE);
			
			sessionStatefull.insert(event);
			sessionStatefull.fireAllRules();
			
		}
		
		((ConfigurableApplicationContext) context).close();
		
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
		
	}

}
