import java.util.Scanner;

public class Input {
    //private String UserName;

    // Checking if username contains underscore and is 5 characters or less
    public boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() <= 5;
    }

    // Checking password complexity:
    // - at least 8 characters
    // - contains at least one uppercase letter
    // - contains at least one special character
    public boolean checkPasswordComplexity(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[1-20].*") &&
                password.matches(".*[#%!$].*");
    }

    // Registering user based on username and password validation rules
    public String registerUser(String userName, String password) {
        if (userName == null || !(userName.contains("_") && userName.length() <= 5)) {
            return "The userName is incorrectly formatted";
        } else if (!checkPasswordComplexity(password)) {
            return "The password does not meet the complexity requirements";
        } else {
            return "The two above conditions have been met, and the user has been registered successfully";
        }
    }

    // Checking if phone number follows international format
    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+[1-9]\\d{0,2}\\d{1,10}$");
    }

    // Validating login credentials
    public boolean loginUser(String userName, String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") &&
                password.matches(".*[#%!$&@].*");
    }

    // Returning login status message based on boolean result
    public String returnLoginStatus(boolean loginUser) {
        if (loginUser) {
            return "A successful login";
        } else {
            return "A failed login";
        }
    }

    // Main method to test registration output
    public static void main(String[] args) {
        Input obj = new Input();

        // Testing registerUser method with sample input
        System.out.println(obj.registerUser("kyl_1", "Kyle123$#"));
    }
}


