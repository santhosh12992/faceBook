package com.qa.auto.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.auto.pageObjects.CreatePostPage;
import com.qa.auto.pageObjects.HomePage;
import com.qa.auto.pageObjects.LoginPage;
import com.qa.auto.testHelper.ConfigSettings;
import com.qa.auto.testHelper.IoLibrary;

public class WebDriverBase {

	public static WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public CreatePostPage createPostPage;

	public static void getWebDriver(String browser) {

		if (browser.equals("chrome")) {

			IoLibrary.writeLine("Launching Chrome Browser.");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			IoLibrary.writeLine("Launching Firefox Browser.");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else {
			throw new RuntimeException(String.format(
					"Browser Type %s, not Found, please add additional code for this desired WebDriver Type.",
					browser));
		}
	}

	public static void getWebDriver(WebDriver chrome) {
		driver = chrome;
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	public WebDriverBase() {
		try {
			new ConfigSettings().getConfigSettings();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getWebDriver(ConfigSettings.getWebBrowser());
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(ConfigSettings.getWebUrl());
		// Initialize all the page objects
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		createPostPage = new CreatePostPage(driver);
	}
}
