package page.common;

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

    // selector display Credit card
    By cardNumberSelector = By.xpath("//label[text()='Card Number']");
    By nameOnCardSelector = By.xpath("//label[text()='Name on Card']");
    By expiryDateSelector = By.xpath("//label[text()='Expiry Date']");
    By ccvNumberSelector = By.xpath("//label[text()='CVV Number']");
    By messageNoteSelector = By.xpath("//*[@id='cardForm']/div[6]/p");

    // Selector message error
    By messageErrorSelector = By.xpath("//div[@class='dic_msg clear']");

    // selector debit card
    By clickDebitCardSelector = By.id("pills-dabit-tab");
    //By cardNumberDebitSelector = By.xpath("//label[text()='Card Number']");
    By cardNumberDebitSelector = By.xpath("//*[@id='pills-dabit']/form/div[2]/label[text()='Card Number']");
    By nameOnCardDebitSelector = By.xpath("//*[@id='pills-dabit']/form/div[3]/label[text()='Name on Card']");
    By expiryDateDebitSelector = By.xpath("//*[@id='pills-dabit']/form/div[4]/label[text()='Expiry Date']");
    By ccvNumberDebitSelector = By.xpath("//*[@id='pills-dabit']/form/div[5]/label[text()='CVV Number']");
    By messageNoteDebitSelector = By.xpath("//*[@id='pills-dabit']/form/div[6]/p");

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

    // Phương thức show thông tin credir card
    public boolean getCardNumberLabel () {
        return driver.findElement(cardNumberSelector).isDisplayed();
    }

    public boolean getNameOnCardLabel() {
        return driver.findElement(nameOnCardSelector).isDisplayed();
    }

    public boolean getExpiryDateLabel () {
        return driver.findElement(expiryDateSelector).isDisplayed();
    }

    public boolean getCvvNumberLabel() {
        return driver.findElement(ccvNumberSelector).isDisplayed();
    }

    public boolean getMessageNote() {
        return driver.findElement(messageNoteSelector).isDisplayed();
    }

    public String getMessageError() {
        return driver.findElement(messageErrorSelector).getText();
    }

    public void openDebitCard() {
        driver.findElement(clickDebitCardSelector).click();
    }

    // Phương thức show thông tin credir card
    public String getCardNumberDebitLabel () {
        return driver.findElement(cardNumberDebitSelector).getText();
    }

    public String getNameOnCardDebitLabel() {
        return driver.findElement(nameOnCardDebitSelector).getText();
    }

    public String getExpiryDateDebitLabel () {
        return driver.findElement(expiryDateDebitSelector).getText();
    }

    public String getCvvNumberDebitLabel() {
        return driver.findElement(ccvNumberDebitSelector).getText();
    }

    public String getMessageNoteDebit() {
        return driver.findElement(messageNoteDebitSelector).getText();
    }
}
