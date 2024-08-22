package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //selector
    By openPromotionSelector = By.xpath("//span[text()='Promotion']");
    By userMenuSelector = By.xpath("//*[@id='remove-scroll']/ul/li[5]/a");

    public void openPromotionMenu() {
        WebElement openPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(openPromotionSelector));
        openPromotionElement.click();
    }

    public void clickUserMenu() {
        driver.findElement(userMenuSelector).click();
    }

}
