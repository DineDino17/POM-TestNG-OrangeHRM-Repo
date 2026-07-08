package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.AdminPage;
import pageObjects.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

	@Test
	public void loginSuccess() {
		LOGGER.info("Browser page loaded");
		loginPage.username().sendKeys(username);
		loginPage.password().sendKeys(password);
		loginPage.loginBtn().click();
	}

	@Test(dependsOnMethods = "loginSuccess")
	public void adminPortal(){
		adminPage.adminOption().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(adminPage.systemUsers()));
	}

}
