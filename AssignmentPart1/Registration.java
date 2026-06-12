import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {

        // Create a Scanner object to read user input from keyboard
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter userName");
        String userName = scanner.nextLine();

        // Check if username contains underscore and is not more than 5 characters
        if (userName.contains("_") && userName.length() <= 5) {
            System.out.println("Username successfully captured");

        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        System.out.println("Please enter the password");
        String password = scanner.nextLine();

        // Check password complexity:
        // - at least 8 characters
        // - contains at least one uppercase letter
        // - contains a special character
        if (password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[1-20].*") &&
                password.matches(".*[#%!$].*")) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly, formatted, please insure that the password contains atleast eight characters,a capital letter, a number and a special character");
        }

        System.out.println("Please enter cellphone number");
        String number = scanner.nextLine();

        // Check if number matches international format,starts with + followed by country code and number:

        if (number.matches("^\\+[1-9]\\d{0,2}\\d{1,10}$")) {
            System.out.println("Cellphone number successfully added");
        } else {
            System.out.println("Cellphone number incorrectly formatted, or does not contain international code");
        }
    }
}