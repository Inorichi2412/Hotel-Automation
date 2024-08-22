package page.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserPage extends BasePage{
    WebDriver driver;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //selector
    By userMenuSelector = By.xpath("//*[@id='remove-scroll']/ul/li[5]/a");
    By clickViewUserSelector = By.xpath("//*[@id='remove-scroll']/ul/li[5]/ul/li[2]/a");
    By listViewSelector = By.xpath("//div[@class='card-body ']");
    By clickGridViewSelector = By.xpath("//a[text()='Grid View']");
    By showGridViewSelector = By.xpath("//div[@class='tab-pane active show']");
    By usersNumberDropdownSelector = By.xpath("//*[@id='example4_length']/label/select");
    By numberOfUsersSelector = By.xpath("//tbody//tr");
    By clickAddUserSelector = By.xpath("//span[text()='Add User']");

    public void clickUserMenu() {
        driver.findElement(userMenuSelector).click();
    }

    public void clickViewUser() {
        driver.findElement(clickViewUserSelector).click();
    }

    public boolean showListView() {
        return driver.findElement(listViewSelector).isDisplayed();
    }

    public void clickGridView() {
        driver.findElement(clickGridViewSelector).click();
    }

    public boolean showGridView() {
        return driver.findElement(showGridViewSelector).isDisplayed();
    }

    private void selectNumberOfUser(String rows) {
        WebElement userNumber = driver.findElement(usersNumberDropdownSelector);
        userNumber.click();
        Select select = new Select(userNumber);
        select.selectByVisibleText(rows);
    }

    public void showTenBookingRows() {
        selectNumberOfUser("10");
    }

    public void showTwentyFiveBookingRows() {
        selectNumberOfUser("25");
    }

    public void showFiftyBookingRows() {
        selectNumberOfUser("50");
    }

    public void showHundredBookingRows() {
        selectNumberOfUser("100");
    }

    public int numberOfUsersIsDisplay() {
        List<WebElement> numberOfUsers = driver.findElements(numberOfUsersSelector);
        int rowUsers;
        return rowUsers = numberOfUsers.size();
    }

    public void clickAddUser() {
        driver.findElement(clickAddUserSelector).click();
    }
}
