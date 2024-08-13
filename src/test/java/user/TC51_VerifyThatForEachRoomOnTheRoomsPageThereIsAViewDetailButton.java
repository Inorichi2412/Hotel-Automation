package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.user.HomePage;
import page.user.LoginPage;
import page.user.GeneralPage;
import page.user.RoomsPage;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Random;

public class TC51_VerifyThatForEachRoomOnTheRoomsPageThereIsAViewDetailButton {
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
    public void VerifyThatForEachRoomOnTheRoomsPageThereIsAViewDetailButton() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openRoomsPage();

        roomsPage.checkViewDetailsButtonForAllRooms(softAssert);

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
