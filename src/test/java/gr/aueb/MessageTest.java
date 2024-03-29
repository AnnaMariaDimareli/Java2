package gr.aueb;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MessageTest {

    private final User testUser1 = new User("panos1b", "rdeolzcaq", "Panos",
            "Daskalopoulos", "alexdask1@icloud.com", "16-10-2003");
    private final User testUser2 = new User("Greg", "gfsdrdfg", "Gregory",
            "Terzidis", "gregterzidis@gmail.com", "19-04-20003");
    private Message testMessage;

    @Before
    public void setUp() {
        testMessage = new Message(testUser1, testUser2,
                "L + Ratio + You fell off + maidenless");
    }

    @Test
    public void constructorTest() {
        assertEquals("failure - does not assign correct Receiver!", "panos1b", testMessage.getReceiver());
        assertEquals("failure - does not assign correct Sender!", "Greg", testMessage.getSender());
        assertEquals("failure - does not assign correct Contents!", "L + Ratio + You fell off + maidenless", testMessage.getContents());

    }

    @Test
    public void toStringTest() {
        assertEquals("Wrong toString!",
                "The receiver is panos1b,  the sender is Greg and the message is L + Ratio + You fell off + maidenless",
                testMessage.toString());
    }

    @Test
    public void addUnseenMessageTest() {
        testMessage.addUnseenMessage();

        ArrayList<Message> unseenMessages = testUser1.getNewMessages();
        assertFalse("ArrayList of messages empty! Even though a message was added", unseenMessages.isEmpty()); //array should not be empty
        assertTrue("Message was not added to ArrayList", unseenMessages.contains(testMessage));//array should contain message
    }

    @Test
    public void getSenderTest() {
        assertEquals("Method is not returning Sender!", "Greg", testMessage.getSender());
    }

    @Test
    public void getReceiverTest() {
        assertEquals("Method is not returning Receiver!", "panos1b", testMessage.getReceiver());
    }

    @Test
    public void getContentsTest() {
        assertEquals("Method is not returning Contents!", "L + Ratio + You fell off + maidenless", testMessage.getContents());
    }


}
