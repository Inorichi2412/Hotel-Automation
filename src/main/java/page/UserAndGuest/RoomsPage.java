package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class RoomsPage extends GeneralPage {

    By availableRoomsSelector= By.xpath("//div[@class=\"most_pop_item_blog clearfix\"]");
    String rooms = "(//div[@class=\"most_pop_item_blog clearfix\"])[%s]";
    String viewDetailsButton = "(//a[@class=\"btn btn-success float-right\"])[%s]";
    String roomName ="(//h5)[%s]";

    public boolean isHaveAvailableRoomsDisplayed() {
        return driver.findElement(availableRoomsSelector).isDisplayed();
    }

    public int getNumberOfAvailableRooms() {
        List<WebElement> rooms = driver.findElements(availableRoomsSelector);
        return rooms.size();
    }

    public boolean isViewDetailsButtonDisplayedForRoom(int roomIndex) {
        By viewDetailsButtonSelector = By.xpath(String.format(this.viewDetailsButton, roomIndex));
        List<WebElement> elements = driver.findElements(viewDetailsButtonSelector);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public void checkViewDetailsButtonForAllRooms(SoftAssert softAssert) {
        int numberOfRooms = getNumberOfAvailableRooms();
        for (int roomIndex = 1; roomIndex <= numberOfRooms; roomIndex++) {
            boolean isButtonDisplayed = isViewDetailsButtonDisplayedForRoom(roomIndex);
            softAssert.assertTrue(isButtonDisplayed, "View detail not available for room " + roomIndex);
        }
    }

    public String openRoomByIndex(int roomIndex) {
        String roomNameByIndex=getRoomsNameByIndex(roomIndex);
        By viewDetailsButtonSelector = By.xpath(String.format(this.viewDetailsButton, roomIndex));
        driver.findElement(viewDetailsButtonSelector).click();
        return roomNameByIndex;
    }

    public String getRoomsNameByIndex(int roomIndex) {
        By roomNameSelector=By.xpath(String.format(this.roomName,roomIndex));
        return driver.findElement(roomNameSelector).getText();
    }


    public RoomsPage(WebDriver driver) {
        super(driver);

    }
}
