package org.example.PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.StepDefinition.hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class accountPage extends basePage{
    public static Logger logger = LogManager.getLogger(accountPage.class);

    public accountPage (WebDriver driver){super(driver);}

    //locators
    @FindBy(xpath = "//h2[contains(text(),'My Account')]")
    private WebElement myAccount;


    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    private WebElement logoutele;

    //actions
    public boolean isMyAccount() {
        logger.info("In this function we are verifying myAccount page opened or not");
        try {
            return myAccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    public void clickOnLogout(){
        Actions actions = new Actions(driver);
        actions.moveToElement(logoutele).click().perform();
    }

}
