package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.*;
import utils.BookingDataGenerator;

public class TC2_VerifyThatTheSearchFunctionOfTheSearchTextboxOnTheHomeRoomAboutBlogsContactUsBlogsScreensIsSuccessful {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContanctPage contanctPage;
    FaqsPage faqsPage;
    BookingDataGenerator bookingDataGenerator;


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
        contanctPage = new ContanctPage(driver);
        faqsPage = new FaqsPage(driver);
        bookingDataGenerator = new BookingDataGenerator();
    }

    @Test
    public void TC2() {
//        homePage.textBoxSearchHome();
//        roomsPage.textBoxSearchRooms();
//        aboutPage.textBoxSearchAbout();
//        blogsPage.textBoxSearchBlog();
//        contanctPage.textBoxSearchContact();
//        faqsPage.textBoxSearchFaqs();

        String checkInDate = bookingDataGenerator.generateCheckInDate();
        String checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
        String adults = bookingDataGenerator.generateAdults();
        String children = bookingDataGenerator.generateChildren();
        String fullName = bookingDataGenerator.generateFullName();
        String email = bookingDataGenerator.generateEmail();
        String phone = bookingDataGenerator.generatePhone();
        String address = bookingDataGenerator.generateAddress();

        homePage.actionSearchBooking(checkInDate, checkOutDate, adults, children);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
