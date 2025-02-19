package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.time.temporal.ChronoUnit;

public class AddWalletScreen extends BaseScreen {

    private AddWalletScreen() {
        initializePage(this);
    }

    public static AddWalletScreen INSTANCE() {
        return new AddWalletScreen();
    }

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_read_guide")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement nextBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_read_guide")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement readtheGuideBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btn_add_wallet")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addAWalletBtn;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/etWalletAddress")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement polygonAddressTxb;

    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/btnAddWallet")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement confirmAddressBtn;
}
