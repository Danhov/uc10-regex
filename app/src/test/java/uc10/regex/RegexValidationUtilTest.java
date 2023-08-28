package uc10.regex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexValidationUtilTest {

    int defaultMaxLength = 16;

    private static Stream<Arguments> generateInvalidStrings() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of(" "),
                Arguments.of("0Lh6b3gVxA\n%9A6"),
                Arguments.of("almostvalid12!"),
                Arguments.of("A1!")
        );
    }

    private static Stream<Arguments> generateValidStrings() {
        return Stream.of(
                Arguments.of("ValidString1$"),
                Arguments.of("Ab123}"),
                Arguments.of("0Lh6b**3gVxA%9A6"),
                Arguments.of("Atc5d11$!%86rn6N"),
                Arguments.of("u6%S4")
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidStrings")
    void validInputStringShouldReturnTrue(String validInputString) {
        boolean validationResult = RegexValidationUtil.validateAll(validInputString, defaultMaxLength);

        assertTrue(validationResult, "String being validated - " + validInputString);
    }

    @ParameterizedTest
    @MethodSource("generateInvalidStrings")
    void validInputStringShouldReturnFalse(String invalidInputString) {
        boolean validationResult = RegexValidationUtil.validateAll(invalidInputString, defaultMaxLength);

        assertFalse(validationResult, "String being validated - " + invalidInputString);
    }

    @Test
    void validateHasDigit() {
        assertTrue(RegexValidationUtil.validateHasDigit("Ab123"));
    }

    @Test
    void validateHasLoweCase() {
        assertTrue(RegexValidationUtil.validateHasLoweCase("Ab123"));
    }

    @Test
    void validateHasUpperCase() {
        assertTrue(RegexValidationUtil.validateHasUpperCase("Ab123"));
    }

    @Test
    void validateHasSpecialChar() {
        assertTrue(RegexValidationUtil.validateHasSpecialChar("Ab!123"));
    }

    @Test
    void validateMaxLength() {
        assertTrue(RegexValidationUtil.validateMaxLength("Ab123", 5));
    }

    @Test
    void validateNoWhitespaces() {
        assertTrue(RegexValidationUtil.validateNoWhitespaces("Ab123"));
    }
}
