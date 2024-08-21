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

}
