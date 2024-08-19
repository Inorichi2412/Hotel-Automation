package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class RoomDetailsPage extends GeneralPage {
    WebDriver driver;
    String locationMenu = "link3";
    String reviewMenu = "link4";

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
    By bookNowButtonSelector=By.xpath("//input[@value='Book Now']");
    By roomNameHeaderSelector=By.xpath("//h3[@class='float-left m-0']");

    // Selector menu roomsDetailsPage
    By displayTitleLocationSelector = By.xpath("//h3[@class='dic_title']");
    By displayTitleReviewSelector = By.xpath("//h4[@class='dic_title float-left']");
    By isMessageRoomsSelector = By.xpath("//h2[@class='mmb-blc-title']");

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

    public void enterAdultNumber(int adults) {
        driver.findElement(adultInputSelector).clear();
        // Chuyển đổi giá trị int thành String trước khi nhập
        String adultsText = String.valueOf(adults);
        driver.findElement(adultInputSelector).sendKeys(adultsText);
    }

    public void enterChildrenNumber(String children) {
        driver.findElement(childrenInputSelector).clear();
        driver.findElement(childrenInputSelector).sendKeys(children);
    }

    public void clickBookNowButton() {
        driver.findElement(bookNowButtonSelector).click();
    }

    public String getRoomName() {
        return driver.findElement(roomNameHeaderSelector).getText();
    }

    // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
    public void openBookNow() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        DriverUtils.scrollToElement(driver, scrollToTopButton);
        driver.findElement(bookNowButtonSelector).click();
    }

    public String isMessageRooms() {
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        DriverUtils.scrollToElement(driver, scrollToTopButton);
        return driver.findElement(isMessageRoomsSelector).getText();
    }

    // Phương thức điều hướng tại menu roomDetailsPage
    public void navigateToSpecificMenu(String menuName) {
        if (menuName.equalsIgnoreCase("location")) {
            navigateToMenu(locationMenu);
        } else if (menuName.equalsIgnoreCase("review")) {
            navigateToMenu(reviewMenu);
        } else {
            throw new IllegalArgumentException("Menu name is not valid: " + menuName);
        }
    }

    // get title location và reivew
    public String getTitleLoacation() {
        return driver.findElement(displayTitleLocationSelector).getText();
    }

    public String getTitleReview() {
        return driver.findElement(displayTitleLocationSelector).getText();
    }



}
