package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import page_objects.mobile.BaseScreen;
import utils.Config;
import utils.Platforms;
import utils.factory.DriverFactory;
import utils.factory.DriverUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomHook {
    private final static Logger LOGGER = LogManager.getLogger("Cucumber");

    @Given("I open a web browser")
    @Before("@web")
    public void iOpenAWebBrowser() throws MalformedURLException {
        DriverFactory.createWebInstance();
        DriverFactory.initPages("page_objects.desktop_web", DriverFactory.getWebDriver());
    }

    @Given("I open Appen App")
    public void beforeApp() throws MalformedURLException {
        System.out.println("Location " + Config.countryLocation());
        LOGGER.warn("Opening Mobile App");
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            DriverFactory.startAppiumService();
            DriverFactory.createMobileInstance(Platforms.IOS);
        } else {
            DriverFactory.startAppiumService();
            DriverFactory.createMobileInstance(Platforms.ANDROID);
        }

        DriverUtils.waitForAWhile(5, "Loading app");
    }

    @After()
    public void afterEachScenario(Scenario scenarioResult) {
        try {
            testDataEmbeddedOnFail(scenarioResult);
            screenshotOnFail(scenarioResult);
//            if (scenarioResult.isFailed()) {
//                testDataEmbeddedOnFail(scenarioResult);
//                screenshotOnFail(scenarioResult);
//            }
        } catch (Exception e) {
            LOGGER.error("Unable to take screenshot");
        } finally {
            DriverFactory.dismissInstances();
            BaseScreen.dismissScreens();
            DriverFactory.stopAppiumService();
        }
    }

    private void testDataEmbeddedOnFail(Scenario scenario) {
        String url = "";
        if (DriverFactory.isWebDriverRun) {
            url = "\nURL: " + DriverFactory.getWebDriver().getCurrentUrl();
        }
        scenario.write("TEST DATA USED:\n" + "{YOUR CUSTOM OUTPUT}" + url);
    }

    private void emulatorLocationSetter() {
        double latitude = 40.7128;  // New York City
        double longitude = -74.0060;

        // Command to connect to the emulator using telnet
        String telnetCmd = "telnet localhost 5554"; // Use the appropriate port for your emulator

        // Command to set the GPS location
        String setLocationCmd = "geo fix " + longitude + " " + latitude;

        try {
            // Start a telnet session to the emulator
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", telnetCmd);
            Process process = pb.start();

            // Send the location command
            process.getOutputStream().write((setLocationCmd + "\n").getBytes());
            process.getOutputStream().flush();

            // Close the telnet session
            process.getOutputStream().close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void screenshotOnFail(Scenario scenarioResult) {
        screenshotByPlatform(scenarioResult);
        String yourCustomOutput = "";
        LOGGER.error(String.format("The Test was failed with following test data: %s", yourCustomOutput));
        LOGGER.info(String.format("Test result: %s", scenarioResult.getStatus()));
    }

    private void screenshotByPlatform(Scenario scenario) {
        if (DriverFactory.isWebDriverRun) {
            LOGGER.info("Embedding Web SS");
            byte[] webss = ((RemoteWebDriver) DriverFactory.getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(webss, "image/png");
        }
        if (DriverFactory.isAndroidRun) {
            LOGGER.info("Embedding Android SS");
            byte[] mobiless = ((RemoteWebDriver) DriverFactory.getAndroidDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(mobiless, "image/png");
        }
        if (DriverFactory.isIOSRun) {
            LOGGER.info("Embedding IOS SS");
            byte[] mobiless = ((RemoteWebDriver) DriverFactory.getIOSDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(mobiless, "image/png");
        }
    }
}
