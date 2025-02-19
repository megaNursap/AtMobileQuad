package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class EarnMoreRewardScreen extends BaseScreen {

    private EarnMoreRewardScreen() {
        initializePage(this);
    }

    public static EarnMoreRewardScreen INSTANCE() {
        return new EarnMoreRewardScreen();
    }

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Apply\"])[1]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/recycler_view']//*[@text='Audio Collection - QA edition']/parent::android.view.ViewGroup/parent::android.widget.RelativeLayout//*[@resource-id='com.sheelafoam.quadrant.staging:id/btn_start_project']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement audioApplyBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Apply\"])[4]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/recycler_view']//*[@text='Video - 40 record 2 mins each']/parent::android.view.ViewGroup/parent::android.widget.RelativeLayout//*[@resource-id='com.sheelafoam.quadrant.staging:id/btn_start_project']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement videoApplyBtn;

//    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/recycler_view']//*[@text='Audio Collection - QA edition']/parent::android.view.ViewGroup/parent::android.widget.RelativeLayout//*[@resource-id='com.sheelafoam.quadrant.staging:id/btn_start_project']")
//    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//    public MobileElement audioApplyBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/cbQuiz")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement agreeQuizCbx;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnContinueUpload")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueUploadBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Use Video\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tvUseVideo")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement useVideoBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/cbQuizComponent")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement agreeCompleteProfileCbx;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnTakeQuizComponent")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement completeProfileBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"first_name\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstNameTxb;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"last_name\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement lastNameTxb;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"date_of_birth\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement dateOfBirthTxb;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"occupation\"]/android.view.ViewGroup/android.widget.EditText")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement occupationTxb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnTakeQuiz")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement updateProfileBtn;


    //XCUIElementTypeButton[@name="continue button"]
    @iOSXCUITFindBy(accessibility = "continue button")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnRight")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnPositive")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitBtn;

    @iOSXCUITFindBy(accessibility = "Submit")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_submit")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement submitButton;

    @AndroidFindBy(xpath = "//android.widget.RadioGroup/android.widget.RadioButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstRadioOption;

    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/leftContainer']/android.widget.CheckBox[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstCheckboxOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"marital_status\"]//android.widget.RadioButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstMaritalStatusOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"annual_income\"]//android.widget.RadioButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstAnnualIncomeOption;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"skin_tone\"]//android.widget.RadioButton[1]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstSkinToneOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RECORD AUDIO\"]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/iv_audio_record")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement recordAudioBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"RECORD VIDEO\"]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/iv_video_record")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement recordVideoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Video\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_add_video")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addVideoBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Geo Beta\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnRecord")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement recordBtn;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"VideoCapture\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnRecordVideo")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement videoRecordBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save to draft\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnSaveDraft")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveDraftBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Audio\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_add_audio")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addAudioBtn;

    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_record']/android.view.ViewGroup")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public List<MobileElement> audioRecordList;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[not(contains(@name,\"Delete\")) and not(contains(@name,\"Add\")) and not(contains(@name,\"your\")) and not(contains(@name,\"button\")) and not(contains(@name,\"Back\"))]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_record']//*[@resource-id='com.sheelafoam.quadrant.staging:id/iv_upload_status']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement uploadDraftBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Resume\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resumeBtn;

}
