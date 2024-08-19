package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.*;
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
    ContactUsPage contactUsPage;
    FAQsPage faQsPage;
    CheckOutPage checkOutPage;
    GeneralPage generalPage;
    ConfirmPage confirmPage;
    RoomDetailsPage roomDetailsPage;
    SearchRoomsPage searchRoomsPage;
    BookNowPage bookNowPage;
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
    String resultBookingId;

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
        contactUsPage = new ContactUsPage(driver);
        faQsPage = new FAQsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        generalPage = new GeneralPage(driver);
        confirmPage = new ConfirmPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        searchRoomsPage = new SearchRoomsPage(driver);
        bookNowPage = new BookNowPage(driver);
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
    public void TC2() {
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

        // Gọi phương thức getBookingId() từ ConfirmPage để lấy ID của booking sau khi xác nhận
        bookingId = confirmPage.getBookingId();

        // Gọi phương thức getBookingId() từ SearchPage để lấy ID của booking sau khi tìm kiếm
        resultBookingId = searchRoomsPage.getBookingId();

        // Điều hướng đến trang , tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        homePage.navigateToHomePage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the roomsPage!");

        roomsPage.navigateToRoomsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the homePage!");

        aboutPage.navigateToAboutPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the aboutPage!");

        blogsPage.navigateToBlogsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the blogsPage!");

        contactUsPage.navigateToContactPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the contactPage!");

        // Điều hướng đến trang contact, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        faQsPage.navigateToFaqsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(bookingId, resultBookingId, "Booking ID does not match the faqsPage!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
