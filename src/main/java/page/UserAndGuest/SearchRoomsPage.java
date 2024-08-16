package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchRoomsPage {
    WebDriver driver;

    By checkInInputSelector=By.id("check-in");
    By checkOutInputSelector=By.id("check-out");
    By adultInputSelector=By.xpath("//input[@name=\"adult\"]");
    By childrenInputSelector =By.xpath("//input[@name=\"children\"]");
    By searchButtonSelector=By.xpath("//input[@value=\"Search\"]");

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

    public SearchRoomsPage(WebDriver driver) {
        this.driver = driver;
    }
}
