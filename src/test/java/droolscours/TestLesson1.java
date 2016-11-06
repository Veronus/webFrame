package droolscours;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.mes.utils.KnowledgeSessionHelper;
import com.mes.utils.OutputDisplay;



@SuppressWarnings("restriction")
public class TestLesson1 {

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
	public void testFristOne() {
		// fail("Not yet implemented");
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		Account account = new Account();
		sessionStatefull.insert(account);
		sessionStatefull.fireAllRules();
	}
	
	@Test
	public void testRuleIneFactWithFactAndUsageOfGlobalAndCallBack(){
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		sessionStatefull.addEventListener(new RuleRuntimeEventListener() {
			
			public void objectUpdated(ObjectUpdatedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object was update \n"
						+ "new Content \n"
						+ event.getObject().toString());
			}
			
			public void objectInserted(ObjectInsertedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object inserted \n"
						+ event.getObject().toString());
			}
			
			public void objectDeleted(ObjectDeletedEvent event) {
				// TODO Auto-generated method stub
				System.out.println("Object retracted \n"
						+ event.getOldObject().toString());
			}
		});
		
		Account account = new Account();
		account.setAccountno(10);
		FactHandle handle = sessionStatefull.insert(account);
		account.setBalance(12.0);
		sessionStatefull.update(handle, account);
		sessionStatefull.delete(handle);
		sessionStatefull.fireAllRules();
		System.out.println("So you saw something; ");
	}

}
