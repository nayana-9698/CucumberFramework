package org.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {

    //constructor
    public homePage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccountLinkEle;
    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement registerLinkEle;
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginHome;

    //actions
    public void clickOnMyAccount(){
        myAccountLinkEle.click();
    }

    public void clickOnRegister(){
        registerLinkEle.click();
    }

    public void clickOnLoginHome(){
        loginHome.click();
    }


}
