package gr.aueb;

import org.junit.Test;

import java.security.GeneralSecurityException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {

    //We create a user we will need
    private final User testUser = new User("panos1b", "rdeolzcaq", "Panos",
            "Daskalopoulos", "alexdask1@icloud.com", "16-10-2003");

    @Test
    public void addNewMessageTest() {
        Message testMessage = new Message(testUser, testUser, "We in dis b***, finna get crunk, eyebrows on fleek");
        testUser.addNewMessage(testMessage);

        ArrayList<Message> unseenMessages = testUser.getNewMessages();
        assertFalse("ArrayList of messages empty! Even though a message was added", unseenMessages.isEmpty()); //array should not be empty
        assertTrue("Message was not added to ArrayList", unseenMessages.contains(testMessage));//array should contain message
    }

    @Test
    public void getUsernameTest() {
        assertEquals("Method not returning username!", "panos1b", testUser.getUsername());//username should match with what was inputted
    }

    @Test
    public void getNameTest() {
        assertEquals("Method not returning name!", "Panos", testUser.getName());//name should match with what was inputted
    }

    @Test
    public void getSurnameTest() {
        assertEquals("Method not returning surname!", "Daskalopoulos", testUser.getSurname());//surname should match with what was inputted
    }

    @Test
    public void getEmailTest() {
        assertEquals("Method not returning email!", "alexdask1@icloud.com", testUser.getEmail());//email should match with what was inputted
    }

    @Test
    public void getDateOfBirthTest() {
        assertEquals("Method not returning date of birth!", "16-10-2003", testUser.getDateOfBirth());//date of birth should match with what was inputted
    }

    @Test
    public void loginTest() {
        try {
            assertEquals("Login Unsuccessful", testUser, User.login("panos1b","rdeolzcaq"));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNewMessagesTest() {
        Message testMessage = new Message(testUser, testUser, "Filakia Vicki");
        testUser.addNewMessage(testMessage);
        ArrayList<Message> myUnseenMessages = new ArrayList<>();
        myUnseenMessages.add(testMessage);
        assertEquals("First Unseen Message is okay", myUnseenMessages.get(0), testUser.getNewMessages().get(0));
    }

    @Test
    public void toStringTest() {
        assertEquals("Method is not working properly!","Your username is panos1b.",testUser.toString());
    }

    @Test
    public void getUserFromUsernameTest() {
        assertEquals("Method does not get the right user!",testUser,User.getUserFromUsername("panos1b"));
        assertNull("Method returns non existent user!",User.getUserFromUsername("what da dog doing"));
    }
}
