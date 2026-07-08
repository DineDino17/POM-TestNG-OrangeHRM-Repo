package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

    public AdminPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(partialLinkText = "Admin")
    private WebElement adminOption;

    @FindBy(xpath = "//h5[text()='System Users']")
    private WebElement systemUsers;

    public WebElement adminOption(){
       return adminOption;
    }

    public WebElement systemUsers(){
        return systemUsers;
    }


}
