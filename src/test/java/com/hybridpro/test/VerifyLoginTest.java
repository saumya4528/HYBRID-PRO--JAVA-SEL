package com.hybridpro.test;

import org.apache.log4j.Logger;
import java.lang.reflect.Method;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.hybridpro.initiate.Base;


public class VerifyLoginTest extends Base
{
	
	@Test
	public void LoginTest(Method result)
	{
		
		GetUrl("admin");
		logger.info("Application launched");
		logger.info("Please start automation");
		extentTest.log(Status.INFO, result.getName()+" started...");
		System.out.println("************HYBRID PRO SELENIUM************************** ");
		System.out.println("***********************TESTING DONE*****************************************??????????");
	}

}
