package step_defs.mobile;

import com.google.common.collect.ImmutableMap;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.touch.offset.PointOption;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.mobile.*;
import utils.Config;
import utils.ScenarioContext;
import utils.api.adminpanel.AdminPanelAPI;
import utils.api.mailinator.MailinatorAPI;
import utils.factory.DriverFactory;
import utils.factory.DriverUtils;
import utils.factory.DynamoDeleteCampPOI;
import utils.factory.Run;
import io.appium.java_client.MobileBy;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileStepdefs {
    Run _location = Run.fromText(Config.ENV.RUN_LOCATION());
    @When("I log in to Geolancer app")
    public void iLogIntoApp() throws InterruptedException {
//        if(_location == Run.BROWSER_STACK){
//            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getCurrentAppiumDriver();
//            jse.executeScript("browserstack_executor: {\"action\":\"cameraImageInjection\", \"arguments\": {\"imageUrl\" : \"media://ddcab7ee70d9dcd8312189626e3409d6272a69a2\"}}");
//        }
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            try {
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEOLANCER_USERNAME());
            } catch (Exception e) {
                HomeScreen.INSTANCE().loginBtn.click();
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEOLANCER_USERNAME());
            }
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            }
            LoginScreen.INSTANCE().getStartedIcon.click();
            MapScreen.INSTANCE().applicationPermissiom.click();
            MapScreen.INSTANCE().skipWalletSetup.click();
            DriverUtils.waitForAWhile(1, "Wait for 1 second");
            MapScreen.INSTANCE().addYourFirstPOI.click();
            MapScreen.INSTANCE().closeAds.click();
        } else {
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEOLANCER_USERNAME());
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().getStartedIcon.click();
        }
    }

    @When("I log in to Geo app")
    public void iLogIntoGeoApp() throws InterruptedException {
//        if(_location == Run.BROWSER_STACK){
//            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getCurrentAppiumDriver();
//            jse.executeScript("browserstack_executor: {\"action\":\"cameraImageInjection\", \"arguments\": {\"imageUrl\" : \"media://ddcab7ee70d9dcd8312189626e3409d6272a69a2\"}}");
//        }
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            try {
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEO_USERNAME());
            } catch (Exception e) {
                HomeScreen.INSTANCE().loginBtn.click();
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEO_USERNAME());
            }
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(Config.ENV.GEO_PASSWORD());
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            }
            LoginScreen.INSTANCE().getStartedIcon.click();
            MapScreen.INSTANCE().applicationPermissiom.click();
            MapScreen.INSTANCE().skipWalletSetup.click();
            DriverUtils.waitForAWhile(1, "Wait for 1 second");
            MapScreen.INSTANCE().addYourFirstPOI.click();
            MapScreen.INSTANCE().closeAds.click();
        } else {
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.GEO_USERNAME());
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(Config.ENV.GEO_PASSWORD());
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().getStartedIcon.click();
        }
    }


    @When("I log in to Geolancer app with username {string} and password {string}")
    public void iLogIntoAppwithUsernameAndPassword(String username, String password) throws InterruptedException {
        if(_location == Run.BROWSER_STACK){
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getCurrentAppiumDriver();
            jse.executeScript("browserstack_executor: {\"action\":\"cameraImageInjection\", \"arguments\": {\"imageUrl\" : \"media://c1538395bb8ba295ec43739eec7bb5d6598a4799\"}}");
        }
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(username);
            try {
                LoginScreen.INSTANCE().emailTextbox.sendKeys(username);
            } catch (Exception e) {
                HomeScreen.INSTANCE().loginBtn.click();
                LoginScreen.INSTANCE().emailTextbox.sendKeys(username);
            }
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            }
            LoginScreen.INSTANCE().getStartedIcon.click();
            MapScreen.INSTANCE().applicationPermissiom.click();
            MapScreen.INSTANCE().skipWalletSetup.click();
            DriverUtils.waitForAWhile(1, "Wait for 1 second");
            MapScreen.INSTANCE().addYourFirstPOI.click();
            MapScreen.INSTANCE().closeAds.click();
        } else {
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(username);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().getStartedIcon.click();
        }
    }

    @And("I click login button")
    public void clickLogin(){
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            HomeScreen.INSTANCE().loginBtn.click();
        } else {
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
        }
    }

    @Then("I verify user login successfully")
    public void validateHomeScreen() {
        DriverUtils.waitForAWhile(3,"Wait for loading");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(SignUpScreen.INSTANCE().getStartedIcon.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user login unsuccessfully")
    public void iVerifyUserLoginUnsuccessfully() {
        DriverUtils.waitForAWhile(3,"Wait for loading");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(LoginScreen.INSTANCE().getStartedIcon.isDisplayed()).isEqualTo(false);
        softly.assertAll();
    }

    @Then("I can not logged into the home screen")
    public void cantValidateHomeScreen() {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            try {
                LoginScreen.INSTANCE().getStartedIcon.findElement(By.xpath("//XCUIElementTypeButton[@name='Get Started']"));
            } catch (Exception e) {
                System.out.println("element is not present");
            }
        } else {
            // for android
            try {
                LoginScreen.INSTANCE().getStartedIcon.findElement(By.id("com.sheelafoam.quadrant.staging:id/tv_get_started"));
            } catch (Exception e) {
                System.out.println("element is not present");
            }
        }
    }

    @When("I open POI by deeplink with POI name")
    public void iOpenPOIByDeeplinkWithPOIName() throws IOException {
        String deepLinkURL = null;
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            deepLinkURL = "GeoStg://home/mapbox/openPoi?poiName=" + ScenarioContext.currentContext().get("POI Name", String.class);
            if(_location == Run.BROWSER_STACK) {
                ((RemoteWebDriver) DriverFactory.getIOSDriver()).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));

                List args = new ArrayList();
                args.add("-U");
                args.add(deepLinkURL);

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("bundleId", "com.apple.mobilesafari");
                params.put("arguments", args);

                ((RemoteWebDriver) DriverFactory.getIOSDriver()).executeScript("mobile: launchApp", params);
            } else {
                DriverFactory.getCurrentAppiumDriver().get(deepLinkURL);
            }
        } else {
//            deepLinkURL = "geolancer://home/mapbox/openPoi?poiName=" + ScenarioContext.currentContext().get("POI Name", String.class);
            deepLinkURL = "https://m.uber.com/ul/?action=setPickup&pickup[latitude]=25.467999999999986&pickup[longitude]=-80.49564&dropoff[latitude]=25.46779&dropoff[longitude]=-80.49314999999999";

            if(_location == Run.BROWSER_STACK) {
                DriverFactory.getCurrentAppiumDriver().get(deepLinkURL);
            } else {
//                String adbCommand = "adb shell am start -W -a android.intent.action.VIEW -d " + deepLinkURL + " com.sheelafoam.quadrant.staging";
                String adbCommand = "adb shell am start -W -a android.intent.action.VIEW -d " + deepLinkURL + " com.ubercab";
                Runtime.getRuntime().exec(adbCommand);
                DriverUtils.waitForAWhile(3, "Wait");
            }
        }
        System.out.println("deepLinkURL " + deepLinkURL);
    }

    @When("I open Campaign POI by deeplink with Campaign POI name")
    public void iOpenCampaignPOIByDeeplinkWithPOIName() throws IOException {

        String deepLinkURL = null;
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            deepLinkURL = "GeoStg://home/mapbox/openPoi?poiName=" + ScenarioContext.currentContext().get("Campaign POI Name", String.class);
            DriverFactory.getCurrentAppiumDriver().get(deepLinkURL);
        } else {
//            deepLinkURL = "geolancer://home/mapbox/openPoi?poiName=" + ScenarioContext.currentContext().get("Campaign POI Name", String.class);
            deepLinkURL = "geolancer://home/mapbox/openPoi?poiName=Campaign-POI-auto-test-05-07-2023-22-40-22";
            if(_location == Run.BROWSER_STACK) {
                DriverFactory.getCurrentAppiumDriver().get(deepLinkURL);
            } else {
                String adbCommand = "adb shell am start -W -a android.intent.action.VIEW -d " + deepLinkURL + " com.sheelafoam.quadrant.staging";
                Runtime.getRuntime().exec(adbCommand);
                DriverUtils.waitForAWhile(3, "Wait");
            }
        }
        System.out.println("deepLinkURL " + deepLinkURL);
        DriverUtils.waitForAWhile(10, "Wait");

    }

    @When("delete POI with name {string}")
    public void deletePOIWithName(String poiName) {
        AdminPanelAPI adminPanelAPI = AdminPanelAPI.builder().build();
        adminPanelAPI.loginV2();
        adminPanelAPI.getPOIId(poiName);
        DynamoDeleteCampPOI.deletePOI(ScenarioContext.currentContext().get("POI ID", String.class));
    }

    @When("delete all POIs in current lat long")
    public void deleteAllPOIsInCurrentLatLong() {
        AdminPanelAPI adminPanelAPI = AdminPanelAPI.builder().build();
        adminPanelAPI.loginV2();
        adminPanelAPI.deleteAllPOIs();
    }

    @When("I set status {string} POI name from Admin Panel")
    public void iSetStatusForPOINameFromAdminPanel(String status) throws Exception {
        DriverUtils.waitForAWhile(3, "Wait for map loading");
        System.out.println("POI Name" +  ScenarioContext.currentContext().get("POI Name", String.class));
        AdminPanelAPI adminPanelAPI = AdminPanelAPI.builder().build();
        adminPanelAPI.loginV2();
        adminPanelAPI.getPOIId(ScenarioContext.currentContext().get("POI Name", String.class));
        adminPanelAPI.setStatusForPOIFromAdminPanel(status);
    }

    @Given("I set status {string} for Campaign name from Admin Panel")
    public void iSetStatusForCampaignNameFromAdminPanel(String status) throws Exception {
        AdminPanelAPI adminPanelAPI = AdminPanelAPI.builder().build();
        adminPanelAPI.loginV2();
        adminPanelAPI.getPOIId(ScenarioContext.currentContext().get("Campaign POI Name", String.class));
        adminPanelAPI.setStatusForCampaignPOIFromAdminPanel(status);
    }

    @When("I logout Geolancer app")
    public void iLogoutGeolancerApp() throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            // iOS
            HomeScreen.INSTANCE().settingBtn.click();
            HomeScreen.INSTANCE().swipeFromTopToBottom();
            HomeScreen.INSTANCE().swipeFromTopToBottom();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            SettingScreen.INSTANCE().logOutBtn.click();
            SettingScreen.INSTANCE().yesBtn.click();
        } else {
            // android
            HomeScreen.INSTANCE().settingBtn.click();
            HomeScreen.INSTANCE().swipeFromTopToBottom();
            HomeScreen.INSTANCE().swipeFromTopToBottom();
            SettingScreen.INSTANCE().logOutBtn.click();
        }
        Thread.sleep(30000);
    }

    @Then("I verify user log out Geolancer app successfully")
    public void iVerifyUserLogOutGeolancerAppSuccessfully() {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            assert HomeScreen.INSTANCE().loginBtn.isDisplayed() == true;
        } else {
            assert LoginScreen.INSTANCE().emailTextbox.isDisplayed() == true;
        }

    }

    @When("I edit regular POI")
    public void iEditRegularPOI() {
        VerifyAPOIScreen.INSTANCE().swipeFromTopToBottom();
        VerifyAPOIScreen.INSTANCE().editPOIDetailsBtn.click();
        VerifyAPOIScreen.INSTANCE().otherNameOfPOICxb.click();
        VerifyAPOIScreen.INSTANCE().saveBtn.click();
        VerifyAPOIScreen.INSTANCE().editBusinessHoursBtn.click();
        VerifyAPOIScreen.INSTANCE().addBusinessHourDetailEverydayRdb.click();
        VerifyAPOIScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
        VerifyAPOIScreen.INSTANCE().saveBtn.click();
        VerifyAPOIScreen.INSTANCE().swipeFromTopToBottom();
        VerifyAPOIScreen.INSTANCE().submitEditedPOIBtn.click();
        VerifyAPOIScreen.INSTANCE().confirmSubmitEditedPOIBtn.click();
    }

    @And("I add regular POI with all NA fields")
    public void iAddRegularPOIWithAllNAFields() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String poiName = Config.ENV.PLACE_NAME() + dtf.format(now);
        ScenarioContext.currentContext().set("POI Name").with(poiName);
        System.out.println("poiName: " + poiName);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
            AddPOIScreen.INSTANCE().continueButton.click();
            MovePinScreen.INSTANCE().saveBtn.click();
            AddPOIScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
//                AddPOIScreen.INSTANCE().okBtn.click();
                AddPOIScreen.INSTANCE().firstPhotoFromLibrary.click();
            } else {
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
            }
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().nameOfThePlaceTxb.sendKeys(poiName);
            AddPOIScreen.INSTANCE().houseBuildingNumberTxb.sendKeys(Config.ENV.STREET_NAME());
            AddPOIScreen.INSTANCE().floorUnitNumberNACxb.click();
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().addBusinessHourAddPhotoBtn.click();
            AddPOIScreen.INSTANCE().firstPhotoFromLibrary.click();
            AddPOIScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().submitPOIBtn.click();
            AddPOIScreen.INSTANCE().submitPOIBtn.click();


//            AddPOIScreen.INSTANCE().addBusinessHourSwitchOnOff.click();
//            AddPOIScreen.INSTANCE().continueButton.click();
//            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
//            AddPOIScreen.INSTANCE().submitPOIBtn.click();
        } else {
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
            AddPOIScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    SettingScreen.INSTANCE().allowBluetooth.click();
                }catch (Exception e){}
                try {
                    SettingScreen.INSTANCE().permissionAllowBluetooth.click();
                }catch (Exception e){}
                DriverUtils.waitForAWhile(2, "Wait for map loading");
                try {
                    SettingScreen.INSTANCE().allowTurnOnBluetooth.click();
                }catch (Exception e){}
//                MapScreen.INSTANCE().addPOI.click();
//                DriverUtils.waitForAWhile(5, "Wait for map loading");
//                AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
//                AddPOIScreen.INSTANCE().continueButton.click();
            }
            MovePinScreen.INSTANCE().moveMyPin.click();
            AddPOIScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                DriverUtils.waitForAWhile(2, "wait for auto captured");
//                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                DriverFactory.getAndroidDriver().rotate(ScreenOrientation.LANDSCAPE);
                DriverUtils.waitForAWhile(2, "Wait rotate");
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
            AddPOIScreen.INSTANCE().continuePhotoBtn.click();
            DriverUtils.waitForAWhile(2, "Wait for loading");
            AddPOIScreen.INSTANCE().nameOfThePlaceTxb.sendKeys(poiName);
            DriverUtils.waitForAWhile(5, "Wait for loading");
            AddPOIScreen.INSTANCE().rightContinueBtn.click();
            AddPOIScreen.INSTANCE().houseBuildingNumberTxb.sendKeys(Config.ENV.HOUSE_BUILDING_NUMBER());
            AddPOIScreen.INSTANCE().floorUnitNumberNACxb.click();
            AddPOIScreen.INSTANCE().rightContinueBtn.click();
            AddPOIScreen.INSTANCE().photoOfOpeningHoursNACbx.click();
            AddPOIScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().submitPOIBtn.click();
            AddPOIScreen.INSTANCE().submitConfirmationBtn.click();
            DriverUtils.waitForAWhile(10, "Wait for loading");
        }
    }

    @And("I add regular POI with all fields filled")
    public void iAddRegularPOIWithAllFieldsFilled() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String poiName = Config.ENV.PLACE_NAME() + dtf.format(now);
        ScenarioContext.currentContext().set("POI Name").with(poiName);
        System.out.println("poiName: " + poiName);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
            AddPOIScreen.INSTANCE().continueButton.click();
            MovePinScreen.INSTANCE().saveBtn.click();
            AddPOIScreen.INSTANCE().takePhotoBtn.click();
            try {
                AddPOIScreen.INSTANCE().okBtn.click();

            } catch (Exception e) {
            }
            if(_location == Run.BROWSER_STACK){
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
            } else {
                AddPOIScreen.INSTANCE().photoImage.click();
            }
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().nameOfThePlaceTxb.sendKeys(poiName);
            AddPOIScreen.INSTANCE().houseBuildingNumberTxb.sendKeys(Config.ENV.STREET_NAME());
            AddPOIScreen.INSTANCE().floorUnitNumberTxb.sendKeys(Config.ENV.STREET_NAME());
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().addBusinessHourYes.click();
            AddPOIScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
            } else {
                AddPOIScreen.INSTANCE().photoImage.click();
            }
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().addBusinessHourDetailEverydayRdb.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().continueButton.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().submitPOIBtn.click();
        } else {
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
            AddPOIScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    SettingScreen.INSTANCE().allowBluetooth.click();
                }catch (Exception e){}
                try {
                    SettingScreen.INSTANCE().permissionAllowBluetooth.click();
                }catch (Exception e){}
                DriverUtils.waitForAWhile(2, "Wait for map loading");
                try {
                    SettingScreen.INSTANCE().allowTurnOnBluetooth.click();
                }catch (Exception e){}
                MapScreen.INSTANCE().addPOI.click();
                DriverUtils.waitForAWhile(5, "Wait for map loading");
                AddPOIScreen.INSTANCE().selectCampaignTypeList("Regular POI");
                AddPOIScreen.INSTANCE().continueButton.click();
            }
            MovePinScreen.INSTANCE().moveMyPin.click();
            AddPOIScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                DriverFactory.getAndroidDriver().rotate(ScreenOrientation.LANDSCAPE);
                DriverUtils.waitForAWhile(2, "Wait rotate");
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
            AddPOIScreen.INSTANCE().continuePhotoBtn.click();
            DriverUtils.waitForAWhile(2, "Wait for loading");
            AddPOIScreen.INSTANCE().nameOfThePlaceTxb.sendKeys(poiName);
            DriverUtils.waitForAWhile(5, "Wait for loading");
            AddPOIScreen.INSTANCE().rightContinueBtn.click();
            AddPOIScreen.INSTANCE().houseBuildingNumberTxb.sendKeys(Config.ENV.HOUSE_BUILDING_NUMBER());
            AddPOIScreen.INSTANCE().floorUnitNumberTxb.sendKeys(Config.ENV.FLOOR_UNIT_NUMBER());
            AddPOIScreen.INSTANCE().rightContinueBtn.click();
            AddPOIScreen.INSTANCE().openingHoursTakePhoto.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                DriverFactory.getAndroidDriver().rotate(ScreenOrientation.LANDSCAPE);
                DriverUtils.waitForAWhile(2, "Wait rotate");
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
//            AddPOIScreen.INSTANCE().addBusinessHourDetailWeekdaysRdb.click();
            AddPOIScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            AddPOIScreen.INSTANCE().swipeFromTopToBottom();
            AddPOIScreen.INSTANCE().submitPOIBtn.click();
            AddPOIScreen.INSTANCE().submitConfirmationBtn.click();
            DriverUtils.waitForAWhile(10, "Wait for loading");
        }
    }

    @And("I refresh the map screen")
    public void iRefreshTheMapScreen() {
        MapScreen.INSTANCE().refreshBtn.click();
        DriverUtils.waitForAWhile(10, "Wait for map loading");
    }

    @And("I input email address with {string} and password with {string}")
    public void inputEmailAddress(String email, String password) throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().xButtonPopUp.click();
            try {
                LoginScreen.INSTANCE().emailTextbox.sendKeys(email);
            } catch (Exception e) {
                HomeScreen.INSTANCE().loginBtn.click();
                LoginScreen.INSTANCE().emailTextbox.sendKeys(email);
            }
        } else {
            HomeScreen.INSTANCE().loginBtn.click();
            try {
                LoginScreen.INSTANCE().nextBtn.click();
                LoginScreen.INSTANCE().nextBtn.click();
                LoginScreen.INSTANCE().nextBtn.click();
            } catch (Exception e) {
            }
            LoginScreen.INSTANCE().emailTextbox.clear();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(email);
            LoginScreen.INSTANCE().passwordTextbox.clear();
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
        }
    }

    @And("I input multiple invalid email address and valid password with {string} {string} {string} {string} {string}")
    public void inputEmail(String emailAddress1, String emailAddress2, String emailAddress3, String emailAddress4, String password) throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 1
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress1);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().emailTextbox.clear();
            // email 2
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress2);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 3
            LoginScreen.INSTANCE().emailTextbox.clear();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress3);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 4
            LoginScreen.INSTANCE().emailTextbox.clear();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress4);
            HomeScreen.INSTANCE().loginBtn.click();
        }
        else {
//            // for android
//
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 1
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress1);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().emailTextbox.clear();
            // email 2
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress2);
            LoginScreen.INSTANCE().continueButton.click();
            // email 3
            LoginScreen.INSTANCE().emailTextbox.clear();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress3);
            LoginScreen.INSTANCE().continueButton.click();
            // email 4
            LoginScreen.INSTANCE().emailTextbox.clear();
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress4);
            LoginScreen.INSTANCE().continueButton.click();
        }
    }

    @And("I input multiple valid email address and invalid password with {string} {string} {string} {string} {string}")
    public void inputPassword(String emailAddress, String password1, String password2, String password3, String password4) throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            try {
                LoginScreen.INSTANCE().nextBtn.click();
                LoginScreen.INSTANCE().nextBtn.click();
                LoginScreen.INSTANCE().nextBtn.click();
            } catch (Exception e) {
            }
            // email 1
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password1);
            HomeScreen.INSTANCE().loginBtn.click();
            LoginScreen.INSTANCE().passwordTextbox.clear();
            // email 2
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password2);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 3
            LoginScreen.INSTANCE().passwordTextbox.clear();
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password3);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 4
            LoginScreen.INSTANCE().passwordTextbox.clear();
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password4);
            HomeScreen.INSTANCE().loginBtn.click();
        } else {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            // email 1
            LoginScreen.INSTANCE().emailTextbox.sendKeys(emailAddress);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password1);
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().passwordTextbox.clear();
            // email 2
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password2);
            LoginScreen.INSTANCE().continueButton.click();
            // email 3
            LoginScreen.INSTANCE().passwordTextbox.clear();
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password3);
            LoginScreen.INSTANCE().continueButton.click();
            // email 4
            LoginScreen.INSTANCE().passwordTextbox.clear();
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password4);
            LoginScreen.INSTANCE().continueButton.click();
        }
    }

    @And("I input password with {string}")
    public void inputPassword(String password) throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            // for ios
            Thread.sleep(1000);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
        } else {
            // for android
            Thread.sleep(1000);
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(password);
        }
    }

    @Then("I verify the POI detail displaying correctly with status {string}")
    public void iVerifyThePOIDetailWithNameDisplayingCorrectlyWithAllNAField(String status) {
        SoftAssertions softly = new SoftAssertions();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            softly.assertThat(VerifyAPOIScreen.INSTANCE().poiName.getText()).isEqualTo(ScenarioContext.currentContext().get("POI Name", String.class));
            softly.assertThat(VerifyAPOIScreen.INSTANCE().poiStatus.getText()).isEqualTo(status);
        } else {
            softly.assertThat(VerifyAPOIScreen.INSTANCE().poiName.getText()).isEqualTo(ScenarioContext.currentContext().get("POI Name", String.class));
            softly.assertThat(VerifyAPOIScreen.INSTANCE().nameOfThePlaceInfo.getText()).isEqualTo(ScenarioContext.currentContext().get("POI Name", String.class));
            softly.assertThat(VerifyAPOIScreen.INSTANCE().houseBuildingNumberInfo.getText()).isEqualTo(Config.ENV.HOUSE_BUILDING_NUMBER());
        }
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){

        } else {
            VerifyAPOIScreen.INSTANCE().closeBtn.click();
        }
        softly.assertAll();
    }

    @And("I open Report from Map Screen")
    public void iOpenEQuadTabFromReport() {
        DriverUtils.waitForAWhile(5, "Wait for map loading");
        MapScreen.INSTANCE().reportBtn.click();
        DriverUtils.waitForAWhile(2, "Wait for map loading");
    }

    @And("I click {string} from Report Screen")
    public void iClickFromReportScreen(String tab) {
        DriverUtils.waitForAWhile(2, "Wait for map loading");
        switch (tab) {
            case "eQuad Points":
                ReportScreen.INSTANCE().equadPointTab.click();
                break;
            case "NFTs":
                ReportScreen.INSTANCE().nftTab.click();
                break;
            case "POI Status":
                ReportScreen.INSTANCE().nftTab.click();
                break;
            case "Approved":
                ReportScreen.INSTANCE().poiApprovedBtn.click();
                break;
            case "Rejected":
                ReportScreen.INSTANCE().poiRejectedBtn.click();
                break;
            default:
                break;
        }
        ReportScreen.INSTANCE().swipeFromTopToBottom();

    }

    @Then("I verify user receive the equad reward for regular POI")
    public void iVerifyTheLastestEQuadRewardForRegularPOI() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ReportScreen.INSTANCE().lastestPOIName.getText()).isEqualTo(ScenarioContext.currentContext().get("POI Name", String.class));
        softly.assertThat(Double.parseDouble(ReportScreen.INSTANCE().lastestEquadPoint.getText())).isGreaterThan(0);
    }

    @Then("I verify user receive the equad reward for campaign POI")
    public void iVerifyUserReceiveTheEquadRewardForCampaignPOI() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(ReportScreen.INSTANCE().lastestPOIName.getText()).isEqualTo(ScenarioContext.currentContext().get("Campaign Name", String.class));
        softly.assertThat(Double.parseDouble(ReportScreen.INSTANCE().lastestEquadPoint.getText())).isGreaterThan(0);
    }

    @Then("I as {string} will get the eQuad rewards")
    public void iAsWillGetTheEQuadRewards(String userType) throws Exception {
        if (userType.equalsIgnoreCase("collector")){
//            AddPOIScreen.eQuadCollector = "43.54";
//            AddPOIScreen.androidPoiName = "wed-22-1 edit";
            String poiName = "null";
            int k = 0;
            for (int i=0;i<3;i++){
                if(i==0){
                    DriverUtils.waitForAWhile(40, "Wait city");
                    DriverFactory.scrollActionAndroid(0.2F, 0.3F, 0.2F,0.7F);
                }
                for (int j=0;j<3;j++) {
                    try {
                        poiName = DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RelativeLayout[@text=''][" + k + "]/android.widget.TextView[@text='" + AddPOIScreen.androidPoiName + "']")).getText();
                    }catch (Exception e){}
                    System.out.println("jjj = " + j);
                    System.out.println("iii = " + i);
                    System.out.println("kkk = " + k);
                    System.out.println("poiName = " + poiName);
                    if (poiName.equalsIgnoreCase(AddPOIScreen.androidPoiName)) {
                        String getEquads = DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RelativeLayout[@text=''][" + k + "]/android.widget.LinearLayout[@text='']/android.widget.TextView[@index='2']")).getText();
                        // check between equad estimation and equad received is equal
                        if(getEquads.equalsIgnoreCase(AddPOIScreen.eQuadCollector)) {
                            System.out.println("====================== ");
                            System.out.println("Received Rewards Collector "+getEquads);
                            System.out.println("====================== ");
                        }
                        j = 4;
                        i = 4;
                        break;
                    }else if(poiName.equalsIgnoreCase("null") && (k==7 && i==2)){
                        throw new NoSuchFieldException("The Reward is not received");
                    }
                    k = k+1;
                }
                DriverFactory.scrollActionAndroid(0.5F, 0.8F, 0.5F,0.3F);
            }

        }else {
//            AddPOIScreen.eQuadVerifier = "21.77";
//            AddPOIScreen.androidPoiName = "wed-22-1 edit";
            String poiName = "null";
            int k = 0;
            for (int i=0;i<3;i++){
                if(i==0){
                    DriverUtils.waitForAWhile(40, "Wait city");
                    // refresh equad
                    DriverFactory.scrollActionAndroid(0.2F, 0.3F, 0.2F,0.7F);
                }
                for (int j=0;j<3;j++) {
                    try {
                        poiName = DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RelativeLayout[@text=''][" + k + "]/android.widget.TextView[@text='" + AddPOIScreen.androidPoiName + "']")).getText();
                    }catch (Exception e){}
                    System.out.println("jjj = " + j);
                    System.out.println("iii = " + i);
                    System.out.println("kkk = " + k);
                    System.out.println("poiName = " + poiName);
                    if (poiName.equalsIgnoreCase(AddPOIScreen.androidPoiName)) {
                        String getEquads = DriverFactory.getAndroidDriver().findElement(By.xpath("//android.widget.RelativeLayout[@text=''][" + k + "]/android.widget.LinearLayout[@text='']/android.widget.TextView[@index='2']")).getText();
                        // check between equad estimation and equad received is equal
                        if(getEquads.equalsIgnoreCase(AddPOIScreen.eQuadVerifier)) {
                            System.out.println("====================== ");
                            System.out.println("Received Rewards Verifier "+getEquads);
                            System.out.println("====================== ");
                        }
                        j = 4;
                        i = 4;
                        break;
                    }else if(poiName.equalsIgnoreCase("null") && (k==7 && i==2)){
                        throw new NoSuchFieldException("The Reward is not received");
                    }
                    k = k+1;
                }
                DriverFactory.scrollActionAndroid(0.5F, 0.8F, 0.5F,0.3F);
            }
        }
    }

    @Then("I collect Campaign POI name GojekAddressData with filling all fields")
    public void iCollectAndroidCampaignPOINameWithFillingAllFields() {
        MapScreen.INSTANCE().addPOI.click();
        boolean found = false;
        if(_location == Run.BROWSER_STACK){
            System.out.println("browserstack");
            DriverUtils.waitForAWhile(3, "Wait for map loading");
            try {
                SettingScreen.INSTANCE().allowBluetooth.click();
            }catch (Exception e){}
            try {
                SettingScreen.INSTANCE().permissionAllowBluetooth.click();
            }catch (Exception e){}
            DriverUtils.waitForAWhile(2, "Wait for map loading");
            try {
                SettingScreen.INSTANCE().allowTurnOnBluetooth.click();
            }catch (Exception e){}
        }else{
            while( found == false){
                try{
                    CampGojekAddressData.INSTANCE().selectGojekCampaign.click();
                    found = true;
                    break;
                }catch (Exception e){
                    DriverFactory.scrollActionAndroid(0.5F, 0.7F, 0.5F,0.1F);
                }
            }
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            CampGojekAddressData.INSTANCE().continueCampBtn.click();
            CampGojekAddressData.INSTANCE().popUpCampOkBtn.click();
        }
        DriverUtils.waitForAWhile(2, "Wait for map loading");
        DriverFactory.scrollActionAndroid(0.2F, 0.3F, 0.3F,0.3F);
        MovePinScreen.INSTANCE().moveMyPin.click();
        DriverUtils.waitForAWhile(8, "Wait for map loading");
        CampGojekAddressData.INSTANCE().locationNameTx.sendKeys("Gejek Address Data 1");
    }

    @Then("I verify there is no equad reward existed in report tab")
    public void iVerifyThereIsNoEquadRewardExistedInReportTab() {
        SoftAssertions softly = new SoftAssertions();
        ReportScreen.INSTANCE().swipeFromTopToBottom();
        softly.assertThat(ReportScreen.INSTANCE().lastestPOIName.getText()).isNotEqualTo(ScenarioContext.currentContext().get("POI Name", String.class));
    }

    @And("I collect general Campaign POI  with filling all fields")
    public void iCollectGeneralCampaignPOIWithFillingAllFields() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String campaignName = Config.ENV.CAMPAIGN_NAME() + dtf.format(now);
        ScenarioContext.currentContext().set("Campaign Name").with(campaignName);
        System.out.println("CampaignName: " + campaignName);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            MapScreen.INSTANCE().selectCampaignTypeList("Automation Coll General Cases");
            GeneralCampaignScreen.INSTANCE().continueButton.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().getStartedBtn.click();
            GeneralCampaignScreen.INSTANCE().nameOfTheStreetTxb.sendKeys(Config.ENV.STREET_NAME());
            GeneralCampaignScreen.INSTANCE().selectCaTegory("Automotive", "Auto Tires Shop");
            GeneralCampaignScreen.INSTANCE().selectCity("Aceh Barat, Aceh");
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().checkbox1.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().checkboxTextTxb.sendKeys("Test");
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().selectTypeOfThePlace("Empty ground");
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().getLocationBtn.click();
            DriverUtils.waitForAWhile(3, "Wait for loading");
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().multiInputPopUpBtn.click();
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
                GeneralCampaignScreen.INSTANCE().takePhotoBtn.click();
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
            } else {
                AddPOIScreen.INSTANCE().photoImage.click();
            }
            GeneralCampaignScreen.INSTANCE().fridayCbx.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().selectTypeOfThePlace("dropdown1");
            GeneralCampaignScreen.INSTANCE().addItemMultiPopupInputBtn.click();
            GeneralCampaignScreen.INSTANCE().multipleTakePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
                GeneralCampaignScreen.INSTANCE().takePhotoBtn.click();
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
            } else {
                AddPOIScreen.INSTANCE().photoImage.click();
            }
            GeneralCampaignScreen.INSTANCE().singleTakePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                AddPOIScreen.INSTANCE().photoCaptureOnRealDevice.click();
                AddPOIScreen.INSTANCE().usePhotoOnRealDevice.click();
            } else {
                AddPOIScreen.INSTANCE().photoImage.click();
            }
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().unhideRdb.click();
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().openingHourEverydayRdb.click();
            GeneralCampaignScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().continueBtn.click();
            GeneralCampaignScreen.INSTANCE().submitBtn.click();
            GeneralCampaignScreen.INSTANCE().continueButton.click();
        } else {
            DriverUtils.waitForAWhile(10, "Wait for map loading");
            MapScreen.INSTANCE().addPOI.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            MapScreen.INSTANCE().swipeFromTopToBottom();
            MapScreen.INSTANCE().selectCampaignTypeList("Automation Coll General Cases");
            GeneralCampaignScreen.INSTANCE().continueButton.click();
            GeneralCampaignScreen.INSTANCE().popUpCampOkBtn.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    SettingScreen.INSTANCE().allowBluetooth.click();
                }catch (Exception e){}
                try {
                    SettingScreen.INSTANCE().permissionAllowBluetooth.click();
                }catch (Exception e){}
                DriverUtils.waitForAWhile(2, "Wait for map loading");
                try {
                    SettingScreen.INSTANCE().allowTurnOnBluetooth.click();
                }catch (Exception e){}
                MapScreen.INSTANCE().addPOI.click();
                DriverUtils.waitForAWhile(5, "Wait for map loading");
                MapScreen.INSTANCE().swipeFromTopToBottom();
                MapScreen.INSTANCE().selectCampaignTypeList("Automation Coll General Cases");
                GeneralCampaignScreen.INSTANCE().continueButton.click();
                GeneralCampaignScreen.INSTANCE().popUpCampOkBtn.click();
            }
            MovePinScreen.INSTANCE().moveMyPin.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
            GeneralCampaignScreen.INSTANCE().nameOfTheStreetTxb.sendKeys(Config.ENV.STREET_NAME());
            GeneralCampaignScreen.INSTANCE().selectCaTegory("Automotive", "Auto Tires Shop");
            GeneralCampaignScreen.INSTANCE().selectCity("Aceh Barat");
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().checkbox1.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().checkboxTextTxb.sendKeys("Test");
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            GeneralCampaignScreen.INSTANCE().selectTypeOfThePlace("Empty ground");
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            GeneralCampaignScreen.INSTANCE().getLocationBtn.click();
            DriverUtils.waitForAWhile(3, "Wait for loading");
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            GeneralCampaignScreen.INSTANCE().multiInputPopUpBtn.click();
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().takePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
                GeneralCampaignScreen.INSTANCE().takePhotoBtn.click();
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
            GeneralCampaignScreen.INSTANCE().fridayCbx.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().selectTypeOfThePlace("dropdown1");
            GeneralCampaignScreen.INSTANCE().addItemMultiPopupInputBtn.click();
            GeneralCampaignScreen.INSTANCE().multipleTakePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
                GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
                GeneralCampaignScreen.INSTANCE().multipleTakePhotoBtn.click();
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
            GeneralCampaignScreen.INSTANCE().singleTakePhotoBtn.click();
            if(_location == Run.BROWSER_STACK){
                try {
                    AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                } catch (Exception e) {
                }
                AddPOIScreen.INSTANCE().OkBtn.click();
            } else {
                AddPOIScreen.INSTANCE().shutterPhotoButton.click();
                AddPOIScreen.INSTANCE().donePhotoBtn.click();
            }
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().unhideRdb.click();
            GeneralCampaignScreen.INSTANCE().swipeFromTopToBottom();
            GeneralCampaignScreen.INSTANCE().nameOfBusinessTxb.sendKeys(Config.ENV.BUSINESS_NAME());
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            GeneralCampaignScreen.INSTANCE().openingHourEverydayRdb.click();
            GeneralCampaignScreen.INSTANCE().sameOpeningHoursEverydayRdb.click();
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            GeneralCampaignScreen.INSTANCE().rightContinueBtn.click();
            //Get equad etimation
            GeneralCampaignScreen.INSTANCE().submitConfirmationBtn.click();
            DriverUtils.waitForAWhile(3, "Wait for loading");
            GeneralCampaignScreen.INSTANCE().submitConfirmationBtn.click();
        }
    }

    @Given("I create an sample POI for Campaign from Admin Panel")
    public void iCreateAnSamplePOIForCampaignFromAdminPanel() {
        AdminPanelAPI adminPanelAPI = AdminPanelAPI.builder().build();
        adminPanelAPI.loginV2();
        adminPanelAPI.createSamplePOIForCampaign();
    }

    @And("I go to Setting screen")
    public void iGoToSettingScreen() {
        HomeScreen.INSTANCE().settingBtn.click();
    }

    @And("I submit {string} audios with {string} seconds for each")
    public void iSubmitAudiosWithSecondsForEach(String audioAmount, String duration) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            DriverUtils.waitForAWhile(3, "Wait for seconds");
        }
        SettingScreen.INSTANCE().earnMoreReward.click();

        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
        EarnMoreRewardScreen.INSTANCE().agreeCompleteProfileCbx.click();
        EarnMoreRewardScreen.INSTANCE().completeProfileBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstNameTxb.sendKeys("Jack");
        EarnMoreRewardScreen.INSTANCE().lastNameTxb.sendKeys("La");
        EarnMoreRewardScreen.INSTANCE().dateOfBirthTxb.sendKeys("18/02/2000");
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstCheckboxOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstCheckboxOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstMaritalStatusOption.click();
        EarnMoreRewardScreen.INSTANCE().occupationTxb.sendKeys("Test");
        EarnMoreRewardScreen.INSTANCE().firstAnnualIncomeOption.click();
        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
        EarnMoreRewardScreen.INSTANCE().firstSkinToneOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for seconds");
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();


        EarnMoreRewardScreen.INSTANCE().audioApplyBtn.click();
        EarnMoreRewardScreen.INSTANCE().agreeQuizCbx.click();
        EarnMoreRewardScreen.INSTANCE().updateProfileBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        DriverUtils.waitForAWhile(3, "Wait for seconds");
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().recordAudioBtn.click();
        EarnMoreRewardScreen.INSTANCE().recordBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")){
            DriverUtils.waitForAWhile(Integer.parseInt(duration), "Wait for seconds");
        }
        EarnMoreRewardScreen.INSTANCE().recordBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            DriverUtils.waitForAWhile(Integer.parseInt(duration), "Wait for seconds");
            EarnMoreRewardScreen.INSTANCE().recordBtn.click();
        }
//        EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
//        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")){
//            EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
//            DriverUtils.waitForAWhile(3, "Wait for uploading");
//        }
        EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
        EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
        DriverUtils.waitForAWhile(3, "Wait for uploading");

        for (int i = 0; i < Integer.parseInt(audioAmount) - 1; i ++) {
            if (i > 0 && i%4 == 0) {
                EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
            }
            EarnMoreRewardScreen.INSTANCE().addAudioBtn.click();
            EarnMoreRewardScreen.INSTANCE().recordBtn.click();
            DriverUtils.waitForAWhile(Integer.parseInt(duration), "Wait for 20sec");
            EarnMoreRewardScreen.INSTANCE().recordBtn.click();
            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
                EarnMoreRewardScreen.INSTANCE().recordBtn.click();
            }
//            EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
//            EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
//            DriverUtils.waitForAWhile(3, "Wait for uploading");
            EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
            EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
            DriverUtils.waitForAWhile(3, "Wait for uploading");
        }
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitButton.click();
        DriverUtils.waitForAWhile(20, "Wait for uploading");
    }

    @And("I submit {string} videos with {string} seconds for each")
    public void iSubmitVideosWithSecondsForEach(String videoAmount, String duration) {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            DriverUtils.waitForAWhile(3, "Wait for seconds");
        }
        SettingScreen.INSTANCE().earnMoreReward.click();

        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();


        EarnMoreRewardScreen.INSTANCE().agreeCompleteProfileCbx.click();
        EarnMoreRewardScreen.INSTANCE().completeProfileBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstNameTxb.sendKeys("Jack");
        EarnMoreRewardScreen.INSTANCE().lastNameTxb.sendKeys("La");
        EarnMoreRewardScreen.INSTANCE().dateOfBirthTxb.sendKeys("18/02/2000");
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstCheckboxOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstCheckboxOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstMaritalStatusOption.click();
        EarnMoreRewardScreen.INSTANCE().occupationTxb.sendKeys("Test");
        EarnMoreRewardScreen.INSTANCE().firstAnnualIncomeOption.click();
        EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
        EarnMoreRewardScreen.INSTANCE().firstSkinToneOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for seconds");
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();


        EarnMoreRewardScreen.INSTANCE().videoApplyBtn.click();
        EarnMoreRewardScreen.INSTANCE().agreeQuizCbx.click();
        EarnMoreRewardScreen.INSTANCE().updateProfileBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().firstRadioOption.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        DriverUtils.waitForAWhile(3, "Wait for seconds");
        EarnMoreRewardScreen.INSTANCE().submitBtn.click();
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().recordVideoBtn.click();
        EarnMoreRewardScreen.INSTANCE().videoRecordBtn.click();
        DriverUtils.waitForAWhile(Integer.parseInt(duration), "Wait for seconds");
        try {
            EarnMoreRewardScreen.INSTANCE().videoRecordBtn.click();
        } catch (Exception e) {}
        DriverUtils.waitForAWhile(5, "Wait for uploading");
        EarnMoreRewardScreen.INSTANCE().useVideoBtn.click();
        DriverUtils.waitForAWhile(2, "Wait for uploading");
        EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
        EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
//        EarnMoreRewardScreen.INSTANCE().continueUploadBtn.click();
        DriverUtils.waitForAWhile(10, "Wait for uploading");
        for (int i = 0; i < Integer.parseInt(videoAmount) - 1; i ++) {
            if (i > 0 && i%4 == 0) {
                EarnMoreRewardScreen.INSTANCE().swipeFromTopToBottom();
            }
            EarnMoreRewardScreen.INSTANCE().addVideoBtn.click();
            EarnMoreRewardScreen.INSTANCE().videoRecordBtn.click();
            DriverUtils.waitForAWhile(Integer.parseInt(duration), "Wait for 20sec");
            try {
                EarnMoreRewardScreen.INSTANCE().videoRecordBtn.click();
            } catch (Exception e) {}
            DriverUtils.waitForAWhile(5, "Wait for uploading");
            EarnMoreRewardScreen.INSTANCE().useVideoBtn.click();
            DriverUtils.waitForAWhile(2, "Wait for uploading");
            EarnMoreRewardScreen.INSTANCE().saveDraftBtn.click();
            EarnMoreRewardScreen.INSTANCE().uploadDraftBtn.click();
//            EarnMoreRewardScreen.INSTANCE().continueUploadBtn.click();
            DriverUtils.waitForAWhile(10, "Wait for uploading");
        }
        EarnMoreRewardScreen.INSTANCE().continueBtn.click();
        EarnMoreRewardScreen.INSTANCE().submitButton.click();
        DriverUtils.waitForAWhile(20, "Wait for uploading");
    }

    @And("I click setting button")
    public void iClickSettingBtn() throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")){
            // iOS
            HomeScreen.INSTANCE().settingBtn.click();
            DriverUtils.waitForAWhile(5, "Wait for map loading");
        } else {
            // android
            HomeScreen.INSTANCE().settingBtn.click();
        }
    }

    @Then("Im on setting page and can click {string}")
    public void clickSettingPageOpt(String opt) throws InterruptedException {
            switch(opt){
                case "show profile":
                    SettingScreen.INSTANCE().showProfileBtn.click();
                    break;
                case "email":
                    SettingScreen.INSTANCE().emailBtn.click();
                    break;
                case "set wallet address":
                    SettingScreen.INSTANCE().setWalletAddressBtn.click();
                    break;
                case "change password":
                    SettingScreen.INSTANCE().changePasswordBtn.click();
                    break;
                case "earn more rewards":
                    SettingScreen.INSTANCE().earnMoreRewardsBtn.click();
                    break;
                case "help center":
                    if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                        SettingScreen.INSTANCE().helpCenterBtn.click();
                        verifyHelpCenter();
                    }
                    else {
                        verifyHelpCenter();
                    }
                    break;
                case "trust & safety":
                    SettingScreen.INSTANCE().trustAndSafetyBtn.click();
                    break;
                case "privacy policy":
                    SettingScreen.INSTANCE().privacyPolicyBtn.click();
                    break;
                case "logout":
                    SettingScreen.INSTANCE().logOutBtn.click();
                    break;
                case "delete account":
                    try{
                    SettingScreen.INSTANCE().deleteAccountBtn.click();
                    } catch(Exception e){
                        ReportScreen.INSTANCE().swipeFromTopToBottom();
                    }
                    break;
                case "refferal":
                    SettingScreen.INSTANCE().refferalBtn.click();
                    break;
            }
        }
//    }

    @Then("I can verify help center")
    public void verifyHelpCenter() throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().reportBugBtn.click();
            SettingScreen.INSTANCE().reportBugAndSuggestFeaturePage.findElement(MobileBy.AccessibilityId("main"));
            SettingScreen.INSTANCE().backBtn.click();
            SettingScreen.INSTANCE().suggestAFeatureBtn.click();
            SettingScreen.INSTANCE().reportBugAndSuggestFeaturePage.findElement(MobileBy.AccessibilityId("main"));
            SettingScreen.INSTANCE().backBtn.click();
        } else {
            SettingScreen.INSTANCE().reportBugBtnAndroid.click();
            SettingScreen.INSTANCE().urlBarChrome.findElement(MobileBy.id("com.android.chrome:id/url_bar"));
            Thread.sleep(4000);
            DriverFactory.getAndroidDriver().navigate().back();
            SettingScreen.INSTANCE().suggestAFeatureBtnAndroid.click();
            SettingScreen.INSTANCE().urlBarChrome.findElement(MobileBy.id("com.android.chrome:id/url_bar"));
        }
    }

    @Then("I can verify trust and safety")
    public void verifyTrustNSafety(){
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().trustSafetyPage.findElement(MobileBy.AccessibilityId("Geolancer – Trust & Safety (Bahasa) – Geolancer"));
        } else {
            SettingScreen.INSTANCE().trustSafetyPage.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/tvTitle"));
        }
    }

    @Then("I can verify privacy policy")
    public void verifyPrivacyPolicy(){
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().privacyPolicyPage.findElement(MobileBy.AccessibilityId("Geolancer Privacy Policy – Geolancer"));
        } else {
            SettingScreen.INSTANCE().privacyPolicyPage.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/html_viewer"));
        }
    }

    @Then("I can verify referral link")
    public void verifyDeleteAccNReff(){
            SettingScreen.INSTANCE().refferalBtn.click();
            try{
            SettingScreen.INSTANCE().refferalLink.findElement(MobileBy.AccessibilityId("~USD 5 worth of EQUAD rewards for you and your friend!"));
        } catch(Exception e){
                SettingScreen.INSTANCE().refferalLink.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/tv_title"));
            }
    }

    @And("I can verify delete account")
    public void verifyDeleteAccount(){
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().yesDeleteAccountBtn.findElement(MobileBy.AccessibilityId("Yes, delete my account"));
            SettingScreen.INSTANCE().cancelBtn.click();
        } else {
            ReportScreen.INSTANCE().swipeFromTopToBottom();
        }
    }

    @And("I can click back button")
    public void clickBackBtn(){
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().backBtn.click();
        }
    }

    @Then("I can verify there are project or campaign inside earn more rewards")
    public void verifyProject() throws InterruptedException {
//        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().guideLinesBtn.click();
            Thread.sleep(2000);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SettingScreen.INSTANCE().backBtnInsideCampaign.click();
            Thread.sleep(2000);
        } else {
            SettingScreen.INSTANCE().backBtn.click();
        }
            SettingScreen.INSTANCE().answerMoreBtn.click();
            Thread.sleep(2000);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SettingScreen.INSTANCE().backBtnInsideCampaign.click();
        } else {
            SettingScreen.INSTANCE().backBtn.click();
        }
            ReportScreen.INSTANCE().swipeFromTopToBottom();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SettingScreen.INSTANCE().completeYourProfileBtn.findElement(MobileBy.AccessibilityId("Complete your profile"));
            SettingScreen.INSTANCE().checkBox.click();
            SettingScreen.INSTANCE().unCheckBox.click();
        } else {
            ReportScreen.INSTANCE().swipeFromTopToBottom();
            SettingScreen.INSTANCE().completeYourProfileBtn.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/btnTakeQuizComponent"));
            SettingScreen.INSTANCE().checkBox.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/cbQuizComponent"));;
        }
    }

    @Then("I can set {string} wallet with {string}")
    public void setWalletAddress(String valid, String walletAddressValue) {
//        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            if(valid.equals("valid")){
                SettingScreen.INSTANCE().walletAddressTextBox.clear();
                SettingScreen.INSTANCE().walletAddressTextBox.sendKeys(walletAddressValue);
                SettingScreen.INSTANCE().addWalletContinueBtn.click();
                SettingScreen.INSTANCE().oKWalletAddressBtn.click();
            } else {
                SettingScreen.INSTANCE().walletAddressTextBox.clear();
                SettingScreen.INSTANCE().walletAddressTextBox.sendKeys(walletAddressValue);
                SettingScreen.INSTANCE().addWalletContinueBtn.click();
                try{
                SettingScreen.INSTANCE().warningAddWallet.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Must have at least 42 characters\"]"));
                }catch(Exception e){
                    SettingScreen.INSTANCE().addWalletContinueBtn.findElement(By.id("com.sheelafoam.quadrant.staging:id/btnAddWallet"));
                }
            }
        }
//    }

    @Then("I can verify the value of profile shouldnt be wrong")
    public void verifyProfile(){
            SettingScreen.INSTANCE().showProfileBtn.click();
            assertThat(SettingScreen.INSTANCE().showProfileNameTextBox.getText()).isEqualTo("Geotest1 11");
            assertThat(SettingScreen.INSTANCE().showProfileEmailTextBox.getText()).isEqualTo("geotest111@mailinator.com");
//        try {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            assertThat(SettingScreen.INSTANCE().showProfilePhoneNumberTextBox.getText()).isEqualTo("8983523131");
        }else {
            assertThat(SettingScreen.INSTANCE().showProfilePhoneNumberTextBox.getText()).isEqualTo("+628983523131");
        }
    }

    @Then("I can set {string} on current password with {string} and new password with {string}")
    public void setCurrentPassword(String valid, String currentPassValue, String newPassValue) {
//        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            switch (valid){
                case "valid":
                    SettingScreen.INSTANCE().currentPasswordTextBox.sendKeys(currentPassValue);
                    SettingScreen.INSTANCE().newPasswordTextBox.sendKeys(newPassValue);
                    SettingScreen.INSTANCE().saveBtn.click();
                    if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                    SettingScreen.INSTANCE().oKPassUpdatedBtn.click();
                    }
                    break;
                case "invalid one":
                    SettingScreen.INSTANCE().currentPasswordTextBox.sendKeys(currentPassValue);
                    SettingScreen.INSTANCE().newPasswordTextBox.sendKeys(newPassValue);
                    SettingScreen.INSTANCE().saveBtn.click();
                    if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                    SettingScreen.INSTANCE().currentPassWarning.findElement(MobileBy.AccessibilityId("Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character."));
                    } else {
                        SettingScreen.INSTANCE().currentPassWarning.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/snackbar_text"));
                    }
                    break;
                case "invalid two":
                    SettingScreen.INSTANCE().currentPasswordTextBox.sendKeys(currentPassValue);
                    SettingScreen.INSTANCE().newPasswordTextBox.sendKeys(newPassValue);
                    SettingScreen.INSTANCE().saveBtn.click();
                    if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                    SettingScreen.INSTANCE().newPassWarning.findElement(MobileBy.AccessibilityId("Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character."));
                    } else {
                        SettingScreen.INSTANCE().currentPassWarning.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/snackbar_text"));
                    }
                    break;
                default:
                    SettingScreen.INSTANCE().currentPasswordTextBox.sendKeys(currentPassValue);
                    SettingScreen.INSTANCE().newPasswordTextBox.sendKeys(newPassValue);
                    SettingScreen.INSTANCE().saveBtn.click();
                    if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                    SettingScreen.INSTANCE().currentPassWarning.findElement(MobileBy.AccessibilityId("Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character."));
                    SettingScreen.INSTANCE().newPassWarning.findElement(MobileBy.AccessibilityId("Use 8-30 characters and should contain alphanumeric (upper case & lower case) characters and a symbol character."));
                    }else {
                        SettingScreen.INSTANCE().currentPassWarning.findElement(MobileBy.id("com.sheelafoam.quadrant.staging:id/snackbar_text"));
                    }
                    break;
            }
    }

    @Then("I can verify Sign Up Button and redirect to Sign Up Page")
    public void goToSignUpPage() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @When("I open url for referral code")
    public void iOpenUrlForReferralCode() {
        DriverFactory.getCurrentAppiumDriver().get("https://geolancer.test-app.link/1yrm6BkZHCb");
    }

    @Then("I verify user can change password successfully")
    public void iVerifyUserCanChangePasswordSuccessfully() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().loginBtn.click();
        LoginScreen.INSTANCE().forgotPasswordBtn.click();
        ForgotPasswordScreen.INSTANCE().emailTxb.sendKeys(Config.ENV.FORGOT_PASSWORD_USER());
        ForgotPasswordScreen.INSTANCE().getOTPBtn.click();
        DriverUtils.waitForAWhile(5,"Wait for loading");
        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest_geolancer");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            ForgotPasswordScreen.INSTANCE().otpTxb.click();
            ForgotPasswordScreen.INSTANCE().otpTxb.sendKeys(otpCode);
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            ForgotPasswordScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            ForgotPasswordScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            ForgotPasswordScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            ForgotPasswordScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            ForgotPasswordScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            ForgotPasswordScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
        }
        ForgotPasswordScreen.INSTANCE().oneTimePasswordLabel.click();
        ForgotPasswordScreen.INSTANCE().verifyAndProceedBtn.click();
        String newPassword = DriverUtils.generateRandomPassword();
        ScenarioContext.currentContext().set("New Password").with(newPassword);
        ForgotPasswordScreen.INSTANCE().newPasswordTxb.sendKeys(newPassword);
        ForgotPasswordScreen.INSTANCE().confirmNewPasswordBtn.click();
        softly.assertThat(ForgotPasswordScreen.INSTANCE().changePasswordSuccessLabel.isDisplayed()).isTrue();
        ForgotPasswordScreen.INSTANCE().backToLoginBtn.click();
        softly.assertAll();
    }

    @When("I login with new password successfully")
    public void iLoginWithNewPasswordSuccessfully() throws InterruptedException {
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            Thread.sleep(1000);
            HomeScreen.INSTANCE().loginBtn.click();
            try {
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.FORGOT_PASSWORD_USER());
            } catch (Exception e) {
                HomeScreen.INSTANCE().loginBtn.click();
                LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.FORGOT_PASSWORD_USER());
            }
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(ScenarioContext.currentContext().get("New Password", String.class));
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            if(_location == Run.BROWSER_STACK){
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            }
            LoginScreen.INSTANCE().getStartedIcon.click();
            MapScreen.INSTANCE().applicationPermissiom.click();
            MapScreen.INSTANCE().skipWalletSetup.click();
            DriverUtils.waitForAWhile(1, "Wait for 1 second");
            MapScreen.INSTANCE().addYourFirstPOI.click();
            MapScreen.INSTANCE().closeAds.click();
        } else {
            LoginScreen.INSTANCE().emailTextbox.sendKeys(Config.ENV.FORGOT_PASSWORD_USER());
            LoginScreen.INSTANCE().passwordTextbox.sendKeys(ScenarioContext.currentContext().get("New Password", String.class));
            LoginScreen.INSTANCE().loginLabel.click();
            LoginScreen.INSTANCE().continueButton.click();
            LoginScreen.INSTANCE().getStartedIcon.click();
        }
    }

    @Then("I verify user can change password successfully after resend OTP")
    public void iVerifyUserCanChangePasswordSuccessfullyAfterResendOTP() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().loginBtn.click();
        LoginScreen.INSTANCE().forgotPasswordBtn.click();
        ForgotPasswordScreen.INSTANCE().emailTxb.sendKeys(Config.ENV.FORGOT_PASSWORD_USER());
        ForgotPasswordScreen.INSTANCE().getOTPBtn.click();
        ForgotPasswordScreen.INSTANCE().resendOTPBtn.click();
        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("geotest111");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            ForgotPasswordScreen.INSTANCE().otpTxb.click();
            ForgotPasswordScreen.INSTANCE().otpTxb.sendKeys(otpCode);
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            ForgotPasswordScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            ForgotPasswordScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            ForgotPasswordScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            ForgotPasswordScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            ForgotPasswordScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            ForgotPasswordScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
        }
        ForgotPasswordScreen.INSTANCE().oneTimePasswordLabel.click();
        ForgotPasswordScreen.INSTANCE().verifyAndProceedBtn.click();
        String newPassword = DriverUtils.generateRandomPassword();
        ScenarioContext.currentContext().set("New Password").with(newPassword);
        ForgotPasswordScreen.INSTANCE().newPasswordTxb.sendKeys(newPassword);
        ForgotPasswordScreen.INSTANCE().confirmNewPasswordBtn.click();
        softly.assertThat(ForgotPasswordScreen.INSTANCE().changePasswordSuccessLabel.isDisplayed()).isTrue();
        ForgotPasswordScreen.INSTANCE().backToLoginBtn.click();
        softly.assertAll();
    }

    @Then("I verify user can not change password with wrong email format")
    public void iVerifyUserCanNotChangePasswordWithWrongEmailFormat() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().loginBtn.click();
        LoginScreen.INSTANCE().forgotPasswordBtn.click();
        ForgotPasswordScreen.INSTANCE().emailTxb.sendKeys("aaa@bbb");
        ForgotPasswordScreen.INSTANCE().getOTPBtn.click();
        softly.assertThat(ForgotPasswordScreen.INSTANCE().emailErrorMessage.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can not change password with non-existing email")
    public void iVerifyUserCanNotChangePasswordWithNonExistingEmail() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String email = "autotest" + formattedDateTime + "@mailinator.com";
        HomeScreen.INSTANCE().loginBtn.click();
        LoginScreen.INSTANCE().forgotPasswordBtn.click();
        ForgotPasswordScreen.INSTANCE().emailTxb.sendKeys(email);
        ForgotPasswordScreen.INSTANCE().getOTPBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            softly.assertThat(ForgotPasswordScreen.INSTANCE().emailErrorMessage.isDisplayed()).isTrue();
        }
        softly.assertAll();
    }

    @When("I go to Report Page")
    public void iGoToReportPage() {
        MapScreen.INSTANCE().reportBtn.click();
    }

    @Then("I verify Total Created POIs amount is correct")
    public void iVerifyTotalCreatedPOIsAmountIsCorrect() {
        SoftAssertions softly = new SoftAssertions();
        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");
        softly.assertThat(Integer.parseInt(ReportScreen_DetailedReport.INSTANCE().totalPOICount.getText())).isGreaterThan(0);
    }

    @Then("I verify user can scroll up and down in Detailed Report screen")
    public void iVerifyUserCanScrollUpAndDownInDetailedReportScreen() {
        ReportScreen_DetailedReport.INSTANCE().swipeFromTopToBottom();
        ReportScreen_DetailedReport.INSTANCE().swipeFromBottomToTop();
    }

    @Then("I verify user can set filter Start and End date")
    public void iVerifyUserCanSetFilterStartAndEndDate() {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            ReportScreen_DetailedReport.INSTANCE().calendarStartDate.click();
            ReportScreen_DetailedReport.INSTANCE().selectStartDateAndEndDate();
            ReportScreen_DetailedReport.INSTANCE().calendarOkBtn.click();
        } else {
            ReportScreen_DetailedReport.INSTANCE().calendarStartDate.click();
            ReportScreen_DetailedReport.INSTANCE().selectStartDate();
            ReportScreen_DetailedReport.INSTANCE().calendarOkBtn.click();
            ReportScreen_DetailedReport.INSTANCE().calendarEndDate.click();
            ReportScreen_DetailedReport.INSTANCE().selectEndDate();
            ReportScreen_DetailedReport.INSTANCE().calendarOkBtn.click();
        }

        DriverUtils.waitForAWhile(5, "Wait for loading");

        String poiCreatedDate = ReportScreen_DetailedReport.INSTANCE().firstRecordCreatedDate.getText().split(":")[1].split("\\|")[0].trim();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

        // Example date strings
        String dateString1 = "Aug 01, 2023";
        String dateString2 = "Aug 30, 2023";

        // Parse the date strings into LocalDate objects
        LocalDate createdDate = LocalDate.parse(poiCreatedDate, formatter);

        LocalDate startDate = LocalDate.parse(dateString1, formatter);
        LocalDate endDate = LocalDate.parse(dateString2, formatter);

        softly.assertThat(createdDate.isAfter(startDate)).isTrue();
        softly.assertThat(createdDate.isBefore(endDate)).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can filter by {string}")
    public void iVerifyUserCanFilterBy(String type) {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_DetailedReport.INSTANCE().filterBtn.click();
        if (type.equalsIgnoreCase("Regular")) {
            ReportScreen_DetailedReport.INSTANCE().regularTypeFilter.click();
        } else {
            ReportScreen_DetailedReport.INSTANCE().premiumTypeFilter.click();
        }
        ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");
        ReportScreen_DetailedReport.INSTANCE().firstRecord.click();

//        softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailType.getText()).isEqualTo(type);

        ReportScreen_DetailedReport.INSTANCE().backBtn.click();

        softly.assertAll();
    }

    @Then("I verify Reset button work properly")
    public void iVerifyResetButtonWorkProperly() {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        String firstRecordName = ReportScreen_DetailedReport.INSTANCE().firstRecordName.getText();

        ReportScreen_DetailedReport.INSTANCE().filterBtn.click();
        ReportScreen_DetailedReport.INSTANCE().regularTypeFilter.click();
        ReportScreen_DetailedReport.INSTANCE().sortByZToAFilter.click();
        ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        String firstRecordNameAfterFilter = ReportScreen_DetailedReport.INSTANCE().firstRecordName.getText();

        softly.assertThat(firstRecordName).isNotEqualTo(firstRecordNameAfterFilter);

        ReportScreen_DetailedReport.INSTANCE().filterBtn.click();
        ReportScreen_DetailedReport.INSTANCE().resetFilterBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        String firstRecordNameAfterReset = ReportScreen_DetailedReport.INSTANCE().firstRecordName.getText();

        softly.assertThat(firstRecordName).isEqualTo(firstRecordNameAfterReset);

        softly.assertAll();
    }

    @Then("I verify user can sort by {string}")
    public void iVerifyUserCanSortBy(String type) {
        String createdDateFirstRecord = "";
        String createdDateSecondRecord = "";

        String firstRecordName = "";
        String secondRecordName = "";

        DateTimeFormatter formatter;
        LocalDate fistRecord;
        LocalDate secondRecord;

        boolean isInAlphabeticalOrder;

        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_DetailedReport.INSTANCE().filterBtn.click();
        switch (type) {
            case "Latest":
                ReportScreen_DetailedReport.INSTANCE().sortByLatestFilter.click();
                ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
                DriverUtils.waitForAWhile(5, "Wait for loading");
                createdDateFirstRecord = ReportScreen_DetailedReport.INSTANCE().firstRecordCreatedDate.getText().split(":")[1].split("\\|")[0].trim();
                createdDateSecondRecord = ReportScreen_DetailedReport.INSTANCE().secondRecordCreatedDate.getText().split(":")[1].split("\\|")[0].trim();
                formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

                fistRecord = LocalDate.parse(createdDateFirstRecord, formatter);
                secondRecord = LocalDate.parse(createdDateSecondRecord, formatter);

                softly.assertThat(fistRecord.isAfter(secondRecord)).isTrue();
                break;
            case "Oldest":
                ReportScreen_DetailedReport.INSTANCE().sortByOldestFilter.click();
                ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
                DriverUtils.waitForAWhile(5, "Wait for loading");
                createdDateFirstRecord = ReportScreen_DetailedReport.INSTANCE().firstRecordCreatedDate.getText().split(":")[1].split("\\|")[0].trim();
                createdDateSecondRecord = ReportScreen_DetailedReport.INSTANCE().secondRecordCreatedDate.getText().split(":")[1].split("\\|")[0].trim();
                formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

                fistRecord = LocalDate.parse(createdDateFirstRecord, formatter);
                secondRecord = LocalDate.parse(createdDateSecondRecord, formatter);

                softly.assertThat(fistRecord.isBefore(secondRecord)).isTrue();
                break;
            case "A-Z":
                ReportScreen_DetailedReport.INSTANCE().sortByAToZFilter.click();
                ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
                DriverUtils.waitForAWhile(5, "Wait for loading");
                firstRecordName = ReportScreen_DetailedReport.INSTANCE().firstRecordName.getText();
                secondRecordName = ReportScreen_DetailedReport.INSTANCE().secondRecordName.getText();

                isInAlphabeticalOrder = DriverUtils.isInAlphabeticalOrder(firstRecordName, secondRecordName);

                softly.assertThat(isInAlphabeticalOrder).isTrue();
                break;
            case "Z-A":
                ReportScreen_DetailedReport.INSTANCE().sortByZToAFilter.click();
                ReportScreen_DetailedReport.INSTANCE().applyFilterBtn.click();
                DriverUtils.waitForAWhile(5, "Wait for loading");
                firstRecordName = ReportScreen_DetailedReport.INSTANCE().firstRecordName.getText();
                secondRecordName = ReportScreen_DetailedReport.INSTANCE().secondRecordName.getText();

                isInAlphabeticalOrder = DriverUtils.isInAlphabeticalOrder(firstRecordName, secondRecordName);

                softly.assertThat(isInAlphabeticalOrder).isFalse();
                break;
            default:
                break;
        }
        ReportScreen_DetailedReport.INSTANCE().backBtn.click();
        softly.assertAll();
    }

    @Then("I verify user can filter with {string} POI status")
    public void iVerifyUserCanFilterWithPOI(String status) {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        switch (status) {
            case "Approved":
                ReportScreen_DetailedReport.INSTANCE().poiApprovedTab.click();
                DriverUtils.waitForAWhile(5, "Wait for loading");
                ReportScreen_DetailedReport.INSTANCE().firstRecord.click();
                softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailedStatus.getText()).isEqualTo("APPROVED");
                ReportScreen_DetailedReport.INSTANCE().backBtn.click();
                break;
            case "Rejected":
                if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
                    ReportScreen_DetailedReport.INSTANCE().poiRejectedTab.click();
                    DriverUtils.waitForAWhile(5, "Wait for loading");
                    ReportScreen_DetailedReport.INSTANCE().firstRecord.click();
                    softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailedStatus.getText()).isEqualTo("REJECTED");
                    ReportScreen_DetailedReport.INSTANCE().backBtn.click();
                } else {
                    ReportScreen_DetailedReport.INSTANCE().poiRejectedTab.click();
                    DriverUtils.waitForAWhile(5, "Wait for loading");
                    softly.assertThat(ReportScreen_DetailedReport.INSTANCE().firstRecordCreatedDate.getText().contains("Rejected")).isTrue();
                }
                break;
        }
        ReportScreen_DetailedReport.INSTANCE().backBtn.click();
        softly.assertAll();
    }

    @Then("I verify POI detail are showing properly")
    public void iVerifyPOIDetailAreShowingProperly() {
        SoftAssertions softly = new SoftAssertions();
        ReportScreen.INSTANCE().poiCreatedBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_DetailedReport.INSTANCE().poiApprovedTab.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");
        ReportScreen_DetailedReport.INSTANCE().firstRecord.click();
        softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailName.isDisplayed()).isTrue();
        softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailedStatus.isDisplayed()).isTrue();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailType.isDisplayed()).isTrue();
        }
        softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailCreatedDate.isDisplayed()).isTrue();
        softly.assertThat(ReportScreen_DetailedReport.INSTANCE().poiDetailMapView.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify the filter is correct with type {string}")
    public void iVerifyTheFilterIsCorrectWithType(String type) {
        DateTimeFormatter inputFormatter;

        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().equadPointTab.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_eQuadPoint.INSTANCE().selectFilterByType(type);
        DriverUtils.waitForAWhile(5, "Wait for loading");


        if (!ReportScreen_eQuadPoint.INSTANCE().isNoRecordPresent()) {

            String poiCreatedDate = ReportScreen_NFTReport.INSTANCE().firstNFTCardName.getText();

            System.out.println("POI Created Date: " + poiCreatedDate);

            if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
                inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy | h:mm:ss a");
            } else {
                inputFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy | HH:mm");
            }

            // Parse the input string to LocalDateTime
            LocalDateTime dateTime = LocalDateTime.parse(poiCreatedDate, inputFormatter);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

            // Extract and format the date component
            String poiCreatedDateTime = dateTime.toLocalDate().format(formatter);

            // Parse the date strings into LocalDate objects
            LocalDate createdDate = LocalDate.parse(poiCreatedDateTime, formatter);

            System.out.println("POI Created Date with formatted: " + createdDate);

            LocalDate now = LocalDate.now();
            String formattedDate = now.format(formatter);
            LocalDate currentDate = LocalDate.parse(formattedDate, formatter);

            System.out.println("Current Date: " + currentDate);

            LocalDate startDateOfThisWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

            LocalDate endDateOfThisWeek = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

            LocalDate startDateOfThisMonth = now.with(TemporalAdjusters.firstDayOfMonth());

            LocalDate endDateOfThisMonth = now.with(TemporalAdjusters.lastDayOfMonth());

            LocalDate startDateOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());

            LocalDate endDateOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

            switch (type) {
                case "All":
                    softly.assertThat(createdDate.isBefore(currentDate)).isTrue();
                    break;
                case "Today":
                    softly.assertThat(createdDate.isEqual(currentDate)).isTrue();
                    break;
                case "This Week":
                    softly.assertThat(createdDate.isAfter(startDateOfThisWeek)).isTrue();
                    softly.assertThat(createdDate.isBefore(endDateOfThisWeek)).isTrue();
                    break;
                case "This Month":
                    softly.assertThat(createdDate.isAfter(startDateOfThisMonth)).isTrue();
                    softly.assertThat(createdDate.isBefore(endDateOfThisMonth)).isTrue();
                    break;
                case "Last Month":
                    softly.assertThat(createdDate.isAfter(startDateOfLastMonth)).isTrue();
                    softly.assertThat(createdDate.isBefore(endDateOfLastMonth)).isTrue();
                    break;
            }
        }
        softly.assertAll();
    }

    @Then("I verify the UI of NFT report page are showing correctly")
    public void iVerifyTheUIOfNFTReportPageAreShowingCorrectly() {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().nftTab.click();

        DriverUtils.waitForAWhile(5, "Wait for loading");

        softly.assertThat(ReportScreen_NFTReport.INSTANCE().lastNFTLabel.getText()).isEqualTo("Your Most Recent NFTs");
        softly.assertThat(ReportScreen_NFTReport.INSTANCE().howToGetNFTLink.getText()).isEqualTo("How to get NFTs?");

        ReportScreen_NFTReport.INSTANCE().nftInfo.click();
        softly.assertThat(ReportScreen_NFTReport.INSTANCE().isToolTipDisplayedWithText("This is total NFTs you have")).isTrue();

        ReportScreen_NFTReport.INSTANCE().bonusInfo.click();
//        softly.assertThat(ReportScreen_NFTReport.INSTANCE().isToolTipDisplayedWithText("This is total bonus from\n all of your NFTs")).isTrue();

        softly.assertThat(ReportScreen_NFTReport.INSTANCE().nftBonusLabel.isDisplayed()).isTrue();

        softly.assertAll();
    }

    @Then("I verify search function of NFTs screen are working correctly")
    public void iVerifySearchFunctionOfNFTsScreenAreWorkingCorrectly() {
        SoftAssertions softly = new SoftAssertions();

        ReportScreen.INSTANCE().nftTab.click();

        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_NFTReport.INSTANCE().viewAllMyNFTLink.click();

        DriverUtils.waitForAWhile(1, "Wait for loading");

        ReportScreen_NFTReport.INSTANCE().searchNFTsField.sendKeys("August 2023");

        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            ((AndroidDriver) DriverFactory.getAndroidDriver()).pressKeyCode(AndroidKeyCode.ENTER);
        } else {
            DriverFactory.getIOSDriver().getKeyboard().sendKeys("\n");
        }
        DriverUtils.waitForAWhile(1, "Wait for loading");

        softly.assertThat(ReportScreen_NFTReport.INSTANCE().firstNFTCardName.getText().contains("8-2023")).isTrue();
        softly.assertThat(ReportScreen_NFTReport.INSTANCE().firstNFTCardDescription.getText().contains("August 2023")).isTrue();

        ReportScreen_NFTReport.INSTANCE().searchNFTsField.clear();

        softly.assertAll();
    }

    @Then("I verify the filter is correct with type name {string} in NFT Report")
    public void iVerifyTheFilterIsCorrectWithTypeNameInNFTReport(String name) {
        DateTimeFormatter inputFormatter;

        SoftAssertions softly = new SoftAssertions();

        ReportScreen_NFTReport.INSTANCE().selectFilterByType(name);
        DriverUtils.waitForAWhile(2, "Wait for loading");

        softly.assertThat(ReportScreen_NFTReport.INSTANCE().firstNFTCardDescription.getText().contains(name)).isTrue();

        ReportScreen_NFTReport.INSTANCE().selectFilterByType("All");

        softly.assertAll();
    }

    @Then("I verify the NFT details are correct")
    public void iVerifyTheNFTDetailsAreCorrect() {
        SoftAssertions softly = new SoftAssertions();

        DriverUtils.waitForAWhile(5, "Wait for loading");

        ReportScreen_NFTReport.INSTANCE().viewAllMyNFTLink.click();

        DriverUtils.waitForAWhile(1, "Wait for loading");

        softly.assertThat(ReportScreen_NFTReport.INSTANCE().nftDetailTitle.isDisplayed()).isTrue();
        softly.assertThat(ReportScreen_NFTReport.INSTANCE().nftDetailBonusPercentage.isDisplayed()).isTrue();
        softly.assertThat(ReportScreen_NFTReport.INSTANCE().checkOnOpenseaBtn.isDisplayed()).isTrue();

        softly.assertAll();
    }


    @Then("I successfully login in into Appen App with email {string} using password {string}")
    public void iLoginToAppenApps(String email, String password) {
        HomeScreen.INSTANCE().appenSignInBtn.click();
        LoginScreen.INSTANCE().emailAddressField.sendKeys(email);
        LoginScreen.INSTANCE().passwordField.sendKeys(password);
        DriverUtils.waitForAWhile(1, "Wait for loading");
        LoginScreen.INSTANCE().signInBtn.click();
        DriverUtils.waitForAWhile(5, "Wait for loading");
    }

    @Then("I login in into Appen App using invalid email and password")
    public void checkInvalidEmail() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().appenSignInBtn.click();
        LoginScreen.INSTANCE().emailAddressField.sendKeys("asdasdasd");
        LoginScreen.INSTANCE().passwordField.sendKeys("asdcacad");
        LoginScreen.INSTANCE().signInBtn.click();
        assertThat(LoginScreen.INSTANCE().emailWarningMsg.getText()).isEqualTo("The email format is incorrect. Please use a valid email address in this format: name@email.com.");
//        DriverUtils.waitForAWhile(5, "Wait");

    }

    @Then("I login in into Appen App using invalid password")
    public void checkInvalidPassword() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().appenSignInBtn.click();
        LoginScreen.INSTANCE().emailAddressField.sendKeys("ptuser0100_appen@yopmail.com");
        LoginScreen.INSTANCE().passwordField.sendKeys("asdcacad");
        LoginScreen.INSTANCE().signInBtn.click();
        assertThat(LoginScreen.INSTANCE().passwordWarningMsg.getText()).isEqualTo("Incorrect email address or password.");
    }

    @Then("I can verify this is account with email {string}")
    public void verifyEmailProfile(String email) {
        DriverUtils.waitForAWhile(4, "Wait");
        HomeScreen.INSTANCE().profileBtn.click();
        String emails = HomeScreen.INSTANCE().emailProfileText.getText();
//        System.out.println("Actual email: " + emails);
        assertThat(emails).isEqualTo(email);
    }

    @Then("I can logout from Appen App")
    public void logout() {
        SoftAssertions softly = new SoftAssertions();
        HomeScreen.INSTANCE().logoutBtn.click();
        softly.assertThat(HomeScreen.INSTANCE().appenSignInBtn.isDisplayed()).isTrue();
    }


    @Then("I can click link and verify the URL is {string}")
    public void welcomingExternalLink(String URL) {
        HomeScreen.INSTANCE().welcomeURL.click();
        String chromeURL = HomeScreen.INSTANCE().chromeURL.getText();
        assertThat(chromeURL).isEqualTo(URL);
    }

    @Then("I can click link and verify the our website URL is {string}")
    public void ourWebsiteLink(String URL) {
        HomeScreen.INSTANCE().webURL.click();
        String chromeURL = HomeScreen.INSTANCE().chromeURL.getText();
        assertThat(chromeURL).isEqualTo(URL);
    }

    @Then("I can click link and verify the our website URLs is {string}")
    public void ourWebsiteProjectScreen(String URL) {
        HomeScreen.INSTANCE().ourWebsiteURL.click();
        String chromeURL = HomeScreen.INSTANCE().chromeURL.getText();
        assertThat(chromeURL).isEqualTo(URL);
    }

    @Then("I can click by using coordinate {int} and {int}")
    public void clickAtCoordinates(int x, int y) {
        DriverUtils.waitForAWhile(10, "Wait");
//        System.out.println("Attempting to tap at coordinates: (" + x + ", " + y + ")");
        try {
            if (DriverFactory.getCurrentAppiumDriver() != null) {
                new TouchAction(DriverFactory.getCurrentAppiumDriver())
                        .tap(PointOption.point(x, y))
                        .perform();
                System.out.println("Tap action performed successfully.");
            } else {
                System.out.println("Driver is not initialized.");
            }
        } catch (Exception e) {
            System.out.println("Error during tap action: " + e.getMessage());
        }
    }

    @Then("I verify the website URLs is {string}")
    public void verifyChromeURL(String URL) {
        String chromeURL = HomeScreen.INSTANCE().chromeURL.getText();
        assertThat(chromeURL).isEqualTo(URL);
    }

//    @Then("I click start working button on {int} job")
//    public void clickStartBtn(int index) {
//        DriverUtils.waitForAWhile(10, "Wait");
//        DriverFactory.getAndroidDriver().findElement(By.xpath("(//android.view.ViewGroup[contains(@content-desc, 'Start working')]/android.view.ViewGroup[1])["+index+"]")).click();
//    }
    @Then("I click start working button on {int} job")
    public void clickStartBtn(int index) {
        DriverUtils.waitForAWhile(10, "Wait");
        String dynamicXPath = String.format("(//android.widget.TextView[contains(@text, 'Data Collection')])[%d]", index);
        System.out.println("Using XPath: " + dynamicXPath); // Log the XPath
        WebDriverWait wait = new WebDriverWait(DriverFactory.getAndroidDriver(), 10);
        MobileElement startBtn = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dynamicXPath)));
        startBtn.click();
    }


    @Then("I verify the job page")
    public void verifyJobPage() {
        DriverUtils.waitForAWhile(3, "Wait");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(HomeScreen.INSTANCE().descPage.isDisplayed()).isTrue();
    }
}
