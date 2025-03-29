package edu.lytvyniuk;

import java.util.List;
import java.util.regex.Pattern;

/*
  @author darin
  @project romanToInteger
  @class CustomConverter
  @version 1.0.0
  @since 29.03.2025 - 20.28
*/
public class CustomConverter {

    // Regex to validate proper Roman numeral format
    private static final Pattern ROMAN_NUMERAL_PATTERN =
            Pattern.compile("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    // Set of valid Roman numeral characters
    private static final String VALID_ROMAN_CHARS = "IVXLCDM";


    public static int romanToArabic(String input) {
        if (input == null) {
            throw new NullPointerException("Roman numeral cannot be null");
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Roman numeral cannot be empty");
        }

        String romanNumeral = input.toUpperCase();

        if (romanNumeral.contains(" ")) {
            throw new IllegalArgumentException("Roman numeral cannot contain spaces");
        }

        if (romanNumeral.contains("-") || romanNumeral.contains("_") || romanNumeral.contains("|")) {
            throw new IllegalArgumentException("Roman numeral contains invalid special characters");
        }

        for (char c : romanNumeral.toCharArray()) {
            if (VALID_ROMAN_CHARS.indexOf(c) == -1) {
                throw new IllegalArgumentException("Roman numeral contains invalid characters: " + c);
            }
        }

        if (!ROMAN_NUMERAL_PATTERN.matcher(romanNumeral).matches()) {
            throw new IllegalArgumentException("Invalid Roman numeral format: " + input);
        }

        int result = 0;
        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        String remainingNumeral = romanNumeral;

        while ((remainingNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (remainingNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                remainingNumeral = remainingNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (remainingNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        if (result > 3999) {
            throw new IllegalArgumentException("Roman numeral exceeds maximum value of 3999");
        }

        return result;
    }
}
