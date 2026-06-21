package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CheckoutPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ======================
    // FILL SHIPPING ADDRESS
    // ======================
    public void fillAddress() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/fullNameET")
        )).sendKeys("Mira Reina Maharani");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/address1ET"))
                .sendKeys("Jl. Sudirman No 1");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/address2ET"))
                .sendKeys("Apartment 12B");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cityET"))
                .sendKeys("Jakarta");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/stateET"))
                .sendKeys("DKI Jakarta");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/zipET"))
                .sendKeys("12345");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/countryET"))
                .sendKeys("Indonesia");
    }

    // ======================
    // PROCEED TO PAYMENT
    // ======================
    public void proceedToPayment() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")
        )).click();

        // 🔥 WAIT PAGE READY
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/cardNumberET")
        ));
    }

    // ======================
    // PAYMENT FORM
    // ======================
    public void fillPayment() {

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/nameET"))
                .sendKeys("Mira Reina Maharani");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cardNumberET"))
                .sendKeys("4111111111111111");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/expirationDateET"))
                .sendKeys("12/30");

        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/securityCodeET"))
                .sendKeys("123");
    }

    // ======================
    // REVIEW ORDER
    // ======================
    public void reviewOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/paymentBtn")
        )).click();

        // 🔥 WAIT PAGE Review your order
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/enterShippingAddressTV")
        ));
    }

    // ======================
    // PLACE ORDER
    // ======================
    public void placeOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Completes the process of checkout']")
        )).click();
    }

    // ======================
    // CONTINUE SHOPPING
    // ======================
    public void continueShopping() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Tap to open catalog']")
        )).click();

        // wait balik ke product page
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/productTV")
        ));
    }
}