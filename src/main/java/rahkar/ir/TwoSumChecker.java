package rahkar.ir;

import java.util.*;

public class TwoSumChecker {

    /**
     * بررسی می‌کند که آیا در لیست اعداد، دو عدد وجود دارد که مجموع آن‌ها برابر با target باشد.
     * همچنین دو عددی که مجموعشان برابر target است را چاپ می‌کند.
     *
     * @param numbers لیستی از اعداد (نمونه‌ای از Integer)
     * @param target عدد هدف که می‌خواهیم مجموع دو عدد برابر با آن شود.
     * @return true اگر دو عدد وجود داشته باشد که مجموعشان برابر target شود، در غیر این صورت false.
     * @throws IllegalArgumentException اگر لیست null باشد یا کمتر از دو عنصر داشته باشد.
     */
    public static boolean hasTwoSum(List<Integer> numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException("لیست اعداد نمی‌تواند null باشد.");
        }
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("لیست باید حداقل شامل دو عدد باشد.");
        }

        Map<Integer, Integer> seen = new HashMap<>(); // نقشه‌ای برای ذخیره اعداد و ایندکس‌هایشان
        for (int num : numbers) {
            int complement = target - num;
            if (seen.containsKey(complement)) {
                System.out.println("✅ دو عددی که مجموعشان برابر " + target + " است: " +
                        complement + " + " + num + " = " + target);
                return true;
            }
            seen.put(num, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("لطفاً لیست اعداد را با فاصله وارد کنید (مثلاً: 2 7 11 15): ");
            String numberInput = scanner.nextLine();

            // بررسی ورودی لیست اعداد
            List<Integer> numbers = parseNumberList(numberInput);
            if (numbers.isEmpty()) {
                System.out.println("❌ لیست اعداد نمی‌تواند خالی باشد.");
                return;
            }

            System.out.print("لطفاً عدد هدف را وارد کنید: ");
            String targetInput = scanner.nextLine();

            // بررسی ورودی عدد هدف
            int target = parseTarget(targetInput);
            if (target == Integer.MIN_VALUE) {
                return; // خطای ورودی قبلاً در parseTarget چاپ شده است.
            }

            // بررسی وجود دو عدد که مجموعشان برابر target شود
            boolean result;
            try {
                result = hasTwoSum(numbers, target);
                if (!result) {
                    System.out.println("❌ خیر، هیچ دو عددی در لیست وجود ندارد که مجموع‌شان برابر " + target + " شود.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("❌ خطا: " + ex.getMessage());
            }
        }
    }

    /**
     * تبدیل ورودی متنی کاربر به یک لیست از اعداد صحیح با اعتبارسنجی.
     *
     * @param input رشته‌ای از اعداد که با فاصله جدا شده‌اند.
     * @return لیستی از اعداد صحیح (اگر مقدار نامعتبر باشد، لیست خالی برمی‌گرداند).
     */
    private static List<Integer> parseNumberList(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input == null || input.trim().isEmpty()) {
            return numbers;
        }

        String[] tokens = input.trim().split("\\s+");
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException ex) {
                System.out.println("⚠️ مقدار نامعتبر: '" + token + "'. لطفاً فقط اعداد صحیح وارد کنید.");
                return Collections.emptyList();
            }
        }

        return numbers;
    }

    /**
     * تبدیل ورودی عدد هدف به مقدار صحیح با اعتبارسنجی.
     *
     * @param input مقدار متنی ورودی.
     * @return مقدار عدد صحیح یا `Integer.MIN_VALUE` در صورت نامعتبر بودن.
     */
    private static int parseTarget(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("❌ عدد هدف نمی‌تواند خالی باشد.");
            return Integer.MIN_VALUE;
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException ex) {
            System.out.println("❌ مقدار هدف نامعتبر است. لطفاً یک عدد صحیح وارد کنید.");
            return Integer.MIN_VALUE;
        }
    }
}
