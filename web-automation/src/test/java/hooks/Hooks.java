package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {

        driver = DriverManager.getDriver();

        //driver.get("https://bibit.id");

        System.out.println("---Browser Started---");
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.manage().deleteAllCookies();
            DriverManager.quitDriver();
        }

        System.out.println("---Browser Closed---");
    }
}