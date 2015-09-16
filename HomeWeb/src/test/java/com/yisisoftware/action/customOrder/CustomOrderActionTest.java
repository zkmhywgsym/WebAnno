package com.yisisoftware.action.customOrder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomOrderActionTest {

	@Test
	public void testGetNewHZbillNo() {
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomOrderAction ca = (CustomOrderAction) app.getBean("customOrderAction"); 
//		System.out.println(ca.getNewHZbillNo("TS_Receipt"));
		System.out.println(ca.isNum("10s"));
	}

}
