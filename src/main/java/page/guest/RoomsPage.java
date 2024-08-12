package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class RoomsPage extends BasePage {

    // Selector cho nút điều hướng đến trang Rooms
    By buttonDirectionalRoomsSelector = By.xpath("//a[@href='/rooms']");
    // Tiêu đề của trang Rooms
    String pageTitle = "Rooms";

    //selector search
    By viewDetailsButtonSelector = By.xpath("//a[@class='btn btn-success float-right']");
    By bookNowButtonSelector  = By.xpath("//input[@value='Book Now']");
    By addYourInfoFormSelector = By.xpath("//h4[text()='Add Your Informations :-']");
    By textBoxFullNameSelector = By.id("name");
    By textBoxEmailSelector = By.id("email");
    By textBoxPhoneSelector = By.id("phone");
    By textBoxAddressSelector = By.id("address");
    By checkBoxIAgreeSelector = By.xpath("//Strong[text()='Terms and Conditions']");
    By clickButtonSubmitRoomDetailsSelector =  By.xpath("//*[@id='user']/div/div[1]/div[6]/input");

    // Constructor của lớp RoomsPage
    public RoomsPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức kiểm tra tiêu đề của trang room sau khi điều hướng
    public String getRoomsPageTitle() {
        WebElement roomButton = driver.findElement(buttonDirectionalRoomsSelector);
        // Điều hướng và lấy tiêu đề trang
        return directional(roomButton, pageTitle);
    }

    // Phương thức để điều hướng đến trang Rooms và xác nhận tiêu đề sau khi cuộn lên đầu
    public void verifyRoomPageTitleAfterScroll() {
        WebElement roomButton = driver.findElement(buttonDirectionalRoomsSelector);
        roomButton.click();
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getPageTitle(pageTitle);  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, pageTitle, "Failed to scroll to top and view correct title on Rooms Page");
    }

    // Phương thức để nhấn vào button Breadcrumb Home (sử dụng từ BasePage)
    public void navigateToHomePage() {
        WebElement roomButton = driver.findElement(buttonDirectionalRoomsSelector);
        roomButton.click();
    }

    //TC2
    // Phương thức cuộn tới phần tử và nhấn nút View Details
    public void scrollToElementAndClickViewDetails() {
        // Cuộn đến phần tử nút "Scroll to Top"
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        // Sau khi cuộn lên đầu trang, nhấn vào nút "View Details"
        driver.findElement(viewDetailsButtonSelector).click();
    }

    // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
    public void scrollToAndClickBookNowInRoomDetails() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        driver.findElement(bookNowButtonSelector).click();
    }

    // Phương thức cuộn đến phần thông tin bổ sung trên trang
    public void scrollToAddInformationForm() {
        // Tìm phần tử của biểu mẫu thông tin bổ sung
        WebElement addInformationForm = driver.findElement(addYourInfoFormSelector);
        // Cuộn đến phần tử để đảm bảo nó nằm trong vùng nhìn thấy
        driverUtils.scrollToElement(addInformationForm);
    }

    // Nhập tên đầy đủ
    public void enterFullName(String fullName) {
        driver.findElement(textBoxFullNameSelector).sendKeys(fullName);
    }

    // Nhập địa chỉ email
    public void enterEmail(String email) {
        driver.findElement(textBoxEmailSelector).sendKeys(email);
    }

    // Nhập số điện thoại
    public void enterPhoneNumber(String phone) {
        driver.findElement(textBoxPhoneSelector).sendKeys(phone);
    }

    // Nhập địa chỉ
    public void enterAddress(String address) {
        driver.findElement(textBoxAddressSelector).sendKeys(address);
    }

    // Kiểm tra và chọn
    public void checkAndSelectIAgree() {
        WebElement checkBox = driver.findElement(checkBoxIAgreeSelector);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    // Nhập thông tin bổ sung và gửi
    public void fillAndSubmitAdditionalInformation(String fullName, String email, String phone, String address) {
        enterFullName(fullName);
        enterEmail(email);
        enterPhoneNumber(phone);
        enterAddress(address);
        checkAndSelectIAgree();
        driver.findElement(clickButtonSubmitRoomDetailsSelector).click();
    }

    // Phương thức cụ thể của RoomsPage để nhập mã xác nhận và tìm kiếm

}
