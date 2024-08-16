package guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.guest.*;
import utils.BookingDataGenerator;
import utils.CreditCard;

public class TC3_VerifyThatTheSearchFunctionOfTheSearchTextboxOnTheHomeRoomAboutBlogsContactUsBlogsScreensIsNoSuccessful {
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
    RoomDetailsPage roomDetailsPage;
    SearchPage searchPage;
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
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contactPage = new ContactPage(driver);
        faqsPage = new FaqsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        basePage = new BasePage(driver);
        confirmPage = new ConfirmPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        searchPage = new SearchPage(driver);
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
    public void TC3() {
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchForBooking(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNowInRoomDetails();

        // Phương thức nhập thông tin bổ sung và gửi
        roomsPage.fillAndSubmitAdditionalInformation(fullName, email, phone, address);

        //Phương thức nhập thông tin thẻ tín dụng và enter "Pay Now"
        checkOutPage.enterCreditCardDetails(creditCard);

        // Phương thức hiển thị thông tin booking
         confirmPage.displayToElement();

        // Gọi phương thức getBookingId() từ ConfirmPage để lấy ID của booking sau khi xác nhận
        bookingId = null;

        // Điều hướng đến trang room, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        confirmPage.navigateToPage("/rooms");
        roomsPage.searchBooking(bookingId);
        softAssert.assertEquals(roomsPage.getBookingNotFoundMessage(),"Opps ! No booking found !", "Booking ID does not match the roomsPage!");

        // Điều hướng đến trang home, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        searchPage.navigateToPage("/");
        homePage.searchBooking(bookingId);
        softAssert.assertEquals(homePage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the homePage!");

        // Điều hướng đến trang about, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        searchPage.navigateToPage("/about");
        aboutPage.searchBooking(bookingId);
        softAssert.assertEquals(aboutPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the aboutPage!");

        // Điều hướng đến trang blog, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        searchPage.navigateToPage("/blogs");
        blogsPage.searchBooking(bookingId);
        softAssert.assertEquals(blogsPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the blogsPage!");

        // Điều hướng đến trang contact, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        searchPage.navigateToPage("/contact");
        contactPage.searchBooking(bookingId);
        softAssert.assertEquals(contactPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the contactPage!");

        // Điều hướng đến trang contact, tìm kiếm bookingID và so sánh ConfirmPage và SearchPage.
        searchPage.navigateToPage("/faqs");
        faqsPage.searchBooking(bookingId);
        softAssert.assertEquals(faqsPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the faqsPage!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
