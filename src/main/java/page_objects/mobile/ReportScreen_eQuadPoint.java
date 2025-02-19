package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import utils.Config;
import utils.factory.DriverFactory;
import utils.factory.DriverUtils;

import java.time.temporal.ChronoUnit;

public class ReportScreen_eQuadPoint extends BaseScreen {

    private ReportScreen_eQuadPoint() {
        initializePage(this);
    }

    public static ReportScreen_eQuadPoint INSTANCE() {
        return new ReportScreen_eQuadPoint();
    }

    @iOSXCUITFindBy(accessibility = "Go Down")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_spinner")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement filterByDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name, 'Last')]/parent::*/XCUIElementTypeStaticText[7]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rvWalletTransactions']/android.widget.RelativeLayout[1]//*[@resource-id='com.sheelafoam.quadrant.staging:id/tvDate']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstRecordCreatedDate;

    public void selectFilterByType(String type) {
        filterByDropdown.click();
        DriverUtils.waitForAWhile(1, "Wait for opening");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + type + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '" + type + "')]")).click();
        }
    }

    public boolean isNoRecordPresent() {
        try {
            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                return DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"You don’t have any  eQUAD yet\"]")).isDisplayed();
            } else {
                return DriverFactory.getAndroidDriver().findElement(By.id("com.sheelafoam.quadrant.staging:id/tv_empty")).isDisplayed();
            }
        } catch (Exception e) {
            return false;
        }
    }


}
