package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.UserAndGuest.*;
import utils.ConfigReader;

import java.time.Duration;

public class TC48_VerifyThatUsersCanReturnToTheHomePageFromAnyOtherPageByClickingOnTheSiteLogo {
    WebDriver driver;
    ConfigReader configReader;

    GeneralPage generalPage;
    HomePage homePage;
    LoginPage loginPage;
    page.UserAndGuest.RoomsPage roomsPage;
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
    public void VerifyThatUsersCanReturnToTheHomePageFromAnyOtherPageByClickingOnTheSiteLogo() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openHomePage();
        homePage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openRoomsPage();
        roomsPage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openAboutPage();
        aboutPage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openBlogsPage();
        blogsPage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openContactPage();
        contactUsPage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openFAQsPage();
        faQsPage.openLogoPage();
        softAssert.assertEquals(generalPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
