package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import utils.Config;
import utils.factory.DriverFactory;

import java.time.temporal.ChronoUnit;

public class MapScreen extends BaseScreen {

    private MapScreen() {
        initializePage(this);
    }

    public static MapScreen INSTANCE() {
        return new MapScreen();
    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Application Permission\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement applicationPermissiom;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Skip for now\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement skipWalletSetup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Your First POI\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addYourFirstPOI;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Learn More\"]/parent::XCUIElementTypeOther/XCUIElementTypeButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement closeAds;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add POI\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/action_add_poi")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addPOI;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"Regular POI\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement selectRegular;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/button_continue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueCollection;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"   \"]/parent::*/XCUIElementTypeButton[4]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnMapRefresh")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement refreshBtn;

    @iOSXCUITFindBy(accessibility = "Report")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ReportFragment")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement reportBtn;

    public void selectCampaignTypeList(String type) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + type + "']/parent::*/XCUIElementTypeImage[@name=\"circle\"]")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RadioButton[@text='" + type + "']")).click();
        }
    }

}
