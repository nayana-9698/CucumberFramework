package org.example.PageInitializer;

import org.example.utils.driverFactory;
import org.openqa.selenium.WebDriver;

import org.example.PageObject.*;
import org.example.StepDefinition.hooks;

import org.example.utils.driverFactory;
import org.openqa.selenium.WebDriver;

public class pageInitializer {

    protected WebDriver driver;

    protected hooks hooks;
    protected org.example.PageObject.homePage homePage;
    protected org.example.PageObject.accountPage accountPage;
    protected org.example.PageObject.loginPage loginPage;



    public pageInitializer() {
        this.driver = driverFactory.getDriver();

        // Init once, not in every step def
        hooks = new hooks();
        homePage = new homePage(driver);
        accountPage = new accountPage(driver);
        loginPage = new loginPage(driver);

    }
}
