package page_objects.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import utils.Config;
import utils.factory.DriverFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReportScreen_DetailedReport extends BaseScreen {

    private ReportScreen_DetailedReport() {
        initializePage(this);
    }

    public static ReportScreen_DetailedReport INSTANCE() {
        return new ReportScreen_DetailedReport();
    }

    @iOSXCUITFindBy(accessibility = "All")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/tl_options_filter']//*[contains(@text, 'Approved')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiAllTab;

    @iOSXCUITFindBy(accessibility = "Approved")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/tl_options_filter']//*[contains(@text, 'Approved')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiApprovedTab;

    @iOSXCUITFindBy(accessibility = "Rejected")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/tl_options_filter']//*[contains(@text, 'Rejected')]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiRejectedTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Created POI(s)\"]/parent::*/XCUIElementTypeButton[1]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/iv_third_filter")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement filterBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Created POI(s)\"]/parent::*/XCUIElementTypeStaticText[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_search_filter_header_value")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement totalPOICount;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeImage[1]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_poi_list']/android.view.ViewGroup[1]/*[@resource-id='com.sheelafoam.quadrant.staging:id/item_report_arrow_iv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstRecord;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[2]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_poi_list']/android.view.ViewGroup[1]/*[@resource-id='com.sheelafoam.quadrant.staging:id/poi_created_date_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstRecordCreatedDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[10]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_poi_list']/android.view.ViewGroup[5]/*[@resource-id='com.sheelafoam.quadrant.staging:id/poi_created_date_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement secondRecordCreatedDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[1]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_poi_list']/android.view.ViewGroup[1]/*[@resource-id='com.sheelafoam.quadrant.staging:id/poi_name_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement firstRecordName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[9]")
    @AndroidFindBy(xpath = "//*[@resource-id='com.sheelafoam.quadrant.staging:id/rv_poi_list']/android.view.ViewGroup[5]/*[@resource-id='com.sheelafoam.quadrant.staging:id/poi_name_tv']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement secondRecordName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement backBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Created POI(s)\"]/parent::*/XCUIElementTypeButton[2]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_first_filter_placeholder")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarStartDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Total Created POI(s)\"]/parent::*/XCUIElementTypeButton[3]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/tv_second_filter_placeholder")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarEndDate;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Back\"])[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/month_navigation_previous")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarPrevMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Forward\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/month_navigation_next")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarNextMonth;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Forward\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/confirm_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarMonthNavigationToggle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/confirm_button")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarOkBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    @AndroidFindBy(id = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarCancelBtn;

    @iOSXCUITFindBy(accessibility = "Reset")
    @AndroidFindBy(id = "//XCUIElementTypeButton[@name=\"Cancel\"]")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement calendarResetBtn;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Back\"]/parent::*/parent::*/XCUIElementTypeOther/*/*/*/XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Auto test\"])[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/poi_detail_name_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiDetailName;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Back\"]/parent::*/parent::*/XCUIElementTypeOther/*/*/*/XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"APPROVED\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/poi_detail_status_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiDetailedStatus;

//    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Back\"]/parent::*/parent::*/XCUIElementTypeOther/*/*/*/XCUIElementTypeScrollView/*/XCUIElementTypeStaticText[3]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"May 28, 2023 | 13:43 pm\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/poi_detail_created_date_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiDetailCreatedDate;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"eQuad Points\"]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/poi_detail_type_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiDetailType;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Back\"]/parent::*/parent::*/XCUIElementTypeOther/*/*/*/XCUIElementTypeScrollView/*/XCUIElementTypeImage[2]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/poi_detail_map_view")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement poiDetailMapView;

    @iOSXCUITFindBy(accessibility = "Regular")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/type_regular_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement regularTypeFilter;

    @iOSXCUITFindBy(accessibility = "Premium")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/type_premium_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement premiumTypeFilter;

    @iOSXCUITFindBy(accessibility = "Latest")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sort_by_latest_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sortByLatestFilter;

    @iOSXCUITFindBy(accessibility = "Oldest")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sort_by_oldest_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sortByOldestFilter;

    @iOSXCUITFindBy(accessibility = "A-Z")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sort_by_atoz_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sortByAToZFilter;

    @iOSXCUITFindBy(accessibility = "Z-A")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/sort_by_ztoa_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement sortByZToAFilter;

    @iOSXCUITFindBy(accessibility = "Show all POIs under review")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/status_under_review_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement statusUnderReviewFilter;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Reset\"]/XCUIElementTypeImage")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/reset_tv")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resetFilterBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Apply')]")
    @AndroidFindBy(id = "com.sheelafoam.quadrant.staging:id/apply_btn")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement applyFilterBtn;

    public void  selectStartDateAndEndDate() {
        LocalDate currentDate = LocalDate.now();

        // Get the current month
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();


        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            for (int i = 0; i < currentMonth - 8; i++) {
                calendarPrevMonth.click();
            }
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"1\"]")).click();
            DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"31\"]")).click();
        } else {
            for (int i = 0; i < currentMonth - 8; i++) {
                calendarPrevMonth.click();
            }
            DriverFactory.getAndroidDriver().findElement(By.xpath("//*[@resource-id='com.sheelafoam.quadrant.staging:id/month_grid']/android.widget.TextView[2]")).click();
            DriverFactory.getAndroidDriver().findElement(By.xpath("//*[@resource-id='com.sheelafoam.quadrant.staging:id/month_grid']/android.widget.TextView[29]")).click();
        }
    }

    public void  selectStartDate() {
        LocalDate currentDate = LocalDate.now();

        // Get the current month
        int currentMonth = currentDate.getMonthValue();

        for (int i = 0; i < currentMonth - 8; i++) {
            calendarPrevMonth.click();
        }
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"2\"]")).click();
    }

    public void  selectEndDate() {
        LocalDate currentDate = LocalDate.now();

        // Get the current month
        int currentMonth = currentDate.getMonthValue();

        for (int i = 0; i < currentMonth - 8; i++) {
            calendarPrevMonth.click();
        }
        DriverFactory.getIOSDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"29\"]")).click();
    }
}
