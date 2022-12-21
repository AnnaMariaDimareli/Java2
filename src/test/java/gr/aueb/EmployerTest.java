package gr.aueb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class EmployerTest {

    //Creating a final Employer object for check
    private final Employer testEmployer = new Employer("markella12122", "helloworld", "Markella",
        "Egglezou", "t8210039@aueb.gr", "21-02-2003");
    private Post testPost1;
    private Post testPost2;
	private ArrayList<Post> uploadedPostsTest = new ArrayList<>();
    private ArrayList<Post> draftPostsTest = new ArrayList<>();

    @Test
    public void addDraftPostsTest() {
        //Post should be added in ArrayList
        testPost1 = new Post(testEmployer);
        draftPostsTest.add(testPost1);
        assertEquals("Method has not added the draft post!", testPost1, testEmployer.getDraftPosts().get(0));
    }

    @Test
    public void getDraftPostsTest() {
        //It should match testPost1
        assertEquals("Method is not returning draft posts!", draftPostsTest, testEmployer.getDraftPosts());
    }

    @Test
    public void sizeOfDraftPostsTest() {
        //Size of ArrayList should be 1
        assertEquals("Method does not return 1!", 1, testEmployer.getDraftPosts().size()); 
    }

    @Test 
    public void deleteDraftPostTest() {
        //Size of ArrayList should be 0
        testEmployer.deleteDraftPost(testPost1);
        assertEquals("Method does not delete post!", 0, testEmployer.getDraftPosts().size());
    }

    @Test
    public void addUploadedPostsTest() {
        //Post should be added in ArrayList
        testPost2 = new Post(testEmployer);
        testPost2.setAvailable("YES");
        uploadedPostsTest.add(testPost2);
        assertEquals("Method has not added the uploaded post!", testPost2, testEmployer.getUploadedPosts().get(0));
    }

    @Test
    public void getUploadedPostsTest() {
        //It should match testPost2
        assertEquals("Method is not returning uploaded posts!", uploadedPostsTest, testEmployer.getUploadedPosts());
    }

    @Test
    public void sizeOfUploadedPostsTest() {
        //Size of ArrayList should be 1
        assertEquals("Method does not return 1!", 1, testEmployer.getUploadedPosts().size());
    }

    @Test 
    public void deleteUploadedPostTest() {
        //Size of ArrayList should be 0
        testEmployer.deleteUploadedPost(testPost2);
        assertEquals("Method does not delete post!", 0, testEmployer.getUploadedPosts().size());
    }
    
}
