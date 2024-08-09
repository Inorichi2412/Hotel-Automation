package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameInputSelector = By.xpath("//input[@name=\"email\"]");
    By passwordInputSelector=By.xpath("//input[@name=\"password\"]");
    By submitButtonSelector=By.xpath("//input[@value=\"Sign In\"]");
    By loginErrorSelector=By.id("loginError");
    By loginFormSelector=By.xpath("//form[@name=\"login-form\"]");

    public void clickEmailInput() {
        driver.findElement(usernameInputSelector).click();
    }

    public void clickPasswordInput() {
        driver.findElement(passwordInputSelector).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonSelector).click();
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

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



}
