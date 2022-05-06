package com.opencart.testCases;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pageObjects.AccountLogin;
import com.opencart.pageObjects.YourStore;
import com.relevantcodes.extentreports.LogStatus;



public class TC001_LoginTest_Fail extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException{
		test = report.startTest("Fail Test case running....");
        logger.info("Fail test case running....");
	//	logger.info("Opening URL");
		
		
		YourStore yt = new YourStore(driver);
		yt.ClickonMyaccount();
		
		test.log(LogStatus.INFO, "Clicked on My account dropdown");
		logger.info("Clicked on My Account ");
		Thread.sleep(2500);
		
		yt.ClickonLogin();
		
		test.log(LogStatus.INFO, "Clicked on Login option");
		logger.info("Clicked on Login option ");
		
		AccountLogin al = new AccountLogin(driver);
		String exptitle = "Account Login1";
		String acttitle = driver.getTitle();
	//	Assert.assertEquals(acttitle, exptitle);
		Thread.sleep(2500);
		if(exptitle == acttitle){
			Assert.assertTrue(true);
			al.ClickLogin2(username, password);
			
			test.log(LogStatus.INFO, "Entered username and password");
			logger.info("Entered username and password ");
		}
		else{
			Assert.assertTrue(false);
			
			logger.info("Test Failed");
		}
		
		
		
	}

}
