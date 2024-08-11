package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.user.HomePage;
import page.user.LoginPage;
import page.user.RegisterPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC41_VerifyThatUsersCanCheckTheNumberOfHotelsForEachLocationByHovering {

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

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatUsersCanCheckTheNumberOfHotelsForEachLocationByHovering() {

        homePage.hoverLocation1();
        softAssert.assertTrue(homePage.isBadgeSuccessDisplayed(),
                "Still not display number of available rooms");

        homePage.hoverLocation2();
        softAssert.assertTrue(homePage.isBadgeSuccessDisplayed(),
                "Still not display number of available rooms");

        homePage.hoverLocation3();
        softAssert.assertTrue(homePage.isBadgeSuccessDisplayed(),
                "Still not display number of available rooms");

        homePage.hoverLocation4();
        softAssert.assertTrue(homePage.isBadgeSuccessDisplayed(),
                "Still not display number of available rooms");

        homePage.hoverLocation5();
        softAssert.assertTrue(homePage.isBadgeSuccessDisplayed(),
                "Still not display number of available rooms");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
