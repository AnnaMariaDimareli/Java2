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
	public Employer(String username, String password, String name,
					String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}

	//Uploads a post
	public void addUploadedPosts(Post x) {
		uploadedPosts.add(x);
	}

	//Deletes an Uploaded post from the ArrayList<Post>
	public void deleteUploadedPost(Post postForDeletion) {
		uploadedPosts.remove(postForDeletion);
		System.out.println("Your post has been deleted!");
	}

	//Shows how many posts have been created by the user
	public void sizeOfUploadedPosts() {
		System.out.println("You have uploaded " + uploadedPosts.size() + " posts!");
	}

	//Returns the users draft posts
	public ArrayList<Post> getUploadedPosts() {
		return uploadedPosts;
	}

	//Stores a draft post
	public void addDraftPosts(Post x) {
		draftPosts.add(x);
	}

	//Deletes a draft post
	public void deleteDraftPost(Post postForDeletion) {
		draftPosts.remove(postForDeletion);
		System.out.println("Your draft post has been deleted!");
	}

	//Shows how many draft posts have been created by the user
	public void sizeOfDraftPosts() {
		System.out.println("You have uploaded " + draftPosts.size() + " draft posts!");
	}

	//Returns the users draft posts
	public ArrayList<Post> getDraftPosts() {
		return draftPosts;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return String.format(super.toString(), "and you are an employer-type user.");
	}

}
