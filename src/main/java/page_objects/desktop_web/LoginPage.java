package page_objects.desktop_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(id = "username")
    public static WebElement userName;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(css = "button[type=\"submit\"]")
    public static WebElement submitButton;

}
