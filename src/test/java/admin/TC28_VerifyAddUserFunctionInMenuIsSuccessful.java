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
import utils.BookingDataGenerator;

public class TC28_VerifyAddUserFunctionInMenuIsSuccessful {
    WebDriver driver;
    HomePage homePage;
    AdminPage adminPage;
    LoginPage loginPage;
    LoginForm loginForm;
    UserPage userPage;
    BookingDataGenerator bookingDataGenerator;
    SoftAssert softAssert;
    SetUp setUp;
    String fullName;
    String email;
    String phone;
    String userName;
    String password;
    String confirmPassword;
    String address;
    String searchResultEmail;

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
        bookingDataGenerator = new BookingDataGenerator();
        // Khởi tạo đối tượng
        loginForm = LoginForm.getLoginAdmin();
        // Khơi ta information user
        fullName = bookingDataGenerator.generateFullName();
        email = bookingDataGenerator.generateEmail();
        phone = bookingDataGenerator.generatePhone();
        userName = bookingDataGenerator.generateUserName();
        password = bookingDataGenerator.generatePassword();
        confirmPassword = password;
        address = bookingDataGenerator.generateAddress();
    }

    @Test
    public void TC28() {
        // Phương thức click login và đăng nhặp admin
        homePage.openLoginForm();
        // Phương thức login
        homePage.loginAdmin(loginForm);

        // phương thức go to admin
        homePage.clickButtonGoToAdmin();
        // thao tac userPage
        userPage.clickUserMenu();
        userPage.clickAddUser();
        userPage.enterInforUser(fullName, email, phone, userName, password, confirmPassword, address);
        userPage.searchUserName(email);
        // Lấy kết quả tìm kiếm và so sánh với email đã nhập
        searchResultEmail = userPage.getEmailFromSearchResults();
        softAssert.assertEquals(searchResultEmail, email, "Email do not match!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
