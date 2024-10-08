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
import utils.ConfigReader;

import java.time.Duration;

public class TC44_VerifyThatTheRoomsPageDisplaysAListOfRoomsThatMatchTheUserSearchCriteria {
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
    public void VerifyThatTheRoomsPageDisplaysAListOfRoomsThatMatchTheUserSearchCriteria() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        homePage.searchRoom("2024/08/09","2024/08/10",2,2);
        softAssert.assertTrue(selectRoomPage.isItemDescriptionsDisplayed(),"Don't have any available room");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
