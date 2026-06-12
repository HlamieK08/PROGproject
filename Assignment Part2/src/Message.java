import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class Message {

    //Arrays which will store messages
    static ArrayList<String> sentMessages = new ArrayList<>();
    static ArrayList<String> storedMessages = new ArrayList<>();

    //Attributes
    private String messageID;
    private String recipientCell;
    private String messageHash;
    private String messageText;
    int totalMessages;


    public Message(int totalMessages, String recipientCell, String printMessages) {

        //Generate ID with not more than 10 characters
        this.messageID = UUID.randomUUID().toString().replace("_", "").substring(0, 10);

        this.totalMessages = totalMessages;
        this.recipientCell = recipientCell;
        this.messageText = printMessages;
    }

    //Check message ID
    public boolean checkMessageID() {
        return messageID.length() <= 10;

    }

    //Checking Recipient Cell Number
    public String checkRecipientCell() {

        // Must contain international code and 10 characters
        if (recipientCell.startsWith("+") && recipientCell.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again";
        }
    }

    //Check Message Length
    public String checkMessageLength() {

        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {

            int exceeded = messageText.length() - 250;

            return "Message exceeds 250 characters by" + exceeded + ", please reduce the size";
        }
    }

    //Create message hash
    public String createMessageHash() {

        String firstTwo = messageID.substring(0, 2).toUpperCase();

        String[] words = messageText.split(" ");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        messageHash = firstTwo + ":" + firstWord + lastWord;

        return messageHash;
    }

    //Send/Store Disregard Message
    public String sentMessage() {

        Scanner input = new Scanner(System.in);

        System.out.println("Choose an option");
        System.out.println("1) Send Message");
        System.out.println("2 Disregard Message");
        System.out.println("3 Store Message");


        int choice = input.nextInt();

        switch (choice) {

            case 1:

                sentMessages.add(messageText);

                return "Message successfully sent.";

            case 2:

                return "Press 0 to delete the message";

            case 3:

                storeMessage();

                return "Message successfully stored.";

            default:

                return "Invalid option selected.";
        }
    }

    //Store message in JSON Style
    public void storeMessage() {

        String jsonMessage = "{"
                + "\"MessageID\":\"" + messageID + "\","
                + "\"Recipient\":\"" + recipientCell + "\","
                + "\"Message\":\"" + messageText + "\","
                + "\"MessageHash\":\"" + messageHash + "\""
                + "}";

        storedMessages.add(jsonMessage);

    }

    //Print all sent messages
    public static String printMessages() {

        if (sentMessages.isEmpty()) {

            return "No messages available.";

        }

        String output = "\nSent Messages\n";

        for (String msg : sentMessages) {

            output += msg + "\n";
        }
        return output;
    }

    //Return total messages
    public static int returnTotalMessages() {

        return sentMessages.size();
    }

    //Write Main Method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("********************");
        System.out.println("WELCOME TO QUICKCHAT");
        System.out.println("********************");

        System.out.print("How many messages would you like to send? ");
        int numberOfMessages = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numberOfMessages; i++) {

            System.out.println("\nEnter recipient cell number: ");
            String recipient = input.nextLine();

            System.out.println("Enter message: ");
            String message = input.nextLine();

            Message msg =
                    new Message(i + 1, recipient, message);

            //Message ID
            if (msg.checkMessageID()) {

                System.out.println("Message ID generated: "
                        + msg.messageID);

            } else {

                System.out.println("Message ID exceeds 10 characters.");
            }
            //Recipient validation
            System.out.println(msg.checkRecipientCell());

            //Message length validation
            System.out.println(msg.checkMessageLength());

            //Create and display hash
            System.out.println("Message Hash: "
                    + msg.createMessageHash());

            // Send/Store/Disregard
            System.out.println(msg.sentMessage());
        }

        //Display all sent Messages
        System.out.println(printMessages());

        //Display total Messages
        System.out.println("Total messages sent: "
                + returnTotalMessages());
    }
}