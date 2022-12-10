package gr.aueb;

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
	private String surname;
	private String email;
	private String dateOfBirth;

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
		System.out.println("You have created an account!");
	}

	//When called upon with a set of credentials this method will return the object which relates to the user.
	//If no such user exists it will return null. If an incorrect password is given it will throw a GeneralSecurityException
	public static User login(String username, String password) throws GeneralSecurityException {
		User currentUser= createdUsers.get(username);
		if (currentUser == null){
			System.out.println("Username "+username+" is incorrect");
		}else{
			if (currentUser.getPasswordValidity(password)){
				System.out.println("Wellcome "+username);
			} else{
				System.out.println();
				throw new GeneralSecurityException("Password `"+password+"` is incorrect for user "+username);
			}
		}
		return currentUser;
	}

	public String getUsername() {
		return username;
	}

	//checks if password given is valid used for logging in
	public boolean getPasswordValidity(String password) {
		return Objects.equals(password, this.password);
	}

	public void setPassword(String oldPassword, String newPassword) throws GeneralSecurityException {
		if (Objects.equals(oldPassword, password)) {
			password = newPassword;
		} else {
			throw new GeneralSecurityException("Password `"+oldPassword+"` is incorrect for user "+username);
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


	//Shows user their messages and then empties it
	public void seeNewMessages() {
		System.out.println("Your unseen messages are: ");
		System.out.println(unseenMessages);
		unseenMessages.clear();
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


}
