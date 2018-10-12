package com.learn.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learn.models.JdbcDAOImpl;

public class TestBeanInh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("bean-def-inh.xml");
		
		JdbcDAOImpl conn1 = (JdbcDAOImpl)appCtx.getBean("conn1");
		System.out.println(conn1);

		JdbcDAOImpl conn2 = (JdbcDAOImpl)appCtx.getBean("conn2");
		System.out.println(conn2);

		JdbcDAOImpl conn3 = (JdbcDAOImpl)appCtx.getBean("conn3");
		System.out.println(conn3);
		
	}

}
