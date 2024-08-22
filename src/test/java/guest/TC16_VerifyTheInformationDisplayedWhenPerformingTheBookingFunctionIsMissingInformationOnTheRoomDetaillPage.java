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

public class TC16_VerifyTheInformationDisplayedWhenPerformingTheBookingFunctionIsMissingInformationOnTheRoomDetaillPage {
    WebDriver driver;
    String url;
    SetUp setUp;
    RoomsPage roomsPage;
    RoomDetailsPage roomDetailsPage;
    BookingDataGenerator bookingDataGenerator;
    SoftAssert softAssert;
    String checkInDate;
    String checkOutDate;

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
        roomsPage = new RoomsPage(driver);
        roomDetailsPage = new RoomDetailsPage(driver);
        bookingDataGenerator = new BookingDataGenerator();
        softAssert = new SoftAssert();
        // information search
        checkInDate = bookingDataGenerator.generateCheckInDate();
        checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
    }


    @Test
    public void TC16() {

        // Phương thức open RoomsPage
        roomsPage.openRoomsPage();
        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();
        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNow();
        softAssert.assertTrue(roomDetailsPage.showDatePopup(),"No Popup date Check In");

        // Trường hợp nhập checkin
        roomDetailsPage.enterCheckInTime(checkInDate);
        roomDetailsPage.clickBookNowButton();
        softAssert.assertTrue(roomDetailsPage.showDatePopup(),"No Popup date Check Out");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
