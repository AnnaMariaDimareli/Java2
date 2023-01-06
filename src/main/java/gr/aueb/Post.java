package gr.aueb;

import java.util.Date;
import java.util.HashMap;

public class Post {

    private static final Date dt = new Date(System.currentTimeMillis());
    private static final HashMap<Integer, Post> postNumberToPost = new HashMap<>();

    private static int numberOfPosts;

    private final String creator;
    private final String creationDate = dt.toString();
    private final String postContent;
    private final Employer referenceToEmployer;
    private final int postNumber = numberOfPosts;

    private int likeCount = 0;
    private boolean available = false;


    //This constructor is only used for testing
    protected Post(final Employer emp, final String postContent) {
        numberOfPosts++;
        referenceToEmployer = emp;
        creator = referenceToEmployer.getName() + " " + emp.getSurname();
        this.postContent = postContent;
        referenceToEmployer.addDraftPosts(this);
        postNumberToPost.put(postNumber, this);
    }

    //Returns the post or null if it doesn't exist
     public static Post getPostFromPostNumber(final int postNumber) {
        return postNumberToPost.get(postNumber);
    }

    public final Employer getReferenceToEmployer() {
        return referenceToEmployer;
    }

    public final int getLikeCount() {
        return likeCount;
    }

    /*If an employee wants to like a post
    then the Employee class makes a call to
    */
    /*The setLikeCount() method
    to increase post's number of likes
    */
    public final void like() {
        likeCount++;
    }

    //Returns the Creators full name
    public final String getCreator() {
        return creator;
    }

    //This method returns if the post is available
    public final Boolean getAvailable() {
        return available;
    }

    /* If the employer wants to make the
    post available then calls setAvailable with argument YES
    */
    /*If he wants to set it as
    unavailable then he calls setAvailable with argument NO
     */
    public final void setAvailable() {
            available = true;
            referenceToEmployer.addUploadedPosts(this);
            referenceToEmployer.deleteDraftPost(this);
    }

    @Override
    public final String toString() {
        return String.format("Post number:%d%n"
        + "Created on %s"
        + "by %s%n%s", postNumber, creationDate, creator, postContent);
    }

    public final int getPostNumber() {
        return postNumber;
    }
}
