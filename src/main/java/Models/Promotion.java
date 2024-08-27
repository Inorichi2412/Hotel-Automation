package Models;

public class Promotion {
    private String promoCode;
    private float promoValue;
    private String prompType; // "FIXED" hoặc "PERCENTAGE"

    // Constructor, getters và setters
    public Promotion(String promoCode, float promoValue, String type) {
        this.promoCode = promoCode;
        this.promoValue = promoValue;
        this.prompType = type;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public float getPromoValue() {
        return promoValue;
    }

    public String getPrompType() {
        return prompType;
    }

    // Phương thức tính giá trị giảm giá
    public float calculateDiscount(float total) {
        if ("FIXED".equalsIgnoreCase(prompType)) {
            return promoValue;
        } else if ("PERCENTAGE".equalsIgnoreCase(prompType)) {
            return total * (promoValue / 100);
        }
        return 0;
    }

}


