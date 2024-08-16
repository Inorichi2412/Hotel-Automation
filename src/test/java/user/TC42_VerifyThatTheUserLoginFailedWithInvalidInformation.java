package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.UserAndGuest.HomePage;
import page.UserAndGuest.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC42_VerifyThatTheUserLoginFailedWithInvalidInformation {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheUserLoginFailedWithInvalidInformation() {

        homePage.openLoginForm();
        loginPage.login("","");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        loginPage.login("vyvanviet","");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        loginPage.login("","abc123");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        loginPage.login("vyvanvietviet","abc123");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        loginPage.login("vyvanviet","abc123123");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
