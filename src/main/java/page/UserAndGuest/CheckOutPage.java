package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CreditCard;
import utils.DriverUtils;

public class CheckOutPage extends GeneralPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
       super(driver);
       this.driver = driver;
    }

    // Selector
    By regionChooseAPaymentSelector = By.xpath("//h4[text()='Choose a Payment Method :-']");
    By cardNumberInputSelector = By.id("cardNumber");
    By nameOnCardInputSelector = By.id("ownerName");
    By expiryDateInputSelector = By.name("expiry");
    By ccvNumberInputSelector = By.id("cvvcode");
    By payNowButtonSelector = By.xpath("(//input[@value='Pay Now'])[1]");

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

    // Cuộn tới phần chọn phương thức thanh toán
    public void scrollToPaymentMethodSection() {
        WebElement regionChooseAPayment = driver.findElement(regionChooseAPaymentSelector);
        DriverUtils.scrollToElement(driver, regionChooseAPayment);
    }

    // Nhập thông tin thẻ tín dụng
    public void enterCreditCardDetails(CreditCard creditCard) {
        scrollToPaymentMethodSection();
        driver.findElement(cardNumberInputSelector).sendKeys(creditCard.getCardNumber());
        driver.findElement(nameOnCardInputSelector).sendKeys(creditCard.getNameOnCard());
        driver.findElement(expiryDateInputSelector).sendKeys(creditCard.getExpiryDate());
        driver.findElement(ccvNumberInputSelector).clear();
        driver.findElement(ccvNumberInputSelector).sendKeys(creditCard.getCvvNumber());
        clickButtonPayNow();
    }

    // Nhấn nút "Pay Now"
    public void clickButtonPayNow() {
        driver.findElement(payNowButtonSelector).click();
    }


}
