package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.user.HomePage;
import page.user.LoginPage;
import page.user.NavigationBarAndBreadCrumbPage;
import page.user.RoomsPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC51_VerifyThatForEachRoomOnTheRoomsPageThereIsAViewDetailButton {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    RoomsPage roomsPage;
    NavigationBarAndBreadCrumbPage navigationBarAndBreadCrumbPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        roomsPage=new RoomsPage(driver);

        navigationBarAndBreadCrumbPage =new NavigationBarAndBreadCrumbPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatForEachRoomOnTheRoomsPageThereIsAViewDetailButton() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        navigationBarAndBreadCrumbPage.clickRooms();

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
