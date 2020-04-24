package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    //Thread because our driver is singleton and parallel testing will try to use same object at the same time and fail
    private static ThreadLocal <WebDriver> driverPool = new ThreadLocal<>();
    //so noone can create object of class
    //everyone should call static getter method instead
    private Driver (){
    }

    //SYNC Enabbles multi-threading works little slower but make sure
    //two different method can access here at the same time
    public synchronized static WebDriver getDriver(String browser) {
        if(driverPool.get()==null){
           // String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chromeheadless":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driverPool.get();
    }

    public synchronized static WebDriver getDriver() {
        if(driverPool.get()==null){
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    break;
                case "chromeheadless":
                    ChromeOptions chromeOptions=new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;

                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driverPool.get();
    }
    public static void closeDriver()
    {
        if(driverPool!=null)
        {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
// ThreadLocal allows to create a copy of the object at the run time for every thread.
//we need to make getter synchronized to prevent a crash so they will  not clash.
//it calls thread safety.
//to run data provider test in parallel add parameter (parallel =true)
// How to make parallel testing with WebDriver ? Interview question
//Make your webDriver object ThreadLocal and make your getter synchronized
