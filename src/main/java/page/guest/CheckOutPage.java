package page.guest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CreditCard;
import utils.DriverUtils;

import java.time.Duration;

public class CheckOutPage {
    WebDriver driver;
    DriverUtils driverUtils;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        this.driverUtils = new DriverUtils(driver);
    }

    // Selectors
    By regionChooseAPaymentSelector = By.xpath("//h4[text()='Choose a Payment Method :-']");
    By buttonPayNowSelector = By.xpath("//*[@id='cardForm']/div[6]/input[2]");
    // By buttonPayNowSelector = By.xpath("//input[@value='Pay Now']");
    By textBoxCardNumberSelector = By.id("cardNumber");
    By textBoxNameOnCardSelector = By.id("ownerName");
    By textBoxExpiryDateSelector = By.name("expiry");
    By textBoxCvvNumberSelector = By.id("cvvcode");

    // Selector message
    By showBookingConfirmationMessage = By.xpath("//i[@class='fa fa-info-circle m-r-7']");

    // Cuộn tới phần chọn phương thức thanh toán
    public void scrollToPaymentMethodSection() {
        WebElement regionChooseAPayment = driver.findElement(regionChooseAPaymentSelector);
        driverUtils.scrollToElement(regionChooseAPayment);
    }

    // Nhập thông tin thẻ tín dụng
    public void enterCreditCardDetails(CreditCard creditCard) {
        scrollToPaymentMethodSection();
        driver.findElement(textBoxCardNumberSelector).sendKeys(creditCard.getCardNumber());
        driver.findElement(textBoxNameOnCardSelector).sendKeys(creditCard.getNameOnCard());
        driver.findElement(textBoxExpiryDateSelector).sendKeys(creditCard.getExpiryDate());
        driver.findElement(textBoxCvvNumberSelector).clear();
        driver.findElement(textBoxCvvNumberSelector).sendKeys(creditCard.getCvvNumber());
        clickButtonPayNow();
    }

    // Nhấn nút "Pay Now"
    public void clickButtonPayNow() {
        driver.findElement(buttonPayNowSelector).click();
    }
}
