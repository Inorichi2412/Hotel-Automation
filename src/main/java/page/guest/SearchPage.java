package page.guest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Phương thức get booking id
    public String getBookingId() {
        // Tìm phần tử chứa ID đặt phòng
        WebElement bookingIdElement = driver.findElement(bookingConfirmationIdSelector);
        // Lấy văn bản từ phần tử
        String bookingIdText = bookingIdElement.getText();
        // Kiểm tra chiều dài của văn bản và lấy 14 ký tự cuối
        if (bookingIdText.length() >= 14) {
            return bookingIdText.substring(bookingIdText.length() - 14);
        } else {
            // Nếu văn bản ngắn hơn 14 ký tự, trả về toàn bộ văn bản
            return bookingIdText;
        }
    }
}
