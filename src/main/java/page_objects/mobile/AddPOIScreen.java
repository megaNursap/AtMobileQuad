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

public class AddPOIScreen extends BaseScreen {
    public static String androidPoiName;
    public static String eQuadCollector;
    public static String eQuadVerifier;

    private AddPOIScreen() {
        initializePage(this);
    }

    public static AddPOIScreen INSTANCE() {
        return new AddPOIScreen();
    }


    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowPhotoVideoWhileUsingTheApp;

    @AndroidFindBy(xpath ="//android.widget.RadioButton[@text='Regular POI']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement regularPOICampaignType;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_one_time_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowPhotoVideoOnlyThisTime;

    @AndroidFindBy(id="com.android.permissioncontroller:id/permission_deny_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowPhotoVideoDontAllow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select Category\"]")
    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/etDropdown")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement selectCategory;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/etSearchMulti")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement seacrhCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Coffee Shops\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement coffeeShop;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Education\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Education\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement educationCategory;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Beauty Clinic/ Center\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Elementary School\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement educationSubCategory;

    @iOSXCUITFindBy(accessibility = "Continue")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/button_continue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnContinue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continuePhotoBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnCloseSheet")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement closePhotoBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnBack")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backPhotoBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/action_bar_root")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement barRoot;

    @iOSXCUITFindBy(accessibility = "Take Photos")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takePhotoBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='TAKE A PICTURE']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takePhotoBtn2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Geo Beta\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement photoCaptureOnRealDevice;

    @iOSXCUITFindBy(accessibility = "Use Photo")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement usePhotoOnRealDevice;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[starts-with(@name, 'Photo')][5]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstPhotoFromLibrary;

//    @AndroidFindBy(id="com.android.camera2:id/shutter_button")
    @AndroidFindBy(xpath = "com.sheelafoam.quadrant.staging:id/btnTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement shutterPhotoButton;

    @AndroidFindBy(xpath ="//*[contains(@text, 'OK')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement OkBtn;

    @AndroidFindBy(id="com.android.camera2:id/done_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement donePhotoBtn;

    @AndroidFindBy(id= "com.sheelafoam.quadrant.staging:id/btnRight")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement rightContinueBtn;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/tvLeft")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement btnLeftBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement okBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeImage[4]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement photoImage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Name of the Place\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/editTextMain")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nameOfThePlaceTxb;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Another Synonym']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement anotherSynonym;

    @AndroidFindBy(xpath="//android.widget.EditText[@text='E.g. McDonalds known as Macs']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement synField1;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement synField2;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement synField3;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement synField4;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement synField5;

    @AndroidFindBy(xpath="//android.widget.EditText[@text='Enter building name']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement buildingName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Other Names of the POI\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otherNameOfPOICxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Name of the Street\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='e.g. #24 Hyong Street']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nameOfTheStreetTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"House / Building Number\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='e.g., 22, 13B, 123-125, N/A']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement houseBuildingNumberTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Door Number\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement doorNumberCxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Door Number\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='E.g. 122A']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement doorNumberTxb;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Only alphanumeric and \"#/-\" symbols are allowed']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement doorNumberTxbErrorAlphanumeric;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Floor / Unit Number\"]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/checkboxNA")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement floorUnitNumberNACxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Floor / Unit Number\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='e.g., GF, 1F, 5, #02-14']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement floorUnitNumberTxb;

    @AndroidFindBy(id= "com.sheelafoam.quadrant.staging:id/takePhotoCheckbox")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement photoOfOpeningHoursNACbx;

    @AndroidFindBy(id= "com.sheelafoam.quadrant.staging:id/rlTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement openingHoursTakePhoto;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Only alphanumeric and \"-\" symbols are allowed']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement floorTxbErrorAlphanumeric;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"City\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Choose city']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cityDropdown;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Vstack List\"]//XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/etSearch")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement citySearch;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView[@name=\"List\"]/XCUIElementTypeCell[1]//XCUIElementTypeButton")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cityFirstRow;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Aceh Barat -- Aceh']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement acehBarat;

    // postal code
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Postal Code\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.view.ViewGroup/android.widget.CheckBox")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement postalCodeCxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Postal Code\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Enter postal code']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement postalCodeTxb;

    // email
    @AndroidFindBy(xpath="//android.widget.EditText[@text='E.g. Starbucks@mail.co.id']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement contactEmail;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Email is not valid']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement contactEmailErrorNotValid;

    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.view.ViewGroup/android.widget.CheckBox]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement contactEmailCxb;

    // website
    @AndroidFindBy(xpath="//android.widget.EditText[@text='E.g. https://Starbucks.co.id']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement website;

    @AndroidFindBy(xpath="//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[6]/android.view.ViewGroup/android.widget.CheckBox")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement websiteCxb;

    // Phone Number
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Phone Number\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Enter phone number']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement phoneNumberTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Phone Number\"]/parent::XCUIElementTypeOther//XCUIElementTypeImage")
    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/checkboxNA")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement phoneNumberCxb;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/ivAction")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addPhoneNumber;

    @AndroidFindBy(xpath="//android.widget.EditText[@text='Additional Phone number']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement additionalPhoneNumber;

    // Social Media
    @AndroidFindBy(xpath="//android.widget.EditText[@text='select']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socialMediaDropDown;

    @AndroidFindBy(xpath="//android.widget.EditText[@text='']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedFieldEmpty;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Facebook']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedDropdown1;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/etSocmed")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedField1;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Instagram']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedDropdown2;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Twitter']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedDropdown3;

    @AndroidFindBy(xpath="//android.widget.TextView[@text='Other']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socmedDropdown4;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/tvTakeSocmed")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otherSocialMedia;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Social Media\"]/parent::XCUIElementTypeOther/XCUIElementTypeSwitch")
    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/checkboxSocMedNA")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement socialMediaCxb;

    // Additional Info
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"A1A893EB-0EF5-4F76-87F7-3C27DF9F0392\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Eg. \"Sheltered,Well-lit\"']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement additionalInfo1;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"64B8C9E4-D5C6-4FDD-9CE1-BFD8B7AA4ABF\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Eg. Nr Starbucks']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement additionalInfo2;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"7166768B-E21B-48F1-8724-18AAB6A92485\"]")
    @AndroidFindBy(xpath="//android.widget.EditText[@text='Eg. Pickup only']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement additionalInfo3;

    @AndroidFindBy(xpath="//android.widget.Button[@text='NEW DATA']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement newAdditionalInfo;

    // Business Hours
    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/rlTakePhoto")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takePhotoBusinessHours;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/takePhotoCheckbox")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement takePhotoBusinessHoursCxb;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/buttonRetake")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement retakePhotoBusinessHours;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Yes, they are on display\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourYes;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"No, they are not on display\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourNo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch/XCUIElementTypeSwitch")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourSwitchOnOff;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Take Photos button\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourAddPhotoBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/cbNaBusinessHours")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"N/A\"]/XCUIElementTypeImage")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailNACbx;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekdays (Mon-Fri)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Weekdays (Mon - Fri)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailWeekdaysRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Everyday (Mon-Sun)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Every day (Mon - Sun)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailEverydayRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weekends (Sat-Sun)\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Weekends (Sat - Sun)']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailWeekendsRdb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select days manually\"]")
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Customize days']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addBusinessHourDetailSelectManuallyRdb;

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

    // Submit
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnRight")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitPOIBtn;

    @iOSXCUITFindBy(accessibility = "Back To Map")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnRight")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backToMapBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnPositive")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitConfirmationBtn;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnNegative")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cancelSubmitBtn;

    @AndroidFindBy(id="android:id/button_once")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deeplinkJustOnce;

    @AndroidFindBy(id="android:id/button_once")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deeplinkAlways;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/tvEquadsEst")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement equadEstimation;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"You are about to SUBMIT a POI\"]/parent::XCUIElementTypeOther/XCUIElementTypeStaticText[4]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement equadNumber;


    /////////////////////
    // Verify POI
    /////////////////////
    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnEdit")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editPOI;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnFirstOption")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editAttributeOnly;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnSecondOption")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement editAttributeLocation;

    public void editAndroidNameOfThePlace(String currentPoiName, String newPoiName) {
        // edit POI name
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+currentPoiName+"']")).sendKeys(newPoiName);
        AddPOIScreen.androidPoiName = newPoiName;
    }

    public void editAndroidBuildingName(String oldBuildingName, String newBuildingName
    ) {
        // edit POI name
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldBuildingName+"']")).sendKeys(newBuildingName);
    }

    public void editAndroidStreetAddress(String oldStreetAddress, String newStreetAddress) {
        // edit address
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldStreetAddress+"']")).sendKeys(newStreetAddress);
    }

    public void editAndroidUnitNumber(String oldUnitNumber, String newUnitNumber) {
        // edit unit number
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldUnitNumber+"']")).sendKeys(newUnitNumber);
    }

    public void editAndroidFloor(String oldFloor, String newFloor) {
        // edit Category
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldFloor+"']")).sendKeys(newFloor);
    }

    public void editAndroidPostalCode(String oldPostalCode, String newPostalCode) {
        // edit postal code
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldPostalCode+"']")).sendKeys(newPostalCode);
    }

    public void editAndroidEmail(String oldEmail, String newEmail) {
        // edit email
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldEmail+"']")).sendKeys(newEmail);
    }

    public void editAndroidWebsite(String oldWebsite, String newWebsite) {
        // edit website
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldWebsite+"']")).sendKeys(newWebsite);
    }

    public void editAndroidSocMed(String oldSocMed1,
                          String newSocMed1,
                          String oldSocMed2,
                          String newSocMed2,
                          String oldSocMed3,
                          String newSocMed3,
                          String oldSocMed4,
                          String newSocMed4
                          ) {
        DriverUtils.waitForAWhile(1, "Wait rotate");
        // edit social media
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldSocMed1+"']")).sendKeys(newSocMed1);
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldSocMed2+"']")).sendKeys(newSocMed2);
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldSocMed3+"']")).sendKeys(newSocMed3);
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldSocMed4+"']")).sendKeys(newSocMed4);

    }

    public void editAndroidAdditionalInfo(String oldAddInfo1,
                          String newAddInfo1,
                          String oldAddInfo2,
                          String newAddInfo2,
                          String oldAddInfo3,
                          String newAddInfo3
                          ) {
        DriverUtils.waitForAWhile(1, "Wait rotate");
        // edit additional info 1
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldAddInfo1+"']")).sendKeys(newAddInfo1);
        // edit additional info 2
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldAddInfo2+"']")).sendKeys(newAddInfo2);
        // edit additional info 3
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldAddInfo3+"']")).sendKeys(newAddInfo3);
    }

    public void editAndroidPhoneNumber( String oldPhoneNUmber1, String newPhoneNumber1){
        DriverUtils.waitForAWhile(2, "Wait rotate");
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.EditText[@text='"+oldPhoneNUmber1+"']")).sendKeys(newPhoneNumber1);
        DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.ImageView[@index='2']")).click();
    }


    public void selectCaTegory(String category, String subcategory) {
        DriverUtils.waitForAWhile(2, "Wait rotate");
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + category + "']")).click();
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + subcategory + "']")).click();
    }

    public void selectCampaignTypeList(String type) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + type + "']/parent::*/XCUIElementTypeImage[@name=\"circle\"]")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RadioButton[@text='" + type + "']")).click();
        }
    }

    public void selectSocialMedia(String type, String link) {
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + type + "']")).click();
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name='" + link + "']")).click();
    }


}
