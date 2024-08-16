package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends GeneralPage{
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Selector cho nút điều hướng đến trang Contact
    //By contactPageLink = By.xpath("//a[@href='/contact']");
    String contactPage = "/contact";
    // Tiêu đề của trang Rooms
    By contactPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang Contact
    public void navigateToContactPage() {
        super.navigateToPage(contactPage);
    }

    // Phương thức lấy title
    public String getContactPageTitleText() {
        driver.findElement(contactPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(contactPageTitleSelector).isDisplayed());
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
