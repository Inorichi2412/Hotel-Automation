package Guest;

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
import utils.BookingDataGenerator;

public class TC17_18_VerifyPromoCodeFunctionalityWithExistingPromoCodeInformation {
    WebDriver driver;
    String url;
    SetUp setUp;
    LoginPage loginPage;
    HomePage homePage;
    RoomsPage roomsPage;
    CheckOutPage checkOutPage;
    GeneralPage generalPage;
    RoomDetailsPage roomDetailsPage;
    SearchRoomsPage searchRoomsPage;
    BookNowPage bookNowPage;
    AdminPage adminPage;
    BookingDataGenerator bookingDataGenerator;
    SoftAssert softAssert;
    LoginForm loginForm;
    // Các biến để lưu dữ liệu đặt phòng
    String checkInDate;
    String checkOutDate;
    int adults;
    int children;
    String fullName;
    String email;
    String phone;
    String address;
    String promoCode;
    String promoCodeError;


    @BeforeMethod
    public void setUp() {
        //Khởi tạo đối tượng ChromeDriver
        driver = new ChromeDriver();
        //Khởi tạo đối tượng setUp
        setUp = new SetUp();
        //Lấy URL từ config
        url = setUp.getUrl();
        // Điều hướng đến URL lấy từ file cấu hình
        driver.get(url);
        // Tối ưu hóa cửa sổ trình duyệt
        driver.manage().window().maximize();
        // Khởi tạo đối tượng
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        roomsPage = new RoomsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        generalPage = new GeneralPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        searchRoomsPage = new SearchRoomsPage(driver);
        bookNowPage = new BookNowPage(driver);
        adminPage = new AdminPage(driver);
        bookingDataGenerator = new BookingDataGenerator();
        softAssert = new SoftAssert();
        // information search
        checkInDate = bookingDataGenerator.generateCheckInDate();
        checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
        adults = bookingDataGenerator.generateAdults();
        children = bookingDataGenerator.generateChildren();
        // information guest
        fullName = bookingDataGenerator.generateFullName();
        email = bookingDataGenerator.generateEmail();
        phone = bookingDataGenerator.generatePhone();
        address = bookingDataGenerator.generateAddress();
        // Khởi tạo đối tượng admin
        loginForm = LoginForm.getLoginAdmin();
        // promotion
        promoCodeError = bookingDataGenerator.generatePromotionCode();
    }

    @Test
    public void TC17andTC18() {
        // Phương thức click login và đăng nhặp admin
        loginPage.clickButtonLogin();

        // Phương thức login
        loginPage.loginAdmin(loginForm);

        // Phương thức open tab
        homePage.openAdminTab();

        // Phương thức get promotion
        adminPage.openPromotionMenu();
        adminPage.openViewPromotion();
        adminPage.getCodePromotion();
        promoCode = adminPage.getCodePromotion();

        // Phương thức close tab new, back tab old
        homePage.switchToOriginalTab();

        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchRoom(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNow();

        // Phương thức show, click radio promotion khong ton tai
        bookNowPage.tickPromotion();
        bookNowPage.submitPromotion(promoCodeError);

        //kiem tra
        softAssert.assertEquals(bookNowPage.messagePromotionError(),"Error: Promotion Code not exists !!!", "Error: Promotion Code not exists !!!");

        // Phương thức show, click radio promotion  ton tai
        bookNowPage.tickPromotion();
        bookNowPage.submitPromotion(promoCode);
        softAssert.assertFalse(bookNowPage.messagePromotionExits(),"The following message exists: Error: Promotion Code not exists !!!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
