package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.*;

public class TC5_VerifyBreadcrumbNavigationFromRoomsPage {
    WebDriver driver;
    String url;
    SetUp setUp;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContanctPage contanctPage;
    FaqsPage faqsPage;


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
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contanctPage = new ContanctPage(driver);
        faqsPage = new FaqsPage(driver);
    }

    @Test
    public void TC5() {
        roomsPage.clickButtonBreadcrumbHome();
        aboutPage.clickButtonBreadcrumbHome();
        blogsPage.clickButtonBreadcrumbHome();
        contanctPage.clickButtonBreadcrumbHome();
        faqsPage.clickButtonBreadcrumbHome();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
