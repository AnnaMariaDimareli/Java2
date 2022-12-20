package gr.aueb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployerTest {

    //Creating a final Employer object for check
    private final Employer testEmployer = new Employer("markella12122", "helloworld", "Markella",
        "Egglezou", "t8210039@aueb.gr", "21-02-2003");
    private Post testPost1;
    private Post testPost2;

    @Test
    public void addDraftPostsTest() {
        testPost1 = new Post(testEmployer);
        //FIXME
    }

    @Test
    public void getDraftPostsTest() {
        //It should match testPost1
        assertEquals("Method is not returning draft posts!", testPost1, testEmployer.getDraftPosts());
        //FIXME asserEquals is being used between objects of incompatible types testPost1 is Post while testEmployer.getDraftPosts() is an ArrayList!!!
    }

    @Test
    public void sizeOfDraftPostsTest() {
        //Size of ArrayList should be 1
        assertEquals("Method does not return 1!", 1, draftPosts.size()); //FIXME can't access variable draftPosts. Out of scope!
    }

    @Test 
    public void deleteDraftPostTest() {
        //Size of ArrayList should be 0
        testEmployer.deleteDraftPost(testPost1);
        assertEquals("Method does not delete post!", 0, draftPosts.size()); //FIXME can't access variable draftPosts. Out of scope!
    }

    @Test
    public void addUploadedPostsTest() {
        testPost2 = new Post(testEmployer);
        //FIXME
        testPost2.setAvailable("YES");
    }

    @Test
    public void getUploadedPostsTest() {
        //It should match testPost2
        assertEquals("Method is not returning uploaded posts!", testPost2, testEmployer.getUploadedPosts());
        //FIXME asserEquals is being used between objects of incompatible types testPost2 is Post while testEmployer.getDraftPosts() is an ArrayList!!!
    }

    @Test
    public void sizeOfUploadedPostsTest() {
        //Size of ArrayList should be 1
        assertEquals("Method does not return 1!", 1, uploadedPosts.size()); //FIXME can't access variable uploadedPosts. Out of scope!
    }

    @Test 
    public void deleteUploadedPostTest() {
        //Size of ArrayList should be 0
        testEmployer.deleteUploadedPost(testPost2);
        assertEquals("Method does not delete post!", 0, uploadedPosts.size()); //FIXME can't access variable uploadedPosts. Out of scope!
    }
    
}
