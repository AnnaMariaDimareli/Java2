package gr.aueb;

public class Message {
    /* Message.java is responsible for the communication between the users.
     * It is used to create and show messages.
     */

    private static int numberOfMessages;
    private final User receiver;
    private final User sender;
    private final String contents;

    //Constructor used for creating a Message object
    public Message(final User rec, final User sen, final String cont) {
        receiver = rec;
        sender = sen;
        numberOfMessages++;
        contents = cont;
    }

    //Informs about the receiver, sender and contents of a message
    public final String toString() {
        return "The receiver is " + this.getReceiver()
                + ",  the sender is " + this.getSender()
                + " and the message is " + this.getContents();
    }

    //Shows a message in a more appealing fashion
    public final void showMessage() {
        System.out.println(this.getSender());
        System.out.println(this.getContents());
    }

    //Adds the message to the unseen messages of the receiver
    public final void addUnseenMessage() {
        receiver.addNewMessage(this);
    }

    public final String getSender() {
        return sender.getUsername();
    }

    public final String getReceiver() {
        return receiver.getUsername();
    }

    public final String getContents() {
        return contents;
    }
}
