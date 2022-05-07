package com.opencart.testCases;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencart.utilities.*;
import com.opencart.base.BaseClass;
import com.opencart.pageObjects.AccountLogin;
import com.opencart.pageObjects.YourStore;
import com.relevantcodes.extentreports.LogStatus;



public class TC001_LoginTest_DataDriven extends BaseClass {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void dataloginTest(String eaddress, String pword) throws InterruptedException{
		test = report.startTest("Data Driven login test case running..... ");
		logger.info("Data Driven login test case running.....");
		
		
		YourStore yt = new YourStore(driver);
		Thread.sleep(2000);
		yt.ClickonMyaccount();
		test.log(LogStatus.INFO, "Clicked on My account dropdown");
		logger.info("Clicked on My Account ");
		Thread.sleep(2500);
		yt.ClickonLogin();
		test.log(LogStatus.INFO, "Clicked on Login option");
		logger.info("Clicked on Login option ");
		
		AccountLogin al = new AccountLogin(driver);
		Thread.sleep(2500);
		al.ClickLogin2(eaddress, pword);
		test.log(LogStatus.INFO, "Entered username and password");
		logger.info("Entered username and password ");
		
	}

}
