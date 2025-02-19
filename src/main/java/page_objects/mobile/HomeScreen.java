package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import utils.factory.DriverFactory;

import java.time.temporal.ChronoUnit;

public class HomeScreen extends BaseScreen {
    private HomeScreen() {
        initializePage(this);
    }

    public static HomeScreen INSTANCE() {
        return new HomeScreen();
    }

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/action_home")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement homeButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    @iOSXCUITFindBy(accessibility = "Allow While Using App")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowWhileUsingTheApp;

    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    @iOSXCUITFindBy(accessibility = "Allow")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement allowButton;

    @iOSXCUITFindBy(accessibility = "login button")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_walkthrough_login")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement loginBtn;

    @iOSXCUITFindBy(accessibility = "signup button")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_walktroughend_signup")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signUpBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.TextView[contains(@text,'Update')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement updateButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeOther[1]//XCUIElementTypeButton")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/ivMenuSetting")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement settingBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Sign in\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement appenSignInBtn;

    @AndroidFindBy(xpath = "//android.view.View[@text=\"My projects\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement myProjectTitle;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"--\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement profileBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement logoutBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Help\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement helpBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FAQ\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement faqBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Account Settings\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement accountSettingBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'yopmail.com')]/android.widget.TextView[2]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement emailProfileText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Welcome to the official data collection tool of Appen\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement welcomeURL;

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement chromeURL;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"New to Appen? Find your ideal project on our website\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement webURL;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Find your ideal project on our website\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement ourWebsiteURL;

//    @AndroidFindBy(xpath = "(//android.view.ViewGroup[contains(@content-desc, 'Start working')]/android.view.ViewGroup[1])[1]")
//    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//    public MobileElement startBtn;

    public MobileElement clickDynamicJob(int index) {
        String dynamicXPath = String.format("(//android.view.ViewGroup[contains(@content-desc, 'Start working')]/android.view.ViewGroup[1])[%d]", index);
        return DriverFactory.getAndroidDriver().findElement(By.xpath(dynamicXPath));
    }

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Description\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement descPage;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Job List\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement jobListPage;

}
