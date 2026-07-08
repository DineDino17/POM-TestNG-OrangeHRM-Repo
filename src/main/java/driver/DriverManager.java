package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    //This will create multiple thread for each driver instance
    public static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    //This will receive the driver from the Test Class and sets to Thread
    public static void setDriver(WebDriver driver){
        driverThread.set(driver);
    }

    //This will get the thread with driver instance and returns
    public static WebDriver getDriver(){
        return driverThread.get();
    }

    public static void quitDriver(){
        if(driverThread.get() != null){
            //This will quit the current driver
            driverThread.get().quit();
            //This will remove the current Thread from ThreadLocal
            driverThread.remove();
        }
    }
}
