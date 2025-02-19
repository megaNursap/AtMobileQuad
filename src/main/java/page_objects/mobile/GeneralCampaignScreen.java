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

public class GeneralCampaignScreen extends BaseScreen {

    private GeneralCampaignScreen() {
        initializePage(this);
    }

    public static GeneralCampaignScreen INSTANCE() {
        return new GeneralCampaignScreen();
    }

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/button_continue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    @iOSXCUITFindBy(accessibility = "continue button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueBtn;

    @iOSXCUITFindBy(accessibility = "Submit")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitBtn;

    @iOSXCUITFindBy(accessibility = "Get Started")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getStartedBtn;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnOk")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement popUpCampOkBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"location_name\"]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"location_name\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nameOfTheStreetTxb;

    @iOSXCUITFindBy(accessibility = "Please choose category")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/etDropdown")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement categoryDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"City\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/spinnerMain")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cityDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"check 1\"]/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkbox1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"check 2\"]/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkbox2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"edit_text_checkbox\"]")
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"edit_text_checkbox\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkboxTextTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Friday\"]/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement fridayCbx;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Saturday\"]/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sarturdayCbx;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sunday\"]/XCUIElementTypeImage")
    @AndroidFindBy(xpath = "//android.widget.CheckBox[3]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sundayCbx;

    @AndroidFindBy(id= "com.sheelafoam.quadrant.staging:id/btnRight")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement rightContinueBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Please choose a category\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/spinnerMain")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement typeOfThePlaceDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView[@name=\"edit_text_MIP\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/editTextMain")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nameOfBusinessTxb;

    @iOSXCUITFindBy(accessibility = "Get Current Location")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_location")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getLocationBtn;

    @iOSXCUITFindBy(accessibility = "Multi Input Popup")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvAddLabel")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement multiInputPopUpBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"continue button\"])[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnAddItem")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addItemMultiPopupInputBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takeAPictureBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Take Photos\"])[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement multipleTakePhotoBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Take Photos\"])[3]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takePhotoBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Take Photos\"])[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvSingleTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement singleTakePhotoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"circle\"]")
    @AndroidFindBy(xpath = "//android.widget.RadioButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement unhideRdb;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement iCanNotFindThePlaceRdb;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[3]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement iFoundThePlaceButCanNotGetThereRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekdays (Mon-Fri)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Weekdays (Mon - Fri)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement openingHourWeekdaysRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Everyday (Mon-Sun)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Every day (Mon - Sun)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement openingHourEverydayRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekends (Sat-Sun)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Weekends (Sat - Sun)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement openingHourWeekendsRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Same opening hours everyday\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Same opening hours every day']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sameOpeningHoursEverydayRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Different times each day\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Different opening hours on some days']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement differentTimeEachDayRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Open 24 hours\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Open 24 hours']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement open24HoursRdb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvEquadsEst")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement equadEstimateNumber;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnPositive")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitConfirmationBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvUploading")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement uploadingIcon;

    public void selectCaTegory(String category, String subcategory) {
        categoryDropdown.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + category + "']")).click();
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + subcategory + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.TextView[@text='" + category + "']")).click();
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.TextView[@text='" + subcategory + "']")).click();
        }
    }

    public void selectCity(String city) {
        cityDropdown.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + city + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.TextView[@text='" + city + "']")).click();
        }
    }

    public void selectTypeOfThePlace(String category) {
        typeOfThePlaceDropdown.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + category + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.TextView[@text='" + category + "']")).click();
        }
    }

    public void selectNozzle(String nozzle) {
        typeOfThePlaceDropdown.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {

        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.TextView[@text='" + nozzle + "']")).click();
        }
    }
}
