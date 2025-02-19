# Automation Framework
A combination Test framework for both Web &amp; Mobile App

### Technical

This framework uses a number of open source projects to work properly:

* [Cucumber] - BDD style support for testing on Java!
* [JUnit 4&5] - Test runner tool of Java
* [Selenium] - Library use for interacting with Web Browser.
* [Appium] - Library use for interacting with Mobile App & Mobile Browser.
* [WebDriverManager] - Controlling the driver for each browser in the machine
* [RestAssured] - API interact and assertion

### Installation

Ensure JDK 1.8 and Maven has been installed
```
brew install maven
```
If running mobile testing, please install Appium
```
npm install -g appium
```
and
```
npm install -g appium-doctor
```


### How to run

**For Cucumber Test**
```sh
$ mvn clean verify -Dtest="RunCucumberTest" test -Denv=[environment] -Dlocation=[location] "-Dcucumber.options=--tags \"[tagName]\"" 
```

Run automation for web
```sh
mvn clean verify -Dtest="RunCucumberTest" -Denv=dev -Dcucumber.options="--tags @web" test
```
Run automation for mobile
```sh
mvn clean verify -Dtest="RunCucumberTest" -Denv=dev -Dcucumber.options="--tags @mobile" test
```

[tagName] = @ tag name  e.g. @smoke, @regression, @ios, @android ,@desktop-web...

### Structure
**MAIN**
`main.java.page_object`: contains all **Page Object Classes** of all platforms (desktop web, moblie app, mobile web)
`main.java.utils`: contains all **Utilities Classes**, such as API Helper, Common utility, Database Helper, Driver Factory, Driver Utils, Predefine Caps,  Selenium Custom Element, Environment Configuration...
`main.java.resources`: contains the **Environment Configuration** files (.properties) for dev, staging, prod...

**TEST**
`test.java.stepdefs`: where define **Methods of Cucumber Gherkin steps** https://cucumber.io/docs/cucumber/step-definitions/. Define Cucumber hooks - `CustomHook` (before, after methods or specific cucumber tags ) & Cucumber Running Class - `RunCucumberTest` with JUnit.
`test.java.resources:` The directory `features` stores all **Test Scenarios**.

**Pom.xml**: It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects (plugins, dependencies/libraries, properties, profile, environment variables...)

### How to define a Web/Mobile Element in PageObject Class
Please use this pattern:
```
@FindBy(locator)
[Access Modifier] [?static] WebElement [ElementName];
```
Examples for Web Element: use **Element** type or specific elements as So  and should be `public static`
```
@FindBy(id = "email")
public static WebElement Email_Textbox;
```
Examples for Mobile Element: use **MobileElement** type and should be `public`
```
@iOSXCUITFindBy(accessibility = "signUp")
@AndroidFindBy(accessibility = "Sign up")
public MobileElement SignUp_Button;
```

#### Utilities Classes

- **Factory**: Manage drivers (web, moblie-web, ios, android) and predefine Capabalities of devices
- **Selenium**: Create specific types of inteface **Element**
- **Environment**: Handle application configuration via Java properties files

### Test Case Template
**Features** (stories) are explained using agile framework on user stories.
- Feature can contain one or more scenarios.
- Feature group contains locally related test scenarios.
- Feature represents small, discrete features of the system.
- Feature files start with keyword Feature, followed by feature name/terse description of feature.

**Scenario**: the name for the behavior that will be described with following keywords:
- `Given` some precondition
- `When` I do some action
- `Then` I expect some result

**Note**: Each acceptance criteria written in this format has the following statements:
- `Given` – the beginning state of the scenario
- `When` – specific action that the user makes
- `Then` – the outcome of the action in “When”
- `And` – used to continue any of three previous statements

#### Examples:
**Web Steps:**
```
I open web browser
```

**Mobile Steps:**
```
I open Android app
```

### Assertion
Functions of `AssertJ` library are used in verifying steps (`Then`).
Static import:
```
import static org.assertj.core.api.Assertions.*;
```
Example:
```
assertThat(HomePage.Page_Title.getText()).isEqualTo(PageName);
```

In some concrete cases, using `Soft Assertions` to collects all assertion errors instead of stopping at the first one.

Reference links:
https://joel-costigliola.github.io/assertj/index.html.
https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#soft-assertions.

### Test Report
The Cucumber test report will be generated by using report plugin and defined at @CucumberOptions in `step_defs.RunCucumberTest`

**In Local:**
Use lifecycle `verify` instead of `test` to generate test report in directory `target/cucumber-html-reports/js/`
The main report is file `overview-steps.html`
*Example:* Run this command to execute all scenarios which have tag "@regression" and generate the test report:
```
mvn clean verify -Denv=dev "-Dcucumber.options=--tags \"@mobile\""
```
