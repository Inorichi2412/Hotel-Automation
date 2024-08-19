package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.DriverUtils;

public class BookNowPage extends GeneralPage {
    WebDriver driver;

    public BookNowPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Selector information user
    By addYourInfoFormSelector = By.xpath("//h4[text()='Add Your Informations :-']");
    By nameInputSelector = By.id("name");
    By emailInputSelector = By.id("email");
    By phoneInputSelector = By.id("phone");
    By addressInputSelector = By.id("address");
    By agreeConditionCheckboxSelector = By.xpath("//label[@class='custom-control custom-checkbox']");
    By submitButtonSelector = By.xpath("//input[@value='Submit']");
    By userInformationSelector = By.id("user");
    By checkBoxIAgreeSelector = By.xpath("//Strong[text()='Terms and Conditions']");
    By clickButtonSubmitRoomDetailsSelector =  By.xpath("//*[@id='user']/div/div[1]/div[6]/input");

    // selector Your Reservation
    By yourReservationDisplaySelector = By.xpath("//div[@class='col-12 reserv_detail_contant']");

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

    public void enterNameInput(String fullName) {
        clickNameInput();
        driver.findElement(nameInputSelector).sendKeys(fullName);
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

    // Kiểm tra và chọn
    public void checkAndSelectIAgree() {
        WebElement checkBox = driver.findElement(checkBoxIAgreeSelector);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    // Phương thức cuộn đến phần thông tin bổ sung trên trang
    public void showAddInformationForm() {
        // Tìm phần tử của biểu mẫu thông tin bổ sung
        WebElement addInformationForm = driver.findElement(addYourInfoFormSelector);
        // Cuộn đến phần tử để đảm bảo nó nằm trong vùng nhìn thấy
        DriverUtils.scrollToElement(driver, addInformationForm);
    }

    // Nhập thông tin bổ sung và gửi
    public void fillAndSubmitAdditionalInformation(String fullName, String email, String phone, String address) {
        showAddInformationForm();
        enterNameInput(fullName);
        enterEmailInput(email);
        enterPhoneInput(phone);
        enterAddressInput(address);
        checkAndSelectIAgree();
        driver.findElement(clickButtonSubmitRoomDetailsSelector).click();
    }

    // Phương thưc display information
    public boolean isInformationDisplay() {
         return driver.findElement(userInformationSelector).isDisplayed();
    }

    // Phương thưc display Your Reservation
    public boolean isYourReservationDisplay() {
        return driver.findElement(yourReservationDisplaySelector).isDisplayed();
    }
}
