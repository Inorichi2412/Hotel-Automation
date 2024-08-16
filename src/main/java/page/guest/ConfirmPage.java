package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends BasePage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Selector thông tin phòng booking
     //By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");
    By bookingConfirmationIdSelector = By.xpath("//span[starts-with(@class, 'green_text1') and contains(text(), 'Id:')]");
    By roomNameSelector = By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/h5");
    By roomInfoSelector = By.xpath("//span[@class='float-left']");

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

    // Phương thức get booking id
    public String getBookingIdError() {
        // Tìm phần tử chứa ID đặt phòng
        WebElement bookingIdElement = driver.findElement(bookingConfirmationIdSelector);
        // Lấy văn bản từ phần tử
        String bookingIdText = bookingIdElement.getText();
        // Kiểm tra chiều dài của văn bản và lấy 14 ký tự cuối
        if (bookingIdText.length() >= 14) {
            return bookingIdText.substring(bookingIdText.length() - 13);
        } else {
            // Nếu văn bản ngắn hơn 14 ký tự, trả về toàn bộ văn bản
            return bookingIdText;
        }
    }

}
