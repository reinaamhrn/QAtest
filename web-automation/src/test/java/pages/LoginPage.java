package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginMenu =
            By.xpath("//a[@href='https://app.bibit.id/login']");

    private By phoneNumberField =
            By.cssSelector("input[type='tel']");

    private By loginButton =
        By.cssSelector("[data-testid='login-btn-login']");

    private By lanjutButton =
        By.cssSelector("button[data-content='Lanjut']");

    private By dashboard =
        By.xpath("//div[normalize-space()='Reksa Dana']");


    public void clickLoginMenu() {

        System.out.println("Klik menu login");

        driver.findElement(loginMenu).click();
    }

    public boolean isLoginPageDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        phoneNumberField
                )
        );

        return true;
    }

    public void enterPhoneNumber(String phoneNumber) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneNumberField)
        );

        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickLoginButton() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        ).click();
    }

    public boolean isOTPPageDisplayed() {

        System.out.println("Current URL = " + driver.getCurrentUrl());

        return driver.getPageSource()
                .contains("Kode Verifikasi");
    }

    public void handleAlertPopup() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            System.out.println("Alert text: " + alert.getText());

            alert.accept();

            // tunggu halaman stabil setelah alert ditutup
            wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete'"));

        } catch (Exception e) {
            System.out.println("No alert appeared");
        }
    }

    public void clickLanjutButton() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(
            ExpectedConditions.elementToBeClickable(
                lanjutButton
            )
        ).click();
    }

    public void waitUntilDashboardLoaded() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        dashboard
                )
        );
    }
}