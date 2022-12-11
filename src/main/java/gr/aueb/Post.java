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
    private String postContent;

    public Post(Employer emp) {
        referenceToEmployer = emp;
        creator = referenceToEmployer.getName() + " " + emp.getSurname();
        jobOfferingPost();
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

    //This method returns if the post is available in human readable form 
    public String getAvailable() {
        if (available) {
            return "The post is available";
            
        } else {
            return "The post is not available";
        }
    }

    /* if the employer wants to make the post available then calls setAvailable with argument YES
     * if he wants to set it as unavailable then he calls setAvailable with argument NO
     */
    public void setAvailable(String answer) {
        if (Objects.equals(answer, "YES")) {
            available = true;
            referenceToEmployer.addUploadedPosts(this);
            //TODO draftPosts removal method from Employer when it's available
        } else if (Objects.equals(answer, "NO")) {
            available = false;
            //TODO uploadedPosts removal method from Employer when it's available
            //TODO draftPosts adder method from Employer when it's available
        }
    }

    public void jobOfferingPost() {
        creationDate = dt.toString();
        System.out.print("Job Title : ");
        String jobTitle = "Job Title : " + input.nextLine();
        System.out.println();
        System.out.print("Workplace(On-site , Hybrid , Remote) : ");
        String workPlace = "Workplace type(On-site , Hybrid , Remote) : " + input.nextLine() + " ";
        System.out.println();
        System.out.print("Job Location : ");
        String jobLocation = "Job Location : " + input.nextLine() + " ";
        System.out.println();
        System.out.println("Salary Range ");
        System.out.print("   From: ");
        String salaryRange = "Salary Range : " + Integer.toString(input.nextInt()) + "-"; 
        System.out.print("   To: ");
        salaryRange=salaryRange + Integer.toString(input.nextInt()) + " ";
        System.out.println();
        System.out.print("Description : ");
        String description = "Description : " + input.next() + " ";
        System.out.println();
        postContent = String.format("%s\n%s\n%s\n%s\n%s\n " ,jobTitle ,workPlace ,jobLocation ,salaryRange ,description);
    }

    @Override

    public String toString() {
        return String.format("This post was created on %s by %s\n %s", creationDate, creator, postContent);
    }
}
