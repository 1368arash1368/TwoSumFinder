package test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.Test;
import rahkar.ir.TwoSumChecker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumCheckerTest {

    @Test
    public void testHasTwoSumExists() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertTrue("باید دو عدد با مجموع 9 وجود داشته باشد.", TwoSumChecker.hasTwoSum(numbers, 9));
    }

    @Test
    public void testHasTwoSumNotExists() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertFalse("نباید دو عدد با مجموع 20 وجود داشته باشد.", TwoSumChecker.hasTwoSum(numbers, 20));
    }

    @Test
    public void testNullList() {
        assertThrows(IllegalArgumentException.class, () -> TwoSumChecker.hasTwoSum(null, 5));
    }

    @Test
    public void testEmptyList() {
        List<Integer> numbers = Collections.emptyList();
        assertThrows(IllegalArgumentException.class, () -> TwoSumChecker.hasTwoSum(numbers, 5));
    }

    @Test
    public void testSingleElementList() {
        List<Integer> numbers = Arrays.asList(4);
        assertThrows(IllegalArgumentException.class, () -> TwoSumChecker.hasTwoSum(numbers, 8));
    }

    @Test
    public void testHasTwoSumWithDuplicateNumbers() {
        List<Integer> numbers = Arrays.asList(3, 3);
        assertTrue("باید دو عدد 3 موجود باشد که مجموعشان برابر 6 شود.", TwoSumChecker.hasTwoSum(numbers, 6));
    }

    @Test
    public void testNegativeNumbers() {
        List<Integer> numbers = Arrays.asList(-3, -1, 4, 6);
        assertTrue("باید دو عدد -3 و 6 مجموعشان برابر 3 شود.", TwoSumChecker.hasTwoSum(numbers, 3));
    }

    @Test
    public void testHasTwoSumWithZero() {
        List<Integer> numbers = Arrays.asList(-3, 0, 3, 5);
        assertTrue("باید دو عدد 0 و 3 موجود باشد که مجموعشان برابر 3 شود.", TwoSumChecker.hasTwoSum(numbers, 3));
    }
}
