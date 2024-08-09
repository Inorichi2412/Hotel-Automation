package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlogsPage {
    WebDriver driver;

    By buttonDirectionalBlogsSelector = By.xpath("//a[@href='/blogs']");
    By tittleOurBlogsSelector = By.xpath("//h2[text()='Our Blogs']");
    By buttonTextBoxSearchSelector = By.xpath("//*[@id='searchForm']/span");
    By textBoxSearchSelector = By.name("bookingUID");
    By clickButtonSearchTBSelector = By.xpath("//input[@class='sb-search-submit']");

    // button scroptotop
    By buttonScropToTopSelector = By.xpath("//*[@id='scrollToTop']/a/i");

    //
    By buttonBreadcrumbHomeSelector = By.xpath("//a[@href='/']");

    public BlogsPage(WebDriver driver) {
        this.driver = driver;
    }

    //TC 1
    public String directionalBlog() {
        driver.findElement(buttonDirectionalBlogsSelector).click();
        WebElement titleElement = driver.findElement(tittleOurBlogsSelector);
        return titleElement.getText();
    }

    //TC2
    public void textBoxSearchBlog() {
        driver.findElement(buttonDirectionalBlogsSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208980");
        driver.findElement(clickButtonSearchTBSelector).click();
    }

    //TC3
    public void textBoxSearchBlogNoSuccess() {
        driver.findElement(buttonDirectionalBlogsSelector).click();
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
        driver.findElement(buttonDirectionalBlogsSelector).click();
        scrollToBottom();
        WebElement scrollToTopButton = driver.findElement(buttonScropToTopSelector);
        scrollToTopButton.click();
    }

    //TC5
    public void clickButtonBreadcrumbHome() {
        driver.findElement(buttonBreadcrumbHomeSelector).click();
    }
}