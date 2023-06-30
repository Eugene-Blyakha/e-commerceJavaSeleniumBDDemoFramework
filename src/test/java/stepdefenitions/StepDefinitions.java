package stepdefenitions;

import constants.EndPoint;
import constants.EndPointConstants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;
import factory.DriverFactory;

import java.util.List;
import java.util.Map;

public class StepDefinitions {

    private WebDriver driver;

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPoint.STORE.endPointUrl);
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String productName) {
       new StorePage(driver).addToCart(productName);


    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @Given("I'm a guest  customer")
    public void i_m_a_guest_customer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(EndPointConstants.STORE);
    }
    @And("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }
    @And("I'm on the Checkout page")
    public void i_m_on_the_checkout_page() {
        new CartPage(driver).checkout();
    }
    @When("I provide billing details")
    public void i_provide_billing_details(List<Map<String, String>> billingDetails) {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        //checkoutPage.enterBillingFirstName(billingDetails.get(0).get("firstname"));
        checkoutPage.setBillingDetails(
                billingDetails.get(0).get("firstname"),
                billingDetails.get(0).get("lastname"),
                billingDetails.get(0).get("address_line1"),
                billingDetails.get(0).get("city"),
                billingDetails.get(0).get("state"),
                billingDetails.get(0).get("zip"),
                billingDetails.get(0).get("email")
        );
    }
    @When("I place an order")
    public void i_place_an_order() {
       new CheckoutPage(driver).placeOrder();
    }

    @Then("The order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        Assert.assertEquals("Thank you. Your order has been received.",
                new CheckoutPage(driver).getNotice());
    }








    @Given("I'm smart")
    public void iMSmart() {
        System.out.println("Im smart - method implemented");
    }
    @When("I do smart things")
    public void iDoSmartThings() {
        System.out.println("I do smart things - method implemented");
    }
    @Then("Good things happen")
    public void goodThingsHappen() {
        System.out.println("Good things happen - method implemented");
    }
}
