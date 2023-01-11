package gr.aueb;

public class Message {

    private static int numberOfMessages;
    private final int messageNumber = numberOfMessages;
    private final User receiver;
    private final User sender;
    private final String contents;

    public Message(final User rec, final User sen, final String cont) {
            receiver = rec;
            sender = sen;
            numberOfMessages++;
            contents = cont;
    }

    public final String toString() {
            return  "The receiver is " + this.getReceiver()
                    + ",  the sender is " + this.getSender()
                    + " and the message is " + this.getContents();
    }

    public final void showMessage() {
            System.out.println(this.getSender());
            System.out.println(this.getContents());
    }

    public final void addUnseenMessage() {
            receiver.addNewMessage(this);
    }

    public final String getSender() {
            return sender.getUsername();
    }

    public final String getReceiver() {
            return receiver.getUsername();
    }

    public final int getMessageNumber() {
            return messageNumber;
    }

    public final String getContents() {
            return contents;
    }
    public static int getNumberOfMessages() {
            return numberOfMessages;
    }
}
