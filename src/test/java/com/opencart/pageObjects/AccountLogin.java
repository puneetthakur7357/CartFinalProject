package com.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;



public class AccountLogin extends BasePage {

	public AccountLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="input-email")
	public WebElement text_email;

	@FindBy(id="input-password")
	public WebElement text_password;

	@FindBy(xpath="//input[@value='Login']")
	public WebElement btn_login;

	public void sendEmail(){
		text_email.sendKeys("demotour@gmail.com");
	}
	public void sendPass(){
		text_password.sendKeys("123456");
	}
	public void clickLogin(){
		btn_login.click();

	}
	public void ClickLogin2(String email_address, String password) {
		text_email.sendKeys(email_address);
		text_password.sendKeys(password);
		btn_login.click();
	}
}
