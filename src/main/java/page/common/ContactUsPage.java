package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends GeneralPage{
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Selector cho nút điều hướng đến trang Contact
    String contactPage = "/contact";
    // Tiêu đề của trang Rooms
    By contactPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang Contact
    public void navigateToContactPage() {
        super.navigateToPage(contactPage);
    }
}
