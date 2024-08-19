package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchRoomsPage extends GeneralPage {
    WebDriver driver;

    public SearchRoomsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    String pageName = "/rooms";

    By checkInInputSelector=By.id("check-in");
    By checkOutInputSelector=By.id("check-out");
    By adultInputSelector=By.xpath("//input[@name='adult']");
    By childrenInputSelector =By.xpath("//input[@name='children']");
    By searchButtonSelector=By.xpath("//input[@value='Search']");

    public void clickCheckIn() {
        driver.findElement(checkInInputSelector).click();
    }

    public void clickCheckOut() {
        driver.findElement(checkOutInputSelector).click();
    }

    public void clickAdult() {
        driver.findElement(adultInputSelector).click();
    }

    public void clickChildren() {
        driver.findElement(childrenInputSelector).click();
    }

    public void enterCheckInTime(String checkInTime) {
        clickCheckIn();
        driver.findElement(checkInInputSelector).sendKeys(checkInTime);
    }

    public void enterCheckOutTime(String checkOutTime) {
        clickCheckOut();
        driver.findElement(checkOutInputSelector).sendKeys(checkOutTime);
    }

    public void enterAdultNumber(String adult) {
        clickAdult();
        driver.findElement(adultInputSelector).clear();
        driver.findElement(adultInputSelector).sendKeys(adult);
    }

    public void enterChildrenNumber(String children) {
        clickChildren();
        driver.findElement(childrenInputSelector).clear();
        driver.findElement(childrenInputSelector).sendKeys(children);
    }

    public void clickSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public void searchRoom(String checkin,String checkOut, String adult,String children) {
        enterCheckInTime(checkin);
        enterCheckOutTime(checkOut);
        enterAdultNumber(adult);
        enterChildrenNumber(children);
        clickSearchButton();
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
