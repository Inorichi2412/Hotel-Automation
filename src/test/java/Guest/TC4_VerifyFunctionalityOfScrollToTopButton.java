package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.*;

public class TC4_VerifyFunctionalityOfScrollToTopButton {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactUsPage contactUsPage;
    FAQsPage faQsPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        setUp = new SetUp();
        url = setUp.getUrl();
        driver.get(url);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        roomsPage = new RoomsPage(driver);
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contactUsPage = new ContactUsPage(driver);
        faQsPage = new FAQsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC4() {

        // Kiểm tra tiêu đề trang Home
        homePage.navigateToHomePage();
        homePage.displayButtonScrollToTop();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang Rooms
        roomsPage.navigateToRoomsPage();
        roomsPage.displayButtonScrollToTop();
        softAssert.assertEquals(roomsPage.getPageTitleText(), "Rooms", "The Rooms page title does not match!");

        // Kiểm tra tiêu đề trang About
        aboutPage.navigateToAboutPage();
        aboutPage.displayButtonScrollToTop();
        softAssert.assertEquals(aboutPage.getPageTitleText(), "About Us", "The About page title does not match!");

        // Kiểm tra tiêu đề trang Blogs
        blogsPage.navigateToBlogsPage();
        blogsPage.displayButtonScrollToTop();
        softAssert.assertEquals(blogsPage.getPageTitleText(), "Our Blogs", "The Blogs page title does not match!");

        // Kiểm tra tiêu đề trang Contact
        contactUsPage.navigateToContactPage();
        contactUsPage.displayButtonScrollToTop();
        softAssert.assertEquals(contactUsPage.getPageTitleText(), "Contact Us", "The Contact page title does not match!");

        // Kiểm tra tiêu đề trang FAQs
        faQsPage.navigateToFaqsPage();
        faQsPage.displayButtonScrollToTop();
        softAssert.assertEquals(faQsPage.getPageTitleText(), "FAQ", "The FAQs page title does not match!");

        // Xác nhận tất cả các assert
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
