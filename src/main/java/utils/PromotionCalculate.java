package utils;

import Models.Promotion;

public class PromotionCalculate {
    public static float calculate(float total, Promotion promotion) {
        // Gọi phương thức calculateDiscount từ lớp Promotion để tính giá trị giảm giá
        float discount = promotion.calculateDiscount(total);
        return total - discount;
    }
}
