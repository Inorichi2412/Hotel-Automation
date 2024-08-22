package admin;

import Config.SetUp;
import Models.LoginForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.admin.AdminPage;
import page.admin.UserPage;
import page.common.HomePage;
import page.common.LoginPage;

public class TC30_31_VerifyDisplayOfUserInformationAndNumberOfRecordsOnAllUserPage {
    WebDriver driver;
    HomePage homePage;
    AdminPage adminPage;
    LoginPage loginPage;
    LoginForm loginForm;
    UserPage userPage;
    SoftAssert softAssert;
    SetUp setUp;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        setUp = new SetUp();
        driver.get(setUp.getUrl());
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);
        userPage = new UserPage(driver);

        softAssert = new SoftAssert();
        // Khởi tạo đối tượng
        loginForm = LoginForm.getLoginAdmin();
    }

    @Test
    public void TC30And31() {
        // Phương thức click login và đăng nhặp admin
        loginPage.clickButtonLogin();
        // Phương thức login
        loginPage.loginAdmin(loginForm);
        // phương thức go to admin
        homePage.clickButtonGoToAdmin();

        // thao tac userPage
        userPage.clickUserMenu();
        userPage.clickViewUser();
        // show listview
        softAssert.assertTrue(userPage.showListView(),"List view user does exits");

        // show entries 10
        userPage.showTenBookingRows();
        softAssert.assertEquals(userPage.numberOfUsersIsDisplay(), 10, "The number of reservations is different from 10");

        // show entries 25
        userPage.showTwentyFiveBookingRows();
        softAssert.assertEquals(userPage.numberOfUsersIsDisplay(), 25, "The number of reservations is different from 25");

        // show entries 50
        userPage.showFiftyBookingRows();
        softAssert.assertEquals(userPage.numberOfUsersIsDisplay(), 50, "The number of reservations is different from 50");

        // show entries 100
        userPage.showHundredBookingRows();
        softAssert.assertEquals(userPage.numberOfUsersIsDisplay(), 100, "The number of reservations is different from 100");

        // show grid view
        userPage.clickGridView();
        softAssert.assertTrue(userPage.showGridView(),"Grid view user does exits");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
