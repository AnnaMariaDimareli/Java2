package gr.aueb;

import java.util.Scanner;

public class Message {

    private static int numberOfMessages;
    private final int messageNumber = numberOfMessages;
    private final User receiver;
    private final User sender;
    private String contents;

    public Message(User receiver, User sender, String contents) {
            this.receiver = receiver;
            this.sender = sender;
            numberOfMessages++;
            this.contents = contents;
    }

    public String toString() {
            return  "The receiver is " + this.getReceiver() + ",  the sender is " + this.getSender() + " and the message is " + contents;
    }

    public void enterMessage() {
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter your message:");
	    contents = input.nextLine();
    }// FIXME delete this?

    public void showMessage() {
            System.out.println(this.getSender());
            System.out.println(contents);
    }


    public void addUnseenMessage() {
            receiver.addNewMessage(this);
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
