package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import utils.factory.DriverFactory;

import java.time.temporal.ChronoUnit;

public class VerifyAPOIScreen extends BaseScreen {

    private VerifyAPOIScreen() {
        initializePage(this);
    }

    public static VerifyAPOIScreen INSTANCE() {
        return new VerifyAPOIScreen();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Edit Category\"]/XCUIElementTypeButton[@name=\"Edit\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editPOIDetailsBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Edit Category\"]/XCUIElementTypeButton[@name=\"Edit\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editBusinessHoursBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Suggested section to change\"]/parent::*/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvDialogTitle")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Suggested section to change\"]/parent::*/XCUIElementTypeStaticText[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiStatus;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Suggested section to change\"]/parent::*/XCUIElementTypeStaticText[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement categoryNameInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Preview\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement previewPhotoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Preview\"]/parent::*/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiPhoto;

    @iOSXCUITFindBy(xpath = "//*[contains(@text, 'Not Now')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement notNowSiri;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnClose")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement closeBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Name of the Place\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath="//*[@resource-id='com.sheelafoam.quadrant.staging:id/ltLocationName']//android.widget.TextView[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nameOfThePlaceInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"House / Building Number\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/ltHouseNumber']//android.widget.TextView[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement houseBuildingNumberInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Floor / Unit Number\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath="//*[@resource-id='com.sheelafoam.quadrant.staging:id/ltFloorNumber']//android.widget.TextView[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement floorUnitNumberInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Edit POI\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editPOIBtn;

    @iOSXCUITFindBy(accessibility = "Reject")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement rejectBtn;

    @iOSXCUITFindBy(accessibility = "Approve")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement approveBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select Category\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement selectCategory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Other Names of the POI\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otherNameOfPOICxb;

    @iOSXCUITFindBy(accessibility = "Submit Edited POI")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitEditedPOIBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Submit Edited POI\"])[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement confirmSubmitEditedPOIBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Est. eQUAD rewards =\"]/parent::*/XCUIElementTypeStaticText[4]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement equadRewardsValue;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekdays (Mon-Fri)\"]/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailWeekdaysRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Everyday (Mon-Sun)\"]/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailEverydayRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekends (Sat-Sun)\"]/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailWeekendsRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select days manually\"]/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailSelectManuallyRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Same opening hours everyday\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sameOpeningHoursEverydayRdb;

    public void selectCaTegory(String category, String subcategory) {
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + category + "']")).click();
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + subcategory + "']")).click();
    }
}
