package rahkar.ir;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // دریافت لیست اعداد از کاربر
        System.out.print("لطفاً لیستی از اعداد صحیح را وارد کنید (با کاما از هم جدا کنید): ");
        String input = scanner.nextLine();

        // تبدیل ورودی به لیست از اعداد
        List<Integer> numbers = parseInputToList(input);

        // بررسی اعتبار لیست
        if (numbers == null || numbers.size() < 2) {
            System.out.println("لیست نامعتبر است. لطفاً حداقل دو عدد وارد کنید.");
            return;
        }

        // دریافت عدد هدف از کاربر
        System.out.print("عدد هدف را وارد کنید: ");
        int target;
        try {
            target = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ورودی نامعتبر است. لطفاً یک عدد صحیح وارد کنید.");
            return;
        }

        // بررسی وجود دو عدد که مجموعشان برابر هدف باشد
        boolean result = TwoSumChecker.hasTwoSum(numbers, target);
        if (result) {
            System.out.println("✅ بله! دو عدد در لیست وجود دارند که مجموع‌شان برابر " + target + " می‌شود.");
        } else {
            System.out.println("❌ خیر! هیچ دو عددی در لیست وجود ندارد که مجموع‌شان برابر " + target + " شود.");
        }
    }

    /**
     * متد برای تبدیل رشته ورودی کاربر به یک لیست از اعداد صحیح
     *
     * @param input رشته ورودی شامل اعداد جداشده با کاما
     * @return لیست اعداد صحیح یا `null` در صورت نامعتبر بودن ورودی
     */
    private static List<Integer> parseInputToList(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part.trim()));
            } catch (NumberFormatException e) {
                System.out.println("❌ مقدار '" + part + "' عدد صحیح نیست!");
                return null;
            }
        }

        return numbers;
    }
}