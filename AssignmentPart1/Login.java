import java.util.Scanner;
import java.util.regex.Pattern;

public class Login {
    public static void main(String[] args) {

        // Create Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter first name
        System.out.println("Enter First name");
        String name = scanner.nextLine();

        // Ask user to enter last name
        System.out.println("Enter lastName");
        String lastName = scanner.nextLine();

        // Ask user to enter username
        System.out.println("Please enter userName");
        String userName = scanner.nextLine();

        // Validate username:
        // Must contain underscore and be 5 characters or less
        if (userName.contains("_") && userName.length() <= 5) {
            System.out.println("Username successfully captured");

        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        // Ask user to enter password
        System.out.println("Please enter the password");
        String password = scanner.nextLine();

        // Validate password complexity:
        // - at least 8 characters
        // - contains uppercase letter
        // - contains special character
        if (password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[1-20].*") &&
                password.matches(".*[#%!$].*")) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password is not correctly, formatted, please insure that the password contains atleast eight characters,a capital letter, a number and a special character");
        }

        // Ask user to enter cellphone number
        System.out.println("Please enter cellphone number");
        String number = scanner.nextLine();

        // Validate international cellphone format
        if (number.matches("^\\+[1-9]\\d{0,2}\\d{1,10}$")) {
            System.out.println("Cellphone number successfully added");
        } else {
            System.out.println("Cellphone number incorrectly formatted, or does not contain international code");
        }

        // Final login check:
        // Only proceeds if username and password meet requirements
        if (userName.contains("_") && userName.length() <= 5 && password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[1-20].*") &&
                password.matches(".*[#%!$].*")) {

            // Welcome message after successful validation
            System.out.println("Welcome" + name + " " + lastName + " " + " it is great to see you again");
        }
    }
}