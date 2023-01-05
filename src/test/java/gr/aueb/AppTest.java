package gr.aueb;

import org.junit.Test;

import static gr.aueb.App.integerNotContainedInRange;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Only method which we can test reliably is integerNotContainedInRange()
     * Main is full of printing and looping making it impossible to test
     */
    @Test
    public void integerNotContainedInRangeTest() {
        // Test when x is less than from
        assertTrue(integerNotContainedInRange(10, 20, 5));

        // Test when x is greater than to
        assertTrue(integerNotContainedInRange(10, 20, 25));

        // Test when x is equal to from
        assertFalse(integerNotContainedInRange(10, 20, 10));

        // Test when x is equal to to
        assertFalse(integerNotContainedInRange(10, 20, 20));

        // Test when x is between from and to (exclusive)
        assertFalse(integerNotContainedInRange(10, 20, 15));
    }
}
