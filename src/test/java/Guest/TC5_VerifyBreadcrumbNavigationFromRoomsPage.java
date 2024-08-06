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

public class TC5_VerifyBreadcrumbNavigationFromRoomsPage {
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
    public void TC5() {
        //Navigate assert title Home
        String expectedHomeTitle = "Best Hotel to stay";

        //  breadcrum Room
        String expectedRoomsTitle = "Rooms";
        Assert.assertEquals(roomsPage.directionalRooms(), expectedRoomsTitle, "Rooms");
        roomsPage.clickButtonBreadcrumbHome();
        Assert.assertEquals(homePage.directionalHome(), expectedHomeTitle,"Best Hotel to stay" );

        //  breadcrum About Us
        String expectedAboutTitle = "About Us";
        Assert.assertEquals(aboutPage.directionalAbout(), expectedAboutTitle, "About Us");
        aboutPage.clickButtonBreadcrumbHome();
        Assert.assertEquals(homePage.directionalHome(), expectedHomeTitle,"Best Hotel to stay" );

        //  breadcrum Our Blogs
        String expectedBlogsTitle = "Our Blogs";
        Assert.assertEquals(blogsPage.directionalBlog(), expectedBlogsTitle, "Our Blogs");
        blogsPage.clickButtonBreadcrumbHome();
        Assert.assertEquals(homePage.directionalHome(), expectedHomeTitle,"Best Hotel to stay" );

        //  breadcrum Contact Us
        String expectedContanctTitle = "Contact Us";
        Assert.assertEquals(contanctPage.directionalContanct(), expectedContanctTitle, "Contact Us");
        contanctPage.clickButtonBreadcrumbHome();
        Assert.assertEquals(homePage.directionalHome(), expectedHomeTitle,"Best Hotel to stay" );

        //  breadcrum FAQ
        String expectedFaqsTitle = "FAQ";
        Assert.assertEquals(faqsPage.directionalFAQ(), expectedFaqsTitle, "FAQ");
        faqsPage.clickButtonBreadcrumbHome();
        Assert.assertEquals(homePage.directionalHome(), expectedHomeTitle,"Best Hotel to stay" );

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}