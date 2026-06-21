package stepdefinitions;

import io.cucumber.java.en.*;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.DriverManager;

import java.time.Duration;

public class AndroidSteps {

    AndroidDriver driver;
    WebDriverWait wait;

    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public AndroidSteps() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver, wait);
        productPage = new ProductPage(driver, wait);
        cartPage = new CartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
    }

    @Given("user is on product page")
    public void user_is_on_product_page() {
        productPage.verifyProductList();
    }

    @When("user login from menu")
    public void user_login_from_menu() {
        loginPage.loginFlow();
    }

    @When("user selects product Sauce Labs Backpack")
    public void user_selects_product() {
        productPage.selectProduct();
    }

    @When("user configures product and add to cart")
    public void user_configures_product_and_add_to_cart() {
        productPage.selectColorBlue();
        productPage.increaseQty();
        productPage.addToCart();
    }

    @When("user opens cart and checkout")
    public void user_opens_cart_and_checkout() {
        cartPage.openCart();
        cartPage.checkout();
    }

    @When("user completes checkout process")
    public void user_completes_checkout_process() {
        checkoutPage.fillAddress();
        checkoutPage.proceedToPayment();
        checkoutPage.fillPayment();
        checkoutPage.reviewOrder();
        checkoutPage.placeOrder();
        checkoutPage.continueShopping();
    }

    @When("user returns to product page")
    public void user_returns_to_product_page() {
        productPage.verifyProductList();
    }

    @When("user sorts product by name descending")
    public void user_sort_name_desc() {
        productPage.sortNameDesc();
    }

    @When("user sorts product by price ascending")
    public void user_sort_price_asc() {
        productPage.sortPriceAsc();
    }

    @Then("product list should be displayed")
    public void product_list_should_be_displayed() {
        productPage.verifyProductList();
    }
}