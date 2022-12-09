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


	public void addLikedPosts(Post x) {
		likedPosts.add(x);
	}


	public void sizeOfLikedPosts() {
		System.out.println("You have liked " + likedPosts.size() + " posts!");
	}


	public void unlike(Post x) {
		likedPosts.remove(x);
	}


	public ArrayList<Post> getLikedPosts() {
		return likedPosts;
	}


	@Override
	public String toString() {
		return (super.toString() + " and you are an employee-type user.");
	}

}


































