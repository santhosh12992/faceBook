package com.qa.auto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//*[@id='pass']")
	WebElement pass;
	
	@FindBy(xpath = "//button")
	WebElement login;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    public void login(String emailId, String password){
    	email.sendKeys(emailId);
    	pass.sendKeys(password);
    	login.click();
    }
}
