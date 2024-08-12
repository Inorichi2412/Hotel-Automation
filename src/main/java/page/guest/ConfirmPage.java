package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmPage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
    }

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");

}
