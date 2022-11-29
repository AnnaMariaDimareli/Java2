package gr.aueb;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Post {
    Date dt = new Date(System.currentTimeMillis());
    private String creator;
    Employer reftoemp;
    Scanner input = new Scanner(System.in);
    private int likeCount = 0;
    private boolean available = false;
    private String creationDate;
    public Post(Employer emp) {
        reftoemp = emp;
        creator = reftoemp.getName() + " " + emp.getSurname();
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void like() { //if an employee wants to like a post then Employee class calls setLikeCount method to increase post's number of likes//
        likeCount++;
    }

    public String getCreator() {
        return creator;
    }

    public void getAvailable() {
        if (available) {
            System.out.print("The post is available");
        } else {
            System.out.print("The post is not available");
        }
    }
    /* if the employer wants to make the post available then calls setAvailable with argument YES
     * if he wants to set it as unavailable then calls setAvailable with argument NO
     */
    public void setAvailable(String answer) {
        if (Objects.equals(answer, "YES")) {
            available = true;
            reftoemp.addUploadedPosts(this); //TODO CHECK THE ARGUMENT.
        } else if (Objects.equals(answer, "NO")) {
            available = false;
        }
    }
    public String jobOfferingPost() {
        creationDate = dt.toString();
        return String.format("Job Title : %s /nCompany : %s /nWorkplace type(On-site , Hybrid , Remote) : %s /nJob Location : %s /nSalary Range : %d - %d /nDescription : %s /n", input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextInt(), input.nextInt(), input.nextLine());
    }
    public String thoughtsSharingPost() {
        creationDate = dt.toString();
        return String.format("Share your thoughts with your network . /n %s", input.nextLine());
    }

    @Override

    public String toString() {
        return String.format("This post was created on %s by %s/n", creationDate, creator);
    }
}













