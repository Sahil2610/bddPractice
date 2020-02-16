package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class PageObjectManagers {
    private WebDriver driver;

    private LoginPage loginPage;

    public PageObjectManagers(WebDriver driver) {

        this.driver = driver;

    }

    public LoginPage getLoginPage(){
        return (loginPage == null)? loginPage = new LoginPage(driver) : loginPage;
    }
}
