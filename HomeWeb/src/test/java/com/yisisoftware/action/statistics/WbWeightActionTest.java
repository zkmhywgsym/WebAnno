package com.yisisoftware.action.statistics;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WbWeightActionTest {

	ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testGetInfoQR() {
		WbWeightAction x = (WbWeightAction) app.getBean("wbWeightAction");
//		x.getInfoQR("晋A111");
	}

}
