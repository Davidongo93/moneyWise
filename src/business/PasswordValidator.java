package business;

public class PasswordValidator {

    public static void validatePassword(String password, String confirmedPassword) throws PasswordValidationException {
        if (password.length() < 8) {
            throw new PasswordValidationException("Password must be at least 8 characters long.");
        }

        if (!containsUppercase(password)) {
            throw new PasswordValidationException("Password must contain at least one uppercase letter.");
        }

        if (!password.equals(confirmedPassword)) {
            throw new PasswordValidationException("Passwords do not match.");
        }
    }

    private static boolean containsUppercase(String s) {
        return s.chars().anyMatch(Character::isUpperCase);
    }
}
