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
import java.util.Random;

public class TC52_VerifyThatWhenTheUserClicksOnTheViewDetailButtonForARoomItJumpsToTheRoomsDetailPageCorrespondingToThatRoom {
    WebDriver driver;
    ConfigReader configReader;
    HomePage homePage;
    LoginPage loginPage;
    RoomsPage roomsPage;
    RoomDetailsPage roomDetailsPage;
    GeneralPage generalPage;

    SoftAssert softAssert;
    Random random;
    int roomIndex;
    String nameInRoomPage;
    String nameInRoomDetailPage;

    @BeforeMethod
    public void SetUp() {
        driver=new ChromeDriver();
        configReader=new ConfigReader();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        roomsPage=new RoomsPage(driver);
        roomDetailsPage=new RoomDetailsPage(driver);

        generalPage =new GeneralPage(driver);

        softAssert=new SoftAssert();

        driver.get(configReader.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        random=new Random();
        roomIndex=random.nextInt(12)+1;
    }

    @Test
    public void VerifyThatWhenTheUserClicksOnTheViewDetailButtonForARoomItJumpsToTheRoomsDetailPageCorrespondingToThatRoom() {

        homePage.openLoginForm();
        loginPage.login("vyvanviet","abc123");

        generalPage.openRoomsPage();

        nameInRoomPage=roomsPage.openRoomByIndex(roomIndex);

        nameInRoomDetailPage=roomDetailsPage.getRoomName();
        softAssert.assertEquals(nameInRoomPage,nameInRoomDetailPage,"Name of room is not same");

        softAssert.assertAll();

    }

    @AfterMethod
    public void CleanUp() {
        driver.quit();
    }
}
