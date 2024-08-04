package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;

    By cardNumberInputSelector=By.id("cardNumber");
    By nameOnCardInputSelector=By.id("ownerName");
    By expiryDateInputSelector=By.xpath("//input[@name=\"expiry\"]");
    By ccvNumberInputSelector=By.id("cvvcode");
    By payNowButtonSelector=By.xpath("(//input[@value=\"Pay Now\"])[1]");

    public void enterCardNumber(String cardNumber) {
        driver.findElement(cardNumberInputSelector).click();
        driver.findElement(cardNumberInputSelector).sendKeys(cardNumber);
    }

    public void enterNameCard(String nameCard) {
        driver.findElement(nameOnCardInputSelector).click();
        driver.findElement(nameOnCardInputSelector).sendKeys(nameCard);
    }

    public void enterEDate(String eDate) {
        driver.findElement(expiryDateInputSelector).click();
        driver.findElement(expiryDateInputSelector).sendKeys(eDate);
    }

    public void enterCcvNumber(String cvvNumber) {
        driver.findElement(ccvNumberInputSelector).click();
        driver.findElement(ccvNumberInputSelector).sendKeys(cvvNumber);
    }

    public void clickPay() {
        driver.findElement(payNowButtonSelector).click();
    }

    public void checkOut(String cardNumber, String nameCard, String eDate, String cvvNumber) {
        enterCardNumber(cardNumber);
        enterNameCard(nameCard);
        enterEDate(eDate);
        enterCcvNumber(cvvNumber);
    }

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
}
