package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class HomePage extends GeneralPage {
    Actions actions;
    Wait<WebDriver> wait;

    By loginSelector = By.xpath("//a[@href=\"#Login_tab\"][1]");
    By registerSelector =By.xpath("//a[@href=\"#Register_tab\"][1]");
    By roomsPageSelector=By.xpath("//a[@href='/rooms']");

    By h1HeaderSelector=By.xpath("//h1");

    By badgeSuccessSelector=By.xpath("//label[@class=\"badge-success\"]");
    By location1Selector=By.xpath("(//div[@class=\"yemm_desti_inner\"])[1]");
    By location2Selector=By.xpath("(//div[@class=\"yemm_desti_inner\"])[2]");
    By location3Selector=By.xpath("(//div[@class=\"yemm_desti_inner\"])[3]");
    By location4Selector=By.xpath("(//div[@class=\"yemm_desti_inner\"])[4]");
    By location5Selector=By.xpath("(//div[@class=\"yemm_desti_inner\"])[5]");

    By checkInInputSelector=By.id("check-in");
    By checkOutInputSelector=By.id("check-out");
    By adultInputSelector=By.xpath("//input[@name=\"adult\"]");
    By childrenInputSelector =By.xpath("//input[@name=\"children\"]");
    By searchButtonSelector=By.xpath("//input[@value=\"Search\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getTitle() {
        List<WebElement> elements = driver.findElements(h1HeaderSelector);
        if (!elements.isEmpty()) {
            return elements.get(0).getText();
        } else {
            return "Header not found"; // Hoặc trả về giá trị mặc định khác
        }
    }


    public void clickCheckIn() {
        driver.findElement(checkInInputSelector).click();
    }

    public void clickCheckOut() {
        driver.findElement(checkOutInputSelector).click();
    }

    public void clickAdult() {
        driver.findElement(adultInputSelector).click();
    }

    public void clickChildren() {
        driver.findElement(childrenInputSelector).click();
    }

    public void enterCheckInTime(String checkInTime) {
        clickCheckIn();
        driver.findElement(checkInInputSelector).sendKeys(checkInTime);
    }

    public void enterCheckOutTime(String checkOutTime) {
        clickCheckOut();
        driver.findElement(checkOutInputSelector).sendKeys(checkOutTime);
    }

    public void enterAdultNumber(String adult) {
        clickAdult();
        driver.findElement(adultInputSelector).clear();
        driver.findElement(adultInputSelector).sendKeys(adult);
    }

    public void enterChildrenNumber(String children) {
        clickChildren();
        driver.findElement(childrenInputSelector).clear();
        driver.findElement(childrenInputSelector).sendKeys(children);
    }

    public void clickSearchButton() {
        driver.findElement(searchButtonSelector).click();
    }

    public void searchRoom(String checkin,String checkOut, String adult,String children) {
        enterCheckInTime(checkin);
        enterCheckOutTime(checkOut);
        enterAdultNumber(adult);
        enterChildrenNumber(children);
        clickSearchButton();
    }


    public void openLoginForm() {
        driver.findElement(loginSelector).click();
    }

    public void openRegisterForm() {
        driver.findElement(registerSelector).click();
    }

    public void clickRoomsPage() {
        driver.findElement(roomsPageSelector).click();
    }

    public void hoverLocation1() {
        WebElement location1=driver.findElement(location1Selector);
        actions.moveToElement(location1).perform();
    }

    public void hoverLocation2() {
        WebElement location2=driver.findElement(location2Selector);
        actions.moveToElement(location2).perform();
    }

    public void hoverLocation3() {
        WebElement location3=driver.findElement(location3Selector);
        actions.moveToElement(location3).perform();
    }

    public void hoverLocation4() {
        WebElement location4=driver.findElement(location4Selector);
        actions.moveToElement(location4).perform();
    }
    public void hoverLocation5() {
        WebElement location5 =driver.findElement(location5Selector);
        actions.moveToElement(location5).perform();
    }

    public boolean isBadgeSuccessDisplayed() {
        wait.until(driver->driver.findElement(badgeSuccessSelector).isDisplayed());
        return driver.findElement(badgeSuccessSelector).isDisplayed();
    }

}