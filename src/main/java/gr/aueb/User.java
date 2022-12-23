package gr.aueb;

import org.jetbrains.annotations.NotNull;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class User {

	/* Username and Password are the UID's (the username is unique)
	 * The rest are required for creating the account
	 */
	private final String username; //usernames cant change. set as final
	private String password;
	private String name;
	private final String surname;
	private final String email;
	private final String dateOfBirth;

	//List of messages sent to user
	private ArrayList<Message> unseenMessages = new ArrayList<>();

	//HashMap of users
	private static HashMap<String, User> createdUsers = new HashMap<>();

	// Constructor used to create object User (only useful when used through the two subclasses)
	public User(String username, String password, String name, String surname, String email, String dateOfBirth) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		createdUsers.put(username,this);
	}

	//Method takes a username and checks if a user with that username exists
	public static void checkUserExistence(String Username) throws GeneralSecurityException {
		User checkedUser = createdUsers.get(Username);
		if (checkedUser==null) {
			throw new GeneralSecurityException("Username " + Username + " is incorrect \n");
		}
	}

	//When called upon with a set of credentials this method will return the object which relates to the user
	//If no such user exists it will return null
	//If an incorrect password is given it will throw a GeneralSecurityException
	@NotNull
	public static User login(String username, String password) throws GeneralSecurityException {
		checkUserExistence(username);
		User currentUser = createdUsers.get(username);
		if (currentUser.getPasswordValidity(password)) {
			return currentUser;
		} else {
			throw new GeneralSecurityException("Password `" + password + "` is incorrect for user " + username+"\n");
		}
	}

	public String getUsername() {
		return username;
	}

	//Checks if password given is valid (used for logging in)
	public boolean getPasswordValidity(String password) {
		return Objects.equals(password, this.password);
	}

	public void setPassword(String oldPassword, String newPassword) throws GeneralSecurityException {
		if (getPasswordValidity(password)) {
			password = newPassword;
		} else {
			throw new GeneralSecurityException("Password `" + oldPassword + "` is incorrect for user " + username);
		}
	}

	//Validates password and then changes the name
	public void setName(String newName, String givenPassword) throws GeneralSecurityException {
		if (getPasswordValidity(password)) {
			name = newName;
		} else {
			throw new GeneralSecurityException("Password `" + givenPassword + "` is incorrect for user " + username);
		}

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}


	//Empties the ArrayList that contains the messages and returns them
	public ArrayList<Message> getNewMessages() {
		ArrayList<Message> unseenMessagesCopy = new ArrayList<>(unseenMessages);
		unseenMessages.clear();
		return unseenMessagesCopy;
	}

	//Adds a new message directed towards the User
	public void addNewMessage(Message directedMessage) {
		unseenMessages.add(directedMessage);
	}

	//Informs user of their UID
	@Override
	public String toString() {
		return String.format("Your username is %s.", username);
	}

	protected ArrayList<Message> getGetUnseenMessages() {
		return unseenMessages;
	}

	protected User getUserFromUsername(String username) {
		return createdUsers.get(username);
	}
}
