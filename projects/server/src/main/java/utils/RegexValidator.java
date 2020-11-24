package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {
    private static final String NAME_VALIDATOR = "^[A-Z]+(([a-zA-Z ])?[a-zA-Z ]*)*$";
    private static final String PASSWORD_VALIDATOR = "^(?=[a-zA-Z]).{8,}$";

    public static boolean isNameValid(String name){
        return validateRegex(name,NAME_VALIDATOR);
    }

    public static boolean isPasswordValid(String password){
        return validateRegex(password,PASSWORD_VALIDATOR);
    }

    private static boolean validateRegex(String value,String REGEX){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }
}
