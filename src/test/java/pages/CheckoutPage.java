package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

    @FindBy(id = "billing_first_name") private WebElement billingFirstNameFld;
    @FindBy(xpath = "//input[@id='billing_last_name']") private WebElement billingLastNameFld;
    @FindBy(xpath = "//input[@id='billing_address_1']") private WebElement billingAddressLineOneFld;
    @FindBy(xpath = "//input[@id='billing_city']") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "//input[@id='billing_postcode']") private WebElement billingZipFld;
    @FindBy(id = "//input[@id='billing_email']") private WebElement billingEmailFld;
    @FindBy(xpath = "//button[@id='place_order']") private WebElement placeOrderBtn;
    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']") private WebElement successNotice;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressLineOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        select.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(String billingFirstName, String billingLastName,
                                          String billingAddressLineOne, String billingCity,
                                          String billingStateName, String billingZip,
                                          String billingEmail){
        return (enterBillingFirstName(billingFirstName).
                enterBillingLastName(billingLastName).
                enterBillingAddressLineOne(billingAddressLineOne).
                enterBillingCity(billingCity)).
                selectBillingState(billingStateName).
                enterBillingEmail(billingEmail);
    }

    public CheckoutPage placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.elementToBeClickable(successNotice)).getText();
    }

}
