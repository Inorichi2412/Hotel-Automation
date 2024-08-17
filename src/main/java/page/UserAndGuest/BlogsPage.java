package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogsPage extends GeneralPage{
    WebDriver driver;

    public BlogsPage(WebDriver driver) {
        super(driver);
    }
    // Selector cho nút điều hướng đến trang Blogs
    //By blogsPageLink = By.xpath("//a[@href='/blogs']");
    String blogsPage = "/blogs";
    // Tiêu đề của trang Rooms
    By blogPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang Blogs
    public void navigateToBlogsPage() {
        super.navigateToPage(blogsPage);
    }

    // Phương thức lấy title
    public String getBlogsPageTitleText() {
        driver.findElement(blogPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
