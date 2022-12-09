package gr.aueb;

import java.util.ArrayList;

public class Employer extends User {
	//ArrayList containing post-type objects
	private ArrayList<Post> uploadedPosts = new ArrayList<>();

	/**
	 * Hello world!
	 * FIXME Info about Employer class needed
	 */

	//Creates User through superclass constructor
	public Employer(String username, String password, String name, String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}

	//Creates a post
	public void addUploadedPosts(Post x) {
		uploadedPosts.add(x);
	}

	//Empties user's account from posts
	public void clearUploadedPosts() {
		uploadedPosts.clear();
		System.out.println("Your posts have been deleted!");
	}

	//Shows how many posts have been created by the user
	public void sizeOfUploadedPosts() {
		System.out.println("You have uploaded " + uploadedPosts.size() + " posts!");
	}

	//Shows the user's posts
	public ArrayList<Post> getUploadedPosts() {
		return uploadedPosts;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return String.format(super.toString(), "and you are an employer-type user.");
	}

}
