package utils.factory;

import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Config;

import java.util.HashMap;

import static utils.Config.BS_APP_URL;

public class PredefineCap {

    public static final DesiredCapabilities DESKTOP_WEB = new DesiredCapabilities() {
        {
            setBrowserName("Chrome");
        }
    };

    public static final DesiredCapabilities ANDROID = new DesiredCapabilities() {
        {
            setCapability("automationName", "UiAutomator2");
            setCapability("platformName", "Android");
            setCapability("platformVersion", "12.0");
            setCapability("deviceName", "emulator-5554");
            setCapability("autoGrantPermissions", "true");
            setCapability("autoAcceptAlerts", "true");
            setCapability("appPackage", "com.appen.mobile.integration");
            setCapability("appActivity", "com.appen.mobile.MainActivity");
//            setCapability("disableIdLocatorAutocompletion", true);
        }
    };

    public static final DesiredCapabilities IOS = new DesiredCapabilities() {
        {
            setCapability("automationName", "XCUITest");
            setCapability("platformName", "iOS");
//            setCapability("bundleId", "io.quadrant.GeoappStaging");
            setCapability("platformVersion", "16.4");
            setCapability("deviceName", "iPhone 14 Pro");
            setCapability("autoGrantPermissions", "true");
            setCapability("autoAcceptAlerts", "true");
//            setCapability("fullReset", "true");
//            setCapability("noReset", "false");

        }
    };

    public static final DesiredCapabilities BS_ANDROID = new DesiredCapabilities() {
        {
            setCapability("browserstack.appium_version", "1.22.0");
            setCapability("automationName", "UiAutomator2");
            setCapability("device", "Samsung Galaxy S23 Ultra");
            setCapability("project", "Geolancer");
            setCapability("build", Config.BS_BUILD_NAME);
            setCapability("browserstack.idleTimeout", "300");
            setCapability("os_version", "13.0");
            setCapability("app", Config.BS_APP_URL);
//            setCapability("autoDismissAlerts", "true");
            setCapability("autoAcceptAlerts", "true");
            setCapability("noReset", "false");
//            setCapability("deviceOrientation", "landscape");
            setCapability("autoGrantPermissions", "true");
            setCapability("browserstack.enableCameraImageInjection", "true");
            setCapability("browserstack.gpsLocation", Config.countryLocation());
            setCapability("browserstack.networkLogs", true);
        }
    };

    public static final DesiredCapabilities BS_IOS = new DesiredCapabilities() {
        {
            setCapability("browserstack.appium_version", "1.22.0");
            setCapability("automationName", "XCUITest");
            setCapability("build", Config.BS_BUILD_NAME);
            setCapability("device", "iPhone 14 Pro Max");
            setCapability("project", "Geolancer");
            setCapability("browserstack.idleTimeout", "300");
            setCapability("os_version", "16");
//            setCapability("autoDismissAlerts", "true");
            setCapability("autoAcceptAlerts", "true");
            setCapability("autoGrantPermissions", "true");
            setCapability("app", Config.BS_APP_URL);
            setCapability("browserstack.enableCameraImageInjection", "true");
            setCapability("browserstack.gpsLocation", Config.countryLocation());
            setCapability("browserstack.networkLogs", true);
        }
    };
}
