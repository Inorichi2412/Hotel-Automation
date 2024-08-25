package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PromotionPage extends GeneralPage {
    WebDriverWait wait;

    public PromotionPage(WebDriver driver) {
       super(driver);
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //selector
    By openViewPromotionSelector = By.xpath("//*[@id='remove-scroll']/ul/li[13]/ul/li[2]/a");
    By getCodePromotionSelector = By.xpath("//*[@id='example4']/tbody/tr[1]/td[2]");
    By getValuePromotionSelector = By.xpath("//*[@id='example4']/tbody/tr[1]/td[6]");
    By getTypePromotionSelector = By.xpath("//*[@id='example4']/tbody/tr[1]/td[5]");
    By sortPeriodEndDateSelector = By.xpath("//*[@id='example4_wrapper']/div[2]/div/div/div[1]/div/table/thead/tr/th[4]");

    public void openViewPromotion() {
        WebElement openViewPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(openViewPromotionSelector));
        openViewPromotionElement.click();
        sortPeriodEndDate();
    }

    public void sortPeriodEndDate() {
        driver.findElement(sortPeriodEndDateSelector).click();
        driver.findElement(sortPeriodEndDateSelector).click();
    }

    public String getCodePromotion() {
        WebElement codePromotionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getCodePromotionSelector));
        return codePromotionElement.getText();
    }

    public Float getValuePromotion() {
        WebElement valuePromotionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getValuePromotionSelector));
        String valueText = valuePromotionElement.getText();
        // Chuyển đổi chuỗi thành float
        return Float.parseFloat(valueText);
    }

    public String getTypePromotion() {
        WebElement valePromotionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(getTypePromotionSelector));
        return valePromotionElement.getText();
    }

}
