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

public class TC4_VerifyFunctionalityOfScrollToTopButton {
    WebDriver driver;
    String url;
    SetUp setUp;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactPage contactPage;
    FaqsPage faqsPage;
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
        contactPage = new ContactPage(driver);
        faqsPage = new FaqsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC4() {

        // Kiểm tra tiêu đề trang Home
        homePage.navigateToHomePage();
        homePage.clickScrollToTop();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang Rooms
        roomsPage.navigateToRoomsPage();
        roomsPage.clickScrollToTop();
        softAssert.assertEquals(roomsPage.getPageTitleText(), "Rooms", "The Rooms page title does not match!");

        // Kiểm tra tiêu đề trang About
        aboutPage.navigateToAboutPage();
        aboutPage.clickScrollToTop();
        softAssert.assertEquals(aboutPage.getPageTitleText(), "About Us", "The About page title does not match!");

        // Kiểm tra tiêu đề trang Blogs
        blogsPage.navigateToBlogsPage();
        blogsPage.clickScrollToTop();
        softAssert.assertEquals(blogsPage.getPageTitleText(), "Our Blogs", "The Blogs page title does not match!");

        // Kiểm tra tiêu đề trang Contact
        contactPage.navigateToContactPage();
        contactPage.clickScrollToTop();
        softAssert.assertEquals(contactPage.getPageTitleText(), "Contact Us", "The Contact page title does not match!");

        // Kiểm tra tiêu đề trang FAQs
        faqsPage.navigateToFaqsPage();
        faqsPage.clickScrollToTop();
        softAssert.assertEquals(faqsPage.getPageTitleText(), "FAQ", "The FAQs page title does not match!");

        // Xác nhận tất cả các assert
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
