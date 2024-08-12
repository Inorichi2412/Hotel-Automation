package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BlogsPage extends BasePage {

    // Selector cho nút điều hướng đến trang Blogs
    By buttonDirectionalBlogsSelector = By.xpath("//a[@href='/blogs']");
    // Tiêu đề của trang Blogs
    String pageTitle = "Our Blogs";

    // Constructor của lớp BlogsPage
    public BlogsPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức kiểm tra tiêu đề của trang Blogs sau khi điều hướng
    public String getBlogsPageTitle() {
        WebElement blogsButton = driver.findElement(buttonDirectionalBlogsSelector); // Tìm phần tử nút
        // Điều hướng và lấy tiêu đề trang
        return directional(blogsButton, pageTitle);
    }

    // Phương thức để điều hướng đến trang Blogs và xác nhận tiêu đề sau khi cuộn lên đầu
    public void verifyBlogsPageTitleAfterScroll() {
        WebElement blogsButton = driver.findElement(buttonDirectionalBlogsSelector);
        blogsButton.click();
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getPageTitle(pageTitle);  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, pageTitle, "Failed to scroll to top and view correct title on Blogs Page");
    }

    // Phương thức để nhấn vào button Breadcrumb Home (sử dụng từ BasePage)
    public void navigateToHomePage() {
        WebElement blogsButton = driver.findElement(buttonDirectionalBlogsSelector);
        blogsButton.click();
    }
}
