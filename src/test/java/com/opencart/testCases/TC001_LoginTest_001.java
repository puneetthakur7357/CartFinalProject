package com.opencart.testCases;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageObjects.AccountLogin;
import com.opencart.pageObjects.YourStore;
import com.relevantcodes.extentreports.LogStatus;



public class TC001_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException{
		test = report.startTest("Login test case running.... ");
		logger.info("Login test case running....");
		
		
		YourStore yt = new YourStore(driver);
		yt.ClickonMyaccount();
		test.log(LogStatus.INFO, "Clicked on My account dropdown");
		logger.info("Clicked on My Account ");
		Thread.sleep(2500);
		yt.ClickonLogin();
		test.log(LogStatus.INFO, "Clicked on Login option");
		logger.info("Clicked on Login option ");
		
		AccountLogin al = new AccountLogin(driver);
		Thread.sleep(2500);
		al.ClickLogin2(username, password);
		test.log(LogStatus.INFO, "Entered username and password");
		logger.info("Entered username and password ");
		
	}

}
