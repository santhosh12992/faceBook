package com.qa.auto;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.qa.auto.base.WebDriverBase;
import com.qa.auto.testHelper.ConfigSettings;

public class FacebookPost extends WebDriverBase{
	
	@Test
	public void TC001_create_Hello_world_post() {
		// the email id and password can be made to read from excel sheet, refer apache poi
		String postContent = "Hello World";
		String emailId = ConfigSettings.getEmailId();
		String password = ConfigSettings.getPassword();
		
		loginPage.login(emailId, password);
		homePage.clickPost();
		createPostPage.setPostText(postContent);
		createPostPage.clickPostButton();
		
		driver.navigate().refresh();
		boolean result = driver.getPageSource().contains(postContent);
		assertTrue(result, "able to post and see the posted content in the home page");
	}

}
