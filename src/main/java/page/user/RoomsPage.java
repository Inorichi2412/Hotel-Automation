package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoomsPage {
    WebDriver driver;

    By availableRoomsSelector = By.xpath("//div[@class=\"most_pop_item_blog clearfix\"]");

    String roomsSelector = "(//div[@class=\"most_pop_item_blog clearfix\"])[%s]";
    String viewDetailsButtonSelector = ("(//a[@class=\"btn btn-success float-right\"])[%s]");

    public boolean isHaveAvailableRoomsDisplayed() {
        return driver.findElement(availableRoomsSelector).isDisplayed();
    }

//    public boolean isViewDetailButtonDisplayed(int roomIndex) {
//
//        driver.findElement(By.xpath(String.format(viewDetailsButtonSelector),roomIndex));
//        return
//    }

    public boolean isViewDetailsButtonDisplayedForRoom (int roomIndex) {
        String rooms=String.format(roomsSelector,roomIndex);
        WebElement roomsElement=driver.findElement(By.xpath(rooms));
        boolean isRoomDisplayed=roomsElement.isDisplayed();

        String button=String.format(viewDetailsButtonSelector,roomIndex);
        WebElement buttonElement=driver.findElement(By.xpath(button));
        boolean isButtonDisplayed=buttonElement.isDisplayed();

        if (isRoomDisplayed==isButtonDisplayed){
            return true;
        }else {
            return false;
        }
    }


    public RoomsPage(WebDriver driver) {
        this.driver = driver;
    }
}
