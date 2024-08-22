package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage{
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //selector
    By informationAdminSelector = By.xpath("//div[@class='user-panel']");

    public boolean informationAdmin() {
        return driver.findElement(informationAdminSelector).isDisplayed();
    }

}
