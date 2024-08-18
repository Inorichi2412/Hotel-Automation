package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Gender {
    WebDriver driver;

    By maleGenderSelector= By.xpath("//li[@class=\"mdl-menu__item\" and text()=\"Male\"]");
    By femaleGenderSelector=By.xpath("//li[@class=\"mdl-menu__item\" and text()=\"Female\"]");
    By genderInputSelector =By.xpath("//input[@name=\"gender\"]");

    public void maleGender() {
        driver.findElement(genderInputSelector).click();
        driver.findElement(maleGenderSelector).click();
    }

    public void femaleGender() {
        driver.findElement(genderInputSelector).click();
        driver.findElement(femaleGenderSelector).click();
    }

    public Gender(WebDriver driver) {
        this.driver = driver;
    }
}
