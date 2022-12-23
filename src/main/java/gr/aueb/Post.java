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
    private final String creationDate = dt.toString();
    private final String postContent;

    //This constructor is only used for testing
    protected Post(Employer emp, String postContent) {
        referenceToEmployer = emp;
        creator = referenceToEmployer.getName() + " " + emp.getSurname();
        this.postContent = postContent;
        referenceToEmployer.addDraftPosts(this);
    }

    public Employer getReferenceToEmployer() {
        return referenceToEmployer;
    }

    public int getLikeCount() {
        return likeCount;
    }

    //If an employee wants to like a post then the Employee class makes a call to
    //The setLikeCount() method to increase post's number of likes
    public void like() {
        likeCount++;
    }

    //Returns the Creators full name
    public String getCreator() {
        return creator;
    }

    //This method returns if the post is available FIXME maybe this method is useless
    public Boolean getAvailable() {
        return available;
    }

    /* If the employer wants to make the post available then calls setAvailable with argument YES
     * If he wants to set it as unavailable then he calls setAvailable with argument NO
     */
    public void setAvailable() {
            available = true;
            referenceToEmployer.addUploadedPosts(this);
            referenceToEmployer.deleteDraftPost(this);
    }


    @Override
    public String toString() {
        return String.format("This post was created on %s by %s\n %s", creationDate, creator, postContent);
    }
}
