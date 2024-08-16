package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public class GeneralPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    DriverUtils driverUtils;

    By logoLinkSelector=By.xpath("(//a[@href=\"/\"])[1]");
    By homeLinkSelector=By.xpath("(//a[@href=\"/\"])[2]");
    By roomsLinkSelector= By.xpath("//a[@href=\"/rooms\"]");
    By aboutLinkSelector=By.xpath("//a[@href=\"/about\"]");
    By blogsLinkSelector=By.xpath("//a[@href=\"/blogs\"]");
    By contactLinkSelector=By.xpath("//a[@href=\"/contact\"]");
    By faqsLinkSelector=By.xpath("//a[@href=\"/faqs\"]");

    By h1HeaderSelector=By.xpath("//h1");
    By h2HeaderSelector=By.xpath("//h2[@class=\"page_title white-text\"]");

    By homeBreadCrumbSelector=By.xpath("//li[@class=\"breadcrumb-item\"]/a");

    // selector title
    By pageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Selector cho button scroll
    By buttonScrollToTopSelector = By.id("scrollToTop");
    By bookingInfoSelector = By.xpath("//h4[@class='form_title4']");

    // Selector cho homePage
    By buttonBreadcrumbHomeSelector = By.xpath("//a[@href='/']");

    // Selector cho chức năng search textbox
    By searchIconSelector= By.xpath("//span[@class='sb-icon-search']");
    By bookingIdTextboxSelector = By.name("bookingUID");
    By searchButtonSelector = By.xpath("//*[@id='searchForm']/input[2]");

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[starts-with(@class, 'green_text1') and contains(text(), 'Id:')]");

    // Selector getmessage not found bookingid
    By getBookingIdnotFoundMessage =  By.xpath("//h1[@class='mmb-blc-title']");


    public void openLogoPage() {
        driver.findElement(logoLinkSelector).click();
    }

    public void openHomePage() {
        driver.findElement(homeLinkSelector).click();
    }

    public void openRoomsPage() {
        driver.findElement(roomsLinkSelector).click();
    }

    public void openAboutPage() {
        driver.findElement(aboutLinkSelector).click();
    }

    public void openBlogsPage() {
        driver.findElement(blogsLinkSelector).click();
    }

    public void openContactPage() {
        driver.findElement(contactLinkSelector).click();
    }

    public void openFAQsPage() {
        driver.findElement(faqsLinkSelector).click();
    }

    public void clickHomeBreadCrumb() {
        driver.findElement(homeBreadCrumbSelector).click();
    }

    public String getTitle(){
        return driver.findElement(h2HeaderSelector).getText();
    }

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driverUtils = new DriverUtils(driver);
    }

    final Duration waitDuration = Duration.ofSeconds(10);

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
    public void displayToElement() {
        // Tìm phần tử cần cuộn đến
        WebElement element = driver.findElement(bookingInfoSelector);
        // Cuộn đến phần tử
        driverUtils.scrollToElement(element);
    }

    // Phương thức click vào textbox
    public void openSearchTextbox() {
        driver.findElement(searchIconSelector).click();
    }

    // Phương thức search textbox
    public void searchBooking(String bookingId) {
        openSearchTextbox();
        WebElement bookingIdTextbox = driver.findElement(bookingIdTextboxSelector);
        bookingIdTextbox.sendKeys(bookingId);
        driver.findElement(searchButtonSelector).click();
    }

    // Phương thức get message khi bookingId không tồn tại
    public String getBookingNotFoundMessage() {
        clickScrollToTop();
        WebElement pageMessageElement = driver.findElement(getBookingIdnotFoundMessage);
        return pageMessageElement.getText();
    }
}
