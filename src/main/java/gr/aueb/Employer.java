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
	public Employer(final String username, final String password,
		final String name, final String surname, final String email,
		final String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}

	//Uploads a post
	public final void addUploadedPosts(final Post x) {
		uploadedPosts.add(x);
		ArrayList<Employee> currentEmployees = Employee.getEmployees();
		for (Employee e : currentEmployees) {
			//Adds the new post to all employees unseen posts
			e.addNewPost(x);
		}
	}

	//Returns how many posts have been created by the user
	public final int sizeOfUploadedPosts() {
		return uploadedPosts.size();
	}

	//Returns the users posts
	public final ArrayList<Post> getUploadedPosts() {
		ArrayList<Post> up = new ArrayList<>();
		up.addAll(uploadedPosts);
		return up;
	}

	//Stores a draft post
	public final void addDraftPosts(final Post x) {
		draftPosts.add(x);
	}

	//Deletes a draft post
	public final void deleteDraftPost(final Post postForDeletion) {
		draftPosts.remove(postForDeletion);
	}

	//Returns how many draft posts have been created by the user
	public final int sizeOfDraftPosts() {
		return draftPosts.size();
	}

	//Returns the users draft posts
	public final ArrayList<Post> getDraftPosts() {
		ArrayList<Post> dp = new ArrayList<>();
		dp.addAll(draftPosts);
		return dp;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public final String toString() {
		return (super.toString() + " You are an employer-type user.");
	}

}
