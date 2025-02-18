import com.example.blogapp.models.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BlogPostTest {
    @Test
    void testValidBlogPostCreation() {
        BlogPost post = new BlogPost("1", "1", "This is a blog post.");
        assertNotNull(post);
        assertEquals("This is a blog post.", post.getPostContent());
    }

    @Test
    void testBlogPostInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new BlogPost(null, "1", "Content"));
    }

    @Test
    void testBlogPostInvalidAuthorId() {
        assertThrows(IllegalArgumentException.class, () -> new BlogPost("1", null, "Content"));
    }
}