//package org.example.StepDefinition;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Then;
//import org.example.PageInitializer.pageInitializer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.example.context.testContext;
//import org.example.PageObject.searchResultsPage;
//import org.example.PageObject.productPage;
//
//import java.util.List;
//
//public class productStepDef extends pageInitializer {
//
//    public static Logger logger = LogManager.getLogger(productStepDef.class);
//    private final testContext context;
//
//    public productStepDef(testContext context) {
//        this.context = context;
//    }
//
//    @Then("the user adds the following products to the cart:")
//    public void the_user_adds_the_following_products_to_the_cart(DataTable dataTable) {
//
//        List<String> products = dataTable.asList();
//        context.set("cartItems", products);
//
//        for (String product : products) {
//            homePage.searchProduct(product);
//            searchResultsPage.clickOnProduct(product);
//            productPage.addToCart();
//
//            // Optional: Navigate back to homepage before next iteration
//            driver.get(hooks.getConfigValue("url"));
//        }
//    }
//}
