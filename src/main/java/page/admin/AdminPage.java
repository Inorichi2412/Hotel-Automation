package page.admin;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    //selector
    By openPromotionSelector = By.xpath("//span[text()='Promotion']");
    By openViewPromotionSelector = By.xpath("//a[@href='/admin/promotion']");
    By getcodePromationSelector = By.xpath("//*[@id='example4']/tbody/tr[2]/td[2]");

    public void OpenPromotionMenu() {
        driver.findElement(openPromotionSelector).click();
    }

    public void openViewPromotion() {
        driver.findElement(openViewPromotionSelector).click();
    }

    public String getCodePromotion() {
        String codePromotion = driver.findElement(getcodePromationSelector).getText();
        return  codePromotion;
    }
}
