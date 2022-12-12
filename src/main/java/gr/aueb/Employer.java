package gr.aueb;

import java.util.ArrayList;

public class Employer extends User {

	//ArrayList containing uploaded post-type objects
	private ArrayList<Post> uploadedPosts = new ArrayList<>();
	
	//ArrayList containing draft post-type objects
	private ArrayList<Post> draftPosts = new ArrayList<>();

	/**
	 * Employer-type users offer job positions to Employee-type users
	 * They upload posts referring to available positions
	 * Then Employee-type users show interest via liking their posts
	 */

	//Creates User through superclass constructor
	public Employer(String username, String password, String name, String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}

	//Creates a post
	public void addUploadedPosts(Post x) {
		uploadedPosts.add(x);
	}

	//Deletes post at given index from the account
	public void deleteUploadedPost(int i) {
		uploadedPosts.remove(i);
		System.out.println("Your post at index " + i + " has been deleted!");
	}

	//Shows how many posts have been created by the user
	public void sizeOfUploadedPosts() {
		System.out.println("You have uploaded " + uploadedPosts.size() + " posts!");
	}

	//Shows the user's posts
	public ArrayList<Post> getUploadedPosts() {
		return uploadedPosts;
	}

	//Creates a draft post
	public void addDraftPosts(Post x) {
		draftPosts.add(x);
	}

	//Deletes draft post at given index from the account
	public void deleteDraftPost(int i) {
		draftPosts.remove(i);
		System.out.println("Your draft post at index " + i + " has been deleted!");
	}

	//Shows how many draft posts have been created by the user
	public void sizeOfDraftPosts() {
		System.out.println("You have uploaded " + draftPosts.size() + " draft posts!");
	}

	//Shows the user's draft posts
	public ArrayList<Post> getDraftPosts() {
		return draftPosts;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return String.format(super.toString(), "and you are an employer-type user.");
	}

}
