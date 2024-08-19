package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends GeneralPage{
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Selector cho nút điều hướng đến trang Contact
    //By contactPageLink = By.xpath("//a[@href='/contact']");
    String contactPage = "/contact";
    // Tiêu đề của trang Rooms
    By contactPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    // Phương thức điều hướng đến trang Contact
    public void navigateToContactPage() {
        super.navigateToPage(contactPage);
    }

    // Phương thức lấy title
    public String getContactPageTitleText() {
        driver.findElement(contactPageTitleSelector).click();
        return getPageTitleText();
    }

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }
}
