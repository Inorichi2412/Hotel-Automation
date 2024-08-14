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

    ConfirmPage confirmPage;
    String bookId;
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
    By bookingIdTextboxSelector = By.id("search");
    By searchButtonSelector = By.xpath("//*[@id='searchForm']/input[2]");

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[starts-with(@class, 'green_text1') and contains(text(), 'Id:')]");
    By roomNameSelector = By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/h5");
    By roomInfoSelector = By.xpath("//span[@class='float-left']");


    // Constructor của lớp BasePage
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Khởi tạo đối tượng DriverUtils
        this.driverUtils = new DriverUtils(driver);
        // Khởi tạo đối tượng ConfirmPage
        this.confirmPage = new ConfirmPage(driver);
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

    // Phương thức click vào textbox
    public void openSearchTextbox() {
        driver.findElement(searchIconSelector).click();
    }

    // Phương thức lấy ID xác nhận đặt phòng từ ConfirmPage
    public String getBookingConfirmationId() {
        // Gọi phương thức từ ConfirmPage để lấy ID xác nhận
        return confirmPage.getBookingConfirmationId();
    }

    public void enterBookingIdAndSearch() {
        openSearchTextbox();
        String bookId = getBookingConfirmationId();
        WebElement bookingIdTextbox = driver.findElement(bookingIdTextboxSelector);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementValue(bookingIdTextboxSelector, "")));
        bookingIdTextbox.sendKeys(bookId);
    }
}
