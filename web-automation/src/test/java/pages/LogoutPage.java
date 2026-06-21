package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    private WebDriver driver;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileTab =
            By.cssSelector("[data-testid='tabbar-profile']");

    private By logoutButton =
            By.xpath("//*[contains(text(),'Log Out')]");

    private By landingPageText =
            By.xpath("//*[contains(text(),'Satu klik untuk investasi reksa dana')]");

    public void clickProfileTab() {

        driver.findElement(profileTab).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.urlContains("/profile")
        );

        System.out.println("Profile page opened");
    }

    public void scrollToLogout() {

        By logoutButton = By.xpath("//*[contains(text(),'Log Out')]");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 20; i++) {

            // cek dulu apakah sudah ada
            if (driver.findElements(logoutButton).size() > 0) {

                js.executeScript(
                        "arguments[0].scrollIntoView({block: 'center'});",
                        driver.findElement(logoutButton)
                );

                System.out.println("Logout ketemu & di-scroll");
                return;
            }

            driver.switchTo().activeElement().sendKeys(org.openqa.selenium.Keys.PAGE_DOWN);

            js.executeScript("window.scrollBy(0, 200)");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        throw new RuntimeException("Logout button benar-benar tidak ditemukan (DOM belum ke-render atau beda locator)");
    }

    public void clickLogoutButton() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        logoutButton
                )
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        logoutButton
                )
        ).click();

        System.out.println("Logout clicked");
    }

    public boolean isLandingPageDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(
                ExpectedConditions.urlToBe("https://app.bibit.id/")
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        landingPageText
                )
        ).isDisplayed();
    }
}