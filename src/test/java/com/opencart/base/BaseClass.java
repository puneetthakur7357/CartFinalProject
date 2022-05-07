package com.opencart.base;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import com.opencart.utilities.ExtentManager;

import com.beust.jcommander.Parameter;
import com.opencart.utilities.ReadConfig;
import com.opencart.utilities.ScreenShots;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password= readConfig.getPassword();
	public static WebDriver driver = null;
	public static Logger logger = Logger.getLogger("qaLogger");
	public static ExtentReports report = ExtentManager.getInstance(); ;
	public static ExtentTest test;


	@Parameters("browser")
	@BeforeClass()
	public void setup(String br) throws InterruptedException{
	//	report = new ExtentReports("C:\\Users\\PuneetPC\\workspace\\CartFinalProject\\src\\test\\resources\\extentreport\\report1.html");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe"); // user.dir will give you C:\\Users\\PuneetPC\\workspace\\CartFinalProject

		//PropertyConfigurator.configure("C:\\Users\\PuneetPC\\workspace\\CartFinalProject\\src\\test\\resources\\rough\\log4j.properties");
		//Loading desired browser using @parameter in xml parameter tag
		
		
		
		if(br.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
			//test.log(LogStatus.INFO, "Testing on Chrome Browser ");
			logger.info("Testing on Chrome Browser");
			

		}
		else if(br.equals("firefox")){

			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			//test.log(LogStatus.INFO, "Testing on Firefox Browser ");
			logger.info("Testing on Firefox Browser ");

		}
		
		else if(br.equals("ie")){

			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			//test.log(LogStatus.INFO, "Testing on IEexplorer Browser ");
			logger.info("Testing on IEexplorer Browser");

		}
		else if(br.equals("edge")){

			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
			//test.log(LogStatus.INFO, "Testing on Edge Browser ");
			logger.info("Testing on Edge Browser");

		}


		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("Opening URL");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// Global implicit Wait
	
	}

	@AfterClass
	public void tearDown() throws AddressException, MessagingException, IOException {
		
		
			 driver.quit();
		
		
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
}

