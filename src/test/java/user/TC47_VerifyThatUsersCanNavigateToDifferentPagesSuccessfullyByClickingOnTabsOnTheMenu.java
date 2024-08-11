package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.user.HomePage;
import page.user.LoginPage;
import page.user.NavigationBarPage;
import page.user.SelectRoomPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC47_VerifyThatUsersCanNavigateToDifferentPagesSuccessfullyByClickingOnTabsOnTheMenu {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    NavigationBarPage navigationBarPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        navigationBarPage=new NavigationBarPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatUsersCanNavigateToDifferentPagesSuccessfullyByClickingOnTabsOnTheMenu () {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        navigationBarPage.clickLogo();
        softAssert.assertEquals(navigationBarPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarPage.clickHome();
        softAssert.assertEquals(navigationBarPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarPage.clickRooms();
        softAssert.assertEquals(navigationBarPage.getH2Header(),"Rooms","Wrong H2 header");

        navigationBarPage.clickAbout();
        softAssert.assertEquals(navigationBarPage.getH2Header(),"About Us","Wrong H2 header");

        navigationBarPage.clickBlogs();
        softAssert.assertEquals(navigationBarPage.getH2Header(),"Our Blogs","Wrong H2 header");

        navigationBarPage.clickContact();
        softAssert.assertEquals(navigationBarPage.getH2Header(),"Contact Us","Wrong H2 header");

        navigationBarPage.clickFaqs();
        softAssert.assertEquals(navigationBarPage.getH2Header(),"FAQ","Wrong H2 header");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
