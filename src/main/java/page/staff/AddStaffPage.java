package page.staff;

import Models.AddStaffForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddStaffPage extends GeneralStaffPage{
    By fullNameInputSelector =By.xpath("//input[@name=\"empName\"]");
    By genderInputSelector =By.xpath("//input[@name=\"gender\"]");
    By birthdayInputSelector =By.xpath("//input[@name=\"dateOfBirth\"]");
    By mobileNumberInputSelector =By.xpath("//input[@name=\"phone\"]");
    By positionInputSelector =By.xpath("//input[@name=\"pos\"]");
    By userNameInputSelector =By.xpath("//input[@name=\"username\"]");
    By passwordInputSelector =By.xpath("//input[@name=\"password\"]");
    By confirmPasswordInputSelector =By.id("txtConfirmPwd");
    By addressInputSelector =By.xpath("//textarea[@name=\"address\"]");

    By submitButtonSelector=By.id("submitBtn");
    String chooseGender ="//li[@class=\"mdl-menu__item\" and text()=\"%s\"]";
    String choosePosition ="//li[@class=\"mdl-menu__item\" and text()=\"%s\"]";
    String chooseBirthday="//td[@data-date=\"%s\"]";

    By pageItem=By.xpath("//a[@aria-controls=\"example4\"]");
    String choosePageItem="//a[@aria-controls=\"example4\" and text()=\"%s\"]";

    By okButtonSelector=By.xpath("//button[@class=\"dtp-btn-ok btn btn-flat btn-sm\" and text()=\"OK\"]");
    By addStaffFormSelector=By.id("staff");


    public AddStaffPage(WebDriver driver) {
        super(driver);
    }

    public void clickOKButton() {
        driver.findElement(okButtonSelector).click();
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonSelector).click();
    }

    public void clickFullName() {
        driver.findElement(fullNameInputSelector).click();
    }

    public void clickGender() {
        driver.findElement(genderInputSelector).click();
    }

    public void clickBirthday() {
        driver.findElement(birthdayInputSelector).click();
    }

    public void clickMobileNumber() {
        driver.findElement(mobileNumberInputSelector).click();
    }

    public void clickPosition() {
        driver.findElement(positionInputSelector).click();
    }

    public void clickUserName() {
        driver.findElement(userNameInputSelector).click();
    }

    public void clickPassword() {
        driver.findElement(passwordInputSelector).click();
    }

    public void clickConfirmPassword() {
        driver.findElement(confirmPasswordInputSelector).click();
    }

    public void clickAddress() {
        driver.findElement(addressInputSelector).click();
    }

    public void enterFullName(String fullName) {
        clickFullName();
        driver.findElement(fullNameInputSelector).sendKeys(fullName);
    }

    public void chooseGender(String gender) {
        clickGender();
        By genderName=By.xpath(String.format(chooseGender,gender));
        driver.findElement(genderName).click();
        clickGender();
    }

    public void chooseBirthday(String birthday) {
        clickBirthday();
        By birthDayTime=By.xpath(String.format(chooseBirthday,birthday));
        driver.findElement(birthDayTime).click();
        clickOKButton();
    }

    public void enterMobileNumber(String mobileNumber) {
        clickMobileNumber();
        driver.findElement(mobileNumberInputSelector).sendKeys(mobileNumber);
    }

    public void choosePosition(String position) {
        clickPosition();
        By positionName=By.xpath(String.format(choosePosition,position));
        driver.findElement(positionName).click();
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

//    public void addStaff(String fullName, String gender, String birthday, String mobileNumber,
//    String position,String userName, String password, String confirmPassword, String address ) {
//
//    }

    public void addStaff(AddStaffForm addStaffForm) {
        enterFullName(addStaffForm.getFullName());
        chooseGender(addStaffForm.getGender());
        chooseBirthday(addStaffForm.getBirthDate());
        enterMobileNumber(addStaffForm.getMobileNumber());
        choosePosition(addStaffForm.getPosition());
        enterUserName(addStaffForm.getUsername());
        enterPassword(addStaffForm.getPassword());
        enterConfirmPassword(addStaffForm.getConfirmPassword());
        enterAddress(addStaffForm.getAddress());

        clickSubmitButton();
    }

    public void clickLastPageItem() {
        int maxPageItem= driver.findElements(pageItem).size();
        By pageItemNumber=By.xpath(String.format(choosePageItem,maxPageItem-1));
        driver.findElement(pageItemNumber).click();
    }

    public boolean isAddStaffFormDisplayed() {
        if (driver.findElements(addStaffFormSelector).size()>0){
            return driver.findElement(addStaffFormSelector).isDisplayed();
        }else {
            return false;
        }
    }

}
