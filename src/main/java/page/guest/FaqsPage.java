package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FaqsPage extends BasePage {

    // Selector cho nút điều hướng đến trang FAQs
    By buttonDirectionalFaqsSelector = By.xpath("//a[@href='/faqs']");
    // Tiêu đề của trang FAQs
    String pageTitle = "FAQ";

    // Constructor của lớp FaqsPage
    public FaqsPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức kiểm tra tiêu đề của trang FAQs sau khi điều hướng
    public String getFaqsPageTitle() {
        WebElement faqsButton = driver.findElement(buttonDirectionalFaqsSelector); // Tìm phần tử nút
        // Điều hướng và lấy tiêu đề trang
        return directional(faqsButton, pageTitle);
    }

    // Phương thức để điều hướng đến trang FAQs và xác nhận tiêu đề sau khi cuộn lên đầu
    public void verifyFaqsPageTitleAfterScroll() {
        WebElement faqsButton = driver.findElement(buttonDirectionalFaqsSelector);
        faqsButton.click();
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getPageTitle(pageTitle);  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, pageTitle, "Failed to scroll to top and view correct title on FAQs Page");
    }

    // Phương thức để nhấn vào button Breadcrumb Home (sử dụng từ BasePage)
    public void navigateToHomePage() {
        WebElement faqsButton = driver.findElement(buttonDirectionalFaqsSelector);
        faqsButton.click();
        clickButtonBreadcrumbHome();
    }
}
