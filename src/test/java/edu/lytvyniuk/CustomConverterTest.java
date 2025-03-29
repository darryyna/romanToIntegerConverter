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
*/class CustomConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenRomanIX_thenArabic9() {
        assertEquals(9, CustomConverter.romanToArabic("IX"));
    }

    @Test
    void whenRomanXIV_thenArabic14() {
        assertEquals(14, CustomConverter.romanToArabic("XIV"));
    }

    @Test
    void whenRomanXXIX_thenArabic29() {
        assertEquals(29, CustomConverter.romanToArabic("XXIX"));
    }

    @Test
    void whenRomanXL_thenArabic40() {
        assertEquals(40, CustomConverter.romanToArabic("XL"));
    }

    @Test
    void whenRomanXC_thenArabic90() {
        assertEquals(90, CustomConverter.romanToArabic("XC"));
    }

    @Test
    void whenRomanCD_thenArabic400() {
        assertEquals(400, CustomConverter.romanToArabic("CD"));
    }

    @Test
    void whenRomanCM_thenArabic900() {
        assertEquals(900, CustomConverter.romanToArabic("CM"));
    }

    @Test
    void whenRomanM_thenArabic1000() {
        assertEquals(1000, CustomConverter.romanToArabic("M"));
    }

    @Test
    void whenRomanMCMXCIV_thenArabic1994() {
        assertEquals(1994, CustomConverter.romanToArabic("MCMXCIV"));
    }

    @Test
    void whenRomanMMMCMXCIX_thenArabic3999() {
        assertEquals(3999, CustomConverter.romanToArabic("MMMCMXCIX"));
    }

}