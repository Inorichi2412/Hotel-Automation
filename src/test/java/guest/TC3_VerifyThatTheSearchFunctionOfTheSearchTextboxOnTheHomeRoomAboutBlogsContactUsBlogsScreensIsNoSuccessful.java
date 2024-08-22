package guest;

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

public class TC3_VerifyThatTheSearchFunctionOfTheSearchTextboxOnTheHomeRoomAboutBlogsContactUsBlogsScreensIsNoSuccessful {
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
        contactUsPage = new ContactUsPage(driver);
        faQsPage = new FAQsPage(driver);
        checkOutPage = new CheckOutPage(driver);
        generalPage = new GeneralPage(driver);
        confirmPage = new ConfirmPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        searchRoomsPage = new SearchRoomsPage(driver);
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
        // Booking ID random
        bookingId = bookingDataGenerator.generateBookingId();
    }

    @Test
    public void TC3() {
        // Điều hướng đến trang , tìm kiếm bookingID và kiểm tra booking id co không
        homePage.navigateToHomePage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(homePage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the homePage!");


        roomsPage.navigateToRoomsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(roomsPage.getBookingNotFoundMessage(),"Opps ! No booking found !", "Booking ID does not match the roomsPage!");

        aboutPage.navigateToAboutPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(aboutPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the aboutPage!");

        blogsPage.navigateToBlogsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(blogsPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the blogsPage!");

        contactUsPage.navigateToContactPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(contactUsPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the contactPage!");

        faQsPage.navigateToFaqsPage();
        searchRoomsPage.searchBooking(bookingId);
        softAssert.assertEquals(faQsPage.getBookingNotFoundMessage(), "Opps ! No booking found !", "Booking ID does not match the faqsPage!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
