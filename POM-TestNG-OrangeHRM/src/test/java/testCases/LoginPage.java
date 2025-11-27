package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonUtilities.utils;
import pageObjects.LoginPO;

public class LoginPage extends utils{

	@Test
	public void loginSuccess() {
	PageFactory.initElements(driver, pageObjects.LoginPO.class);
	
	LOGGER.info("Browser page loaded");
	LoginPO.username.sendKeys(username);
	LoginPO.password.sendKeys(password);
	LoginPO.loginBtn.click();
	
	
	}

}
