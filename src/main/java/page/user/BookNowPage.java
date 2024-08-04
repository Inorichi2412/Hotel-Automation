package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookNowPage {
    WebDriver driver;
    By nameInputSelector= By.id("name");
    By emailInputSelector=By.id("email");
    By phoneInputSelector=By.id("phone");
    By addressInputSelector=By.id("address");
    By agreeConditionCheckboxSelector= By.xpath("//label[@class=\"custom-control custom-checkbox\"]");
    By submitButtonSelector=By.xpath("//input[@value=\"Submit\"]");


    public void clickNameInput() {
        driver.findElement(nameInputSelector).click();
    }

    public void clickEmailInput() {
        driver.findElement(emailInputSelector).click();
    }

    public void clickPhoneInput() {
        driver.findElement(phoneInputSelector).click();
    }

    public void clickAddressInput() {
        driver.findElement(addressInputSelector).click();
    }

    public void enterNameInput(String name) {
        clickNameInput();
        driver.findElement(nameInputSelector).sendKeys(name);
    }

    public void enterEmailInput(String email) {
        clickEmailInput();
        driver.findElement(emailInputSelector).sendKeys(email);
    }

    public void enterPhoneInput(String phone) {
        clickPhoneInput();
        driver.findElement(phoneInputSelector).sendKeys(phone);
    }

    public void enterAddressInput(String address) {
        clickAddressInput();
        driver.findElement(addressInputSelector).sendKeys(address);
    }

    public void clickAgree() {
        WebElement agree=driver.findElement(agreeConditionCheckboxSelector);
        new Actions(driver).moveToElement(agree).perform();
        agree.click();
    }

    public void clickSubmit() {
        driver.findElement(submitButtonSelector).click();
    }

    public void verifyInfoBooking(String phone, String address) {
        enterPhoneInput(phone);
        enterAddressInput(address);
        clickAgree();
        clickSubmit();
    }

    public BookNowPage(WebDriver driver) {
        this.driver = driver;
    }
}
