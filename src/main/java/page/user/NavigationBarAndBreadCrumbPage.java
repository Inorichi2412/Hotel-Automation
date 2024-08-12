package page.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarAndBreadCrumbPage {
    WebDriver driver;

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

    public void clickLogo() {
        driver.findElement(logoLinkSelector).click();
    }

    public void clickHome() {
        driver.findElement(homeLinkSelector).click();
    }

    public void clickRooms() {
        driver.findElement(roomsLinkSelector).click();
    }

    public void clickAbout() {
        driver.findElement(aboutLinkSelector).click();
    }

    public void clickBlogs() {
        driver.findElement(blogsLinkSelector).click();
    }

    public void clickContact() {
        driver.findElement(contactLinkSelector).click();
    }

    public void clickFaqs() {
        driver.findElement(faqsLinkSelector).click();
    }

    public void clickHomeBreadCrumb() {
        driver.findElement(homeBreadCrumbSelector).click();
    }

    public String getH1Header(){
        return driver.findElement(h1HeaderSelector).getText();
    }

    public String getH2Header(){
        return driver.findElement(h2HeaderSelector).getText();
    }

    public NavigationBarAndBreadCrumbPage(WebDriver driver) {
        this.driver = driver;
    }
}
