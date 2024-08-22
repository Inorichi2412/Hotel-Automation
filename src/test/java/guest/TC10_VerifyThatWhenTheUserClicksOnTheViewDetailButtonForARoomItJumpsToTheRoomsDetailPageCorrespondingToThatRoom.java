package guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.*;

import java.util.Random;

public class TC10_VerifyThatWhenTheUserClicksOnTheViewDetailButtonForARoomItJumpsToTheRoomsDetailPageCorrespondingToThatRoom {
    WebDriver driver;
    String url;
    SetUp setUp;
    RoomsPage roomsPage;
    RoomDetailsPage roomDetailsPage;
    Random random;
    SoftAssert softAssert;
    String nameInRoomPage;
    String nameInRoomDetailPage;
    int roomIndex;

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
        softAssert = new SoftAssert();
        random = new Random();
        roomIndex = random.nextInt(12)+1;
    }

    @Test
    public void TC10() {
        // Phương thư open RoomsPage
        roomsPage.openRoomsPage();

        nameInRoomPage = roomsPage.openRoomByIndex(roomIndex);
        nameInRoomDetailPage = roomDetailsPage.getRoomName();
        softAssert.assertEquals(nameInRoomPage, nameInRoomDetailPage,"Name of room is not same");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
