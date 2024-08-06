package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.HomePage;


public class TC1_VerifyGuestRedirectsToCorrespondingPagesOnTheAreaMenu {
    WebDriver driver;
    String url;
    HomePage homePage;
    SetUp setUp;

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
        // Khởi tạo đối tượng HomePage
        homePage = new HomePage(driver);
    }

    @Test
    public void TC1() {
        homePage.directionalMenu();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
