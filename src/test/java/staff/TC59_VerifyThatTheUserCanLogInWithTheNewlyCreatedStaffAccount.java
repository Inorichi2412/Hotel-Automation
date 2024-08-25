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
import page.staff.ViewAllStaffPage;
import utils.BookingDataGenerator;
import utils.ConfigReader;

import java.time.Duration;

public class TC59_VerifyThatTheUserCanLogInWithTheNewlyCreatedStaffAccount {
    WebDriver driver;
    ConfigReader configReader;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SoftAssert softAssert;
    BookingDataGenerator bookingDataGenerator;
    AddStaffForm addStaffForm;
    ViewAllStaffPage viewAllStaffPage;
    AddStaffPage addStaffPage;
    String userName;
    String mobilePhone;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        addStaffPage=new AddStaffPage(driver);
        viewAllStaffPage=new ViewAllStaffPage(driver);
        bookingDataGenerator=new BookingDataGenerator();

        userName= bookingDataGenerator.generateUserName();
        mobilePhone= bookingDataGenerator.generatePhone();

        softAssert=new SoftAssert();

        driver.get(configReader.getUrlAdmin());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        addStaffForm=new AddStaffForm("anhviet","Male","20",mobilePhone,"Manager",userName,"123456","123456","vietnam");

    }

    @Test
    public void VerifyThatTheAdminLoginSuccessfulWithValidInformation() {

        loginPage.login("admin","123456");

        dashboardPage.openStaffNav();
        dashboardPage.openAddStaffCard();

        addStaffPage.addStaff(addStaffForm);

        viewAllStaffPage.doLogOutAction();

        loginPage.login(userName,"123456");


        softAssert.assertFalse(loginPage.isLoginFormDisplayed(),"Login form still display");
        softAssert.assertEquals(dashboardPage.getPageTitle(),"Dashboard","Wrong page appear!");


        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
