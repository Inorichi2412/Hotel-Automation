package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FAQsPage extends GeneralPage{
    WebDriver driver;

    public FAQsPage(WebDriver driver) {
        super(driver);
    }

    String faqsPage = "/faqs";

    // Phương thức điều hướng đến trang Faqs
    public void navigateToFaqsPage() {
        super.navigateToPage(faqsPage);
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
