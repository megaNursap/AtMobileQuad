package page_objects.desktop_web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailinatorPage {
    @FindBy(xpath = "//*[@id=\"inbox_pane\"]/div[1]/div[5]/button")
    public static WebElement go;

    @FindBy(xpath = "//body[1]/div[1]/main[1]/div[2]/div[3]/div[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]")
    public static WebElement openEmail;

    @FindBy(xpath = "//body[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/strong[1]")
    public static WebElement fetchOTP;
}
