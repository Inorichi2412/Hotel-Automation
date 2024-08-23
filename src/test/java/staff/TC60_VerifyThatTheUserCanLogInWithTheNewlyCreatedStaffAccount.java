package staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.staff.DashboardPage;
import page.staff.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC60_VerifyThatTheUserCanLogInWithTheNewlyCreatedStaffAccount {
    WebDriver driver;
    ConfigReader configReader;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl2());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheAdminLoginSuccessfulWithValidInformation() {

        loginPage.login("admin","123456");
        softAssert.assertFalse(loginPage.isLoginFormDisplayed(),"Login form still display");
        softAssert.assertEquals(dashboardPage.getPageTitle(),"Dashboard","Wrong page appear!");


        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
