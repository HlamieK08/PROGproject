public class Message {

    String messageHash;
    String recipient;
    String messageText;
    String flag;

    // Constructor
    public Message(String messageHash, String recipient, String messageText, String flag) {
        this.messageHash = messageHash;
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Message Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + messageText +
                "\nFlag: " + flag;
    }
}