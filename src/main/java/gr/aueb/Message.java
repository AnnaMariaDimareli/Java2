package gr.aueb;

import java.util.Scanner;

public class Message {

    private static int numberOfMessages;
    private int messageNumber = numberOfMessages;
    private User receiver;
    private User sender;
    private String contents;

    public Message(User receiver, User sender, String contents) {
            this.receiver = receiver;
            this.sender = sender;
            numberOfMessages++;
            this.contents = contents;
    }
    /* The second constructor should be used for Automated messages
     */
    public Message(User receiver, User sender, String creator, String email) {
            this.receiver = receiver;
            this.sender = sender;
            numberOfMessages++;
            contents = this.sendAutomatedMessage(creator, email);
    }

    public Message(User receiver, User sender) {
            this.receiver = receiver;
	    this.sender = sender;
	    numberOfMessages++;
    }

    public String toString() {
            return  "The receiver is " + this.getReceiver() + ",  the sender is " + this.getSender() + " and the message is " + contents;
    }

    public void enterMessage() {
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter your message:");
	    contents = input.nextLine();
    }

    public void showMessage() {
            System.out.println(this.getSender);
            System.out.println(contents);
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

    public void addUnseenMessage() {
            receiver.unseenMessages.add(this);
    }

    public String getSender() {
            return sender.getUsername();
    }

    public String getReceiver() {
            return receiver.getUsername();
    }

    public int getMessageNumber() {
            return messageNumber;
    }

    public String getContents() {
            return contents;
    }
    public static int getNumberOfMessages() {
            return numberOfMessages;
    }
}
