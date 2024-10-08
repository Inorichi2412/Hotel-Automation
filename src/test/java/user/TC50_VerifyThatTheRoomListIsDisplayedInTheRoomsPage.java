package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.HomePage;
import page.common.LoginPage;
import page.common.GeneralPage;
import page.common.RoomsPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC50_VerifyThatTheRoomListIsDisplayedInTheRoomsPage {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    RoomsPage roomsPage;
    GeneralPage generalPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        roomsPage=new RoomsPage(driver);

        generalPage =new GeneralPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheRoomListIsDisplayedInTheRoomsPage() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openRoomsPage();
        softAssert.assertTrue(roomsPage.isHaveAvailableRoomsDisplayed(),"Don't have any available rooms");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
