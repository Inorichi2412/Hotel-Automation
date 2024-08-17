package page.UserAndGuest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

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
    //By roomsPageLink = By.xpath("//a[@href='/rooms']");
    String pageName = "/rooms";
    // Tiêu đề của trang Rooms
    By roomsPageTitleSelector = By.xpath("//h2[@class='page_title white-text']");

    //selector information
    By viewDetailsButtonSelector = By.xpath("//a[@class='btn btn-success float-right']");
    By addYourInfoFormSelector = By.xpath("//h4[text()='Add Your Informations :-']");
    By textBoxFullNameSelector = By.id("name");
    By textBoxEmailSelector = By.id("email");
    By textBoxPhoneSelector = By.id("phone");
    By textBoxAddressSelector = By.id("address");
    By checkBoxIAgreeSelector = By.xpath("//Strong[text()='Terms and Conditions']");
    By clickButtonSubmitRoomDetailsSelector =  By.xpath("//*[@id='user']/div/div[1]/div[6]/input");

    // selector ton tai phòng
    By itemDescriptionsSelector = By.xpath("//div[@class='pop_item_description']");

    // Selector name room
    By getConferenceRoomNameSelector = By.xpath("//section[2]//h5[1]");

    By availableRoomsSelector= By.xpath("//div[@class=\"most_pop_item_blog clearfix\"]");
    String rooms = "(//div[@class=\"most_pop_item_blog clearfix\"])[%s]";
    String viewDetailsButton = "(//a[@class=\"btn btn-success float-right\"])[%s]";
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

    // Phương thức Breadcrumb
    @Override
    public void navigateToHomePageFromBreadcrumb() {
        //Breadcrumb về Home Page
        super.navigateToHomePageFromBreadcrumb();
    }

    //TC2
    // Phương thức cuộn tới phần tử và nhấn nút View Details
    public void openDetailsView() {
        // Cuộn đến phần tử nút "Scroll to Top"
        WebElement scrollToTopButton = driver.findElement(buttonScrollToTopSelector);
        driverUtils.scrollToElement(scrollToTopButton);
        // Sau khi cuộn lên đầu trang, nhấn vào nút "View Details"
        driver.findElement(viewDetailsButtonSelector).click();
    }

    // Phương thức cuộn đến phần thông tin bổ sung trên trang
    public void scrollToAddInformationForm() {
        // Tìm phần tử của biểu mẫu thông tin bổ sung
        WebElement addInformationForm = driver.findElement(addYourInfoFormSelector);
        // Cuộn đến phần tử để đảm bảo nó nằm trong vùng nhìn thấy
        driverUtils.scrollToElement(addInformationForm);
    }

    // Nhập tên đầy đủ
    public void enterFullName(String fullName) {
        driver.findElement(textBoxFullNameSelector).sendKeys(fullName);
    }

    // Nhập địa chỉ email
    public void enterEmail(String email) {
        driver.findElement(textBoxEmailSelector).sendKeys(email);
    }

    // Nhập số điện thoại
    public void enterPhoneNumber(String phone) {
        driver.findElement(textBoxPhoneSelector).sendKeys(phone);
    }

    // Nhập địa chỉ
    public void enterAddress(String address) {
        driver.findElement(textBoxAddressSelector).sendKeys(address);
    }

    // Kiểm tra và chọn
    public void checkAndSelectIAgree() {
        WebElement checkBox = driver.findElement(checkBoxIAgreeSelector);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
    }

    // Nhập thông tin bổ sung và gửi
    public void fillAndSubmitAdditionalInformation(String fullName, String email, String phone, String address) {
        scrollToAddInformationForm();
        enterFullName(fullName);
        enterEmail(email);
        enterPhoneNumber(phone);
        enterAddress(address);
        checkAndSelectIAgree();
        driver.findElement(clickButtonSubmitRoomDetailsSelector).click();
    }

    // Phương thưc kiểm tra xem phần tử có đang được hiển thị trên trang không.
    public boolean isItemDescriptionsDisplayed() {
        return driver.findElement(itemDescriptionsSelector).isDisplayed();
    }

    // Phương thức get tên phòng
    public String getConferenceRoomName() {
        WebElement conferenceRoomName =  driver.findElement(getConferenceRoomNameSelector);
        return  conferenceRoomName.getText();
    }

}
