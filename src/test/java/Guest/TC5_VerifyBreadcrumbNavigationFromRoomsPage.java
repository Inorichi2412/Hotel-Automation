package Guest;

import Config.SetUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    ContactPage contactPage;
    FaqsPage faqsPage;
    SoftAssert softAssert;

    // Tiêu đề mong đợi của trang Home
    String expectedHomeTitle = "Best Hotel to stay";

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
    public void TC5() {

        // Kiểm tra tiêu đề trang Rooms
        roomsPage.navigateToRoomsPage();
        roomsPage.navigateToHomePageFromBreadcrumb();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang About
        aboutPage.navigateToAboutPage();
        aboutPage.navigateToHomePageFromBreadcrumb();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang Blogs
        blogsPage.navigateToBlogsPage();
        blogsPage.navigateToHomePageFromBreadcrumb();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang Contact
        contactPage.navigateToContactPage();
        contactPage.navigateToHomePageFromBreadcrumb();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang FAQs
        faqsPage.navigateToFaqsPage();
        faqsPage.navigateToHomePageFromBreadcrumb();
        softAssert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
