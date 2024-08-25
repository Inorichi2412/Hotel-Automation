package guest;

import Config.SetUp;
import Models.LoginForm;
import Models.Promotion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.admin.AdminPage;
import page.admin.PromotionPage;
import page.common.*;
import utils.BookingDataGenerator;
import utils.DriverUtils;
import utils.PromotionCalculate;

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
    PromotionPage promotionPage;
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
    Promotion promotion;
    String promoCode;
    String promoValue;
    String promoType;
    String promoCodeNotExits;
    float grandTotal;
    float grandTotalPromotion;
    float grandTotalAfterApplyPromotion;


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
        promotionPage = new PromotionPage(driver);
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
        promoCodeNotExits = bookingDataGenerator.generatePromotionCode();
    }

    @Test
    public void TC17andTC18() {
        // Phương thức click login và đăng nhặp admin
        loginPage.openLoginForm();

        // Phương thức login
        homePage.loginAdmin(loginForm);
        homePage.clickButtonGoToAdmin();

        // Phương thức get promotion
        adminPage.openPromotionMenu();
        promotionPage.openViewPromotion();
        promoCode = promotionPage.getCodePromotion();
        promoValue = promotionPage.getValuePromotion();
        promoType = promotionPage.getTypePromotion();

        driver.get(url);
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchRoom(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNow();

        // Phương thức show, click radio promotion khong ton tai
        bookNowPage.submitPromotion(promoCodeNotExits);
        //kiem tra có ton tại message error
        softAssert.assertEquals(bookNowPage.messagePromotionError(),"Error: Promotion Code not exists !!!", "Error: Promotion Code not exists !!!");

        // Tạo đối tượng Promotion
        promotion = new Promotion(promoCode, Float.parseFloat(promoValue), promoType);

        // Tính toán tổng giá trị trước khi áp dụng giảm giá
        grandTotal = DriverUtils.parseCurrency(bookNowPage.getGrandTotal());
        grandTotalPromotion = PromotionCalculate.calculate(grandTotal, promotion);
        System.out.println("Grand Total before promotion: " + grandTotalPromotion);

        // Áp dụng mã giảm giá tồn tại
        bookNowPage.submitPromotion(promoCode);

        // Lấy giá trị tổng sau khi áp dụng giảm giá
        grandTotalAfterApplyPromotion = DriverUtils.parseCurrency(bookNowPage.getGrandTotal());
        System.out.println("Calculated discount: " + grandTotalAfterApplyPromotion);

        // Kiểm tra xem giá trị tính toán có khớp với giá trị hiển thị không
        softAssert.assertEquals(grandTotalPromotion, grandTotalAfterApplyPromotion, "Promotion calculation error!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
