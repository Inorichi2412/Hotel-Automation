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

public class TC21_VerifyTheDisplayOfTheCreditCardArea {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    CheckOutPage checkOutPage;
    GeneralPage generalPage;

    RoomDetailsPage roomDetailsPage;
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
    public void TC21() {
        //Sử dụng dữ liệu đặt phòng để tìm kiếm
        homePage.searchRoom(checkInDate, checkOutDate, adults, children);

        // phương thức cuộn tới phần tử và nhấn nút View Details
        roomsPage.openDetailsView();

        // Phương thức cuộn tới phần tử và nhấn nút BookNow tại trang Room Details
        roomDetailsPage.openBookNow();

        // Phương thức nhập thông tin bổ sung và gửi
        bookNowPage.fillAndSubmitAdditionalInformation(fullName, email, phone, address);

        // display thông tin credit card
        checkOutPage.displayInformationCredirCard();
        softAssert.assertEquals(checkOutPage.displayCardNumber(),"Card Number", "Card Number Not Display");
        softAssert.assertEquals(checkOutPage.displayNameOnCard(),"Name on Card", "Name on Card Not Display");
        softAssert.assertEquals(checkOutPage.displayExpiryDate(),"Expiry Date", "Expiry Date Not Display");
        softAssert.assertEquals(checkOutPage.displayCvvNumber(),"CVV Number", "CVV Number Not Display");
        softAssert.assertEquals(checkOutPage.displayMessageNote(), "Note: In the next step you will be redirected to your bank's website to verify yourself.", "CVV Number Not Display");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
