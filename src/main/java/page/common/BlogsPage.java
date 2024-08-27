package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogsPage extends GeneralPage{
    WebDriver driver;

    public BlogsPage(WebDriver driver) {
        super(driver);
    }
    // Selector cho nút điều hướng đến trang Blogs
    String blogsPage = "/blogs";

    // Phương thức điều hướng đến trang Blogs
    public void navigateToBlogsPage() {
        super.navigateToPage(blogsPage);
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
