package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class searchResultsPage extends basePage{

    public searchResultsPage(WebDriver driver) {
        super(driver);
    }

    public static void clickOnProduct(String productName) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement productLink = driver.findElement(By.linkText(productName));
        Actions actions = new Actions(driver);
        actions.moveToElement(productLink).click().perform();


    }
}
