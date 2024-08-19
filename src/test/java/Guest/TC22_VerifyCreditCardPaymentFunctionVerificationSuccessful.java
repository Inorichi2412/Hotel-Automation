package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.UserAndGuest.*;
import utils.BookingDataGenerator;
import utils.CreditCard;

public class TC22_VerifyCreditCardPaymentFunctionVerificationSuccessful {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    CheckOutPage checkOutPage;
    GeneralPage generalPage;
    RoomDetailsPage roomDetailsPage;
    BookNowPage bookNowPage;
    ConfirmPage confirmPage;
    BookingDataGenerator bookingDataGenerator;
    CreditCard creditCard;
    SoftAssert softAssert;

    // Các biến để lưu dữ liệu đặt phòng
    String checkInDate;
    String checkOutDate;
    int adults;
    int children;
    String fullName;
    String email;
    String phone;
    String address;
    String bookingId;

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
        homePage = new HomePage(driver);
        roomsPage = new RoomsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        generalPage = new GeneralPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        bookNowPage = new BookNowPage(driver);
        confirmPage = new ConfirmPage(driver);
        bookingDataGenerator = new BookingDataGenerator();
        softAssert = new SoftAssert();
        // Khởi tạo đối tượng CreditCard bằng phương thức getSampleCreditCard
        creditCard = CreditCard.getSampleCreditCard();
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
    }

    @Test
    public void TC22() {
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchRoom(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNow();

        // Phương thức nhập thông tin bổ sung và gửi
        bookNowPage.fillAndSubmitAdditionalInformation(fullName, email, phone, address);

        //Phương thức nhập thông tin thẻ tín dụng và enter "Pay Now"
        checkOutPage.enterCreditCardDetails(creditCard);

        // Xác nhận message confirm, di chuyển đến confirmPage
        softAssert.assertEquals(confirmPage.getPageTitleText(),"Confirm", "The Confirm page title does not match!");
        softAssert.assertEquals(confirmPage.getMessageConfirm(),"Thank you! Your booking has been placed. We will contact you to confirm about the booking soon.", "Message does not exist ");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
