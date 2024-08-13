package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    // Selector thông tin phòng booking
    //By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");
    By bookingConfirmationIdSelector = By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/p[1]/span[2]");

    By roomNameSelector = By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/h5");
    By roomInfoSelector = By.xpath("//span[@class='float-left']");

    // Phương thức cuộn trang để xem phần tử
    public void clickScrollToElement() {
        super.clickScrollToElement();
        try {
            Thread.sleep(5000); // Chờ 5 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lấy ID xác nhận đặt phòng
    public String getBookingConfirmationId() {
        String bookingConfirmationId = driver.findElement(bookingConfirmationIdSelector).getText();
        // Lấy 14 ký tự cuối cùng của chuỗi
        if (bookingConfirmationId.length() > 14) {
            return bookingConfirmationId.substring(bookingConfirmationId.length() - 14);
        } else {
            // Nếu chuỗi ngắn hơn 14 ký tự, trả về toàn bộ chuỗi
            return bookingConfirmationId;
        }
    }

    // Phương thức để lấy tên phòng
    public String getRoomName() {
        WebElement roomNameElement = driver.findElement(roomNameSelector);
        return roomNameElement.getText();
    }

    // Phương thức để lấy thông tin phòng
    public String getRoomInfo() {
        WebElement roomInfoElement = driver.findElement(roomInfoSelector);
        return roomInfoElement.getText();
    }
}
