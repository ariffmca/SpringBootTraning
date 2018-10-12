package com.learn.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.configs.GreetingConfiguration;
import com.learn.models.Greeting;

public class TestJavaBasedDI {

	public static void main(String args[]) {
		AnnotationConfigApplicationContext annoAppCtx = new 
				AnnotationConfigApplicationContext(GreetingConfiguration.class);

		//Greeting gr1 = (Greeting)annoAppCtx.getBean("gr1");
		Greeting gr1 = (Greeting)annoAppCtx.getBean(Greeting.class);
		System.out.println(gr1);
	}

}
