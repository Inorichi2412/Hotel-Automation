package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RoomDetailsPage extends BasePage {

    // Constructor của lớp RoomDetailsPage
    public RoomDetailsPage(WebDriver driver) {
        super(driver);
    }

    //
    By bookNowButtonSelector  = By.xpath("//input[@value='Book Now']");

    // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
    public void openBookNowInRoomDetails() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        driver.findElement(bookNowButtonSelector).click();
    }

}
