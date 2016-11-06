package droolscours;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.mes.utils.KnowledgeSessionHelper;



@SuppressWarnings("restriction")
public class FirstTry {
	
	StatelessKieSession sessionStation = null;
	KieSession sessionStatefull = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass(){
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Test
	public void testFirstOne() {
//		fail("Not yet implemented");
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		sessionStatefull.fireAllRules();
	}

}
