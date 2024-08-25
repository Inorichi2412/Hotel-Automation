package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends GeneralPage{
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //selector fix lay dashbord
    By informationAdminSelector = By.xpath("//div[text()='Dashboard']");

    public boolean informationAdmin() {
        return driver.findElement(informationAdminSelector).isDisplayed();
    }
}
