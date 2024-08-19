package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.common.*;
import utils.ConfigReader;

import java.time.Duration;

public class TC47_VerifyThatUsersCanNavigateToDifferentPagesSuccessfullyByClickingOnTabsOnTheMenu {
    WebDriver driver;
    ConfigReader configReader;

    GeneralPage generalPage;
    HomePage homePage;
    LoginPage loginPage;
    page.common.RoomsPage roomsPage;
    AboutPage aboutPage;
    BlogsPage blogsPage;
    ContactUsPage contactUsPage;
    FAQsPage faQsPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();

        generalPage=new GeneralPage(driver);
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        roomsPage=new RoomsPage(driver);
        aboutPage=new AboutPage(driver);
        blogsPage=new BlogsPage(driver);
        contactUsPage=new ContactUsPage(driver);
        faQsPage=new FAQsPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatUsersCanNavigateToDifferentPagesSuccessfullyByClickingOnTabsOnTheMenu () {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openLogoPage();
        softAssert.assertEquals(homePage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openHomePage();
        softAssert.assertEquals(homePage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openRoomsPage();
        softAssert.assertEquals(roomsPage.getTitle(),"Rooms","Wrong H2 header");

        generalPage.openAboutPage();
        softAssert.assertEquals(aboutPage.getTitle(),"About Us","Wrong H2 header");

        generalPage.openBlogsPage();
        softAssert.assertEquals(blogsPage.getTitle(),"Our Blogs","Wrong H2 header");

        generalPage.openContactPage();
        softAssert.assertEquals(contactUsPage.getTitle(),"Contact Us","Wrong H2 header");

        generalPage.openFAQsPage();
        softAssert.assertEquals(faQsPage.getTitle(),"FAQ","Wrong H2 header");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
