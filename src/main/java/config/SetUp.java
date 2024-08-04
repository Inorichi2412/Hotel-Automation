package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.guest.HomePage;

public class SetUp {

    WebDriver driver;
    HomePage homePage;

    public  void setup() {
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
    }
}
