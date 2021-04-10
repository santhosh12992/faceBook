package com.qa.auto.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.qa.auto.base.WebDriverBase.driver;

public class WebDriverExtensions {
	public static WebElement getElementBySelector(String cssSelector) {
		return waitForElement(By.cssSelector(cssSelector), 10);
	}

	public static WebElement getElementBySelector(String cssSelector, long waitSeconds) {
		return waitForElement(By.cssSelector(cssSelector), waitSeconds);
	}

	public static WebElement waitForElement(By locator, long waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
