package com.qa.auto.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePostPage {
	WebDriver driver;

	@FindBy(xpath = "//span[contains(text(),'Create Post')]//ancestor::div[4]//div[contains(text(), 'on your mind')]")
	WebElement postText;
	
	@FindBy(xpath = "//div[@aria-label='Post']//span[contains(text(), 'Post')]")
	WebElement postButton;

	public CreatePostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setPostText(String text){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.visibilityOf(postText));
		WebElement currentElement = driver.switchTo().activeElement();


		currentElement.sendKeys(text);
	}
	
	public void clickPostButton() {
		postButton.click();
		
		// wait for the posting alert to get complete
		// using sleep now, but needs to be handled using explicit wait
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
