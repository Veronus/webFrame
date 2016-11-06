package com.mes.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	KieServices ks = KieServices.Factory.get();  
        KieContainer kContainer = ks.getKieClasspathContainer();  
        KieSession kSession = kContainer.newKieSession("session-clock");  
          
        kSession.insert(new Clock());  
        kSession.fireAllRules();  
        kSession.dispose();  */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
	}

}
