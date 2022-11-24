package gr.aueb;

public class User {
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String dateOfBirth;

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

	//TODO CHECK
	public void seeNewMessages() {
		
	}
	
	//TODO CHECK
	public void signOut() {
		System.out.println("You have signed out of your account!");
	}
	
	@Override
	public String toString() {
		return String.format("Your username is %s.", username);
	}

}
