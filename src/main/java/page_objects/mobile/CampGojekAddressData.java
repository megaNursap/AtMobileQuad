package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

import java.time.temporal.ChronoUnit;

public class CampGojekAddressData extends BaseScreen {
    public static String androidPoiName;
    public static String eQuadCollector;
    public static String eQuadVerifier;

    private CampGojekAddressData() {
        initializePage(this);
    }

    public static CampGojekAddressData INSTANCE() {
        return new CampGojekAddressData();
    }

    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Gojek Address Data Collection BE - default category']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement selectGojekCampaign;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/button_continue")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueCampBtn;

    @AndroidFindBy(id="com.sheelafoam.quadrant.staging:id/btnOk")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement popUpCampOkBtn;

    @AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc='location_name']//android.widget.EditText[@resource-id='com.sheelafoam.quadrant.staging:id/editTextMain']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement locationNameTx;

}
