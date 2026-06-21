package stepdefinitions;

import utils.SessionState;
import hooks.Hooks;

import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.ExplorePage;
import pages.LoginPage;
import pages.LogoutPage;

import javax.swing.JOptionPane;
import java.time.Duration;

public class BibitSteps {

    private LoginPage getLoginPage() {
        return new LoginPage(Hooks.driver);
    }

    private ExplorePage getExplorePage() {
        return new ExplorePage(Hooks.driver);
    }

    private LogoutPage getLogoutPage() {
        return new LogoutPage(Hooks.driver);
    }

    // =========================
    // 🔥 LOGIN GATE (STABLE)
    // =========================
    private void ensureLogin() {

        if (SessionState.isLoggedIn) {
            System.out.println("Skip login - session active");
            return;
        }

        Hooks.driver.get("https://app.bibit.id/login");

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[type='tel']")
        ));

        LoginPage login = getLoginPage();

        login.enterPhoneNumber("08995429902");
        login.clickLoginButton();

        JOptionPane.showMessageDialog(
                null,
                "Selesaikan OTP + PIN sampai dashboard, lalu klik OK"
        );

        // 🔥 stabilisasi setelah login manual
        wait.until(driver ->
                driver.getCurrentUrl().contains("app.bibit.id")
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[data-testid='tabbar-explore']")
        ));

        SessionState.isLoggedIn = true;

        System.out.println("🚀 LOGIN SUCCESS");
    }

    
    // =========================
    // STEPS
    // =========================

    @Given("User opens Bibit login page")
    public void userOpensBibitLoginPage() {
        ensureLogin();
    }

    @When("User clicks Explore tab")
    public void userClicksExploreTab() {
        getExplorePage().clickExploreTab();
    }

    @Then("Explore page should be displayed")
    public void explorePageShouldBeDisplayed() {
        Assert.assertTrue(getExplorePage().isExplorePageDisplayed());
    }

    @When("User searches investment product {string}")
    public void userSearchesInvestmentProduct(String product) {
        getExplorePage().clickSearchField();
        getExplorePage().searchProduct(product);
    }

    @And("User selects EMAS product")
    public void userSelectsEmasProduct() {
        getExplorePage().selectEmasProduct();
    }

    @Then("Buy button should be displayed")
    public void buyButtonShouldBeDisplayed() {
        Assert.assertTrue(getExplorePage().isBuyButtonDisplayed());
    }

    @And("User waits for {int} seconds")
    public void userWaitsForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000L);
    }

    @And("User navigates back to Explore page")
    public void userNavigatesBackToExplorePage() {
        getExplorePage().clickBackButton();
    }

    @And("User navigates back to Home page")
    public void userNavigatesBackToHomePage() {
        getExplorePage().clickBackButton();
    }

    @When("User clicks Profile tab")
    public void userClicksProfileTab() {
        getLogoutPage().clickProfileTab();
    }

    @And("User scrolls down")
    public void userScrollsDown() {
        getLogoutPage().scrollToLogout();
    }

    @And("User clicks Logout button")
    public void userClicksLogoutButton() {
        getLogoutPage().clickLogoutButton();
    }

    @Then("User should be redirected to landing page")
    public void userShouldBeRedirectedToLandingPage() {
        Assert.assertTrue(getLogoutPage().isLandingPageDisplayed());
    }
}