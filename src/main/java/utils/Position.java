package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Position {
    WebDriver driver;
    By positionInputSelector= By.xpath("//input[@name=\"pos\"]");
    By administratorPositionSelector=By.xpath("//li[@data-val=\"Administrator\"]");
    By managerPositionSelector=By.xpath("//li[@data-val=\"Manager\"]");
    By receptionistPositionSelector=By.xpath("//li[@data-val=\"Receptionist\"]");
    By bellmanPositionSelector=By.xpath("//li[@data-val=\"Bell man\"]");

    public void openPositionSelectBox() {
        driver.findElement(positionInputSelector).click();
    }


}
