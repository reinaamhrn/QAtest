package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorePage {

    private WebDriver driver;

    public ExplorePage(WebDriver driver) {
        this.driver = driver;
    }

    private By exploreTab =
            By.cssSelector("[data-testid='tabbar-explore']");

    private By searchField =
            By.xpath("//p[contains(text(),'Cari produk investasi')]");
    
    private By searchInput =
            By.cssSelector("input.custom-input-search");

    private By emasOption =
            By.xpath("//div[@type='body2' and contains(normalize-space(),'EMAS')]");

    private By buyButton =
            By.cssSelector("[data-testid='stock-explore-action-buy']");

    public void clickExploreTab() {

        driver.findElement(exploreTab).click();

        System.out.println("Klik Explore");

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        searchField
                )
        );
    }

    public boolean isExplorePageDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        searchField
                )
        ).isDisplayed();
    }

    public void clickSearchField() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        searchField
                )
        ).click();

        System.out.println("Klik Search Field");
    }

    public void searchProduct(String productName) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement search =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                searchInput
                        )
                );

        search.sendKeys(productName);

        System.out.println("Search product: " + productName);
    }

    public void selectEmasProduct() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement emas =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                emasOption
                        )
                );

        emas.click();

        wait.until(
                ExpectedConditions.urlContains("/product/stock/EMAS")
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        buyButton
                )
        );

        System.out.println("Halaman EMAS berhasil terbuka");
    }

    public boolean isBuyButtonDisplayed() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        buyButton
                )
        ).isDisplayed();
    }

    public void clickBackButton() {

        driver.navigate().back();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}