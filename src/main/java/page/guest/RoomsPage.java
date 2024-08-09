package page.guest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RoomsPage {
    WebDriver driver;

    By buttonDirectionalRoomsSelector = By.xpath("//a[@href='/rooms']");
    By tittleRoomsSelector = By.xpath("//h2[text()='Rooms']");
    By buttonTextBoxSearchSelector = By.xpath("//*[@id='searchForm']/span");
    By buttonViewDetailsSelector = By.xpath("//a[@class='btn btn-success float-right']");
    By buttonBookNowSelector = By.xpath("//input[@value='Book Now']");
    By textBoxSearchSelector = By.name("bookingUID");
    By clickButtonSearchTBSelector = By.xpath("//input[@class='sb-search-submit']");
    By clickButtonSubmitRoomDetailsSelector =  By.xpath("//*[@id='user']/div/div[1]/div[6]/input");

    // button scroptotop
    By buttonScropToTopSelector = By.xpath("//*[@id='scrollToTop']/a/i");

    //
    By buttonBreadcrumbHomeSelector = By.xpath("//a[@href='/']");

    // Add Your Informations
    By addYourInformationSelector = By.xpath("//h4[text()='Add Your Informations :-']");
    By textBoxFullNameSelector = By.name("name");
    By textBoxEmailSelector = By.id("email");
    By textBoxPhoneSelector = By.name("phone");
    By textBoxAddressSelector = By.name("address");
    By checkBoxIAgreeSelector = By.xpath("//Strong[text()='Terms and Conditions']");

    public RoomsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String directionalRooms() {
        driver.findElement(buttonDirectionalRoomsSelector).click();
        WebElement titleElement = driver.findElement(tittleRoomsSelector);
        return titleElement.getText();
    }

    //TC2
    // Cuộn đến một phần tử cụ thể trên trang
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // click button viewdetail tại trang room
    public void buttonViewDetails() {
        WebElement ScropToTopButton = driver.findElement(buttonScropToTopSelector);
        scrollToElement(ScropToTopButton);
        driver.findElement(buttonViewDetailsSelector).click();
    }

    // click button BookNow tại trang room detail
    public void buttonBookNowRooms() {
        WebElement ScropToTopButton = driver.findElement(buttonScropToTopSelector);
        scrollToElement(ScropToTopButton);
        driver.findElement(buttonBookNowSelector).click();
    }

    // xử lí add information
    public void regionAddInformation() {
        WebElement regionAddInformation = driver.findElement(addYourInformationSelector);
        scrollToElement(regionAddInformation);
        try {
            Thread.sleep(5000); // wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterFullName(String fullName) {
        driver.findElement(textBoxFullNameSelector).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(textBoxEmailSelector).sendKeys(email);
    }

    public void enterPhone(String phone) {
        driver.findElement(textBoxPhoneSelector).sendKeys(phone);
    }

    public void enterAddress(String address) {
        driver.findElement(textBoxAddressSelector).sendKeys(address);
    }

    public void checkAndSelectIAgree() {
        WebElement checkBox = driver.findElement(checkBoxIAgreeSelector);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }
    public void enterAddInformation (String fullName, String email, String phone, String address) {
        enterFullName(fullName);
        enterEmail(email);
        enterPhone(phone);
        enterAddress(address);
        checkAndSelectIAgree();
        driver.findElement(clickButtonSubmitRoomDetailsSelector).click();
    }


//    public void buttonViewDetails() {
//        List<WebElement> viewDetailsButtons = driver.findElements(buttonViewDetailsSelector);
//        if (!viewDetailsButtons.isEmpty()) {
//            WebElement firstViewDetailsButton = viewDetailsButtons.get(0);
//            scrollToElement(firstViewDetailsButton);
//            // Nhấp vào sử dụng JavaScriptExecutor để tránh ElementClickInterceptedException
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", firstViewDetailsButton);
//        } else {
//            throw new NoSuchElementException("No elements found with the given selector");
//        }
//    }


    public void textBoxSearchRooms() {
        driver.findElement(buttonDirectionalRoomsSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208980");
        driver.findElement(clickButtonSearchTBSelector).click();
    }

    //TC3
    public void textBoxSearchRoomsNoSuccess() {
        driver.findElement(buttonDirectionalRoomsSelector).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(d->d.findElement(buttonTextBoxSearchSelector).isDisplayed());
        driver.findElement(buttonTextBoxSearchSelector).click();
        driver.findElement(textBoxSearchSelector).sendKeys("3434-388208970");
        driver.findElement(clickButtonSearchTBSelector).click();
    }

    //TC4
    // Cuộn xuống cuối trang
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public void clickScrollToTop() {
        driver.findElement(buttonDirectionalRoomsSelector).click();
        scrollToBottom();
        WebElement scrollToTopButton = driver.findElement(buttonScropToTopSelector);
        scrollToTopButton.click();
    }

    //TC5
    public void clickButtonBreadcrumbHome() {
        driver.findElement(buttonBreadcrumbHomeSelector).click();
    }
}