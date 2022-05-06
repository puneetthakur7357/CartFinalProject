package com.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;



public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//a[@class = 'dropdown-toggle']")
	public WebElement click_drop;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement click_logout;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	public WebElement click_cont;
	
	
	public void clickdrop(){
		click_drop.click();
	}
	
	public void clicklogout(){
		click_logout.click();
	}
	
	public void clickcontinue(){
		click_cont.click();
	}

}
