package page.common;

import Models.LoginForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    Wait<WebDriver> wait;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //Selector login
    By buttonLoginSelector = By.xpath("//a[text()='Login']");
    By usernameInputSelector = By.xpath("//input[@name=\"email\"]");
    By passwordInputSelector = By.xpath("//input[@name=\"password\"]");
    By submitButtonSelector = By.xpath("//input[@value='Sign In']");
    By loginErrorSelector = By.id("loginError");
    By loginFormSelector = By.xpath("//form[@name='login-form']");
    By messageErrorLoginSelector = By.id("loginError");
    By adminSelector = By.xpath("//*[@id='NavebarProfileDrop']/img");

    public void clickEmailInput() {
        driver.findElement(usernameInputSelector).click();
    }

    public void clickPasswordInput() {
        driver.findElement(passwordInputSelector).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonSelector).click();
    }

    public void enterUserName(String userName) {
        driver.findElement(usernameInputSelector).clear();
        driver.findElement(usernameInputSelector).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputSelector).clear();
        driver.findElement(passwordInputSelector).sendKeys(password);
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLoginSelector).click();
    }

    public void login(String username, String password) {
        clickEmailInput();
        enterUserName(username);
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

    public void loginAdmin(LoginForm loginForm) {
        driver.findElement(usernameInputSelector).sendKeys(loginForm.getEmail());
        driver.findElement(passwordInputSelector).sendKeys(loginForm.getPassword());
        clickSubmitButton();
    }

    public boolean isLoginErrorMessageDisplayed() {
        return driver.findElement(messageErrorLoginSelector).isDisplayed();
    }

    public boolean isAdminPageDisplayed() {
        return driver.findElement(adminSelector).isDisplayed();
    }
}
