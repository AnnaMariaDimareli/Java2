package gr.aueb;

import java.util.ArrayList;

public class Employee extends User {
	private static ArrayList<Employee> employees = new ArrayList<>();
	private ArrayList<Post> likedPosts = new ArrayList<>();
	private ArrayList<Post> unseenPosts = new ArrayList<>();

	/**
	 * Employee-type users like posts of Employer-type users concerning
	 * vacancies in job positions
	 * Then an automated message of interest is sent to Employer-type users
	 */

	//Creates Employee type User through superclass constructor
	public Employee(final String username, final String password,
		final String name, final String surname, final String email,
		final String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
		employees.add(this);
	}

	//Empties the ArrayList that contains the posts and returns them
	public final ArrayList<Post> getNewPosts() {
		ArrayList<Post> unseenPostsCopy = new ArrayList<>(unseenPosts);
		unseenPosts.clear();
		return unseenPostsCopy;
	}

	//Adds a new post
	public final void addNewPost(final Post post) {
		unseenPosts.add(post);
	}

	//Returns all employees
	public static ArrayList<Employee> getEmployees() {
		ArrayList<Employee> emp = new ArrayList<>();
		emp.addAll(employees);
		return emp;
	}

	//Likes a post
	public final void addLikedPost(final Post likedPost) {
		likedPosts.add(likedPost);
		likedPost.like(); //Post's like count increased
		super.addNewMessage(
			new Message(likedPost.getReferenceToEmployer(),
			this, "Thank you for your interest in our job offering."
			+ " You can send your cv to " +  likedPost.getCreator()
			+ " email: "
			+ likedPost.getReferenceToEmployer().getEmail()));
		// Automated message sent
	}

	//Shows how many posts have been liked by the user
	public final int sizeOfLikedPosts() {
		return likedPosts.size();
	}

    //Shows the user's likes
	public final ArrayList<Post> getLikedPosts() {
		ArrayList<Post> lp = new ArrayList<>();
		lp.addAll(likedPosts);
		return lp;
	}

	//Used for informing the user about their UID and their user type
	@Override
	public final String toString() {
		return (super.toString() + " You are an employee-type user.");
	}

}
