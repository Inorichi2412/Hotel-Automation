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
import page.common.*;

public class TC25_26_VerifySuccessfulAndFailedAdminAccountLogins {
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
        loginForm = new LoginForm("","");
    }

    @Test
    public void TC25And26() {
        // Phương thức click login và đăng nhặp admin
        loginPage.openLoginForm();
        // Phương thức login vs empty
        homePage.loginAdmin(loginForm);
        softAssert.assertTrue(loginPage.isLoginErrorMessageDisplayed(), "Error message for invalid not displayed");

        // Phương thức login user khong hợp lệ
        loginForm = new LoginForm("admin1234", "123456");
        homePage.loginAdmin(loginForm);
        softAssert.assertTrue(loginPage.isLoginErrorMessageDisplayed(), "Error message user for invalid not displayed");

        // Phương thức login passs khong hợp lệ
        loginForm = new LoginForm("admin", "123456abc");
        homePage.loginAdmin(loginForm);
        softAssert.assertTrue(loginPage.isLoginErrorMessageDisplayed(), "Error message pass for invalid not displayed");

        // Phương thức login thành công
        homePage.loginAdmin(LoginForm.getLoginAdmin());
        softAssert.assertTrue(loginPage.isAdminPageDisplayed(), "Admin page is not displayed after successful login");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
