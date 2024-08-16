package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.UserAndGuest.HomePage;
import page.UserAndGuest.LoginPage;
import page.UserAndGuest.SelectRoomPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC45_VerifyThatTheRoomsPageDisplaysAnEmptyListWhenTheUserSearcInforAreInvalid {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    SelectRoomPage selectRoomPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        selectRoomPage=new SelectRoomPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheRoomsPageDisplaysAnEmptyListWhenTheUserSearcInforAreInvalid() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        homePage.searchRoom("2024/08/09","2024/08/10","200","200");
        softAssert.assertFalse(selectRoomPage.isItemDescriptionsDisplayed(),"Have available room");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
