package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralStaffPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    By pageTitleSelector= By.xpath("//div[@class=\"page-title\"]");

    public GeneralStaffPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        if (driver.findElements(pageTitleSelector).size()>0){
            return driver.findElement(pageTitleSelector).getText();
        }
        else {
            return "";
        }
    }
}
