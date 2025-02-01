//package rahkar.ir;
//
//import java.util.*;
//
//public class TwoSumChecker2 {
//
//    /**
//     * بررسی می‌کند که آیا در لیست اعداد، دو عدد وجود دارد که مجموع آن‌ها برابر target باشد.
//     * همچنین **تمام** جفت‌هایی که این خاصیت را دارند نمایش می‌دهد.
//     *
//     * @param numbers لیستی از اعداد
//     * @param target عدد هدف
//     * @return true اگر حداقل یک جفت عدد با مجموع target وجود داشته باشد، false در غیر این صورت.
//     * @throws IllegalArgumentException اگر لیست null باشد یا کمتر از دو عنصر داشته باشد.
//     */
//    public static boolean hasTwoSum(List<Integer> numbers, int target) {
//        if (numbers == null) {
//            throw new IllegalArgumentException("لیست اعداد نمی‌تواند null باشد.");
//        }
//        if (numbers.size() < 2) {
//            throw new IllegalArgumentException("لیست باید حداقل شامل دو عدد باشد.");
//        }
//
//        Set<Integer> seen = new HashSet<>();
//        boolean found = false;  // بررسی کنیم که حداقل یک جفت پیدا شده باشد
//
//        for (int num : numbers) {
//            int complement = target - num;
//            if (seen.contains(complement)) {
//                System.out.println("✅ جفت عددی که مجموعشان برابر " + target + " است: " +
//                        complement + " + " + num + " = " + target);
//                found = true;
//            }
//            seen.add(num);
//        }
//        return found;
//    }
//
//    public static void main(String[] args) {
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("لطفاً لیست اعداد را با فاصله وارد کنید (مثلاً: 2 7 11 15): ");
//            String numberInput = scanner.nextLine();
//
//            List<Integer> numbers = parseNumberList(numberInput);
//            if (numbers.isEmpty()) {
//                System.out.println("❌ لیست اعداد نمی‌تواند خالی باشد.");
//                return;
//            }
//
//            System.out.print("لطفاً عدد هدف را وارد کنید: ");
//            String targetInput = scanner.nextLine();
//
//            int target = parseTarget(targetInput);
//            if (target == Integer.MIN_VALUE) {
//                return;
//            }
//
//            boolean result;
//            try {
//                result = hasTwoSum(numbers, target);
//                if (!result) {
//                    System.out.println("❌ هیچ جفت عددی پیدا نشد که مجموع‌شان برابر " + target + " باشد.");
//                }
//            } catch (IllegalArgumentException ex) {
//                System.out.println("❌ خطا: " + ex.getMessage());
//            }
//        }
//    }
//
//    private static List<Integer> parseNumberList(String input) {
//        List<Integer> numbers = new ArrayList<>();
//        if (input == null || input.trim().isEmpty()) {
//            return numbers;
//        }
//
//        String[] tokens = input.trim().split("\\s+");
//        for (String token : tokens) {
//            try {
//                numbers.add(Integer.parseInt(token));
//            } catch (NumberFormatException ex) {
//                System.out.println("⚠️ مقدار نامعتبر: '" + token + "'. لطفاً فقط اعداد صحیح وارد کنید.");
//                return Collections.emptyList();
//            }
//        }
//
//        return numbers;
//    }
//
//    private static int parseTarget(String input) {
//        if (input == null || input.trim().isEmpty()) {
//            System.out.println("❌ عدد هدف نمی‌تواند خالی باشد.");
//            return Integer.MIN_VALUE;
//        }
//        try {
//            return Integer.parseInt(input.trim());
//        } catch (NumberFormatException ex) {
//            System.out.println("❌ مقدار هدف نامعتبر است. لطفاً یک عدد صحیح وارد کنید.");
//            return Integer.MIN_VALUE;
//        }
//    }
//}
