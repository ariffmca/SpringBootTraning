package com.learn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.models.Greeting;
import com.learn.models.GreetingManager;

public class TestGreeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");

		Greeting gr1 = (Greeting)appCtx.getBean("gr1");
		System.out.println(gr1);
		
		Greeting gr2 = (Greeting)appCtx.getBean("gr2");
		System.out.println(gr2);
		
		Greeting gr3 = (Greeting)appCtx.getBean("gr3");
		System.out.println(gr3);
		
		Greeting gr4 = (Greeting)appCtx.getBean("gr4");
		System.out.println(gr4);
		
		Greeting gr5 = (Greeting)appCtx.getBean("gr5");
		System.out.println(gr5);
		*/
		
		
		/*AbstractApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");
		
		Greeting gr6 = (Greeting)appCtx.getBean("gr6");
		System.out.println(gr6);
		
		appCtx.registerShutdownHook();*/
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("beans.xml");

		GreetingManager manager = (GreetingManager)appCtx.getBean("manager");
		Greeting gr = manager.getGreeting();
		System.out.println(gr);
		
		/*Greeting gr7 = (Greeting)appCtx.getBean("gr7");
		System.out.println(gr7);*/
		
	}

}