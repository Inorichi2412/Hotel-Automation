package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.HomePage;
import page.common.LoginPage;
import page.common.RegisterPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC38_VerifyThatUsersCanFailToRegisterWithInvalidInformation {
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
    public void VerifyThatUsersCanFailToRegisterWithInvalidInformation() {

        homePage.openRegisterForm();

        registerPage.register("","","","");
        softAssert.assertTrue(registerPage.isRegisterFormDisplayed(),"Form not display");

        registerPage.clearRegisterForm();
        registerPage.register("vyvanviet","vyvanviet@gmail.com","","");
        softAssert.assertTrue(registerPage.isRegisterFormDisplayed(),"Form still display");

        registerPage.clearRegisterForm();
        registerPage.register("","","abc123","abc123");
        softAssert.assertTrue(registerPage.isRegisterFormDisplayed(),"Form still display");

        registerPage.clearRegisterForm();
        registerPage.register("vyvanviet","vyvanviet","abc123","abc123");
        softAssert.assertTrue(registerPage.isRegisterFormDisplayed(),"Form still display");


        registerPage.clearRegisterForm();
        registerPage.register("vyvanviet","vyvanvietttt@gmail.com","abc123","abc123");
        softAssert.assertTrue(registerPage.isRegisterErrorDisplayed(),"Username already used");


        registerPage.register("vyvanvietttt","vyvanviet@gmail.com","abc123","abc123");
        softAssert.assertTrue(registerPage.isRegisterErrorDisplayed(),"Email already used");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
