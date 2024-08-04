package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Selector dieu huong
    By buttonDirectionalHome = By.xpath("//a[@href='/']");
    By buttonDirectionalRooms = By.xpath("//a[@href='/rooms']");
    By buttonDirectionalAbout = By.xpath("//a[@href='/about']");
    By buttonDirectionalBlogs = By.xpath("//a[@href='/blogs']");
    By buttonDirectionalContactUs = By.xpath("//a[@href='/contact']");
    By buttonDirectionalFaqs = By.xpath("//a[@href='/faqs']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void directionalMenu() {
        driver.findElement(buttonDirectionalHome).click();
        driver.findElement(buttonDirectionalRooms).click();
        driver.findElement(buttonDirectionalAbout).click();
        driver.findElement(buttonDirectionalBlogs).click();
        driver.findElement(buttonDirectionalContactUs).click();
        driver.findElement(buttonDirectionalFaqs).click();
    }
}
