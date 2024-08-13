package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class RoomsPage extends GeneralPage {

    By availableRoomsSelector= By.xpath("//div[@class=\"most_pop_item_blog clearfix\"]");
    String roomsSelector = ("(//div[@class=\"most_pop_item_blog clearfix\"])[%s]");
    String viewDetailsButtonSelector = ("(//a[@class=\"btn btn-success float-right\"])[%s]");

    public boolean isHaveAvailableRoomsDisplayed() {
        return driver.findElement(availableRoomsSelector).isDisplayed();
    }

    public boolean isViewDetailsButtonDisplayedForRoom(int roomIndex) {
        By viewDetailsButton = By.xpath(String.format(viewDetailsButtonSelector, roomIndex));
        return driver.findElement(viewDetailsButton).isDisplayed();
    }

    public void checkViewDetailsButtonForAllRooms(SoftAssert softAssert) {
        for (int roomIndex = 1; roomIndex <= 10; roomIndex++) {
            boolean isButtonDisplayed = isViewDetailsButtonDisplayedForRoom(roomIndex);
            softAssert.assertTrue(isButtonDisplayed, "View detail not available for room " + roomIndex);
        }
    }

    public RoomsPage(WebDriver driver) {
        super(driver);

    }
}
