package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(){
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space(contains(text(),'Login'))]")
	private WebElement loginBtn;

	public WebElement username(){
		return username;
	}
	public WebElement password(){
		return password;
	}
	public WebElement loginBtn(){
		return loginBtn;
	}
	
}
