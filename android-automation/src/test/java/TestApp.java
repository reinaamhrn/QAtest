import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class TestApp {

    public static void main(String[] args) throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");

        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("udid", "emulator-5554");

        caps.setCapability("app", "/Users/farhan/Downloads/mda-2.2.0-25.apk");

        // ⚠️ penting: jangan pakai full reset dulu
        caps.setCapability("noReset", true);
        caps.setCapability("autoGrantPermissions", true);

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                caps
        );

        System.out.println("🔥 APP LAUNCHED");

        // ⛔ jangan langsung close
        Thread.sleep(30000);

        driver.quit();
    }
}