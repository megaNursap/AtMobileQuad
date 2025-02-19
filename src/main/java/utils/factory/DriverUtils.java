package utils.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.Random;

public class DriverUtils {

    private final static Logger LOGGER = LogManager.getLogger("DriverUtil");

    public static void waitForAWhile(long timeToWait, String reason) {
        try {
            LOGGER.info(String.format("Wait %d second(s) %s", timeToWait, reason));
            int numberOfBreak = (int) Math.floor(timeToWait / 60);
            int restTime = (int) (timeToWait % 60);
            for (int i = 1; i <= numberOfBreak; i++) {
                Thread.sleep(60 * 1000);
                if (DriverFactory.isWebDriverRun) {
                    DriverFactory.getWebDriver().getCurrentUrl();
                }
                if (DriverFactory.isAndroidRun) {
                    DriverFactory.getAndroidDriver().getSessionId();
                }
                if (DriverFactory.isIOSRun) {
                    DriverFactory.getIOSDriver().getSessionId();
                }
            }
            Thread.sleep(restTime * 1000);
        } catch (Exception e) {
            LOGGER.error(String.format("Unable to wait %s(s)", timeToWait));
        }
    }

    public static String generateRandomPhoneNumber() {
        Random random = new Random();

        // Generate a random 7-digit number
        int randomDigits = random.nextInt(90000000) + 10000000;

        // Format the number as an Indonesian phone number
        return "812" + randomDigits;
    }

    public static String generateRandomPassword() {
        Random random = new Random();

        // Generate a random 7-digit number
        int randomDigits = random.nextInt(90000000) + 10000000;

        // Format the number as an Indonesian phone number
        return "Appen@" + randomDigits;
    }

    public static String extractDigitFromStrings(String string) {
        return string.replaceAll("[^0-9]", "");
    }

    public static boolean isInAlphabeticalOrder(String str1, String str2) {
        // Using compareTo method to compare strings
        int result = str1.compareTo(str2);

        // If result < 0, str1 comes before str2
        // If result > 0, str1 comes after str2
        // If result == 0, str1 and str2 are equal
        return result < 0;
    }

    public static boolean isElementPresent(AppiumDriver<MobileElement> driver, By.ByXPath locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
