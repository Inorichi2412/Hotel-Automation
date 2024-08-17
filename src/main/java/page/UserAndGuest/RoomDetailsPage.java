package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RoomDetailsPage extends GeneralPage {
    WebDriver driver;

    public RoomDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Selector
    By priceSelector= By.xpath("//div[@class='yemm_top_price']/strong");
    By checkInInputSelector=By.id("check-in");
    By checkOutInputSelector=By.id("check-out");
    By adultInputSelector=By.id("adult");
    By childrenInputSelector =By.id("children");
    By bookNowButtonSelector=By.xpath("//input[@value=\"Book Now\"]");

    By roomNameHeaderSelector=By.xpath("//h3[@class=\"float-left m-0\"]");

    public String getPrice() {
        return driver.findElement(priceSelector).getText();
    }

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
        driver.findElement(checkInInputSelector).sendKeys(checkInTime);
    }

    public void enterCheckOutTime(String checkOutTime) {
        driver.findElement(checkOutInputSelector).sendKeys(checkOutTime);
    }

    public void enterAdultNumber(String adult) {
        driver.findElement(adultInputSelector).clear();
        driver.findElement(adultInputSelector).sendKeys(adult);
    }

    public void enterChildrenNumber(String children) {
        driver.findElement(childrenInputSelector).clear();
        driver.findElement(childrenInputSelector).sendKeys(children);
    }

    public void clickBookNowButton() {
        driver.findElement(bookNowButtonSelector).click();
    }

    public void bookingRoom() {
        clickBookNowButton();
    }

    public String getRoomName() {
        return driver.findElement(roomNameHeaderSelector).getText();
    }

    // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
    public void openBookNow() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        driver.findElement(bookNowButtonSelector).click();
    }
}
