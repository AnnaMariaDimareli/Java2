package gr.aueb;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Post {
    //FIXME Why are we creating an empty Employer object
    Employer emp = new Employer();
    Date dt = new Date(System.currentTimeMillis());
    //FIXME creator is set as strings from default Employer object. Both will be null
    private String creator = emp.getName() + " " + emp.getSurname();
    private int likeCount = 0;
    private boolean available = false;
    private String creationDate; //The creation date of the certain post

    //FIXME missing a constructor

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
    //FIXME employer must be specified while calling method. Using object emp must be incorrect
    public void setAvailable(String answer) {

        if (Objects.equals(answer, "YES")) {

            available = true;

            emp.addUploadedPosts(this); //CHECK THE ARGUMENT.

        } else if (Objects.equals(answer, "NO")) {

            available = false;

        }

    }

    /*createPost method offers to Employers a template in order to create their job offering post .
     * If they just want to create a post to share their ideas about the labor market they choose the second option
     */
    public String createPost() {
        System.out.println("Do you want to create a job offering post or share your thoughts about the labor market ?. Type 1 or 2");
        creationDate = dt.toString();

        Scanner input = new Scanner(System.in);
        if (input.nextInt() == 1) {
            return String.format("Job Title : %s /n Company : %s /n Workplace type(On-site , Hybrid , Remote) : %s /n Job Location : %s /n Salary Range : %d - %d /n Description : %s /n", input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextInt(), input.nextInt(), input.nextLine());
        } else if (input.nextInt() == 2) {
            return String.format("Share your thoughts with your network . /n %s", input.nextLine());
        }
        return null;
    }

    @Override

    public String toString() {

        return String.format("This post was created on %s by %s", creationDate, creator);

    }


}













