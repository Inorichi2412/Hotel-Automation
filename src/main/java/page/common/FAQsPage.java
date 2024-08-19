package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
