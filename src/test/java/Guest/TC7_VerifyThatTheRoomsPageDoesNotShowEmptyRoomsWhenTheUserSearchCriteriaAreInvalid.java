package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.guest.HomePage;
import page.guest.RoomsPage;
import utils.BookingDataGenerator;

public class TC7_VerifyThatTheRoomsPageDoesNotShowEmptyRoomsWhenTheUserSearchCriteriaAreInvalid {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    BookingDataGenerator bookingDataGenerator;
    SoftAssert softAssert;

    // Các biến để lưu dữ liệu đặt phòng
    String checkInDate;
    String checkOutDate;
    int adults;
    int children;


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
        bookingDataGenerator = new BookingDataGenerator();
        softAssert = new SoftAssert();
        // information search
        checkInDate = bookingDataGenerator.generateCheckInDate();
        checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
        adults = bookingDataGenerator.generateLargeNumberOfAdults();
        children = bookingDataGenerator.generateLargeNumberOfChildren();
    }

    @Test
    public void TC2() {
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchForBooking(checkInDate, checkOutDate, adults, children);
        //Xác minh rằng các có phòng đang được hiển thị trên trang Rooms.
        softAssert.assertFalse(roomsPage.isItemDescriptionsDisplayed(),"Have available room");
        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
