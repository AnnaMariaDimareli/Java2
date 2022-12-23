package gr.aueb;


import java.util.ArrayList;

public class Employee extends User {

	private ArrayList<Post> likedPosts = new ArrayList<>();

	/**
	 * Employee-type users like posts of Employer-type users for job positions
	 * Then an automated message of interest is sent to Employer-type users
	 */

	//Creates Employee type User through superclass constructor
	public Employee(String username, String password, String name, String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}

	//Likes a post
	public void addLikedPost(Post likedPost) {
		likedPosts.add(likedPost);
		likedPost.like(); //Post's like count increased
		super.addNewMessage(new Message(likedPost.getReferenceToEmployer(),this,
				"Thank you for your interest in our job offering. You can send your cv to " +
						likedPost.getCreator() + " email: " + likedPost.getReferenceToEmployer().getEmail())); // Automated message sent
	}

	//Shows how many posts have been liked by the user
	public int sizeOfLikedPosts() {
		return likedPosts.size();
	}

    //Shows the user's likes
	public ArrayList<Post> getLikedPosts() {
		return likedPosts;
	}
	
	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return (super.toString() + " You are an employee-type user.");
	}

}