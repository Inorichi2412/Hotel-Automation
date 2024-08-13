package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    DriverUtils driverUtils;
    final Duration waitDuration = Duration.ofSeconds(10);

    // selector title
    By pageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Selector cho button scroll
    By buttonScrollToTopSelector = By.id("scrollToTop");
    By bookingInfoSelector = By.xpath("//h4[@class='form_title4']");

    // Selector cho homePage
    By buttonBreadcrumbHomeSelector = By.xpath("//a[@href='/']");

    // Selector cho chức năng search textbox
    By searchIconSelector= By.xpath("//span[@class='sb-icon-search']");

    // Selector id booking đã xác nhận
    By clickSearchInputBoxSelector  = By.xpath("//*[@id='searchForm']/span");
    By searchInputBoxSelector  = By.xpath("//*[@id='searchForm']/input[2]");

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");

    // Constructor của lớp BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Khởi tạo đối tượng DriverUtils
        this.driverUtils = new DriverUtils(driver);
    }

    // Phương thức điều hướng đến các trang
    public void navigateToPage(String pageName) {
        By menuSelector = By.xpath("//a[@href='"+ pageName +"']");
        driver.findElement(menuSelector).click();
    }

    // Phương thức lấy title
    public String getPageTitleText() {
        WebElement pageTitleElement = driver.findElement(pageTitleSelector);
        return pageTitleElement.getText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    public void clickScrollToTop() {
        // Cuộn xuống dưới cùng
        driverUtils.scrollToBottom();
        // Nhấn nút "Scroll to Top"
        driver.findElement(buttonScrollToTopSelector).click();
    }

    // Phương thức để nhấn vào button Breadcrumb Home
    public void navigateToHomePageFromBreadcrumb() {
        driver.findElement(buttonBreadcrumbHomeSelector).click();
    }

    // phương thức cuộn đến đối tượng cụ thể
    public void clickScrollToElement() {
        // Tìm phần tử cần cuộn đến
        WebElement element = driver.findElement(bookingInfoSelector);
        // Cuộn đến phần tử
        driverUtils.scrollToElement(element);
    }

    // Phương thức chức năng nhập ID booking vào một ô textbox và nhấp vào nút tìm kiếm
    public void enterBookingIdAndSearch() {
        driver.findElement(searchIconSelector).click();
    }
}
