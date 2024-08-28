package page.common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static utils.DriverUtils.scrollToElement;

public class RoomsPage extends GeneralPage {

    ConfirmPage confirmPage;

    // Constructor của lớp RoomsPage
    public RoomsPage(WebDriver driver) {
        super(driver);
        // Khởi tạo ConfirmPage với cùng một driver
        this.confirmPage = new ConfirmPage(driver);
        this.driver = driver;
    }

    // Selector cho nút điều hướng đến trang Rooms
    String pageName = "/rooms";

    //selector information
    By viewDetailsButtonSelector = By.xpath("//a[@class='btn btn-success float-right']");

    // Selecotr
    By itemDescriptionsSelector = By.xpath("//div[@class='pop_item_description']");
    By availableRoomsSelector= By.xpath("//div[@class='most_pop_item_blog clearfix']");
    String rooms = "(//div[@class='most_pop_item_blog clearfix'])[%s]";
    String viewDetailsButton = "(//a[@class='btn btn-success float-right'])[%s]";
    String roomName ="(//h5)[%s]";

    public boolean isHaveAvailableRoomsDisplayed() {
        return driver.findElement(availableRoomsSelector).isDisplayed();
    }

    public int getNumberOfAvailableRooms() {
        List<WebElement> rooms = driver.findElements(availableRoomsSelector);
        return rooms.size();
    }

    public boolean isViewDetailsButtonDisplayedForRoom(int roomIndex) {
        By viewDetailsButtonSelector = By.xpath(String.format(this.viewDetailsButton, roomIndex));
        List<WebElement> elements = driver.findElements(viewDetailsButtonSelector);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public void checkViewDetailsButtonForAllRooms(SoftAssert softAssert) {
        int numberOfRooms = getNumberOfAvailableRooms();
        for (int roomIndex = 1; roomIndex <= numberOfRooms; roomIndex++) {
            boolean isButtonDisplayed = isViewDetailsButtonDisplayedForRoom(roomIndex);
            softAssert.assertTrue(isButtonDisplayed, "View detail not available for room " + roomIndex);
        }
    }

    public String openRoomByIndex(int roomIndex) {
        String roomNameByIndex=getRoomsNameByIndex(roomIndex);
        By viewDetailsButtonSelector = By.xpath(String.format(this.viewDetailsButton, roomIndex));
        driver.findElement(viewDetailsButtonSelector).click();
        return roomNameByIndex;
    }

    public String getRoomsNameByIndex(int roomIndex) {
        By roomNameSelector=By.xpath(String.format(this.roomName,roomIndex));
        return driver.findElement(roomNameSelector).getText();
    }

    // Phương thức điều hướng đến trang Rooms
    public void navigateToRoomsPage() {
        super.navigateToPage(pageName);
    }

    // Phương thưc kiểm tra xem phần tử có đang được hiển thị trên trang không.
    public boolean isItemDescriptionsDisplayed() {
        try {
            return driver.findElement(itemDescriptionsSelector).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("ItemDescriptions element not found.");
            return false;
        }
    }

    // Phương thức cuộn tới phần tử và nhấn nút View Details
    public void openDetailsView() {
        // Cuộn đến phần tử nút "Scroll to Top"
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        scrollToElement(driver, scrollToTopButton);
        // Sau khi cuộn lên đầu trang, nhấn vào nút "View Details"
        driver.findElement(viewDetailsButtonSelector).click();
    }
}
