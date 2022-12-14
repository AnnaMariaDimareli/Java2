package gr.aueb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.Assert.*;

public class UserTest {

    //We create a user we will need
    private final User testUser = new User("panos1b", "rdeolzcaq", "Panos",
            "Daskalopoulos", "alexdask1@icloud.com", "16-10-2003");

    @Test
    public void addNewMessageTest() {
        Message testMessage = new Message(testUser, testUser, "We in dis b***, finna get crunk, eyebrows on fleek");
        testUser.addNewMessage(testMessage);

        ArrayList<Message> unseenMessages = testUser.getGetUnseenMessages();
        assertFalse("ArrayList of messages empty! Even though a message was added", unseenMessages.isEmpty()); //array should not be empty
        assertTrue("Message was not added to ArrayList", unseenMessages.contains(testMessage));//array should contain message
    }

    @Test
    public void getUsernameTest() {
        assertEquals("Method not returning username!", "panos1b", testUser.getUsername());//username should match with what was inputted
    }
}
