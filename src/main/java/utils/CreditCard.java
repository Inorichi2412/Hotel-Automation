package utils;

public class CreditCard {
    private String cardNumber;
    private String nameOnCard;
    private String expiryDate;
    private String cvvNumber;

    // Constructor
    public CreditCard(String cardNumber, String nameOnCard, String expiryDate, String cvvNumber) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expiryDate = expiryDate;
        this.cvvNumber = cvvNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public String toString() {
        return "CreditCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", cvvNumber='" + cvvNumber + '\'' +
                '}';
    }

    public static CreditCard getSampleCreditCard() {
        return new CreditCard("2222 3333 4444 9999", "MABU", "12/32", "123");
    }

}
