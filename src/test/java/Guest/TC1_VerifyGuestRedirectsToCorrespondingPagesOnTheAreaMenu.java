package Guest;

import Config.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.*;

public class TC1_VerifyGuestRedirectsToCorrespondingPagesOnTheAreaMenu {
    WebDriver driver;
    HomePage homePage;
    RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactPage contactPage;
    FaqsPage faqsPage;
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
    }

    // Phương thức để kiểm tra tiêu đề trang
    private void verifyPageTitle(String expectedTitle, String actualTitle) {
        Assert.assertEquals(actualTitle, expectedTitle, "Failed to navigate to " + expectedTitle + " Page");
    }

    @Test
    public void TC1() {
        // Kiểm tra tiêu đề trang Home
        String homeTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homeTitle, "Best Hotel to stay", "Failed to verify Home Page title");

        // Kiểm tra tiêu đề trang Rooms
        String roomsTitle = roomsPage.getRoomsPageTitle();
        verifyPageTitle("Rooms", roomsTitle);

        // Kiểm tra tiêu đề trang About
        String aboutTitle = aboutPage.getAboutPageTitle();
        verifyPageTitle("About Us", aboutTitle);

        // Kiểm tra tiêu đề trang Blogs
        String blogsTitle = blogsPage.getBlogsPageTitle();
        verifyPageTitle("Our Blogs", blogsTitle);

        // Kiểm tra tiêu đề trang Contact
        String contactTitle = contactPage.getContactPageTitle();
        verifyPageTitle("Contact Us", contactTitle);

        // Kiểm tra tiêu đề trang FAQs
        String faqsTitle = faqsPage.getFaqsPageTitle();
        verifyPageTitle("FAQ", faqsTitle);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
