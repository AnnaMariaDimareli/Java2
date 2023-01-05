package gr.aueb;

import java.util.ArrayList;

public class Employer extends User {
	
	//ArrayList containing uploaded post-type objects
	private final ArrayList<Post> uploadedPosts = new ArrayList<>();

	//ArrayList containing draft post-type objects
	private final ArrayList<Post> draftPosts = new ArrayList<>();

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
		ArrayList<Employee> currentEmployees = Employee.getEmployees();
		for(Employee e : currentEmployees) {
			//Adds the new post to all employees unseen posts
			e.addNewPost(x);
		}
	}

	//Returns how many posts have been created by the user
	public int sizeOfUploadedPosts() {
		return uploadedPosts.size();
	}

	//Returns the users posts
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
	}

	//Returns how many draft posts have been created by the user
	public int sizeOfDraftPosts() {
		return draftPosts.size();
	}

	//Returns the users draft posts
	public ArrayList<Post> getDraftPosts() {
		return draftPosts;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return (super.toString() + " You are an employer-type user.");
	}

}
