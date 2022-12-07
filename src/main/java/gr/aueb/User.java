package gr.aueb;

import java.util.ArrayList;

public class User {
	
	/* Username and Password are the UID's (the username is unique)
	 * The rest are required for creating the account
	 */
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String dateOfBirth;

	//List of messages sent to user
	ArrayList<Message> unseenMessages = new ArrayList<Message>();

	// Constructor used to create object User (only useful when used through the two subclasses)
	public User(String username, String password, String name, String surname, String email, String dateOfBirth) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		System.out.println("You have created an account!");
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
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
	
	public void login(String username, String password ) {
		System.out.println("You have logged into your account!");
	}

	//Shows user their messages and then empties it
	public void seeNewMessages() {
		System.out.println("Your unseen messages are: ");
		System.out.println(unseenMessages);
		unseenMessages.clear();
	}
	
	//Disconnects user from account without terminating the programm 
	public void signOut() {
		System.out.println("You have signed out of your account!");
	}
	
	//Informs user of their UID 
	@Override
	public String toString() {
		return String.format("Your username is %s.", username);
	}

}
