public class User {
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String dateOfBirth;

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
	
	//HAVE TO CHECK
	public void login(String username, String password ) {
		System.out.println("You have logged into your account!");
	}
	
	public void register(String username, String password, String name, String surname, String email, String dateOfBirth) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		System.out.println("You have created an account!");
	}
	
	//HAVE TO CHECK
	public void seeNewMessages() {
		
	}
	
	//HAVE TO CHECK
	public void signout() {
		System.out.println("You have signed out of your account!");
	}
	
	//HAVE TO CHECK
	@Override
	public String toString() {
		return String.format("Your username is %s.", username);
	}

}
