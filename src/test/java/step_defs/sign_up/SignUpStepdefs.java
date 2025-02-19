package step_defs.sign_up;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import page_objects.mobile.*;
import utils.Config;
import utils.ScenarioContext;
import utils.api.mailinator.MailinatorAPI;
import utils.api.twilio.TwilioAPI;
import utils.factory.DriverFactory;
import utils.factory.DriverUtils;
import utils.factory.Run;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class SignUpStepdefs {

    Run _location = Run.fromText(Config.ENV.RUN_LOCATION());

    @When("I sign up to Geolancer app")
    public void iSignUpToGeolancerApp() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        }
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(10, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        String phoneNumber = DriverUtils.generateRandomPhoneNumber();
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }
        //SMS
        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);
            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        //Email
        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
        }
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
    }

    @Then("I verify user already signed up successfully")
    public void iVerifyUserAlreadySignedUpSuccessfully() {
        DriverUtils.waitForAWhile(3,"Wait for loading");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(SignUpScreen.INSTANCE().getStartedIcon.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can not sign up with wrong email format")
    public void iVerifyUserCanNotSignUpWithWrongEmailFormat() {
        SoftAssertions softly = new SoftAssertions();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            HomeScreen.INSTANCE().signUpBtn.click();
            SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().emailTxb.sendKeys("brunei.test");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("@gmail.com");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("brunei.test@.com");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("etc");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
        } else {
            HomeScreen.INSTANCE().signUpBtn.click();
            SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().emailTxb.sendKeys("brunei.test");
            SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("@gmail.com");
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("brunei.test@.com");
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
            SignUpScreen.INSTANCE().emailTxb.clear();
            SignUpScreen.INSTANCE().emailTxb.sendKeys("etc");
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidEmailErrorMessage.isDisplayed()).isTrue();
        }
        softly.assertAll();
    }

    @Then("I verify user can not sign up with wrong password format")
    public void iVerifyUserCanNotSignUpWithWrongPasswordFormat() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            HomeScreen.INSTANCE().signUpBtn.click();
            SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
            SignUpScreen.INSTANCE().unHidePasswordIcon.click();
            SignUpScreen.INSTANCE().passwordTxb.click();
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().notFillPasswordErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("ABCDefgh");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("ABcd1234");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("@1234567");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("Abc@123");
            SignUpScreen.INSTANCE().signUpLabel.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.isDisplayed()).isTrue();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
        } else {
            HomeScreen.INSTANCE().signUpBtn.click();
            SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
            SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
            softly.assertThat(SignUpScreen.INSTANCE().signUpBtn.getAttribute("enabled")).isEqualTo("false");
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("ABCDefgh");
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.getText()).isEqualTo("Password should contain a numeric character");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("ABcd1234");
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.getText()).isEqualTo("Password should contain a symbol character");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("@1234567");
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.getText()).isEqualTo("Password should contain lower case character");
            SignUpScreen.INSTANCE().passwordTxb.clear();
            SignUpScreen.INSTANCE().passwordTxb.sendKeys("Abc@123");
            SignUpScreen.INSTANCE().signUpBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidPasswordErrorMessage.getText()).isEqualTo("Password should be 8 or more characters");
        }
        softly.assertAll();
    }

    @Then("I verify user can sign up with multiple word on first name and last name")
    public void iVerifyUserCanSignUpWithMultipleWordOnFirstNameAndLastName() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys("Au Au Au Au Au Au Au Au Au Au");
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys("To To To To To To To To To To");
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        softly.assertThat(SignUpScreen.INSTANCE().phoneNumbTxb.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can sign up without last name")
    public void iVerifyUserCanSignUpWithoutLastName() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys("Auto Test");
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys("");
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        softly.assertThat(SignUpScreen.INSTANCE().phoneNumbTxb.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can sign up with wrong format phone number")
    public void iVerifyUserCanSignUpWithWrongFormatPhoneNumber() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys("Auto");
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys("Test");
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys("999999");
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            softly.assertThat(SignUpScreen.INSTANCE().invalidPhoneNumberErrorMessage.isDisplayed()).isTrue();
        } else {
            softly.assertThat(SignUpScreen.INSTANCE().invalidPhoneNumberErrorMessage.getText()).isEqualTo("Phone number is invalid");
        }
        softly.assertAll();
    }

    @Then("I verify user can sign up success after resend OTP more than 2 times")
    public void iVerifyUserCanSignUpSuccessAfterResendOTP() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        String phoneNumber = DriverUtils.generateRandomPhoneNumber();
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }
        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            SignUpScreen.INSTANCE().waitingForResendOTP();
            SignUpScreen.INSTANCE().resendOTPBtn.click();
            SignUpScreen.INSTANCE().waitingForResendOTP();
            SignUpScreen.INSTANCE().resendOTPBtn.click();
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);

            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        SignUpScreen.INSTANCE().waitingForResendOTP();
        SignUpScreen.INSTANCE().resendOTPBtn.click();
        SignUpScreen.INSTANCE().waitingForResendOTP();
        SignUpScreen.INSTANCE().resendOTPBtn.click();
        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);

        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
        }
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
    }

    @Then("I verify user can not sign up with wrong OTP")
    public void iVerifyUserCanNotSignUpWithWrongOTP() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        }
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }

        String phoneNumber = DriverUtils.generateRandomPhoneNumber();

        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }

        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);

            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys("111111");
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
                softly.assertThat(SignUpScreen.INSTANCE().invalidOTPErrorMessage.isDisplayed()).isTrue();

                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.clear();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys("1");
                SignUpScreen.INSTANCE().otp2Txb.sendKeys("1");
                SignUpScreen.INSTANCE().otp3Txb.sendKeys("1");
                SignUpScreen.INSTANCE().otp4Txb.sendKeys("1");
                SignUpScreen.INSTANCE().otp5Txb.sendKeys("1");
                SignUpScreen.INSTANCE().otp6Txb.sendKeys("1");
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();

                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);

        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys("111111");
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidOTPErrorMessage.isDisplayed()).isTrue();

            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.clear();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys("1");
            SignUpScreen.INSTANCE().otp2Txb.sendKeys("1");
            SignUpScreen.INSTANCE().otp3Txb.sendKeys("1");
            SignUpScreen.INSTANCE().otp4Txb.sendKeys("1");
            SignUpScreen.INSTANCE().otp5Txb.sendKeys("1");
            SignUpScreen.INSTANCE().otp6Txb.sendKeys("1");
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();

            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
        }

        softly.assertAll();
    }

    @Then("I verify user can not sign up with existing email")
    public void iVerifyUserCanNotSignUpWithExistingEmail() {
        SoftAssertions softly = new SoftAssertions();

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(Config.ENV.GEOLANCER_USERNAME());
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(10, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(DriverUtils.generateRandomPhoneNumber());
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }
        softly.assertThat(SignUpScreen.INSTANCE().existedEmailErrorMessage.isDisplayed()).isTrue();
        softly.assertAll();
    }

    @Then("I verify user can not sign up with expired OTP")
    public void iVerifyUserCanNotSignUpWithExpiredOTP() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }

        String phoneNumber = DriverUtils.generateRandomPhoneNumber();

        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }

        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);

            SignUpScreen.INSTANCE().waitingForResendOTP();

            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
                softly.assertThat(SignUpScreen.INSTANCE().invalidOTPErrorMessage.isDisplayed()).isTrue();
                SignUpScreen.INSTANCE().resendOTPBtn.click();
                DriverUtils.waitForAWhile(10,"Wait for getting OTP");
                String smsOTPCode2 = twilioAPI.getSMSOTP("+62" + phoneNumber);

                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.clear();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode2);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();

                SignUpScreen.INSTANCE().resendOTPBtn.click();
                DriverUtils.waitForAWhile(10,"Wait for getting OTP");
                String smsOTPCode2 = twilioAPI.getSMSOTP("+62" + phoneNumber);

                List<String> charList2 = new ArrayList<>();
                for (int i = 0; i < smsOTPCode2.length(); i++) {
                    charList2.add(String.valueOf(smsOTPCode2.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList2.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList2.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList2.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList2.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList2.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList2.get(5));
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);

        SignUpScreen.INSTANCE().waitingForResendOTP();

        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().invalidOTPErrorMessage.isDisplayed()).isTrue();

            SignUpScreen.INSTANCE().resendOTPBtn.click();
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            String otpCode2 = mailinatorAPI.getOTP("autotest" + formattedDateTime);

            SignUpScreen.INSTANCE().otpSMSTxb.click();
            SignUpScreen.INSTANCE().otpSMSTxb.clear();
            SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(otpCode2);
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().continueBtn.click();
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
        }

        softly.assertAll();
    }

    @Then("I verify user can not sign up with less than 6 characters OTP")
    public void iVerifyUserCanNotSignUpWithLessThanCharactersOTP() {
        SoftAssertions softly = new SoftAssertions();
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }

        String phoneNumber = DriverUtils.generateRandomPhoneNumber();

        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }

        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            DriverUtils.waitForAWhile(10,"Wait for getting OTP");
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);

            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys("11111");
                SignUpScreen.INSTANCE().signUpLabel.click();
                softly.assertThat(SignUpScreen.INSTANCE().continueBtn.isEnabled()).isFalse();
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.clear();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
                //Verify error
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);

        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys("11111");
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            softly.assertThat(SignUpScreen.INSTANCE().verifyAndProceedBtn.isEnabled()).isFalse();
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.clear();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().signUpLabel.click();
            SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            //Verify error
        }

        softly.assertAll();
    }

    @Then("I verify user can do registration till page 3, close the apps, then do Login")
    public void iVerifyUserCanDoRegistrationTillPageCloseTheAppsThenDoLogin() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(10, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        String phoneNumber = DriverUtils.generateRandomPhoneNumber();
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        } else {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        }

        DriverFactory.getCurrentAppiumDriver().closeApp(); // or driver.terminateApp("your_app_package_name");

        // Quit the driver to end the session
        DriverFactory.getCurrentAppiumDriver().launchApp();

        DriverUtils.waitForAWhile(5, "Wait for loading");

        //SMS
        if (Config.ENV.COUNTRY().equalsIgnoreCase("ID")) {
            TwilioAPI twilioAPI = TwilioAPI.builder().build();
            String smsOTPCode = twilioAPI.getSMSOTP("+62" + phoneNumber);
            if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
                SignUpScreen.INSTANCE().otpSMSTxb.click();
                SignUpScreen.INSTANCE().otpSMSTxb.sendKeys(smsOTPCode);
                SignUpScreen.INSTANCE().signUpLabel.click();
                SignUpScreen.INSTANCE().continueBtn.click();
            } else {
                List<String> charList = new ArrayList<>();
                for (int i = 0; i < smsOTPCode.length(); i++) {
                    charList.add(String.valueOf(smsOTPCode.charAt(i)));
                }
                SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
                SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
                SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
                SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
                SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
                SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
                SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
            }
        }

        //Email
        DriverUtils.waitForAWhile(10,"Wait for getting OTP");
        MailinatorAPI mailinatorAPI = MailinatorAPI.builder().build();
        String otpCode = mailinatorAPI.getOTP("autotest" + formattedDateTime);
        if (Config.ENV.PLATFORM().equalsIgnoreCase("ios")) {
            SignUpScreen.INSTANCE().otpTxb.click();
            SignUpScreen.INSTANCE().otpTxb.sendKeys(otpCode);
        } else {
            List<String> charList = new ArrayList<>();
            for (int i = 0; i < otpCode.length(); i++) {
                charList.add(String.valueOf(otpCode.charAt(i)));
            }
            SignUpScreen.INSTANCE().otp1Txb.sendKeys(charList.get(0));
            SignUpScreen.INSTANCE().otp2Txb.sendKeys(charList.get(1));
            SignUpScreen.INSTANCE().otp3Txb.sendKeys(charList.get(2));
            SignUpScreen.INSTANCE().otp4Txb.sendKeys(charList.get(3));
            SignUpScreen.INSTANCE().otp5Txb.sendKeys(charList.get(4));
            SignUpScreen.INSTANCE().otp6Txb.sendKeys(charList.get(5));
        }
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().verifyAndProceedBtn.click();
    }

    @Then("I verify user can do registration till page 3 and back to page 2")
    public void iVerifyUserCanDoRegistrationTillPageAndBackToPage() {
        SoftAssertions softly = new SoftAssertions();

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Current Date and Time: " + formattedDateTime);
        String emailSignUp = "autotest" + formattedDateTime + "@mailinator.com";
        System.out.println("Email: " + emailSignUp);

        ScenarioContext.currentContext().set("Email Sign Up").with(emailSignUp);

        HomeScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(5, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        SignUpScreen.INSTANCE().firstNameTxb.sendKeys(Config.ENV.FIRST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().lastNameTxb.sendKeys(Config.ENV.LAST_NAME_SIGNUP());
        SignUpScreen.INSTANCE().emailTxb.sendKeys(emailSignUp);
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().unHidePasswordIcon.click();
        SignUpScreen.INSTANCE().passwordTxb.sendKeys(Config.ENV.GEOLANCER_PASSWORD());
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().swipeFromTopToBottom();
            SignUpScreen.INSTANCE().agreeCbx.click();
        }
        SignUpScreen.INSTANCE().signUpBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(10, "Wait for loading");
        } else {
            try {
                HomeScreen.INSTANCE().allowWhileUsingTheApp.click();
            } catch (Exception e) {}
        }
        String phoneNumber = DriverUtils.generateRandomPhoneNumber();
        SignUpScreen.INSTANCE().phoneNumbTxb.sendKeys(phoneNumber);
        SignUpScreen.INSTANCE().signUpLabel.click();
        SignUpScreen.INSTANCE().regionDropdown.click();
        SignUpScreen.INSTANCE().firstSelectionRegion.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            DriverUtils.waitForAWhile(2, "Wait for loading");
        }
        SignUpScreen.INSTANCE().cityDropdown.click();
        SignUpScreen.INSTANCE().swipeFromTopToBottom();
        SignUpScreen.INSTANCE().firstSelectionCity.click();
        SignUpScreen.INSTANCE().continueBtn.click();
        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            SignUpScreen.INSTANCE().yesBtn.click();
        }
        DriverUtils.waitForAWhile(10, "Wait for loading");

        SignUpScreen.INSTANCE().backBtn.click();

        DriverUtils.waitForAWhile(5, "Wait for loading");

        if (Config.ENV.PLATFORM().equalsIgnoreCase("android")) {
            softly.assertThat(SignUpScreen.INSTANCE().phoneNumbTxb.getText().equalsIgnoreCase(phoneNumber)).isTrue();
        }

        softly.assertAll();
    }

    @Then("I verify the filter is correct with date {string} in NFT Report")
    public void iVerifyTheFilterIsCorrectWithTypeInNFTReport(String type) {
        DateTimeFormatter inputFormatter;

        SoftAssertions softly = new SoftAssertions();

        ReportScreen_NFTReport.INSTANCE().selectDate(type);
        DriverUtils.waitForAWhile(5, "Wait for loading");


        if (ReportScreen_NFTReport.INSTANCE().isRecordPresent()) {

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

        ReportScreen_NFTReport.INSTANCE().selectDate("All");
        softly.assertAll();
    }
}
