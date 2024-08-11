package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.guest.*;


public class TC1_VerifyGuestRedirectsToCorrespondingPagesOnTheAreaMenu {
    WebDriver driver;
    String url;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContanctPage contanctPage;
    FaqsPage faqsPage;
    SetUp setUp;
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
        // Khởi tạo đối tượng
        homePage = new HomePage(driver);
        roomsPage = new RoomsPage(driver);
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contanctPage = new ContanctPage(driver);
        faqsPage = new FaqsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC1() {
        // Expected titles
        String expectedHomeTitle = "Best Hotel to stay";
        String expectedRoomsTitle = "Rooms";
        String expectedAboutTitle = "About Us";
        String expectedBlogsTitle = "Our Blogs";
        String expectedContanctTitle = "Contact Us";
        String expectedFaqsTitle = "FAQ";

        // fix mess
        // Navigate assert title
        Assert.assertEquals(homePage.getTitle(), expectedHomeTitle,"Best Hotel to stay" );
        Assert.assertEquals(roomsPage.directionalRooms(), expectedRoomsTitle, "Rooms");
        Assert.assertEquals(aboutPage.directionalAbout(), expectedAboutTitle, "About Us");
        Assert.assertEquals(blogsPage.directionalBlog(), expectedBlogsTitle, "Our Blogs");
        Assert.assertEquals(contanctPage.directionalContanct(), expectedContanctTitle, "Contact Us");
        Assert.assertEquals(faqsPage.directionalFAQ(), expectedFaqsTitle, "Contact Us");

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
