package Guest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.guest.HomePage;

import java.util.Properties;

public class TC1_VerifyGuestRedirectsToCorrespondingPagesOnTheAreaMenu {
    WebDriver driver;
    String url = "http://14.176.232.213:8084/";
    HomePage homePage;

    @BeforeMethod
    public void setUp () {
        //
        driver = new ChromeDriver();
        // tối ưu hóa cửa sổ trình duyệt
        driver.manage().window().maximize();
        //
        driver.get(url);
        //
        homePage = new HomePage(driver);
    }

    @Test
    public void TC1() {
        homePage.directionalMenu();
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
