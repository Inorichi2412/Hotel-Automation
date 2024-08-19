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

public class TC49_VerifyThatTheUserCanReturnToTheHomePageByClickingOnHomeBreadcrumbs {
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
    public void VerifyThatTheUserCanReturnToTheHomePageByClickingOnHomeBreadcrumbs() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openRoomsPage();
        roomsPage.clickHomeBreadCrumb();
        softAssert.assertEquals(homePage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openAboutPage();
        aboutPage.clickHomeBreadCrumb();
        softAssert.assertEquals(aboutPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openBlogsPage();
        blogsPage.clickHomeBreadCrumb();
        softAssert.assertEquals(blogsPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openContactPage();
        contactUsPage.clickHomeBreadCrumb();
        softAssert.assertEquals(contactUsPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        generalPage.openFAQsPage();
        faQsPage.clickHomeBreadCrumb();
        softAssert.assertEquals(faQsPage.getTitle(),"Best Hotel to stay","Wrong H1 header");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
