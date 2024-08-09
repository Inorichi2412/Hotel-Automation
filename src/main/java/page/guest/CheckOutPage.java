package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CreditCard;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Selectors
    By regionChooseAPaymentSelector = By.xpath("//h4[text()='Choose a Payment Method :-']");
    By buttonPayNowSelector = By.xpath("//input[@value='Pay Now']");
    By textBoxCardNumberSelector = By.id("cardNumber");
    By textBoxNameOnCardSelector = By.id("ownerName");
    By textBoxExpiryDateSelector = By.name("expiry");
    By textBoxCvvNumberSelector = By.id("cvvcode");

    //
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //
    public void regionPayment() {
        WebElement regionChooseAPayment = driver.findElement(regionChooseAPaymentSelector);
        scrollToElement(regionChooseAPayment);
        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // nhập data
    public void enterCreditCardDetails(CreditCard creditCard) {
        driver.findElement(textBoxCardNumberSelector).sendKeys(creditCard.getCardNumber());
        driver.findElement(textBoxNameOnCardSelector).sendKeys(creditCard.getNameOnCard());
        driver.findElement(textBoxExpiryDateSelector).sendKeys(creditCard.getExpiryDate());
        driver.findElement(textBoxCvvNumberSelector).sendKeys(creditCard.getCvvNumber());
    }

    // Click the "Pay Now" button
    public void clickButtonPayNow() {
        driver.findElement(buttonPayNowSelector).click();
    }
}
