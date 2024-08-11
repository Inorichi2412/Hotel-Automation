package utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class BookingDataGenerator {
    private Faker faker;
    private DateTimeFormatter dateFormatter;

    public BookingDataGenerator() {
        faker = new Faker();
        dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    }

    public String generateCheckInDate() {
        LocalDate checkInDate = LocalDate.now().plusDays(faker.number().numberBetween(1, 30));
        return checkInDate.format(dateFormatter);
    }

    public String generateCheckOutDate(String checkInDateStr) {
        LocalDate checkInDate = LocalDate.parse(checkInDateStr, dateFormatter);
        LocalDate checkOutDate = checkInDate.plusDays(faker.number().numberBetween(1, 14));
        return checkOutDate.format(dateFormatter);
    }

    public String generateAdults() {
        int adults = faker.number().numberBetween(1, 4);
        return String.valueOf(adults);
    }

    // chuyen ve int
    public String generateChildren() {
        int children = faker.number().numberBetween(0, 3);
        return String.valueOf(children);
    }

    public String generateFullName() {
        return faker.name().fullName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String generateAddress() {
        return faker.address().fullAddress();
    }

    public static void main(String[] args) {
        BookingDataGenerator generator = new BookingDataGenerator();
        // thông tin search
        String checkInDate = generator.generateCheckInDate();
        String checkOutDate = generator.generateCheckOutDate(checkInDate);
        String adults = generator.generateAdults();
        String children = generator.generateChildren();
        System.out.println("Check In: " + checkInDate);
        System.out.println("Check Out: " + checkOutDate);
        System.out.println("Adults: " + adults);
        System.out.println("Children: " + children);
        // thông tin guest
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
