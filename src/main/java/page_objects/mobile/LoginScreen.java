package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;

public class LoginScreen extends BaseScreen {

    private LoginScreen() {
        initializePage(this);
    }

    public static LoginScreen INSTANCE() {
        return new LoginScreen();
    }

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_walkthrough_next")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement walkThroughNextBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_walkthrough_login")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement walkThroughLoginBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email Address\"]/parent::XCUIElementTypeOther/XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_login_email")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailTextbox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_login_pwd")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordTextbox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_login")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/otp")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement inputOTP;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/verify")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement verifyOTP;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/resend_time")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resendOTP;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/snackbar_text")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement snackBarUnverifyOTP;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hide\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement hidePasswordIcon;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_login_header")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Login\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement loginLabel;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_get_started")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getStartedIcon;

//    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_get_started")
//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Get Started\"]")
//    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
//    public MobileElement getStartedIcon;

    @AndroidFindBy(id = "android:id/autofill_save_yes")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement savePassGoogle;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/pz_dismissImageView")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"X\"]")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement xButtonPopUp;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/pz_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"X\"]")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nextBtn;

    @iOSXCUITFindBy(id = "android:id/autofill_save_yes")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveCredential;

    @iOSXCUITFindBy(xpath = "//android.widget.Button[@text='Save']")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveCredential2;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_get_started")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement letsGoBtn;

    @AndroidFindBy(id = "android:id/autofill_save_yes")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveAccount;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/proceed")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement enableGPS;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement gpsWhileUsingApp;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement gpsOnlyThisTime;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement gpsDontAllow;

    @iOSXCUITFindBy(accessibility = "Please enter a valid email address.")
    @WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement invalidEmailWarningText;

    @iOSXCUITFindBy(accessibility = "Forgot Password?")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_forgot_pwd")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement forgotPasswordBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"register_email\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailAddressField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"register_password\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign In\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signInBtn;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"The email format is incorrect. Please use a valid email address in this format: name@email.com.\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailWarningMsg;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"Incorrect email address or password.\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordWarningMsg;

}
