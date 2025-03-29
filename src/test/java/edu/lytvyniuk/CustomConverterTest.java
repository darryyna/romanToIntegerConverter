package edu.lytvyniuk;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author darin
  @project romanToInteger
  @class CustomConverterTest
  @version 1.0.0
  @since 29.03.2025 - 20.30
*/
class CustomConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            CustomConverter.romanToArabic(null);
        });
    }

    @Test
    public void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("");
        });
    }

    @Test
    public void testOutOfSetCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("XYZ");
        });
    }

    @Test
    public void testLowerCaseCharacters() {
        assertEquals(4, CustomConverter.romanToArabic("iv"));
    }

    @Test
    public void testSpacesInInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("X I V");
        });
    }

    @Test
    public void testTrashInput() {
        // "IIII" is not a valid Roman numeral (should be "IV")
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("IIII");
        });
    }

    @Test
    public void testCyrillicVsLatinXI() {
        // Cyrillic "ХІ" (Ukrainian) vs Latin "XI"
        String cyrillicXI = "ХІ"; // Cyrillic characters that look like XI
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic(cyrillicXI);
        });
    }

    @Test
    public void testLimitOf4000() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("MMMMI"); // 4001
        });
    }

    @Test
    public void testNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("-X");
        });
    }

    @Test
    public void testPipeSymbol() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("X|V");
        });
    }

    @Test
    public void testUnderscore() {
        assertThrows(IllegalArgumentException.class, () -> {
            CustomConverter.romanToArabic("X_V");
        });
    }

}