package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page_objects.mobile.AddPOIScreen.*;
import utils.factory.DriverFactory;
import utils.factory.DriverUtils;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReportScreen extends BaseScreen {
    private ReportScreen() {
        initializePage(this);
    }

    public static ReportScreen INSTANCE() {
        return new ReportScreen();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"eQuad Points\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='eQUAD Points']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement equadPointTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NFTs\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='NFT']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"POI Status\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POI Status']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiStatusTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSegmentedControl/parent::*/XCUIElementTypeScrollView//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rvWalletTransactions']/android.widget.RelativeLayout[1]/*[@resource-id='com.sheelafoam.quadrant.staging:id/tvName']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement lastestPOIName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSegmentedControl/parent::*/XCUIElementTypeScrollView//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[5]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rvWalletTransactions']/android.widget.RelativeLayout[1]//*[@resource-id='com.sheelafoam.quadrant.staging:id/tvEquadAmount']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement lastestEquadPoint;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Approved\"]/parent::*/XCUIElementTypeStaticText[8]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/verified_count")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiApprovedCount;

    @iOSXCUITFindBy(accessibility = "POI(s) Created")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POI(s) Created']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiCreatedBtn;

    @iOSXCUITFindBy(accessibility = "POI(s) Approved")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POI(s) Approved']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiApprovedBtn;

    @iOSXCUITFindBy(accessibility = "POI(s) Rejected")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POI(s) Rejected']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiRejectedBtn;
}
