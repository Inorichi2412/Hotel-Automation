package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CreditCard;
import utils.DriverUtils;

import static utils.DriverUtils.scrollToElement;

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
    By cardNumberDisplaySelector = By.xpath("//*[@id='cardForm']/div[2]/label");
    By nameOnCardDisplaySelector = By.xpath("//*[@id='cardForm']/div[3]/label");
    By expiryDateDisplaySelector = By.xpath("//*[@id='cardForm']/div[4]/label");
    By ccvNumberDisplaySelector =By.xpath("//*[@id='cardForm']/div[5]/label");
    By messageNoteSelector = By.xpath("//*[@id='cardForm']/div[6]/p");

    // Selector display debit card

    // Selector message error
    By messageErrorSelector = By.xpath("//div[@class='dic_msg clear']");

    // selector debit card
    By clickDebitCardSelector = By.id("pills-dabit-tab");


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
    public String displayCardNumber () {
        return driver.findElement(cardNumberDisplaySelector).getText();
    }

    public String displayNameOnCard () {
        return driver.findElement(nameOnCardDisplaySelector).getText();
    }

    public String displayExpiryDate () {
        return driver.findElement(expiryDateDisplaySelector).getText();
    }

    public String displayCvvNumber() {
        return driver.findElement(ccvNumberDisplaySelector).getText();
    }

    public String displayMessageNote() {
        return driver.findElement(messageNoteSelector).getText();
    }

    public void displayInformationCredirCard() {
        // Cuộn đến phần tử nút "Scroll to Top"
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        scrollToElement(driver, scrollToTopButton);
    }

    public String getMessageError() {
        return driver.findElement(messageErrorSelector).getText();
    }

    public void openDebitCard() {
        driver.findElement(clickDebitCardSelector).click();
    }
}
