package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FAQsPage extends GeneralPage{
    WebDriver driver;

    public FAQsPage(WebDriver driver) {
        super(driver);
    }

    String faqsPage = "/faqs";
    // Tiêu đề của trang Rooms
    By faqsPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang Faqs
    public void navigateToFaqsPage() {
        super.navigateToPage(faqsPage);
    }

    // Phương thức lấy title
    public String getFaqsPageTitleText() {
        driver.findElement(faqsPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(faqsPageTitleSelector).isDisplayed());
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
