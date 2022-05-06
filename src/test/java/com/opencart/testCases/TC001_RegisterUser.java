package com.opencart.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.base.BasePage;
import com.opencart.pageObjects.MyAccount;
import com.opencart.pageObjects.RegisterAccount;
import com.opencart.pageObjects.YourStore;
import com.opencart.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;



public class TC001_RegisterUser extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException{
		test = report.startTest("Register new user test case running.... ");
		logger.info("Register new user test case running....");
		
		
		YourStore yt = new YourStore(driver);
		
		yt.ClickonMyaccount();
		test.log(LogStatus.INFO, "Clicked on Drop down account");
		logger.info("Clicked on Drop down account ");
		Thread.sleep(2000);
		
		yt.ClickonRegister();
		test.log(LogStatus.INFO, "Clicked on Register");
		logger.info("Clicked on Register ");
		Thread.sleep(2000);
		String email=randomestring()+"@gmail.com";
		RegisterAccount rAccount = new RegisterAccount(driver);
		rAccount.sendfirstname("Puneet");
		rAccount.sendlasttname("Thakur");
		rAccount.sendemail(email);
		Thread.sleep(3000);
		rAccount.sendphone("646464646");
		rAccount.sendpassword("demo123");
		rAccount.sendcpassword("demo123");
		test.log(LogStatus.INFO, "Entered user information");
		logger.info("Entered user information ");
		rAccount.clickagree();
		rAccount.clickcont();
		boolean res=driver.getPageSource().contains("Your Account Has Been Created!");
		System.out.print(res);
		if(res==true)
		{
			Assert.assertTrue(true);
			test.log(LogStatus.INFO, "test case passed....");
			logger.info("test case passed....");
			
		}
		else
		{
			test.log(LogStatus.INFO, "test case failed....");
			logger.info("test case failed....");
			Utilities.captureScreenshot();
			Assert.assertTrue(false);
		}
		MyAccount myAccount = new MyAccount(driver);
		myAccount.clickcontinue();
		myAccount.clickdrop();
		myAccount.clicklogout();
		test.log(LogStatus.INFO, "Logged out");
		logger.info("Logged out ");
		
	}

}
