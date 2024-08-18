package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameInputSelector = By.xpath("//input[@name=\"username\"]");
    By passwordInputSelector=By.xpath("//input[@name=\"password\"]");
    By loginButtonSelector =By.xpath("//button");
    By loginErrorSelector=By.xpath("//p");
    By loginFormSelector =By.xpath("//form[@class=\"login100-form validate-form\"]");

    public void clearUsernameInput() {
        driver.findElement(usernameInputSelector).clear();
    }

    public void clearPasswordInput() {
        driver.findElement(passwordInputSelector).clear();
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonSelector).click();
    }

    public void enterUsername(String username) {
        clearUsernameInput();
        driver.findElement(usernameInputSelector).sendKeys(username);
    }

    public void enterPassword(String password) {
        clearPasswordInput();
        driver.findElement(passwordInputSelector).sendKeys(password);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoginErrorDisplayed() {
        if (driver.findElements(loginErrorSelector).size()>0){
            return driver.findElement(loginErrorSelector).isDisplayed();
        }
        else {
            return false;
        }
    }

    public boolean isLoginFormDisplayed() {
        if (driver.findElements(loginFormSelector).size()>0){
            return driver.findElement(loginFormSelector).isDisplayed();
        }
        else {
            return false;
        }
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
