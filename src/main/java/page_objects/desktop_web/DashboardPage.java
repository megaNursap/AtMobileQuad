package page_objects.desktop_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(css = ".sidebar > .items:nth-child(4)")
    public static WebElement poisItem;

    @FindBy(css = ".MuiCircularProgress-svg")
    public static WebElement loadingIcon;

    @FindBy(css = "#sorted")
    public static WebElement sortDropdown;

    @FindBy(css = "#menu- .MuiMenu-list li")
    public static List<WebElement> listItems;

    @FindBy(css = ".body > div > button[type=\"button\"]")
    public static WebElement searchButton;

    @FindBy(css = "table tbody tr")
    public static List<WebElement> table;
}
