package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By loginSelector = By.xpath("//a[@href=\"#Login_tab\"][1]");
    By registerSelector =By.xpath("//a[@href=\"#Register_tab\"][1]");
    By roomsPageSelector=By.xpath("//a[@href='/rooms']");

    public void clickLogin() {
        driver.findElement(loginSelector).click();
    }

    public void clickRegister() {
        driver.findElement(registerSelector).click();
    }

    public void clickRoomsPage() {
        driver.findElement(roomsPageSelector).click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
