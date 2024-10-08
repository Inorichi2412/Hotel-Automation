package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.HomePage;
import page.common.LoginPage;
import page.common.SelectRoomPage;
import utils.BookingDataGenerator;
import utils.ConfigReader;

import java.time.Duration;

public class TC45_VerifyThatTheRoomsPageDisplaysAnEmptyListWhenTheUserSearcInforAreInvalid {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    SelectRoomPage selectRoomPage;
    SoftAssert softAssert;
    BookingDataGenerator bookingDataGenerator;
    String checkInDate;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        selectRoomPage=new SelectRoomPage(driver);
        bookingDataGenerator=new BookingDataGenerator();

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        checkInDate= bookingDataGenerator.generateCheckInDate();
    }

    @Test
    public void VerifyThatTheRoomsPageDisplaysAnEmptyListWhenTheUserSearcInforAreInvalid() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        homePage.searchRoom(checkInDate, bookingDataGenerator.generateCheckOutDate(checkInDate), 200,200);
        softAssert.assertFalse(selectRoomPage.isItemDescriptionsDisplayed(),"Have available room");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
