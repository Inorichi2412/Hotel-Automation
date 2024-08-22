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
import page.common.HomePage;
import page.common.LoginPage;

public class TC27_VerifySpecifyStaffDetailsInformationInMenu {
    WebDriver driver;
    HomePage homePage;
    AdminPage adminPage;
    LoginPage loginPage;
    LoginForm loginForm;
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
        softAssert = new SoftAssert();
        // Khởi tạo đối tượng
        loginForm = LoginForm.getLoginAdmin();
    }

    @Test
    public void TC27() {
        // Phương thức click login và đăng nhặp admin
        loginPage.clickButtonLogin();
        // Phương thức login
        loginPage.loginAdmin(loginForm);

        // phương thức go to admin
        homePage.clickButtonGoToAdmin();
        softAssert.assertTrue(adminPage.informationAdmin(),"Admin information not available");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
