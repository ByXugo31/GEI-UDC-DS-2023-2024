package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilitiesTest {
    @Test
    void testIsValidString() {
        assertTrue(StringUtilities.isValidString("12345", "", 5));
        assertTrue(StringUtilities.isValidString("12345", "abcd", 5));
        assertTrue(StringUtilities.isValidString("a1b2a345", "abcd", 5));
        assertFalse(StringUtilities.isValidString("", "", 10));
        assertFalse(StringUtilities.isValidString("123", "", 10));
        assertFalse(StringUtilities.isValidString("aaaaa", "b", 4));
        assertFalse(StringUtilities.isValidString("", "abc", 0));
        assertFalse(StringUtilities.isValidString(null, "abc", 10));
    }

    @Test
    void lowercaseFirstTest() {
        assertEquals(StringUtilities.lowercaseFirst(""), "");
        assertEquals(StringUtilities.lowercaseFirst("ABC"), "ABC");
        assertEquals(StringUtilities.lowercaseFirst("abc"), "abc");
        assertEquals(StringUtilities.lowercaseFirst("ABCabc"), "abcABC");
        assertEquals(StringUtilities.lowercaseFirst("AaBbCc"), "abcABC");
    }

    @Test
    void checkStatsTest() {
        assertTrue(StringUtilities.checkTextStats("Había una vez", 3, 4));
        assertTrue(StringUtilities.checkTextStats("Software", 8, 8));
        assertFalse(StringUtilities.checkTextStats("Programar en Java no está tan mal", 3, 4));
        assertFalse(StringUtilities.checkTextStats("Había una vez", 4, 5));
        assertFalse(StringUtilities.checkTextStats("Había una vez", 2, 3));
        assertThrows(IllegalArgumentException.class, () -> StringUtilities.checkTextStats(null, 1,10));
        assertThrows(IllegalArgumentException.class, () -> StringUtilities.checkTextStats("", 1,10));
        assertThrows(IllegalArgumentException.class, () -> StringUtilities.checkTextStats("Java", -1,10));
        assertThrows(IllegalArgumentException.class, () -> StringUtilities.checkTextStats("Java", 1,0));
    }
}
