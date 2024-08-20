package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //selector
    By openPromotionSelector = By.xpath("//span[text()='Promotion']");
    By openViewPromotionSelector = By.xpath("//*[@id='remove-scroll']/ul/li[13]/ul/li[2]/a");
    By getCodePromotionSelector = By.xpath("//*[@id='example4']/tbody/tr[2]/td[2]");
    By getDiscountSelector = By.xpath("//*[@id='example4']/tbody/tr[2]/td[6]");

    public void openPromotionMenu() {
        WebElement openPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(openPromotionSelector));
        openPromotionElement.click();
    }

    public void openViewPromotion() {
        WebElement openViewPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(openViewPromotionSelector));
        openViewPromotionElement.click();
    }

    public String getCodePromotion() {
        WebElement codePromotionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getCodePromotionSelector));
        return codePromotionElement.getText();
    }

    public String getDiscount() {
        WebElement discountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getDiscountSelector));
        return discountElement.getText();
    }


}
