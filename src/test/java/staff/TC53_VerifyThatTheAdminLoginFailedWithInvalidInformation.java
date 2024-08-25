package staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.staff.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC53_VerifyThatTheAdminLoginFailedWithInvalidInformation {
    WebDriver driver;
    ConfigReader configReader;
    page.staff.LoginPage loginPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrlAdmin());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheUserLoginFailedWithInvalidInformation() {

        loginPage.login("","");
        softAssert.assertTrue(loginPage.isLoginFormDisplayed(),"Login form disappear");

        loginPage.login("admin","");
        softAssert.assertTrue(loginPage.isLoginFormDisplayed(),"Login form disappear");

        loginPage.login("","123456");
        softAssert.assertTrue(loginPage.isLoginFormDisplayed(),"Login form disappear");

        loginPage.login("adminnnnn","123456");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        loginPage.login("admin","12345678");
        softAssert.assertTrue(loginPage.isLoginErrorDisplayed(),"Error message appear");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
