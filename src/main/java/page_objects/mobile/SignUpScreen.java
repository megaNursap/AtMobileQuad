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

public class SignUpScreen extends BaseScreen {

    private SignUpScreen() {
        initializePage(this);
    }

    public static SignUpScreen INSTANCE() {
        return new SignUpScreen();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN UP\"]/parent::*/XCUIElementTypeTextField[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_first_name")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstNameTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN UP\"]/parent::*/XCUIElementTypeTextField[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_last_name")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement lastNameTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN UP\"]/parent::*/XCUIElementTypeTextField[4]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_email")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Please enter a valid email address.\"]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/til_signup_email']//*[@text='Invalid email address format']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement invalidEmailErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"User already exist with emailId.\"]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='User already exist with emailId.']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement existedEmailErrorMessage;

    @iOSXCUITFindBy(accessibility = "Please fill in the password")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement notFillPasswordErrorMessage;

    @iOSXCUITFindBy(accessibility = "Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character.")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/til_pwd']//*[@resource-id='com.sheelafoam.quadrant.staging:id/textinput_error']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement invalidPasswordErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Referral Code']")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_referral_code")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement referralCodeTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SIGN UP\"]/parent::*/XCUIElementTypeTextField[5]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_pwd")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordTxb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/cb_signup")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement agreeCbx;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnCancel")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement yesBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/text_input_end_icon")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement unHidePasswordIcon;

    @iOSXCUITFindBy(accessibility = "Sign Up")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_signup")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signUpBtn;

    @iOSXCUITFindBy(accessibility = "Back")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_signup_back")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Phone Number']")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_phone_num")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement phoneNumbTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Phone number is invalid\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_signup_country_error")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement invalidPhoneNumberErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Select Region\"]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/dropdown_signup_region']//*[@resource-id='com.sheelafoam.quadrant.staging:id/text_input_end_icon']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement regionDropdown;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"category search result selection\"])[2]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/item_dropdown_container'][2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstSelectionRegion;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Select City\"]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/dropdown_signup_city']//*[@resource-id='com.sheelafoam.quadrant.staging:id/text_input_end_icon']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cityDropdown;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"category search result selection\"])[1]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/item_dropdown_container'][1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstSelectionCity;

    @iOSXCUITFindBy(accessibility = "SIGN UP")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_signup_title")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signUpLabel;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_signup_continue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueBtn;

    @iOSXCUITFindBy(accessibility = "Resend Code")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_signup_resend_otp_code")
    @WithTimeout(time = 150, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resendOTPBtn;

    @iOSXCUITFindBy(accessibility = "Oops!\n" +
            "You have entered an invalid One-Time PIN. Please try again.")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement invalidOTPErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter 6-digit OTP code sent to email\"]/parent::*/XCUIElementTypeTextField")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otpTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter 6-digit OTP code sent to SMS\"]/parent::*/XCUIElementTypeTextField")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otpSMSTxb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_1")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp1Txb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_2")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp2Txb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_3")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp3Txb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_4")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp4Txb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_5")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp5Txb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_signup_otp_6")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otp6Txb;

    @iOSXCUITFindBy(accessibility = "Verify & Proceed")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_otp_verify")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement verifyAndProceedBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_get_started")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getStartedIcon;

    public void selectRegion(String region) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + region + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RadioButton[@text='" + region + "']")).click();
        }
    }

    public void selectCity(String city) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='" + city + "']")).click();
        } else {
            DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RadioButton[@text='" + city + "']")).click();
        }
    }

    public void waitingForResendOTP() {
        for (int i = 0 ; i < 61 ; i++) {
            DriverUtils.waitForAWhile(1, "wait for a second");
            if (i%5 == 0) {
                signUpLabel.click();
            }
        }
    }
}
