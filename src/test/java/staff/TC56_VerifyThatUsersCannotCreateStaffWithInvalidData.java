package staff;

import Models.AddStaffForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.staff.AddStaffPage;
import page.staff.DashboardPage;
import page.staff.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC56_VerifyThatUsersCannotCreateStaffWithInvalidData {
    WebDriver driver;
    ConfigReader configReader;
    page.staff.LoginPage loginPage;
    DashboardPage dashboardPage;
    AddStaffPage addStaffPage;
    SoftAssert softAssert;
    AddStaffForm addStaffForm;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        addStaffPage=new AddStaffPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrlAdmin());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        addStaffForm=new AddStaffForm("","Female","20","09996677","Manager","vietanh","123456","123456","vietnam");

    }



    @Test
    public void VerifyThatUsersCannotCreateStaffWithInvalidData() {

        loginPage.login("admin","123456");

        dashboardPage.openStaffNav();
        dashboardPage.openAddStaffCard();

        addStaffForm.setAddress("");
        addStaffPage.addStaff(addStaffForm);

//        addStaffForm.set();

        softAssert.assertTrue(addStaffPage.isAddStaffFormDisplayed(),"add staff form not display");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
