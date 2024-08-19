package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends GeneralPage {
    Actions actions;
    Wait<WebDriver> wait;

    // Selector
    By loginSelector = By.id("NavebarProfileDrop");
    By buttonGoToAdmin = By.xpath("//a[@class='dropdown-item clearfix']");
    By registerSelector =By.xpath("//a[@href='#Register_tab'][1]");
    By roomsPageSelector=By.xpath("//a[@href='/rooms']");

    By h1HeaderSelector=By.xpath("//h1");

    By badgeSuccessSelector=By.xpath("//label[@class='badge-success']");
    By location1Selector=By.xpath("(//div[@class='yemm_desti_inner'])[1]");
    By location2Selector=By.xpath("(//div[@class='yemm_desti_inner'])[2]");
    By location3Selector=By.xpath("(//div[@class='yemm_desti_inner'])[3]");
    By location4Selector=By.xpath("(//div[@class='yemm_desti_inner'])[4]");
    By location5Selector=By.xpath("(//div[@class='yemm_desti_inner'])[5]");

    By checkInInputSelector=By.id("check-in");
    By checkOutInputSelector=By.id("check-out");
    By adultInputSelector=By.xpath("//input[@name='adult']");
    By childrenInputSelector =By.xpath("//input[@name='children']");
    By searchButtonSelector=By.xpath("//input[@value='Search']");

    // Selector cho nút điều hướng đến trang Rooms
    String homePage = "/";
    // Selector cho tiêu đề của trang chính
    By pageHomeTitleSelector = By.xpath("/html/body/section[1]/div/div/div/div/h1");

    // Selector cho các trường trong phần tìm kiếm
    By checkinSelector = By.name("arrival");
    By checkoutSelector = By.name("depature");
    By adultSelector = By.name("adult");
    By childrenSelector = By.name("children");

    // Constructor của lớp HomePage
    public HomePage(WebDriver driver) {
        super(driver);
    }


    // Phương thức điều hướng đến trang Rooms
    public void navigateToHomePage() {
        super.navigateToPage(homePage);
    }

    // phương thưc lấy title
    @Override
    public String getPageTitleText() {
        WebElement titleElement = driver.findElement(pageHomeTitleSelector);
        return titleElement.getText();
    }

    @Override
    public String getTitle() {
        List<WebElement> elements = driver.findElements(h1HeaderSelector);
        if (!elements.isEmpty()) {
            return elements.get(0).getText();
        } else {
            return "Header not found"; // Hoặc trả về giá trị mặc định khác
        }
    }


    public void clickCheckIn() {
        driver.findElement(checkInInputSelector).click();
    }

    public void clickCheckOut() {
        driver.findElement(checkOutInputSelector).click();
    }

    public void clickAdult() {
        driver.findElement(adultInputSelector).click();
    }

    public void clickChildren() {
        driver.findElement(childrenInputSelector).click();
    }

    public void enterCheckInTime(String checkInTime) {
        clickCheckIn();
        driver.findElement(checkInInputSelector).sendKeys(checkInTime);
    }

    public void enterCheckOutTime(String checkOutTime) {
        clickCheckOut();
        driver.findElement(checkOutInputSelector).sendKeys(checkOutTime);
    }

    public void enterAdultNumber(int adults) {
        clickAdult();
        driver.findElement(adultInputSelector).clear();
        // Chuyển đổi giá trị int thành String trước khi nhập
        String adultsText = String.valueOf(adults);
        driver.findElement(adultSelector).sendKeys(adultsText);
    }

    public void enterChildrenNumber(int children) {
        clickChildren();
        driver.findElement(childrenInputSelector).clear();
        // Chuyển đổi giá trị int thành String trước khi nhập
        String childrenText = String.valueOf(children);
        driver.findElement(childrenSelector).sendKeys(childrenText);
    }

    public void searchRoom(String checkIn, String checkOut, int adult, int children) {
        enterCheckInTime(checkIn);
        enterCheckOutTime(checkOut);
        enterAdultNumber(adult);
        enterChildrenNumber(children);
        clickSearchButton();
    }


    public void openLoginForm() {
        driver.findElement(loginSelector).click();
    }

    public void openRegisterForm() {
        driver.findElement(registerSelector).click();
    }

    public void clickRoomsPage() {
        driver.findElement(roomsPageSelector).click();
    }

    public void hoverLocation1() {
        WebElement location1=driver.findElement(location1Selector);
        actions.moveToElement(location1).perform();
    }

    public void hoverLocation2() {
        WebElement location2=driver.findElement(location2Selector);
        actions.moveToElement(location2).perform();
    }

    public void hoverLocation3() {
        WebElement location3=driver.findElement(location3Selector);
        actions.moveToElement(location3).perform();
    }

    public void hoverLocation4() {
        WebElement location4=driver.findElement(location4Selector);
        actions.moveToElement(location4).perform();
    }
    public void hoverLocation5() {
        WebElement location5 =driver.findElement(location5Selector);
        actions.moveToElement(location5).perform();
    }

    public boolean isBadgeSuccessDisplayed() {
        wait.until(driver->driver.findElement(badgeSuccessSelector).isDisplayed());
        return driver.findElement(badgeSuccessSelector).isDisplayed();
    }

    // Phương thức để cuộn xuống dưới cùng và nhấn nút "Scroll to Top"
   @Override
    public void displayButtonScrollToTop() {
        super.scrollToBottomElement();
        //cuộn lên hoặc nhấn nút "Scroll to Top"
        super.clickScrollToTop();
        // khi thấy title cua trang
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(e -> e.findElement(pageHomeTitleSelector).isDisplayed());
    }

    // Phương thức di chuyển đến admin
    public void goToAdmin() {
        openLoginForm();
        driver.findElement(buttonGoToAdmin).click();
    }

}
