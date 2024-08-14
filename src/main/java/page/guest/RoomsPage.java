package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RoomsPage extends BasePage {

    ConfirmPage confirmPage;

    // Selector cho nút điều hướng đến trang Rooms
    By roomsPageLink = By.xpath("//a[@href='/rooms']");
    // Tiêu đề của trang Rooms
    By roomsPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");
    // selector search
    By bookingIdTextboxSelector = By.id("search");
    By searchButtonSelector = By.xpath("//*[@id='searchForm']/input[2]");

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
        // khởi tao đối tượng
        this.confirmPage = new ConfirmPage(driver);
    }

    // Phương thức điều hướng đến trang Rooms
    public void navigateToRoomsPage() {
        driver.findElement(roomsPageLink).click();
    }
    // Phương thức lấy title
    public String getRoomsPageTitleText() {
        driver.findElement(roomsPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(roomsPageTitleSelector).isDisplayed());
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
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

    // Phương thức để lấy ID xác nhận đặt phòng từ RoomsPage
    public String retrieveBookingConfirmationId() {
        return confirmPage.getBookingConfirmationId();
    }

    // Phương thức để lấy tên phòng từ RoomsPage
    public String retrieveRoomName() {
        return confirmPage.getRoomName();
    }

    // Phương thức để lấy thông tin phòng từ RoomsPage
    public String retrieveRoomInfo() {
        return confirmPage.getRoomInfo();
    }

    public void enterBookingIdAndSearch() {
        super.enterBookingIdAndSearch();
    }
}
