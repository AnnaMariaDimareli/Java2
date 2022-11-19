import java.util.Scanner;

public class Message {

    private int messageNumber;
    private String receiver;
    private String sender;
    private boolean seen;
    private String contents;

    public Message(String receiver, String sender, String contents) {
        this.receiver = receiver;
        this.sender = sender;
        seen = false; 
        messageNumber++;
        this.contents = contents;
    }
    /* The second contructor should be used for Automated messages
     */
    public Message(String receiver, String sender, String creator, String email) { 
        this.receiver = receiver;
        this.sender = sender;
        seen = false;
        messageNumber++;
        contents = this.sendAutomatedMessage(creator, email);
    }

    public String toString() {
            return  "The receiver is " + receiver + ",  the sender is " + sender + " and the message is " + contents;

    }
    /* reply method provides the ability to enter the message to the user.
     */

    public String reply(String sender, String receiver) { // 
        this.sender = sender;
        this.receiver = receiver;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your message:");
        contents = input.nextLine();
        seen = false;
        messageNumber++;
        return this.toString();
    }
    /* sendAutomatedMessage method creates an automated message,
     * after an employee likes a post.
     * sendAutomatedMessage requires as a parameter the name and email of the post's creator.
     */
    public String sendAutomatedMessage(String creator, String email) { 
        String x = "Thank you for your interest in our job offering. You can send your cv in Mr/Mrs " + creator + " email: " + email; 
        System.out.println(x); 
        return x;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean getSeen() {
        return seen;
    }

    public String getSender() {
        return sender;
    }
    
    public String getReceiver() {
        return receiver;
    }


}
