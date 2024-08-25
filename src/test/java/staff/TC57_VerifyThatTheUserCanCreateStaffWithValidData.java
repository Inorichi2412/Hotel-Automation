package staff;

import Models.AddStaffForm;
import org.apache.commons.lang3.RandomStringUtils;
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
import utils.BookingDataGenerator;
import utils.ConfigReader;

import java.time.Duration;

public class TC57_VerifyThatTheUserCanCreateStaffWithValidData {
    WebDriver driver;
    ConfigReader configReader;
    page.staff.LoginPage loginPage;
    DashboardPage dashboardPage;
    AddStaffPage addStaffPage;
    SoftAssert softAssert;
    AddStaffForm addStaffForm;
    ViewAllStaffPage viewAllStaffPage;
    BookingDataGenerator bookingDataGenerator;
    String userName;
    String fullName;
    String mobilePhone;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        addStaffPage=new AddStaffPage(driver);
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
    public void VerifyThatTheUserCanCreateStaffWithValidData() {

        loginPage.login("admin","123456");

        dashboardPage.openStaffNav();
        dashboardPage.openAddStaffCard();

        addStaffPage.addStaff(addStaffForm);


        viewAllStaffPage.enterSearchInput(mobilePhone);

        softAssert.assertEquals(viewAllStaffPage.checkPhoneNumberDisplay(mobilePhone),mobilePhone,"Staff not display");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
