import com.example.blogapp.models.BlogPost;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class BlogPostTest {
    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("1")
                .authorId("1")
                .postContent("This is a blog post.")
                .build();

        assertNotNull(post);
        assertEquals("This is a blog post.", post.getPostContent());
    }

    @Test
    void testBlogPostInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id(null)
                .authorId("1")
                .postContent("Content")
                .build());
    }

    @Test
    void testBlogPostInvalidAuthorId() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id("1")
                .authorId(null)
                .postContent("Content")
                .build());
    }
}
