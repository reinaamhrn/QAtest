package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage {

    AndroidDriver driver;
    WebDriverWait wait;

    public ProductPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ================= PRODUCT =================
    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().textContains(\"Sauce Labs Backpack\")" +
                        ".fromParent(new UiSelector().className(\"android.widget.ImageView\"))"
                )
        )).click();
    }

    public void selectColorBlue() {
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().description(\"Blue color\")")
        )).click();
    }

    public void increaseQty() {
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/plusIV")).click();
    }

    public void addToCart() {
        driver.findElement(By.id("com.saucelabs.mydemoapp.android:id/cartBt")).click();
    }

    // ================= SORT =================
    public void sortNameDesc() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/sortIV")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Name - Descending\")")
        )).click();
    }

    public void sortPriceAsc() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/sortIV")
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Price - Ascending\")")
        )).click();
    }

    public void verifyProductList() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\")"
                )
        ));
    }
}