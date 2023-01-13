package gr.aueb;

import org.jetbrains.annotations.NotNull;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {
    //HashMap of users
    private static HashMap<String, User> createdUsers = new HashMap<>();
    /* Username and Password are the UID's (the username is unique)
     * The rest are required for creating the account
     */
    private final String username; //usernames cant change. set as final
    private final String surname;
    private final String email;
    private final String dateOfBirth;
    private String password;
    private String name;
    //List of messages sent to user
    private ArrayList<Message> unseenMessages = new ArrayList<>();

    // Constructor used to create object User
    //(only useful when used through the two subclasses)
    public User(final String un, final String pw, final String n,
                final String sn, final String em, final String db) {
        username = un;
        password = pw;
        name = n;
        surname = sn;
        email = em;
        dateOfBirth = db;
        createdUsers.put(username, this);
    }

    //Method takes a username and checks if a user with that username
    // exists
    public static void checkUserExistence(final String username)
            throws GeneralSecurityException {
        User checkedUser = createdUsers.get(username);
        if (checkedUser == null) {
            throw new GeneralSecurityException(
                    "Username " + username + " is incorrect \n");
        }
    }

    //When called upon with a set of credentials this method will return
    //the object which relates to the user
    //If no such user exists it will return null
    //If an incorrect password is given it will throw a
    //GeneralSecurityException
    @NotNull
    public static User login(final String username, final String password)
            throws GeneralSecurityException {
        checkUserExistence(username);
        User currentUser = createdUsers.get(username);
        if (currentUser.getPasswordValidity(password)) {
            return currentUser;
        } else {
            throw new GeneralSecurityException(
                    "Password `" + password + "` is incorrect for user "
                            + username + "\n");
        }
    }

    //Gives User object using hashmap
    protected static User getUserFromUsername(final String username) {
        return createdUsers.get(username);
    }

    public final String getUsername() {
        return username;
    }

    //Checks if password given is valid (used for logging in)
    public final boolean getPasswordValidity(final String pass) {
        return Objects.equals(pass, password);
    }

    public final void setPassword(final String oldPassword,
                                  final String newPassword)
            throws GeneralSecurityException {
        if (getPasswordValidity(oldPassword)) {
            password = newPassword;
        } else {
            throw new GeneralSecurityException(
                    "Password `" + oldPassword + "` is incorrect for user "
                            + username);
        }
    }

    //Validates password and then changes the name
    public final void setName(final String newName,
                              final String givenPassword)
            throws GeneralSecurityException {
        if (getPasswordValidity(givenPassword)) {
            name = newName;
        } else {
            throw new GeneralSecurityException("Password `" + givenPassword
                    + "` is incorrect for user " + username);
        }
    }

    public final String getName() {
        return name;
    }

    public final String getSurname() {
        return surname;
    }

    public final String getEmail() {
        return email;
    }

    public final String getDateOfBirth() {
        return dateOfBirth;
    }

    //Empties the ArrayList that contains the messages and returns them
    public final ArrayList<Message> getNewMessages() {
        ArrayList<Message> unseenMessagesCopy =
                new ArrayList<>(unseenMessages);
        unseenMessages.clear();
        return unseenMessagesCopy;
    }

    //Adds a new message directed towards the User
    public final void addNewMessage(final Message directedMessage) {
        unseenMessages.add(directedMessage);
    }

    //Informs user of their UID
    @Override
    public String toString() {
        return String.format("Your username is %s.", username);
    }
}
