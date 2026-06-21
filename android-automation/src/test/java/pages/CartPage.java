package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public CartPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ======================
    // OPEN CART
    // ======================
    public void openCart() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/cartIV")
        )).click();

        // wait cart page ready
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//android.widget.Button[contains(@content-desc,'checkout')]")
        ));
    }

    // ======================
    // CLICK CHECKOUT
    // ======================
    public void checkout() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.Button[@content-desc='Confirms products for checkout']")
        )).click();

        // wait masuk checkout page
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("com.saucelabs.mydemoapp.android:id/checkoutTitleTV")
        ));
    }
}