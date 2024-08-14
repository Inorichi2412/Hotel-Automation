package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookingDataGenerator {
    private Faker faker;
    private DateTimeFormatter dateFormatter;

    public BookingDataGenerator() {
        faker = new Faker();
        dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    }

    // Sinh ngày nhận phòng
    public String generateCheckInDate() {
        LocalDate checkInDate = LocalDate.now().plusDays(faker.number().numberBetween(1, 30));
        return checkInDate.format(dateFormatter);
    }

    // Sinh ngày trả phòng dựa trên ngày nhận phòng
    public String generateCheckOutDate(String checkInDateStr) {
        LocalDate checkInDate = LocalDate.parse(checkInDateStr, dateFormatter);
        LocalDate checkOutDate = checkInDate.plusDays(faker.number().numberBetween(1, 2));
        return checkOutDate.format(dateFormatter);
    }

    // Sinh số lượng người lớn
    public int generateAdults() {
        return faker.number().numberBetween(1, 2);
    }

    // Sinh số lượng trẻ em
    public int generateChildren() {
        return faker.number().numberBetween(1, 2);
    }

    // Sinh tên đầy đủ
    public String generateFullName() {
        return faker.name().fullName();
    }

    // Sinh địa chỉ email
    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    // Sinh số điện thoại
    public String generatePhone() {
        // Tạo số điện thoại ngẫu nhiên
        String randomPhoneNumber = faker.phoneNumber().phoneNumber();
        // Loại bỏ ký tự không phải số
        String phoneNumber = randomPhoneNumber.replaceAll("[^0-9]", "");
        if (phoneNumber.length() > 10) {
            // Lấy 10 chữ số cuối
            phoneNumber = phoneNumber.substring(phoneNumber.length() - 10);
        }
        return "0" + phoneNumber; // Thêm mã vùng Việt Nam (0) vào đầu
    }

    // Sinh địa chỉ
    public String generateAddress() {
        return faker.address().fullAddress();
    }

    public static void main(String[] args) {
        BookingDataGenerator generator = new BookingDataGenerator();
        // Thông tin tìm kiếm
        String checkInDate = generator.generateCheckInDate();
        String checkOutDate = generator.generateCheckOutDate(checkInDate);
        int adults = generator.generateAdults();
        int children = generator.generateChildren();
        System.out.println("Check In: " + checkInDate);
        System.out.println("Check Out: " + checkOutDate);
        System.out.println("Adults: " + adults);
        System.out.println("Children: " + children);
        // Thông tin guest
        String fullName = generator.generateFullName();
        String email = generator.generateEmail();
        String phone = generator.generatePhone();
        String address = generator.generateAddress();
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
    }
}
