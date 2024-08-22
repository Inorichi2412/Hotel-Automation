package guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.HomePage;
import utils.BookingDataGenerator;

public class TC8_VerifyTheInformationDisplayedWhenPerformingTheHotelRoomSearchFunctionIsMissingInformationInTheTextBoxesOnTheHomePage {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    BookingDataGenerator bookingDataGenerator;
    SoftAssert softAssert;
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
        bookingDataGenerator = new BookingDataGenerator();
        softAssert = new SoftAssert();
        // information search
        checkInDate = bookingDataGenerator.generateCheckInDate();
        checkOutDate = bookingDataGenerator.generateCheckOutDate(checkInDate);
        adults = bookingDataGenerator.generateAdults();
        children = bookingDataGenerator.generateChildren();
    }


    @Test
    public void TC8() {

        // Trường hợp không nhập data
        homePage.clickSearchButton();
        softAssert.assertTrue(homePage.showDatePopup(),"No Popup date Check In");

        // Trường hợp nhập checkin
        homePage.enterCheckInTime(checkInDate);
        homePage.clickSearchButton();
        softAssert.assertTrue(homePage.showDatePopup(),"No Popup date Check Out");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
