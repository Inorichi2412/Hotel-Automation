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
        // Kiểm tra nút Scroll to Top và tiêu đề trang trên HomePage
        homePage.verifyHomePageTitleAfterScroll();

        // Kiểm tra nút Scroll to Top và tiêu đề trang trên RoomsPage
        roomsPage.verifyRoomPageTitleAfterScroll();

        // Kiểm tra nút Scroll to Top và tiêu đề trang trên AboutPage
        aboutPage.verifyAboutPageTitleAfterScroll();

        // Kiểm tra nút Scroll to Top và tiêu đề trang trên BlogsPage
        blogsPage.verifyBlogsPageTitleAfterScroll();

        // Kiểm tra nút Scroll to Top và tiêu đề trang trên ContactPage
        contactPage.verifyContactPageTitleAfterScroll();

        // Kiểm tra nút Scroll to Top và tiêu đề trang trên FaqsPage
        faqsPage.verifyFaqsPageTitleAfterScroll();

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
