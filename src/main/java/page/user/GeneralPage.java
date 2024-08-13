package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    By logoLinkSelector=By.xpath("(//a[@href=\"/\"])[1]");
    By homeLinkSelector=By.xpath("(//a[@href=\"/\"])[2]");
    By roomsLinkSelector= By.xpath("//a[@href=\"/rooms\"]");
    By aboutLinkSelector=By.xpath("//a[@href=\"/about\"]");
    By blogsLinkSelector=By.xpath("//a[@href=\"/blogs\"]");
    By contactLinkSelector=By.xpath("//a[@href=\"/contact\"]");
    By faqsLinkSelector=By.xpath("//a[@href=\"/faqs\"]");

    By h1HeaderSelector=By.xpath("//h1");
    By h2HeaderSelector=By.xpath("//h2[@class=\"page_title white-text\"]");

    By homeBreadCrumbSelector=By.xpath("//li[@class=\"breadcrumb-item\"]/a");

    public void openLogoPage() {
        driver.findElement(logoLinkSelector).click();
    }

    public void openHomePage() {
        driver.findElement(homeLinkSelector).click();
    }

    public void openRoomsPage() {
        driver.findElement(roomsLinkSelector).click();
    }

    public void openAboutPage() {
        driver.findElement(aboutLinkSelector).click();
    }

    public void openBlogsPage() {
        driver.findElement(blogsLinkSelector).click();
    }

    public void openContactPage() {
        driver.findElement(contactLinkSelector).click();
    }

    public void openFAQsPage() {
        driver.findElement(faqsLinkSelector).click();
    }

    public void clickHomeBreadCrumb() {
        driver.findElement(homeBreadCrumbSelector).click();
    }

    public String getTitle(){
        return driver.findElement(h2HeaderSelector).getText();
    }

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
