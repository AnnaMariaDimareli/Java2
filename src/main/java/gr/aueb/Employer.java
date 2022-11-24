package gr.aueb;

import java.util.ArrayList;

public class Employer extends User {
	
	public Employer(String username, String password, String name, String surname, String email, String dateOfBirth) {
		super(username, password, name, surname, email, dateOfBirth);
	}
	
	private ArrayList<Post> uploadedPosts = new ArrayList<Post>();
	
	public void addUploadedPosts(Post x) {
		uploadedPosts.add(x);
	}
	
	public void clearUploadedPosts() {
		uploadedPosts.clear();
		System.out.println("Your posts have been deleted!");
	}
	
	public void sizeOfUploadedPosts() {
		System.out.println("You have uploaded " + uploadedPosts.size() + " posts!");
	}

	public ArrayList<Post> getUploadedPosts() {
		return uploadedPosts;
	}

	//HAVE TO CHECK
	@Override
	public String toString() {
		return String.format(super.toString(), "and you are an employer-type user.");
	}

}
