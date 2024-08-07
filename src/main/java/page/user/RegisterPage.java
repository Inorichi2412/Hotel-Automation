package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    By usernameInputSelector= By.xpath("//input[@name=\"Reg-Username\"]");
    By emailInputSelector=By.xpath("//input[@name=\"Reg-Email\"]");
    By passwordInputSelector=By.xpath("//input[@name=\"Reg-Password\"]");
    By confirmPasswordInputSelector=By.xpath("//input[@name=\"Confirm Password\"]");
    By termConfirmSelector=By.xpath("(//label/span[@class=\"custom-control-description\"])[2]");
    By singUpButtonSelector=By.xpath("//input[@value=\"Sign Up\"]");
    By registerFormSelector =By.xpath("//form[@action=\"register\"]");
    By registerErrorSelector=By.id("registerError");

    public void enterUsername(String username) {
        driver.findElement(usernameInputSelector).sendKeys(username);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInputSelector).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputSelector).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordInputSelector).sendKeys(confirmPassword);
    }

    public void confirmTerm() {
        driver.findElement(termConfirmSelector).click();
    }

    public void clickSignUp() {
        driver.findElement(singUpButtonSelector).click();
    }

    public void register(String username, String email, String password, String confirmPassword) {
        enterUsername(username);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        confirmTerm();
        clickSignUp();
    }

    public boolean isRegisterFormDisplayed() {
        return driver.findElement(registerFormSelector).isDisplayed();
    }

    public boolean isRegisterErrorDisplayed() {
        return driver.findElement(registerErrorSelector).isDisplayed();
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
}
