package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoomsPage {
    WebDriver driver;

    By availableRoomsSelector= By.xpath("//div[@class=\"most_pop_item_blog clearfix\"]");

    public boolean isHaveAvailableRoomsDisplayed() {
        return driver.findElement(availableRoomsSelector).isDisplayed();
    }
    public RoomsPage(WebDriver driver) {
        this.driver = driver;
    }
}
