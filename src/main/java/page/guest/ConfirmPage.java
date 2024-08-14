package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;

import java.time.Duration;

public class ConfirmPage {
    WebDriver driver;
    DriverUtils driverUtils;
    String BookingConfirmationId;


    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        // Khởi tạo đối tượng DriverUtils
        this.driverUtils = new DriverUtils(driver);
    }

    // selector
    By bookingInfoSelector = By.xpath("//h4[@class='form_title4']");

    // Selector thông tin phòng booking
    By bookingConfirmationIdSelector = By.xpath("//span[@class='green_text1 float-right']");
    //By bookingConfirmationIdSelector = By.xpath("//span[starts-with(@class, 'green_text1') and contains(text(), 'Id:')]");
    By roomNameSelector = By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/h5");
    By roomInfoSelector = By.xpath("//span[@class='float-left']");

    // phương thức cuộn đến đối tượng cụ thể
    public void dispalyInforBookingc() {
        // Tìm phần tử cần cuộn đến
        WebElement element = driver.findElement(bookingInfoSelector);
        // Cuộn đến phần tử
        driverUtils.scrollToElement(element);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(bookingInfoSelector).isDisplayed());
    }

    // Phương thức lấy và trả về ID xác nhận đặt phòng
    public String getBookingConfirmationId() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(bookingConfirmationIdSelector).getText());
        BookingConfirmationId = driver.findElement(bookingConfirmationIdSelector).getText();
        return BookingConfirmationId;
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
