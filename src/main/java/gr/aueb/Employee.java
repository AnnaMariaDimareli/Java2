package gr.aueb;


import java.util.ArrayList;

public class Employee extends User {

	private ArrayList<Post> likedPosts = new ArrayList<>();

	/**
	 * Hello world!
	 * FIXME Info about Employee class needed
	 */

	//Creates Employee type User through superclass constructor
	public Employee(String username, String password, String name, String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}


	//Likes a post
	public void addLikedPosts(Post likedPost) {
		likedPosts.add(likedPost);
		likedPost.like(); //Post's like count increased
		super.addNewMessage(new Message(likedPost.getReferenceToEmployer(),this,
				"Thank you for your interest in our job offering. You can send your cv to " +
						likedPost.getCreator() + " email: " + likedPost.getReferenceToEmployer().getEmail())); // Automated message sent
	}
	
	public void unlikePost() {
		//TODO
	}

    
	//Shows how many posts have been liked by the user
	public void sizeOfLikedPosts() {
		System.out.println("You have liked " + likedPosts.size() + " posts!");
	}




    //Shows the user's likes
	public ArrayList<Post> getLikedPosts() {
		return likedPosts;
	}

	
	//Used for informing the user about their UID and their user type
	@Override
	public String toString() {
		return (super.toString() + " and you are an employee-type user.");
	}

}