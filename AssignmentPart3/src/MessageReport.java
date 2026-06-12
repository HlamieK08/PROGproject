import java.util.ArrayList;
import java.util.Scanner;

public class MessageReport {

    // Stores all messages
    static ArrayList<Message> messages = new ArrayList<>();

    //Allows manual entry of messages
    public static void addMessage() {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter message hash: ");
        String hash = input.nextLine();

        System.out.print("Enter recipient: ");
        String recipient = input.nextLine();

        System.out.print("Enter message: ");
        String text = input.nextLine();

        System.out.print("Enter flag: ");
        String flag = input.nextLine();

        messages.add(new Message(hash, recipient, text, flag));

        System.out.println("Message added successfully.");
    }

    //Display all messages in report format
    public static void displayReport() {

        for (Message m : messages) {

            System.out.println("Message Hash: " + m.messageHash);
            System.out.println("Recipient: " + m.recipient);
            System.out.println("Message: " + m.messageText);
            System.out.println("Flag: " + m.flag);
            System.out.println("-------------------");
        }
    }

    //Returns longest message text
    public static String longestMessage() {

        if (messages.isEmpty()) return "No messages";

        Message longest = messages.get(0);

        for (Message m : messages) {

            if (m.messageText.length() > longest.messageText.length()) {
                longest = m;
            }
        }

        return longest.messageText;
    }


    //Search messages by recipient
    public static ArrayList<String> searchByRecipient(String recipient) {

        ArrayList<String> results = new ArrayList<>();

        for (Message m : messages) {

            if (m.recipient.equals(recipient)) {
                results.add(m.messageText);
            }
        }

        return results;
    }

    //Search single message by recipient (first match)
    public static String searchMessage(String recipient) {

        for (Message m : messages) {

            if (m.recipient.equals(recipient)) {
                return m.messageText;
            }
        }

        return "Not found";
    }

    //Delete message by hash
    public static String deleteMessageByHash(String hash) {

        for (int i = 0; i < messages.size(); i++) {

            if (messages.get(i).messageHash.equals(hash)) {

                String msg = messages.get(i).messageText;
                messages.remove(i);

                return "Message: \"" + msg + "\" successfully deleted.";
            }
        }

        return "Message not found.";
    }

    //Menu system (no unit tests included)
    public static void menu() {

        Scanner input = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Message");
            System.out.println("2. Display Report");
            System.out.println("3. Longest Message");
            System.out.println("4. Search by Recipient");
            System.out.println("5. Delete by Message Hash");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addMessage();
                    break;

                case 2:
                    displayReport();
                    break;

                case 3:
                    System.out.println("Longest Message: " + longestMessage());
                    break;

                case 4:
                    System.out.print("Enter recipient: ");
                    String rec = input.nextLine();

                    ArrayList<String> results = searchByRecipient(rec);

                    if (results.isEmpty()) {
                        System.out.println("No messages found.");
                    } else {
                        for (String msg : results) {
                            System.out.println(msg);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter message hash to delete: ");
                    String hash = input.nextLine();

                    System.out.println(deleteMessageByHash(hash));
                    break;
            }

        } while (choice != 6);
    }

    public static void main(String[] args) {
        menu();
    }
}