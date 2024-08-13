package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AboutPage extends BasePage {

    // Selector cho nút điều hướng đến trang Rooms
    By aboutPageLink = By.xpath("//a[@href='/about']");
    // Tiêu đề của trang Rooms
    By aboutPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Constructor của lớp RoomsPage
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức điều hướng đến trang About
    public void navigateToAboutPage() {
        driver.findElement(aboutPageLink).click();
    }

    // Phương thức lấy title
    public String getAboutPageTitleText() {
        driver.findElement(aboutPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
    @Override
    public void clickScrollToTop() {
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(aboutPageTitleSelector).isDisplayed());
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
