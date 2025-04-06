package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.PageInitializer.pageInitializer;
import org.example.PageObject.accountPage;
import org.example.PageObject.homePage;
import org.example.PageObject.loginPage;
import org.example.utils.driverFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class loginStepDef extends pageInitializer {

    public static Logger logger = LogManager.getLogger(loginStepDef.class);

//    hooks hooks = new hooks();
//    WebDriver driver = driverFactory.getDriver();
//    loginPage loginPage = new loginPage(driver);
//    homePage homePage = new homePage(driver);
//    accountPage ap = new accountPage(driver);

    @Given("As a user I want to launch to the application")
    public void as_a_user_i_want_to_login_to_the_application() {
        //driver.get("https://tutorialsninja.com/demo");
        driver.get(hooks.getConfigValue("url"));
        logger.info("Opencart application launched successfully");

    }

    @And("I need to click on Login link")
    public void iNeedToClickOnLoginLink() throws InterruptedException {
        homePage.clickOnMyAccount();
        Thread.sleep(3000);
        homePage.clickOnLoginHome();
        logger.info("I am able to click on login link");
    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username() {
        loginPage.seteMailAddress(hooks.getConfigValue("username"));
        logger.info("I am able to enter email address");

    }
    @When("I enter a valid password")
    public void i_enter_a_valid_password() throws InterruptedException {
        loginPage.setPassword(hooks.getConfigValue("password"));
        logger.info("I am able to enter password");
        Thread.sleep(2000);

    }
    @Then("I should login successfully")
    public void i_should_login_successfully() {
//        boolean Actualvalue = ap.isMyAccount();
//        Assert.assertTrue(Actualvalue);

        loginPage.clickOnLoginHome();

        String CurrentURL = driver.getCurrentUrl();
        if(CurrentURL.contains("account/account")){
            org.junit.Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
        logger.info("we are verifying login is success or not");

    }


    @And("I enter a Invalid password")
    public void iEnterAInvalidPassword() {
        loginPage.setPassword(hooks.getConfigValue("wrongPassword"));
    }

    @Then("I should click on login")
    public void iShouldClickOnLogin() {
        loginPage.clickOnLoginHome();
        String CurrentURL = driver.getCurrentUrl();
        if(CurrentURL.contains("account1234")){
            org.junit.Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
    }

    @When("user enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
        loginPage.seteMailAddress(email);
        loginPage.setPassword(password);
    }

    @Then("the login {string} should be displayed")
    public void theLoginShouldBeDisplayed(String expectedResult) {

        switch (expectedResult) {
            case "success":
                Assert.assertTrue(accountPage.isMyAccount());
                break;
            case "login error":
//                Assert.assertTrue(loginPage.getWarningMessage().contains("No match for E-Mail Address and/or Password."));
//                break;
        }
    }

}

