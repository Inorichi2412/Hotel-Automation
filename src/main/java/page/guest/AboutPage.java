package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AboutPage extends BasePage {

    // Selector cho nút điều hướng đến trang Rooms
    By buttonDirectionalAboutSelector = By.xpath("//a[@href='/about']");
    // Tiêu đề của trang Rooms
    String pageTitle = "About Us";

    // Constructor của lớp RoomsPage
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức kiểm tra tiêu đề của trang Rooms sau khi điều hướng
    public String getAboutPageTitle() {
        WebElement aboutButton = driver.findElement(buttonDirectionalAboutSelector); // Tìm phần tử nút
        // Điều hướng và lấy tiêu đề trang
        return directional(aboutButton, pageTitle);
    }

    // Phương thức để điều hướng đến trang About và xác nhận tiêu đề sau khi cuộn lên đầu
    public void verifyAboutPageTitleAfterScroll() {
        WebElement aboutButton = driver.findElement(buttonDirectionalAboutSelector);
        aboutButton.click();
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getPageTitle(pageTitle);  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, pageTitle, "Failed to scroll to top and view correct title on About Page");
    }

    // Phương thức để nhấn vào button Breadcrumb Home (sử dụng từ BasePage)
    public void navigateToHomePage() {
        WebElement aboutButton = driver.findElement(buttonDirectionalAboutSelector);
        aboutButton.click();
    }
}
