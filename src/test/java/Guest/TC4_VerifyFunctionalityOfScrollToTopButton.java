package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.guest.*;

public class TC4_VerifyFunctionalityOfScrollToTopButton {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContanctPage contanctPage;
    FaqsPage faqsPage;
    SoftAssert softAssert;

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
        roomsPage = new RoomsPage(driver);
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contanctPage = new ContanctPage(driver);
        faqsPage = new FaqsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC4() {
        // Home
        homePage.clickScrollToTop();
        // Expected titles
        String expectedHomeTitle = "Best Hotel to stay";
        // Navigate assert title
        softAssert.assertEquals(homePage.directionalHome(),expectedHomeTitle,"Best Hotel to stay");

        // Rooms
        roomsPage.clickScrollToTop();
        // Expected titles
        String expectedRoomsTitle = "Rooms";
        // Navigate assert title
        softAssert.assertEquals(roomsPage.directionalRooms(),expectedRoomsTitle,"Rooms");

        // About Us
        aboutPage.clickScrollToTop();
        // Expected titles
        String expectedAboutTitle = "About Us";
        // Navigate assert title
        softAssert.assertEquals(aboutPage.directionalAbout(),expectedAboutTitle,"About Us");

        // Our Blogs
        blogsPage.clickScrollToTop();
        // Expected titles
        String expectedBlogsTitle = "Our Blogs";
        // Navigate assert title
        softAssert.assertEquals(blogsPage.directionalBlog(),expectedBlogsTitle,"Our Blogs");

        // Contact Us
        contanctPage.clickScrollToTop();
        // Expected titles
        String expectedContanctTitle = "Contact Us";
        // Navigate assert title
        softAssert.assertEquals(contanctPage.directionalContanct(),expectedContanctTitle,"Contact Us");

        // FAQ
        faqsPage.clickScrollToTop();
        // Expected titles
        String expectedFaqsTitle = "FAQ";
        // Navigate assert title
        softAssert.assertEquals(faqsPage.directionalFAQ(),expectedFaqsTitle,"FAQ");

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
