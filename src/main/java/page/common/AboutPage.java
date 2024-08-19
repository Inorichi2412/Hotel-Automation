package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage extends GeneralPage{
    WebDriver driver;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    // Selector cho nút điều hướng đến trang Rooms
    //By aboutPageLink = By.xpath("//a[@href='/about']");
    String aboutPage = "/about";
    // Tiêu đề của trang Rooms
    By aboutPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang About
    public void navigateToAboutPage() {
        super.navigateToPage(aboutPage);
    }

    // Phương thức lấy title
    public String getAboutPageTitleText() {
        driver.findElement(aboutPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
