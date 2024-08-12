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

    // Selector cho button scroll
    By buttonScrollToTopSelector = By.id("scrollToTop");

    // Selector cho homePage
    By buttonBreadcrumbHomeSelector = By.xpath("//a[@href='/']");

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

    // Phương thức để xây dựng selector cho tiêu đề dựa trên tên trang
    public By getTitleSelector(String pageTitle) {
        return By.xpath("//h2[text()='" + pageTitle + "']");
    }

    // Phương thức điều hướng và lấy tiêu đề trang
    public String directional(WebElement button, String pageTitle) {
        // Nhấn vào nút
        button.click();
        // Khởi tạo WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        // Tạo selector cho tiêu đề trang dựa trên tên trang
        By titleSelector = getTitleSelector(pageTitle);
        // Chờ đến khi phần tử tiêu đề có thể nhìn thấy được
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titleSelector));
        // Trả về văn bản của tiêu đề
        return titleElement.getText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    public void clickScrollToTop() {
        // Cuộn xuống dưới cùng
        driverUtils.scrollToBottom();
        // Nhấn nút "Scroll to Top"
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        scrollToTopButton.click();
    }

    // Phương thức để lấy tiêu đề của trang dựa trên pageTitle
    public String getPageTitle(String pageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, waitDuration);
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getTitleSelector(pageTitle)));
        return titleElement.getText();
    }

    //TC5
    // Phương thức để nhấn vào button Breadcrumb Home
    public void clickButtonBreadcrumbHome() {
        WebElement breadcrumbHomeButton = driver.findElement(buttonBreadcrumbHomeSelector);
        breadcrumbHomeButton.click();
    }

    //TC2

}
