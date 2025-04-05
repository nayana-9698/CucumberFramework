package org.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class registerPage extends basePage {


    //constructor
    public registerPage(WebDriver driver) {
        super(driver);
    }

    //locators

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement txtlastNameEle;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement txteMailEle;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement txtpasswordEle;
    @FindBy(xpath = "//input[@name='agree']")
    private WebElement btnagreeEle;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    private WebElement btncontinueEle;
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement txtfirstNameEle;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement yourAccountHasBeenCreated;



    //actions
    public void setFirstname(String firstname){
        txtfirstNameEle.sendKeys(firstname);
    }
    public void setLastname(String lastname){
        txtlastNameEle.sendKeys(lastname);
    }
    public void setEmail(String email){
        txteMailEle.sendKeys(email);
    }
    public void setPassword(String password){
        txtpasswordEle.sendKeys(password);
    }

    public void clickOnAgree(){
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(btnagreeEle)).click();*/

        Actions actions = new Actions(driver);
        actions.moveToElement(btnagreeEle).click().perform();
    }

    public void clickOnContinue(){
        btncontinueEle.click();
    }

    public String getMessage(){
        return yourAccountHasBeenCreated.getText();
    }


}
