package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;

public class ForgotPasswordScreen extends BaseScreen {

    private ForgotPasswordScreen() {
        initializePage(this);
    }

    public static ForgotPasswordScreen INSTANCE() {
        return new ForgotPasswordScreen();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email\"]/parent::*/XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_forgot_email")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Email\"]/parent::*/XCUIElementTypeStaticText[3]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/til_forgot_email']//*[@resource-id='com.sheelafoam.quadrant.staging:id/textinput_error']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"get_otp_button\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_get_otp")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getOTPBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter One-Time Password\"]/parent::*/XCUIElementTypeTextField")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otpTxb;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter One-Time Password\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_otp_title")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement oneTimePasswordLabel;

    @iOSXCUITFindBy(accessibility = "verify_and_proceed_button")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_otp_verify")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement verifyAndProceedBtn;

    @iOSXCUITFindBy(accessibility = "OTP is not verified.")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ivMenuSetting")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement otpErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"enter_password_field\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/et_pwd")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement newPasswordTxb;

    @iOSXCUITFindBy(accessibility = "confirm_new_password_button")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_confirm_new_password")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement confirmNewPasswordBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"enter_password_field\"])[2]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/til_pwd']//*[@resource-id='com.sheelafoam.quadrant.staging:id/textinput_error']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordErrorMessage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"change_password_success_view\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_go_login")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backToLoginBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"change_password_success_view\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_title")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement changePasswordSuccessLabel;

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

    @iOSXCUITFindBy(accessibility = "Resend Code")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_signup_resend_otp_code")
    @WithTimeout(time = 150, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resendOTPBtn;

}
