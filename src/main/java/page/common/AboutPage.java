package page.common;

import org.openqa.selenium.WebDriver;

public class AboutPage extends GeneralPage{
    WebDriver driver;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    // Selector cho nút điều hướng đến trang Rooms
    String aboutPage = "/about";

    // Phương thức điều hướng đến trang About
    public void navigateToAboutPage() {
        super.navigateToPage(aboutPage);
    }

}
