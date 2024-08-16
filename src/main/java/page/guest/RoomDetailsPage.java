package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RoomDetailsPage extends BasePage {

    // Constructor của lớp RoomDetailsPage
    public RoomDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // selector button book now
    By bookNowButtonSelector  = By.xpath("//input[@value='Book Now']");

    // Selector get tên phòng tại room details
    By getConferenceRoomDetasilsNameSelector = By.xpath("//h3[@class='float-left m-0']");

    // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
    public void openBookNowInRoomDetails() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        driver.findElement(bookNowButtonSelector).click();
    }

    // Phương thức get tên phòng tại roomDetailsPage
    public String getConferenceRoomDetailsName() {
        WebElement conferenceRoomDetailName =  driver.findElement(getConferenceRoomDetasilsNameSelector);
        return  conferenceRoomDetailName.getText();
    }
}
