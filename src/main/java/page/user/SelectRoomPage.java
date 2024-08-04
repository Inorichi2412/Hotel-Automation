package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectRoomPage {
    WebDriver driver;
    By room1DetailSelector= By.xpath("(//div[@class=\"yemm_hotel_location clearfix\"]/a)[1]");
    By room2DetailSelector= By.xpath("(//div[@class=\"yemm_hotel_location clearfix\"]/a)[2]");
    By room3DetailSelector= By.xpath("(//div[@class=\"yemm_hotel_location clearfix\"]/a)[3]");

    public void moveToRoom1() {
        WebElement room1Detail=driver.findElement(room1DetailSelector);
        new Actions(driver).moveToElement(room1Detail).perform();
    }

    public void selectRoom1Detail() {
        driver.findElement(room1DetailSelector).click();
    }

    public void selectRoom2Detail() {
        driver.findElement(room2DetailSelector).click();
    }

    public void selectRoom3Details() {
        driver.findElement(room3DetailSelector).click();
    }

    public boolean isSelectRoomDisplayed() {
        return driver.findElement(room1DetailSelector).isDisplayed();
    }

    public SelectRoomPage(WebDriver driver) {
        this.driver = driver;
    }
}
