package staff;

import Models.AddStaffForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.staff.AddStaffPage;
import page.staff.DashboardPage;
import page.staff.LoginPage;
import page.staff.ViewAllStaffPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC59_VerifyThatTheNewlyCreatedStaffAppearsInTheStaffList {
    WebDriver driver;
    ConfigReader configReader;
    page.staff.LoginPage loginPage;
    DashboardPage dashboardPage;
    AddStaffPage addStaffPage;
    SoftAssert softAssert;
    AddStaffForm addStaffForm;
    ViewAllStaffPage viewAllStaffPage;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        addStaffPage=new AddStaffPage(driver);
        viewAllStaffPage=new ViewAllStaffPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl2());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeTest
    public void beforeTest() {
        addStaffForm=new AddStaffForm("vietanh","Male","20","09996677","Manager","vietanh","123456","123456","vietnam");
    }

    @Test
    public void VerifyThatTheUserCanCreateStaffWithValidData() {

        loginPage.login("admin","123456");

        dashboardPage.openStaffNav();
        dashboardPage.openAddStaffCard();

//        addStaffPage.addStaff(addStaffForm);

        addStaffPage.openStaffNav();
        addStaffPage.openViewAllStaffCard();

        viewAllStaffPage.clickLastPageItem();

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}