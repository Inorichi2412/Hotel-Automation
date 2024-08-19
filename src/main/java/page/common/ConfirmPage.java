package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage extends GeneralPage {
    WebDriver driver;

    public ConfirmPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[starts-with(@class, 'green_text1') and contains(text(), 'Id:')]");
    By messageConfirmSelector = By.xpath("//div[@class='alert alert-success']");

    // Phương thức get booking id
    public String getBookingId() {
        super.displayToElement();
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

    public String getMessageConfirm() {
        return driver.findElement(messageConfirmSelector).getText();
    }

}
