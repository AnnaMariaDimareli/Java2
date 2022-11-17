import java.util.ArrayList;

public class Employer extends User {
	
	//HAVE TO CHECK
	private ArrayList<Post> uploadedPosts = new ArrayList<Post>();
	
	//HAVE TO CHECK
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
		return String.format("Your username is %s and you are an employer-type user.", super.getUsername());
	}

}
