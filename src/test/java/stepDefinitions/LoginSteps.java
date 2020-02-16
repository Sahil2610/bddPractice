package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManagers;
import managers.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    TestContext testContext;

    WebDriver driver;
    LoginPage loginPage;
    PageObjectManagers pageObjectManagers;
    ConfigFileReader configFileReader;
    WebDriverManager webDriverManager;

    public LoginSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
    }

    @Given("^user is on rediff homepage$")
    public void user_is_on_rediff_homepage(){
        webDriverManager = new WebDriverManager();
        driver=webDriverManager.getDriver();
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),TimeUnit.SECONDS);
        pageObjectManagers = new PageObjectManagers(driver);
        loginPage = pageObjectManagers.getLoginPage();
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

    @When("^user enters username and password and clicks submit button$")
    public void user_enters_username_and_password_and_clicks_submit_button() {
        loginPage.signIn_link();
        loginPage.enter_username("sahil.balgotra");
        loginPage.enter_pwd("26October");
        loginPage.submit_button();
    }

    @Then("^email page must be displayed$")
    public void email_page_must_be_displayed(){
        loginPage.mailbox_home();
    }

    @Then("^user can see logout link$")
    public void user_can_see_logout_link(){
        loginPage.logoutIsDisplayed();
    }

    @Then("^when user clicks on logout option$")
    public void when_user_clicks_on_logout_option(){
        loginPage.click_logout();
    }

    @Then("^the user is logged out$")
    public void the_user_is_logged_out(){
        loginPage.logoff_message();
        webDriverManager.closeDriver();
    }
    @After()
    public void afterScenario(Scenario scenario) {
        if (!scenario.isFailed()) {

            //This takes a screenshot from the driver at save it to the specified location
            final byte[] screenshot= ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
    }
}
