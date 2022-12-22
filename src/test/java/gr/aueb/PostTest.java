package gr.aueb;
import org.junit.Test;
import static org.junit.Assert.*;

public class PostTest {
    private Employer employer = new Employer("simosathan9", "jhnksxj", "Simos",
            "Athanasiadis", "simosathan03@gmail.com", "9-11-2003");
    private Post post = new Post(employer,"This is a test post");

    @Test
    public void testGetReferenceToEmployer() {
        assertEquals(employer, post.getReferenceToEmployer());
    }

    @Test
    public void testLike() {
        post.like();
        assertEquals(1, post.getLikeCount());
    }

    @Test
    public void testGetCreator() {
        assertEquals("Simos Athanasiadis", post.getCreator());
    }

    @Test
    public void testSetAvailable() {
        post.setAvailable("YES");
        assertEquals("The post is available", post.getAvailable());

        post.setAvailable("NO");
        assertEquals("The post is not available", post.getAvailable());
    }
    //TODO METHODS toString(), getLikeCount() and getAvailable() test methods needed
}
