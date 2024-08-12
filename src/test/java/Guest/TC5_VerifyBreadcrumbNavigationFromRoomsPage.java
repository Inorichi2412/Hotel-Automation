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

    // Phương thức để kiểm tra breadcrumb navigation
    public void verifyBreadcrumbNavigation(BasePage page) {
        // Click breadcrumb Home
        page.clickButtonBreadcrumbHome();
        // Xác minh rằng tiêu đề Home là chính xác
        String actualHomeTitle = homePage.getHomePageTitle();
        softAssert.assertEquals(actualHomeTitle, expectedHomeTitle, "Failed to navigate back to Home Page");
    }

    @Test
    public void TC5() {
        // Xác minh breadcrumb navigation cho từng trang
        roomsPage.navigateToHomePage();
        verifyBreadcrumbNavigation(roomsPage);

        aboutPage.navigateToHomePage();
        verifyBreadcrumbNavigation(aboutPage);

        blogsPage.navigateToHomePage();
        verifyBreadcrumbNavigation(blogsPage);

        contactPage.navigateToHomePage();
        verifyBreadcrumbNavigation(contactPage);

        faqsPage.navigateToHomePage();
        verifyBreadcrumbNavigation(faqsPage);


        // Kiểm tra tất cả các xác nhận
        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
