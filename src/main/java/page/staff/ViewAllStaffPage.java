package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewAllStaffPage extends GeneralStaffPage{

    By pageItem=By.xpath("//a[@aria-controls=\"example4\"]");
    String choosePageItem="//a[@aria-controls=\"example4\" and text()=\"%s\"]";

    public ViewAllStaffPage(WebDriver driver) {
        super(driver);
    }

    public void clickLastPageItem() {
        int maxPageItem= driver.findElements(pageItem).size();
        By pageItemNumber=By.xpath(String.format(choosePageItem,maxPageItem-1));
        driver.findElement(pageItemNumber).click();
    }
}
