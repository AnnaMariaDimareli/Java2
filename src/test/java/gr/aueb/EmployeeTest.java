package gr.aueb;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    //Creating a final Employer object and a Post object for check
    private final Employer testEmployer = new Employer("markella12122", "helloworld", "Markella",
            "Egglezou", "t8210039@aueb.gr", "21-02-2003");
    //Creating a final Employee object and a Message object for check
    private final Employee testEmployee = new Employee("mark12", "helloworld", "Markella",
            "Egglezou", "t8210039@aueb.gr", "21-02-2003");
    private Post testPost = new Post(testEmployer, "This is the content's of the post");
    private ArrayList<Post> likedPostsTest = new ArrayList<>();

    @Test
    public void addLikedPostTest() {
        //Creates a post for the Employee to like
        testEmployer.addUploadedPosts(testPost);
        likedPostsTest.add(testPost);
        testEmployee.addLikedPost(testPost);
        assertEquals("Proper message has been sent!", new Message(testEmployer, testEmployee,
                "Thank you for your interest in our job offering. You can send your cv to Markella Egglezou email: t8210039@aueb.gr").toString(),
                testEmployee.getNewMessages().get(0).toString());
    }

    @Test
    public void sizeOfLikedPostsTest() {
        //Size of ArrayList should be the same as size of uploadedPostsTest
        assertEquals("Method does not return 1!", likedPostsTest.size(), testEmployee.sizeOfLikedPosts());
    }

    @Test
    public void getLikedPostsTest() {
        //It should match likedPostsTest
        assertEquals("Method is not returning liked posts!", likedPostsTest, testEmployee.getLikedPosts());
    }

    @Test
    public void toStringTest() {
        //It should match Employee's toString
        assertEquals("Method is not workig properly!", "Your username is mark12. You are an employee-type user.", testEmployee.toString());
    }

}
