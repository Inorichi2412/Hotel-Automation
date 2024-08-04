package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContanctPage {
    WebDriver driver;

    By buttonDirectionalContactUsSelector = By.xpath("//a[@href='/contact']");
    By buttonTextBoxSearchSelector = By.xpath("//*[@id='searchForm']/span");
    By textBoxSearchSelector = By.name("bookingUID");
    By clickButtonSearchTBSelector = By.xpath("//input[@class='sb-search-submit']");

    public ContanctPage(WebDriver driver) {
        this.driver = driver;
    }

    public void textBoxSearchContact() {
        driver.findElement(buttonDirectionalContactUsSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208980");
        driver.findElement(clickButtonSearchTBSelector).click();
    }
}
