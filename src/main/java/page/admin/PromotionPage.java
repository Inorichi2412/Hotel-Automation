package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromotionPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public PromotionPage(WebDriver driver) {
       super(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //selector

    By openViewPromotionSelector = By.xpath("//*[@id='remove-scroll']/ul/li[13]/ul/li[2]/a");
    By getCodePromotionSelector = By.xpath("//*[@id='example4']/tbody//td[contains(text(),'Happy')]/following-sibling::td[1]");


    public void openViewPromotion() {
        WebElement openViewPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(openViewPromotionSelector));
        openViewPromotionElement.click();
    }

    public String getCodePromotion() {
        WebElement codePromotionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getCodePromotionSelector));
        return codePromotionElement.getText();
    }

}
