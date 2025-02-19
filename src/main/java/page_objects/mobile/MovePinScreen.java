package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;

public class MovePinScreen extends BaseScreen {

    private MovePinScreen() {
        initializePage(this);
    }

    public static MovePinScreen INSTANCE() {
        return new MovePinScreen();
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Save\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement saveBtn;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnMoveMyPin")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement moveMyPin;

}
