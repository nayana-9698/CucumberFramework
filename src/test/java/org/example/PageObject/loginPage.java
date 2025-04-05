package org.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage {

    public loginPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement eMailAddressEle;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordEle;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement btnloginEle;

    //@FindBy(xpath = "//body/div[@id='account-login']")
    //@FindBy(id = "account-login") private WebElement loginHome;
    @FindBy(xpath = "//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
    private WebElement loginHome;


    //Actions
    public void seteMailAddress(String eMailAddress){
        eMailAddressEle.sendKeys(eMailAddress);
    }

    public void setPassword(String password){
        passwordEle.sendKeys(password);
    }

    public void clickOnLogin(){
        btnloginEle.click();
    }

    public void clickOnLoginHome(){
        loginHome.click();
    }
}
