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

public class ReportScreen_NFTReport extends BaseScreen {

    private ReportScreen_NFTReport() {
        initializePage(this);
    }

    public static ReportScreen_NFTReport INSTANCE() {
        return new ReportScreen_NFTReport();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NFTs\"]/parent::*/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvNftNumbers")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftAmount;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"Info\"])[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ivIconInfoNft")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NFTs\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvBonus")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement bonusPercentage;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeImage[@name=\"Info\"])[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ivIconInfoBonus")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement bonusInfo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvHowToGetNFT")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement howToGetNFTLink;

    @iOSXCUITFindBy(accessibility = "Your Most Recent NFTs")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvMyLatestNft")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement lastNFTLabel;

    @iOSXCUITFindBy(accessibility = "View all NFTs")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvViewAllNfts")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement viewAllMyNFTLink;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"NFTs\"]/parent::*/XCUIElementTypeStaticText[8]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/imageView2")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftBonusLabel;

    @iOSXCUITFindBy(accessibility = "Click Here to Copy Your Wallet ID")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnCopyWalletAddress")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement copyWalletID;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Check Your Progress->\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvCheckProgress")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkProgressBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total NFTs\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_search_filter_header_value")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement totalNFTsNumber;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Search\"]/parent::*/XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/search_src_text")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement searchNFTsField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total NFTs\"]/parent::*/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sp_first_filter_placeholder")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement dateDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total NFTs\"]/parent::*/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sp_second_filter_placeholder")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement filterByDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[1]//*[@resource-id='com.sheelafoam.quadrant.staging:id/nft_name_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstNFTCardName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[1]//*[@resource-id='com.sheelafoam.quadrant.staging:id/nft_bonus_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstNFTBonusPercentage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[4]")
    @AndroidFindBy(xpath = "//androidx.cardview.widget.CardView[1]//*[@resource-id='com.sheelafoam.quadrant.staging:id/nft_description_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstNFTCardDescription;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total NFTs\"]/parent::*/XCUIElementTypeStaticText[5]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/nft_item_detail_title_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftDetailTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total NFTs\"]/parent::*/XCUIElementTypeStaticText[7]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/nft_item_detail_bonus_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nftDetailBonusPercentage;

    @iOSXCUITFindBy(accessibility = "Check on Opensea")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/nft_item_detail_check_on_opensea_btn")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkOnOpenseaBtn;

    public void selectDate(String date) {
        dateDropdown.click();
        DriverUtils.waitForAWhile(1, "Wait for opening");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + date + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '" + date + "')]")).click();
        }
    }

    public void selectFilterByType(String type) {
        filterByDropdown.click();
        DriverUtils.waitForAWhile(1, "Wait for opening");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + type + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.CheckedTextView[contains(@text, '" + type + "')]")).click();
        }
    }

    public boolean isToolTipDisplayedWithText(String text) {
        try {
            DriverFactory.getCurrentAppiumDriver().findElement(By.xpath("//*[@text='" + text + "']")).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRecordPresent() {
        try {
            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                return DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"You don’t have any  eQUAD yet\"]")).isDisplayed();
            } else {
                return DriverFactory.getAndroidDriver().findElement(By.xpath("//androidx.cardview.widget.CardView")).isDisplayed();
            }
        } catch (Exception e) {
            return false;
        }
    }

}
