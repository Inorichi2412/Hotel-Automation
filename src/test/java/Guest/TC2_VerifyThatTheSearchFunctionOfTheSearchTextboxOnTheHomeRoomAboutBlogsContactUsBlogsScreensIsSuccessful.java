package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.*;
import utils.BookingDataGenerator;
import utils.CreditCard;

public class TC2_VerifyThatTheSearchFunctionOfTheSearchTextboxOnTheHomeRoomAboutBlogsContactUsBlogsScreensIsSuccessful {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactPage contactPage;
    FaqsPage faqsPage;
    CheckOutPage checkOutPage;
    BasePage basePage;
    ConfirmPage confirmPage;
    BookingDataGenerator bookingDataGenerator;
    CreditCard creditCard;

    // Các biến để lưu dữ liệu đặt phòng
    String checkInDate;
    String checkOutDate;
    int adults;
    int children;
    String fullName;
    String email;
    String phone;
    String address;


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
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contactPage = new ContactPage(driver);
        faqsPage = new FaqsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        basePage = new BasePage(driver);
        confirmPage = new ConfirmPage(driver);
        bookingDataGenerator = new BookingDataGenerator();
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
    public void TC2() {
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchForBooking(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.scrollToElementAndClickViewDetails();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomsPage.scrollToAndClickBookNowInRoomDetails();

        // Phương thức cuộn tới vung AddInformationForm
        roomsPage.scrollToAddInformationForm();

        // Phương thức nhập thông tin bổ sung và gửi
          roomsPage.fillAndSubmitAdditionalInformation(fullName, email, phone, address);
//        roomsPage.fillAndSubmitAdditionalInformation("hoangvu", "hoangvu@gmail.com ", "0705959123", "vn");

        //Phương thức cuộn tới phần chọn phương thức thanh toán
        checkOutPage.scrollToPaymentMethodSection();

        //Phương thức nhập thông tin thẻ tín dụng
        checkOutPage.enterCreditCardDetails(creditCard);
//        checkOutPage.enterCreditCardDetails("2222333344449999", "MABU", "1232", "123");

        // Phương thức enter "Pay Now"
        checkOutPage.clickButtonPayNow();

        // Phương thức hiển thị thông tin booking
         confirmPage.clickScrollToElement();

        //
        roomsPage.navigateToRoomsPage();
        roomsPage.enterBookingIdAndSearch();

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
