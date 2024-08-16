package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    By usernameInputSelector= By.xpath("//input[@name=\"Reg-Username\"]");
    By emailInputSelector=By.xpath("//input[@name=\"Reg-Email\"]");
    By passwordInputSelector=By.xpath("//input[@name=\"Reg-Password\"]");
    By confirmPasswordInputSelector=By.xpath("//input[@name=\"Confirm Password\"]");
    By termConfirmSelector=By.xpath("(//span[@class=\"custom-control-description\"])[2]");
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

    public void clearRegisterForm() {
        driver.findElement(usernameInputSelector).clear();
        driver.findElement(emailInputSelector).clear();
        driver.findElement(passwordInputSelector).clear();
        driver.findElement(confirmPasswordInputSelector).clear();
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
        wait.until(driver->driver.findElement(registerErrorSelector).isDisplayed());
        return driver.findElement(registerErrorSelector).isDisplayed();
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
