package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT,using = "Sign in")
    private WebElement signIn;

    @FindBy(how = How.ID,using = "login1")
    private WebElement username;

    @FindBy(how = How.ID,using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH,using = "//*[@title='Sign in']")
    private WebElement submit;

    @FindBy(how = How.XPATH,using = "//*[@title='Go to Sahil balgotra profile']")
    private WebElement mailbox_header;

    @FindBy(how = How.CLASS_NAME,using = "rd_logout")
    private WebElement logout_link;

    @FindBy(how = How.XPATH,using = "//*[text()[contains(., 'You have successfully signed out of Rediffmail.')]]")
    private WebElement logout_message;

    public void signIn_link(){
        signIn.click();
    }

    public void enter_username(String name){
        username.sendKeys(name);
    }

    public void enter_pwd(String pwd){
        password.sendKeys(pwd);
    }
    public void submit_button(){
        submit.click();
    }

    public void mailbox_home(){
        mailbox_header.isDisplayed();
    }

    public void logoutIsDisplayed(){
        logout_link.isDisplayed();
    }

    public void click_logout(){
        logout_link.click();
    }

    public void logoff_message(){
        logout_message.isDisplayed();
    }

}
