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
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactPage contactPage;
    FaqsPage faqsPage;
    BasePage basePage;
    SoftAssert softAssert;
    SetUp setUp;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        setUp = new SetUp();
        driver.get(setUp.getUrl());
        driver.manage().window().maximize();
        // Khởi tạo đối tượng
        homePage = new HomePage(driver);
        roomsPage = new RoomsPage(driver);
        aboutPage = new AboutPage(driver);
        blogsPage = new BlogsPage(driver);
        contactPage = new ContactPage(driver);
        faqsPage = new FaqsPage(driver);
        basePage = new BasePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC1() {

        // Kiểm tra tiêu đề trang Home
        homePage.navigateToHomePage();
        Assert.assertEquals(homePage.getPageTitleText(), "Best Hotel to stay", "The Home page title does not match!");

        // Kiểm tra tiêu đề trang Rooms
        roomsPage.navigateToRoomsPage();
        softAssert.assertEquals(roomsPage.getPageTitleText(), "Rooms", "The Rooms page title does not match!");

        // Kiểm tra tiêu đề trang About
        aboutPage.navigateToAboutPage();
        softAssert.assertEquals(aboutPage.getPageTitleText(), "About Us", "The About page title does not match!");

        // Kiểm tra tiêu đề trang Blogs
        blogsPage.navigateToBlogsPage();
        softAssert.assertEquals(blogsPage.getPageTitleText(), "Our Blogs", "The Blogs page title does not match!");

        // Kiểm tra tiêu đề trang Contact
        contactPage.navigateToContactPage();
        softAssert.assertEquals(contactPage.getPageTitleText(), "Contact Us", "The Contact page title does not match!");

        // Kiểm tra tiêu đề trang FAQs
        faqsPage.navigateToFaqsPage();
        softAssert.assertEquals(faqsPage.getPageTitleText(), "FAQ", "The FAQs page title does not match!");

        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
