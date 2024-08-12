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
    }

    // Phương thức chuẩn bị dữ liệu cho việc đặt phòng
    public void prepareBookingData() {
        checkInDate = bookingDataGenerator.generateCheckInDate();
        checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
        adults = bookingDataGenerator.generateAdults();
        children = bookingDataGenerator.generateChildren();
    }

    // Phương thức chuẩn bị dữ liệu cho thông tin khách
    public void prepareGuestData() {
        fullName = bookingDataGenerator.generateFullName();
        email = bookingDataGenerator.generateEmail();
        phone = bookingDataGenerator.generatePhone();
        address = bookingDataGenerator.generateAddress();
    }

    @Test
    public void TC2() {
        // Gọi phương thức chuẩn bị dữ liệu
        prepareBookingData();
        prepareGuestData();
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
        //Phương thức cuộn tới phần chọn phương thức thanh toán
        checkOutPage.scrollToPaymentMethodSection();
        //Phương thức nhập thông tin thẻ tín dụng
        checkOutPage.enterCreditCardDetails(creditCard);
        try {
            Thread.sleep(5000); // Chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Phương thức enter "Pay Now"
        checkOutPage.clickButtonPayNow();
        try {
            Thread.sleep(5000); // Chờ 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Phương thức hiển thị thông tin booking
       // confirmPage.displayBookingInformation();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
