package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewAllStaffPage extends GeneralStaffPage{

    By pageItem=By.xpath("//a[@aria-controls=\"example4\"]");
    String choosePageItem="//a[@aria-controls=\"example4\" and text()=\"%s\"]";
    By searchInputSelector=By.xpath("//input[@type=\"search\"]");
    String phoneNumberCheck="//td[@class=\"center\" and text()=\"%s\"]";

    public ViewAllStaffPage(WebDriver driver) {
        super(driver);
    }

    public void clickLastPageItem() {
        int maxPageItem= driver.findElements(pageItem).size();
        By pageItemNumber=By.xpath(String.format(choosePageItem,maxPageItem-1));
        driver.findElement(pageItemNumber).click();
    }

    public void enterSearchInput(String inputKey) {
        driver.findElement(searchInputSelector).sendKeys(inputKey);
    }

    public String checkPhoneNumberDisplay(String phoneNumber) {
        By phoneNumberCheckSelector=By.xpath(String.format(phoneNumberCheck,phoneNumber));
        return driver.findElement(phoneNumberCheckSelector).getText();
    }
}
