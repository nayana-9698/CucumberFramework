package org.example.StepDefinition;
import freemarker.template.SimpleDate;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.configReader;
import org.example.utils.driverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class hooks {

    public static Logger logger = LogManager.getLogger(hooks.class);
    private static configReader configReader;

    @Before
    public void setup(){
        logger.info("Base class initiated");

        String environment = System.getProperty("environment","dev");
        String path="src/test/resources/config-"+environment+".properties";
        configReader = new configReader(path);

        WebDriver driver = driverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            logger.error("Test scenario failed: " + scenario.getName());
            try{
                TakesScreenshot takesScreenshot = (TakesScreenshot) driverFactory.getDriver();
                final byte[] sourceBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourceBytes,"image/png", scenario.getName());
                captureScreenshot(scenario.getName());
            }catch (Exception e){
               e.printStackTrace();
            }
        }else{

            logger.info("Scenario passed " + scenario.getName());
        }
        driverFactory.quitDriver();
    }


    public String captureScreenshot(String testcasename){
        String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testcasename + timestamp+".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driverFactory.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\screenShots\\" +fileName;
        File targetFile = new File(path);
        sourceFile.renameTo(targetFile);
        return path;
    }

    public static String getConfigValue(String key){
        return configReader.getProperty(key);
    }

}
