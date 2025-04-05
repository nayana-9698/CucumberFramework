package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.StepDefinition.hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverFactory {
//to get the driver object
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logger logger = LogManager.getLogger(driverFactory.class);


    public static WebDriver getDriver(){
        logger.info("In this method we are getting WebDriver");
        if(driver.get()==null){
            initDriver();
        }
        return driver.get();
    }

    //to initiate the driver object
    public static void initDriver(){

        logger.info("In this method we are initiating WebDriver");
        System.setProperty("browser","chrome");
        String browser = System.getProperty("browser");

        switch(browser.toLowerCase()){
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Please select valid browser");

        }
    }

    //this method is used to quit the driver object
    public static void quitDriver(){
        logger.info("In this method we are quiting WebDriver");
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }


}
