package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddStaffPage extends GeneralStaffPage{
    By fullNameInputSelector =By.xpath("//input[@name=\"empName\"]");
    By genderInputSelector =By.xpath("//input[@name=\"gender\"]");
    By birthdayInputSelector =By.xpath("//input[@name=\"dateOfBirth\"]");
    By mobileNumberInputSelector =By.xpath("//input[@name=\"phone\"]");
    By positionInputSelector =By.xpath("//input[@name=\"gender\"]");
    By userNameInputSelector =By.xpath("//input[@name=\"gender\"]");
    By passwordInputSelector =By.xpath("//input[@name=\"gender\"]");
    By confirmPasswordInputSelector =By.xpath("//input[@name=\"gender\"]");
    By addressInputSelector =By.xpath("//input[@name=\"gender\"]");


    public AddStaffPage(WebDriver driver) {
        super(driver);
    }

    public void clickFullName() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickGender() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickBirthday() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickMobileNumber() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickPosition() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickUserName() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickPassword() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickConfirmPassword() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickAddress() {
        driver.findElement(genderInputSelector).click();
    }

    public void enterFullName(String fullName) {
        clickFullName();
        driver.findElement(fullNameInputSelector).sendKeys(fullName);
    }

    public void chooseGender(String gender) {
        clickGender();
        driver.findElement(fullNameInputSelector).sendKeys(gender);
    }

    public void chooseBirthday(String birthday) {
        clickBirthday();
        driver.findElement(fullNameInputSelector).sendKeys(birthday);
    }

    public void enterMobileNumber(String mobileNumber) {
        clickMobileNumber();
        driver.findElement(mobileNumberInputSelector).sendKeys(mobileNumber);
    }

    public void choosePosition(String position) {
        clickPosition();
        driver.findElement(positionInputSelector).sendKeys(position);
    }

    public void enterUserName(String userName) {
        clickUserName();
        driver.findElement(userNameInputSelector).sendKeys(userName);
    }

    public void enterPassword(String password) {
        clickPassword();
        driver.findElement(passwordInputSelector).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        clickConfirmPassword();
        driver.findElement(confirmPasswordInputSelector).sendKeys(confirmPassword);
    }

    public void enterAddress(String address) {
        clickAddress();
        driver.findElement(addressInputSelector).sendKeys(address);
    }

    public void addStaff(String fullName, String gender, String birthday, String mobileNumber,
    String position,String userName, String password, String confirmPassword, String address ) {
        enterFullName(fullName);
        chooseGender(gender);
        chooseBirthday(birthday);
        enterMobileNumber(mobileNumber);
        choosePosition(position);
        enterUserName(userName);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterAddress(address);
    }

}
