package page.common;

import Models.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends GeneralPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Selector login
    By usernameInputSelector = By.xpath("//input[@name='email']");
    By passwordInputSelector = By.xpath("//input[@name='password']");
    By submitButtonSelector = By.xpath("//input[@value='Sign In']");
    By loginErrorSelector = By.id("loginError");
    By loginFormSelector = By.xpath("//form[@name='login-form']");
    By messageErrorLoginSelector = By.id("loginError");
    By adminSelector = By.xpath("//*[@id='NavebarProfileDrop']/img");

    public void clickEmailInput() {
        driver.findElement(usernameInputSelector).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonSelector).click();
    }

    public void clickPasswordInput() {
        driver.findElement(passwordInputSelector).click();
    }

    public void enterEmail(String email) {
        driver.findElement(usernameInputSelector).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputSelector).sendKeys(password);
    }


    public void login(String username, String password) {
        clickEmailInput();
        enterEmail(username);
        clickPasswordInput();
        enterPassword(password);
        clickSubmitButton();
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElement(loginErrorSelector).isDisplayed();
    }

    public boolean isLoginFormDisplayed() {
        return driver.findElement(loginFormSelector).isDisplayed();
    }

    public boolean isLoginErrorMessageDisplayed() {
        return driver.findElement(messageErrorLoginSelector).isDisplayed();
    }

    public boolean isAdminPageDisplayed() {
        return driver.findElement(adminSelector).isDisplayed();
    }
}
