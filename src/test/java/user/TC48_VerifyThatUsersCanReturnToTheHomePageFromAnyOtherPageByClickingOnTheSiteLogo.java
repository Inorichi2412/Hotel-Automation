package user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.user.HomePage;
import page.user.LoginPage;
import page.user.NavigationBarAndBreadCrumbPage;
import utils.ConfigReader;

import java.time.Duration;

public class TC48_VerifyThatUsersCanReturnToTheHomePageFromAnyOtherPageByClickingOnTheSiteLogo {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    NavigationBarAndBreadCrumbPage navigationBarAndBreadCrumbPage;

    SoftAssert softAssert;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        navigationBarAndBreadCrumbPage =new NavigationBarAndBreadCrumbPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void VerifyThatUsersCanReturnToTheHomePageFromAnyOtherPageByClickingOnTheSiteLogo() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        navigationBarAndBreadCrumbPage.clickHome();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarAndBreadCrumbPage.clickRooms();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarAndBreadCrumbPage.clickAbout();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarAndBreadCrumbPage.clickBlogs();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarAndBreadCrumbPage.clickContact();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        navigationBarAndBreadCrumbPage.clickFaqs();
        navigationBarAndBreadCrumbPage.clickLogo();
        softAssert.assertEquals(navigationBarAndBreadCrumbPage.getH1Header(),"Best Hotel to stay","Wrong H1 header");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
