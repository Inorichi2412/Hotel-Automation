package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.UserAndGuest.HomePage;
import page.UserAndGuest.LoginPage;
import page.UserAndGuest.RegisterPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC39_VerifyThatTheUserCanRegisterSuccessfullyWithValidInformation {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        registerPage=new RegisterPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheUserCanRegisterSuccessfullyWithValidInformation() {

        homePage.openRegisterForm();

        registerPage.register("","","","");
        softAssert.assertFalse(registerPage.isRegisterFormDisplayed(),"Form still display");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
