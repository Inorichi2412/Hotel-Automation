package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    // Selector dieu huong
    By buttonDirectionalHomeSelector = By.xpath("//a[@href='/']");
    By tittleHomeSelector = By.xpath("//h1[text()='Best Hotel to stay']");

    // TextBox search
    By checkinSelector = By.name("arrival");
    By checkoutSelector = By.name("depature");
    By adultSelector = By.name("adult");
    By childrenSelector = By.name("children");
    By buttonSearchSelector = By.xpath("//input[@class='btn btn-success btn-block']");
    By showRoomSelector = By.xpath("//h2[@class='page_title white-text']");
    By buttonTextBoxSearchSelector = By.xpath("//*[@id='searchForm']/span");
    By textBoxSearchSelector = By.name("bookingUID");
    By clickButtonSearchTBSelector = By.xpath("//input[@class='sb-search-submit']");

    //Button scrop to top
    By buttonScropToTopSelector = By.id("scrollToTop");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //TC1
    public String directionalHome() {
        driver.findElement(buttonDirectionalHomeSelector).click();
        WebElement titleElement = driver.findElement(tittleHomeSelector);
        return titleElement.getText();
    }

    //TC2
    public void enterCheckin(String checkIn) {
        driver.findElement(checkinSelector).sendKeys(checkIn);
    }

    public void enterCheckout(String checkOut) {
        driver.findElement(checkoutSelector).sendKeys(checkOut);
    }

    public void enterAdult(String adults) {
        driver.findElement(adultSelector).sendKeys(adults);
    }

    public void enterChildren(String children) {
        driver.findElement(childrenSelector).sendKeys(children);
    }

    public void clickButtonSearch() {
        driver.findElement(buttonSearchSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e->e.findElement(showRoomSelector).isDisplayed());
    }

    public void actionSearchBooking(String checkIn, String checkOut, String adults, String children) {
        enterCheckin(checkIn);
        enterCheckout(checkOut);
        enterAdult(adults);
        enterChildren(children);
        clickButtonSearch();
    }

    public void textBoxSearchHome() {
        driver.findElement(buttonDirectionalHomeSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208980");
        driver.findElement(clickButtonSearchTBSelector).click();
    }

    //TC3
    public void textBoxSearchHomeNoSuccess() {
        driver.findElement(buttonDirectionalHomeSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208970");
        driver.findElement(clickButtonSearchTBSelector).click();
    }

    //TC4
    // Cuộn xuống cuối trang
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void clickScrollToTop() {
        scrollToBottom();
        WebElement scrollToTopButton = driver.findElement(buttonScropToTopSelector);
        scrollToTopButton.click();
    }
}
