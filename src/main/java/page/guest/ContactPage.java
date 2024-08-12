package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ContactPage extends BasePage {

    // Selector cho nút điều hướng đến trang Contact
    By buttonDirectionalContactSelector = By.xpath("//a[@href='/contact']");
    // Tiêu đề của trang Contact
    String pageTitle = "Contact Us";

    // Constructor của lớp ContactPage
    public ContactPage(WebDriver driver) {
        super(driver);
    }

    // Phương thức kiểm tra tiêu đề của trang Contact sau khi điều hướng
    public String getContactPageTitle() {
        WebElement contactButton = driver.findElement(buttonDirectionalContactSelector); // Tìm phần tử nút
        // Điều hướng và lấy tiêu đề trang
        return directional(contactButton, pageTitle);
    }

    // Phương thức để điều hướng đến trang Contact và xác nhận tiêu đề sau khi cuộn lên đầu
    public void verifyContactPageTitleAfterScroll() {
        WebElement contactButton = driver.findElement(buttonDirectionalContactSelector);
        contactButton.click();
        clickScrollToTop();  // Cuộn lên đầu trang
        String actualTitle = getPageTitle(pageTitle);  // Lấy tiêu đề trang
        Assert.assertEquals(actualTitle, pageTitle, "Failed to scroll to top and view correct title on Contact Page");
    }

    // Phương thức để nhấn vào button Breadcrumb Home (sử dụng từ BasePage)
    public void navigateToHomePage() {
        WebElement contactButton = driver.findElement(buttonDirectionalContactSelector);
        contactButton.click();
    }
}
