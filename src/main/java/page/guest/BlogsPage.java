package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BlogsPage extends BasePage {

    // Selector cho nút điều hướng đến trang Blogs
    //By blogsPageLink = By.xpath("//a[@href='/blogs']");
    String blogsPage = "/blogs";
    // Tiêu đề của trang Rooms
    By blogPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Constructor của lớp BlogsPage
    public BlogsPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức điều hướng đến trang Blogs
    public void navigateToBlogsPage() {
       super.navigateToPage(blogsPage);
    }

    // Phương thức lấy title
    public String getBlogsPageTitleText() {
        driver.findElement(blogPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(blogPageTitleSelector).isDisplayed());
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
