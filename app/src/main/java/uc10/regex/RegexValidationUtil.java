package uc10.regex;

import java.util.regex.Pattern;

public class RegexValidationUtil {

    public static final String AT_LEAST_ONE_LOWERCASE = "\\A.*(?=[a-z]).*\\z";
    public static final String AT_LEAST_ONE_UPPERCASE = "\\A.*(?=[A-Z]).*\\z";
    public static final String AT_LEAST_ONE_DIGIT = "\\A.*(?=\\d).*\\z";
    public static final String ALLOWED_SPECIAL_CHARS = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~";
    public static final String AT_LEAST_ONE_SPECIAL_CHAR = "\\A.*(?=[" + Pattern.quote(ALLOWED_SPECIAL_CHARS) + "]).*\\z";
    public static final String NO_WHITE_SPACES = "\\A\\S++\\z";

    private RegexValidationUtil() {
    }

    public static boolean validateAll(String stringToValidate, int maxLength) {

        return validateNoWhitespaces(stringToValidate) &&
                validateMaxLength(stringToValidate, maxLength) &&
                validateHasSpecialChar(stringToValidate) &&
                validateHasDigit(stringToValidate) &&
                validateHasUpperCase(stringToValidate) &&
                validateHasLoweCase(stringToValidate);
    }

    public static boolean validateHasDigit(String stringToValidate) {
        Pattern hasDigit = Pattern.compile(AT_LEAST_ONE_DIGIT);

        return hasDigit.matcher(stringToValidate).matches();
    }

    public static boolean validateHasLoweCase(String stringToValidate) {
        Pattern hasLowerCase = Pattern.compile(AT_LEAST_ONE_LOWERCASE);

        return hasLowerCase.matcher(stringToValidate).matches();
    }

    public static boolean validateHasUpperCase(String stringToValidate) {
        Pattern hasUpperCase = Pattern.compile(AT_LEAST_ONE_UPPERCASE);

        return hasUpperCase.matcher(stringToValidate).matches();
    }

    public static boolean validateHasSpecialChar(String stringToValidate) {
        Pattern hasSpecialChar = Pattern.compile(AT_LEAST_ONE_SPECIAL_CHAR);

        return hasSpecialChar.matcher(stringToValidate).matches();
    }

    public static boolean validateMaxLength(String stringToValidate, int maxLength) {
        String maxLengthRegex = "^.{1," + maxLength + "}$";
        Pattern validLength = Pattern.compile(maxLengthRegex);
        return validLength.matcher(stringToValidate).matches();
    }

    public static boolean validateNoWhitespaces(String stringToValidate) {
        Pattern validLength = Pattern.compile(NO_WHITE_SPACES);

        return validLength.matcher(stringToValidate).matches();
    }
}
