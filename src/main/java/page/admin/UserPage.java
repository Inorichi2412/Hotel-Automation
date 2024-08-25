package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserPage extends GeneralPage{
    WebDriver driver;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Selector view user
    By userMenuSelector = By.xpath("//*[@id='remove-scroll']/ul/li[5]/a");
    By clickViewUserSelector = By.xpath("//*[@id='remove-scroll']/ul/li[5]/ul/li[2]/a");
    By listViewSelector = By.xpath("//div[@class='card-body ']");
    By clickGridViewSelector = By.xpath("//a[text()='Grid View']");
    By showGridViewSelector = By.xpath("//div[@class='tab-pane active show']");
    By usersNumberDropdownSelector = By.xpath("//*[@id='example4_length']/label/select");
    By numberOfUsersSelector = By.xpath("//tbody//tr");

    // Selector add user
    By AddUserButtonSelector = By.xpath("//span[text()='Add User']");
    By enterFullNameSelector = By.id("txtFirstName");
    By enterEmailSelector = By.id("txtemail");
    By enterPhoneSelector = By.id("text5");
    By enterUserNameSelector = By.id("txtUserName");
    By enterPasswordSelector = By.id("txtPwd");
    By enterComfimPasswordSelector = By.id("txtConfirmPwd");
    By enterAddressSelector = By.id("text7");
    By clickSubmitButtonSelector = By.xpath("//span[@class='mdl-button__ripple-container']");
    By enterSearchTextboxSelector = By.xpath("//input[@class='form-control form-control-sm']");

    public void clickUserMenu() {
        driver.findElement(userMenuSelector).click();
    }

    public void clickViewUser() {
        driver.findElement(clickViewUserSelector).click();
        try {
            Thread.sleep(5000); // Chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean showListView() {
        return driver.findElement(listViewSelector).isDisplayed();
    }

    public void clickGridView() {
        driver.findElement(clickGridViewSelector).click();
    }

    public boolean showGridView() {
        return driver.findElement(showGridViewSelector).isDisplayed();
    }

    private void selectNumberOfUser(String rows) {
        WebElement userNumber = driver.findElement(usersNumberDropdownSelector);
        Select select = new Select(userNumber);
        select.selectByVisibleText(rows);
    }

    public void showTenBookingRows() {
        selectNumberOfUser("10");
    }

    public void showTwentyFiveBookingRows() {
        selectNumberOfUser("25");
    }

    public void showFiftyBookingRows() {
        selectNumberOfUser("50");
    }

    public void showHundredBookingRows() {
        selectNumberOfUser("100");
    }

    public int numberOfUsersIsDisplay() {
        List<WebElement> numberOfUsers = driver.findElements(numberOfUsersSelector);
        int rowUsers;
        return rowUsers = numberOfUsers.size();
    }

    public void clickAddUser() {
        driver.findElement(AddUserButtonSelector).click();
    }

    // Phương thức gửi giá trị vào trường họ và tên
    public void enterFullName(String fullName) {
        driver.findElement(enterFullNameSelector).sendKeys(fullName);
    }

    // Phương thức gửi giá trị vào trường email
    public void enterEmail(String email) {
        driver.findElement(enterEmailSelector).sendKeys(email);
    }

    // Phương thức gửi giá trị vào trường số điện thoại
    public void enterPhone(String phone) {
        driver.findElement(enterPhoneSelector).sendKeys(phone);
    }

    // Phương thức gửi giá trị vào trường tên người dùng
    public void enterUserName(String userName) {
        driver.findElement(enterUserNameSelector).sendKeys(userName);
    }

    // Phương thức gửi giá trị vào trường mật khẩu
    public void enterPassword(String password) {
        driver.findElement(enterPasswordSelector).sendKeys(password);
    }

    // Phương thức gửi giá trị vào trường xác nhận mật khẩu
    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(enterComfimPasswordSelector).sendKeys(confirmPassword);
    }

    // Phương thức gửi giá trị vào trường địa chỉ
    public void enterAddress(String address) {
        driver.findElement(enterAddressSelector).sendKeys(address);
    }

    public void clickSubmitButton() {
        driver.findElement(clickSubmitButtonSelector).click();
    }

    // Phương thức gửi tất cả thông tin người dùng
    public void enterInforUser(String fullName, String email, String phone, String userName, String password, String confirmPassword, String address) {
        enterFullName(fullName);
        enterEmail(email);
        enterPhone(phone);
        enterUserName(userName);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterAddress(address);
        clickSubmitButton();
    }

    public void searchUserName(String userName) {
        driver.findElement(enterSearchTextboxSelector).sendKeys(userName);
    }
}
