package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;

public class SettingScreen extends BaseScreen {

    private SettingScreen() {
        initializePage(this);
    }

    public static SettingScreen INSTANCE() {
        return new SettingScreen();
    }

    @iOSXCUITFindBy(accessibility = "Logout")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/logOut")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement logOutBtn;

    @iOSXCUITFindBy(accessibility = "Yes")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement yesBtn;

    @iOSXCUITFindBy(accessibility = "Cancel")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cancelBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ivMenuSetting")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement settingButton;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnOK")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowBluetooth;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnCancel")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement denyBluetooth;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement permissionAllowBluetooth;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement permissionDenyBluetooth;

    @AndroidFindBy(id = "android:id/button1")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowTurnOnBluetooth;

    @AndroidFindBy(id = "android:id/button2")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement denyTurnOnBluetooth;


    @iOSXCUITFindBy(accessibility = "Yes, delete my account")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement yesDeleteAccountBtn;

    @iOSXCUITFindBy(accessibility = "Send")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/iv_send")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement refferalBtn;

    @iOSXCUITFindBy(accessibility = "~USD 5 worth of EQUAD rewards for you and your friend!")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_title")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement refferalLink;

    // setting options
    @iOSXCUITFindBy(accessibility = "Show Profile")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/edit_account")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement showProfileBtn;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"geotest111@mailinator.com\"`]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/email")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement showProfileEmailTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Geotest1 11\"`]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/name")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement showProfileNameTextBox;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"8983523131\"`]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/mobile")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement showProfilePhoneNumberTextBox;


    @iOSXCUITFindBy(accessibility = "Email")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailBtn;

    @iOSXCUITFindBy(accessibility = "Set Wallet Address")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/wallet_layout")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement setWalletAddressBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/etWalletAddress")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement walletAddressTextBox;

    @iOSXCUITFindBy(accessibility = "Add Wallet")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnAddWallet")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addWalletContinueBtn;

    @iOSXCUITFindBy(accessibility = "Must have at least 42 characters")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement warningAddWallet;

    @iOSXCUITFindBy(accessibility = "Ok")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnOK")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement oKWalletAddressBtn;

    @iOSXCUITFindBy(accessibility = "Change Password")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/password_layout")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement changePasswordBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/old_password")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement currentPasswordTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/new_password")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement newPasswordTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Guidelines\"][2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_instructions")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement guideLinesBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Answer More\"][1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_start_project")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement answerMoreBtn;


    @iOSXCUITFindBy(accessibility = "Complete your profile")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnTakeQuizComponent")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement completeYourProfileBtn;

    @iOSXCUITFindBy(accessibility = "Square")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/cbQuizComponent")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement checkBox;

    @iOSXCUITFindBy(accessibility = "Selected")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement unCheckBox;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/iv_back")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtnInsideCampaign;


    @iOSXCUITFindBy(accessibility = "Geolancer – Trust & Safety (Bahasa) – Geolancer")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvTitle")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement trustSafetyPage;

    @iOSXCUITFindBy(accessibility = "Geolancer Privacy Policy – Geolancer")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/html_viewer")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement privacyPolicyPage;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/change")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveBtn;

    @iOSXCUITFindBy(accessibility = "Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character.")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/snackbar_text")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement currentPassWarning;

    @iOSXCUITFindBy(accessibility = "Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character.")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/snackbar_text")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement newPassWarning;

    @iOSXCUITFindBy(accessibility = "OK")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement oKPassUpdatedBtn;


    @iOSXCUITFindBy(accessibility = "EARN MORE REWARDS")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/earn_more_survey")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement earnMoreRewardsBtn;

    @iOSXCUITFindBy(accessibility = "Help Center")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement helpCenterBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/bug_report")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement reportBugBtnAndroid;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/feature_request")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement suggestAFeatureBtnAndroid;

    @iOSXCUITFindBy(accessibility = "Report a Bug, Report your concern by leaving a message and we’ll respond as soon as we can.")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/bug_report")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement reportBugBtn;

    @AndroidFindBy(id ="com.android.chrome:id/url_bar")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement urlBarChrome;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Suggest a Feature\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/feature_request")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement suggestAFeatureBtn;

    @iOSXCUITFindBy(accessibility = "main")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement reportBugAndSuggestFeaturePage;

    @iOSXCUITFindBy(accessibility = "Trust & Safety")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/trust_safety")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement trustAndSafetyBtn;

    @iOSXCUITFindBy(accessibility = "Privacy Policy")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/privacy")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement privacyPolicyBtn;

    @iOSXCUITFindBy(accessibility = "Delete Account?")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deleteAccountBtn;

    @iOSXCUITFindBy(accessibility = "EARN MORE REWARDS")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/earn_more_survey")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement earnMoreReward;
}
