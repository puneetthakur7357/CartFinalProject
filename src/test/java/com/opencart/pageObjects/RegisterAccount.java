package com.opencart.pageObjects;

import org.jaxen.function.StringFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.opencart.base.BasePage;



public class RegisterAccount extends BasePage
{
	 public RegisterAccount(WebDriver driver) {
		// TODO Auto-generated constructor stub 
			super(driver);
	}
		@FindBy(id = "input-firstname")
		WebElement fname;
		@FindBy(id = "input-lastname")
		WebElement lname;
		@FindBy(id = "input-email")
		WebElement email;
		@FindBy(id = "input-telephone")
		WebElement phone;
		@FindBy(id = "input-password")
		WebElement ipassword;
		@FindBy(id = "input-confirm")
		WebElement cpassword;
		
		@FindBy(xpath="//input[@name='agree']")
		WebElement btn_agree;
		@FindBy(xpath="//input[@class = 'btn btn-primary']")
		WebElement btn_continue;

		public void sendfirstname(String f){
			fname.sendKeys(f);
		}
		public void sendlasttname(String l){
			lname.sendKeys(l);
		}
		public void sendemail(String e){
			email.sendKeys(e);
		}
		public void sendphone(String p){
			phone.sendKeys(p);
		}
		public void sendpassword(String pw){
			ipassword.sendKeys(pw);
		}
		public void sendcpassword(String cpwd){
			cpassword.sendKeys(cpwd);
		}
		public void clickagree(){
			btn_agree.click();
		}
		public void clickcont(){
			btn_continue.click();
		}
		
}
