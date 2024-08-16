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

public class TC56_VerifyThatTheUserCanFindTheAddStaffButtonToAddStaff {
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

        driver.get(configReader.getUrl2());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatTheUserCanFindTheAddStaffButtonToAddStaff() {

        loginPage.login("admin","123456");



        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
