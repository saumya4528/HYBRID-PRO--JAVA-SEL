package com.hybridpro.test;

import org.apache.log4j.Logger;
import java.lang.reflect.Method;
import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.hybridpro.initiate.Base;


public class Test1001_VerifyLogin extends Base
{
	
	@Test
	public void Test1(Method result)
	{
		
		GetUrl("admin");
		logger.info("Application launched");
		logger.info("Please start automation");
		extentTest.log(Status.INFO, result.getName()+" started...");
	}

}
