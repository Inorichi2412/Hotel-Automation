package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.DriverUtils;

import java.time.Duration;

public class HomePage extends BasePage {

    //Khai báo một đối tượng DriverUtils
    DriverUtils driverUtils;

    // Selector cho nút điều hướng đến trang Rooms
    //By homePageLink = By.xpath("//a[@href='/']");
    String homePage = "/";
    // Selector cho tiêu đề của trang chính
    By pageHomeTitleSelector = By.xpath("/html/body/section[1]/div/div/div/div/h1");

    // Selector cho các trường trong phần tìm kiếm
    By checkinSelector = By.name("arrival");
    By checkoutSelector = By.name("depature");
    By adultSelector = By.name("adult");
    By childrenSelector = By.name("children");
    By buttonSearchSelector = By.xpath("//input[@class='btn btn-success btn-block']");
    By showRoomSelector = By.xpath("//h2[@class='page_title white-text']");

    // Selector id booking đã xác nhận
    By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");

    // Constructor của lớp HomePage
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Phương thức điều hướng đến trang Rooms
    public void navigateToHomePage() {
       super.navigateToPage(homePage);
    }

    // phương thưc lấy title
    @Override
    public String getPageTitleText() {
        WebElement titleElement = driver.findElement(pageHomeTitleSelector);
        return titleElement.getText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
//        // khi thấy title cua trang
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(e -> e.findElement(pageHomeTitleSelector).isDisplayed());
    }

    //TC2
    // Nhập ngày check-in
    public void inputCheckinDate(String checkIn) {
        driver.findElement(checkinSelector).sendKeys(checkIn);
    }

    // Nhập ngày check-out
    public void inputCheckoutDate(String checkOut) {
        driver.findElement(checkoutSelector).sendKeys(checkOut);
    }

    // Nhập số lượng người lớn
    public void inputAdults(int adults) {
        // Chuyển đổi giá trị int thành String trước khi nhập
        String adultsText = String.valueOf(adults);
        driver.findElement(adultSelector).sendKeys(adultsText);
    }

    // Nhập số lượng trẻ em
    public void inputChildren(int children) {
        // Chuyển đổi giá trị int thành String trước khi nhập
        String childrenText = String.valueOf(children);
        driver.findElement(childrenSelector).sendKeys(childrenText);
    }

    // Nhấn nút tìm kiếm
    public void clickSearchButton() {
        driver.findElement(buttonSearchSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(showRoomSelector).isDisplayed());
    }

    // Thực hiện tìm kiếm đặt phòng với các thông tin: ngày check-in, check-out, số lượng người lớn và trẻ em
    public void searchForBooking(String checkIn, String checkOut, int adults, int children) {
        inputCheckinDate(checkIn);
        inputCheckoutDate(checkOut);
        inputAdults(adults);
        inputChildren(children);
        clickSearchButton();
    }
}
