package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.DriverManager;

import java.net.URL;

public class Hooks {

    @Before
    public void setup() throws Exception {

        // ======================
        // CAPABILITIES
        // ======================
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");

        // Appium 2 style caps (WAJIB pakai appium:)
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:udid", "emulator-5554");

        // APK PATH
        caps.setCapability(
                "appium:app",
                "/Users/farhan/Downloads/mda-2.2.0-25.apk"
        );

        // OPTIONAL STABILITY
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:fullReset", true);
        caps.setCapability("appium:autoGrantPermissions", true);

        // ======================
        // START DRIVER
        // ======================
        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                caps
        );

        DriverManager.setDriver(driver);

        System.out.println("Appium Driver Started");
    }
}