package gr.aueb;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class PostTest {
    private final Employer employer = new Employer("simosathan9", "jhnksxj", "Simos",
            "Athanasiadis", "simosathan03@gmail.com", "9-11-2003");
    private final Post post = new Post(employer,"These are the contents of the post\nI love potatoes\nThis app is amazing");

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
        post.setAvailable();
        assertTrue("setAvailable is not changing post status to Available", post.getAvailable());
    }
    @Test
    public void testToString() {
        final Date dt = new Date(System.currentTimeMillis());
        String creationDate = dt.toString();
        String expectedOutput = String.format("Post number:"+post.getPostNumber()+"%nCreated on "+ creationDate + " by Simos Athanasiadis%nThese are the contents of the post\nI love potatoes\nThis app is amazing");
        assertEquals(expectedOutput, post.toString());
    }
    @Test
    public void testGetLikeCount() {
        assertEquals(0, post.getLikeCount());
        post.like();
        int expectedlikes = 1;
        assertEquals(expectedlikes, post.getLikeCount());
    }
}
