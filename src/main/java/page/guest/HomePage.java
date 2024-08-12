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

    // Selector cho tiêu đề của trang chính
    By titleHomeSelector = By.xpath("//h1[text()='Best Hotel to stay']");

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

    //TC1
    // Phương thức để điều hướng và kiểm tra tiêu đề của trang chính
    public String getHomePageTitle() {
        WebElement titleElement = driver.findElement(titleHomeSelector);
        return titleElement.getText();
    }

    //TC4
    // Phương thức để kiểm tra tiêu đề của trang Home sau khi cuộn lên đầu
    public void verifyHomePageTitleAfterScroll() {
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getHomePageTitle();  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, "Best Hotel to stay", "Failed to scroll to top and view correct title on Home Page");
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

    // Phương thức cl
}
