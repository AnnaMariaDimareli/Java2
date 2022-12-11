package gr.aueb;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Post {
    private static final Scanner input = new Scanner(System.in);
    private static final Date dt = new Date(System.currentTimeMillis());

    private final String creator;
    private final Employer referenceToEmployer;

    private int likeCount = 0;
    private boolean available = false;
    private String creationDate;
    //FIXME POST DOESN'T STORE ITS OWN CONTENT!

    public Post(Employer emp) {
        referenceToEmployer = emp;
        creator = referenceToEmployer.getName() + " " + emp.getSurname();
        //TODO post must be added to draft posts upon creation as available is false
    }

    public Employer getReferenceToEmployer() {
        return referenceToEmployer;
    }

    public int getLikeCount() {
        return likeCount;
    }

    //if an employee wants to like a post then the Employee class makes a call to
    //the setLikeCount() method to increase post's number of likes
    public void like() {
        likeCount++;
    }

    //Returns the Creators full name
    public String getCreator() {
        return creator;
    }

    // TODO explain what this dose. maybe getAvailable() is not a correct name as the method returns void!
    public void getAvailable() {
        if (available) {
            System.out.print("The post is available");
        } else {
            System.out.print("The post is not available");
        }
    }

    /* if the employer wants to make the post available then calls setAvailable with argument YES
     * if he wants to set it as unavailable then he calls setAvailable with argument NO
     */
    public void setAvailable(String answer) {
        if (Objects.equals(answer, "YES")) {
            available = true;
            referenceToEmployer.addUploadedPosts(this);
            // TODO draftPosts removal method from Employer when it's available
        } else if (Objects.equals(answer, "NO")) {
            available = false;
            //TODO uploadedPosts removal method from Employer when it's available
            //TODO draftPosts adder method from Employer when it's available
        }
    }

    public String jobOfferingPost() { // FIXME method is not storing post contents! maybe this can be merged with the constructor
        creationDate = dt.toString();
        return String.format("Job Title : %s /nCompany : %s /nWorkplace type(On-site , Hybrid , Remote) : %s /nJob Location : %s /nSalary Range : %d - %d /nDescription : %s /n", input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextInt(), input.nextInt(), input.nextLine());
    }

    public String thoughtsSharingPost() {//TODO SAFE REMOVAL. NO OTHER POSTS EXCEPT JOB OFFERINGS
        creationDate = dt.toString();
        return String.format("Share your thoughts with your network . /n %s", input.nextLine());
    }

    @Override

    public String toString() {
        return String.format("This post was created on %s by %s/n", creationDate, creator);
    }
}













