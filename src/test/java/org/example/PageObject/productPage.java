package org.example.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class productPage extends basePage{

    public productPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "button-cart")
    static WebElement addToCartButton;

    public static void addToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCartButton).click().perform();
    }
}