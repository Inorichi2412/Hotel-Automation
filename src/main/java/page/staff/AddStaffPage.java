package page.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddStaffPage extends GeneralStaffPage{
    By genderInputSelector =By.xpath("//input[@name=\"gender\"]");

    public AddStaffPage(WebDriver driver) {
        super(driver);
    }

    public void clickGender() {
        driver.findElement(genderInputSelector).click();
    }

    public void selectValueOfGender(String chooseGender) {
        WebElement gender = driver.findElement(genderInputSelector);
        clickGender();
        Select select = new Select(gender);
        select.selectByVisibleText(chooseGender);
    }
}
