import com.example.blogapp.models.Blog;
import com.example.blogapp.models.BlogPost;
import com.example.blogapp.models.Person;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlogTest {
    @Test
    void testGetPostsByAuthorAge() {
        Person p1 = Person.builder()
                .id("1")
                .firstName("Alice")
                .lastName("Smith")
                .age(25)
                .gender("Female")
                .build();

        Person p2 = Person.builder()
                .id("2")
                .firstName("Bob")
                .lastName("Brown")
                .age(30)
                .gender("Male")
                .build();

        BlogPost post1 = BlogPost.builder()
                .id("101")
                .authorId("1")
                .postContent("Alice's post")
                .build();

        BlogPost post2 = BlogPost.builder()
                .id("102")
                .authorId("2")
                .postContent("Bob's post")
                .build();

        Blog blog = Blog.builder()
                .posts(List.of(post1, post2))
                .contributors(List.of(p1, p2))
                .build();

        List<String> postsBy25 = blog.getPostsByAuthorAge(25);
        assertEquals(List.of("101"), postsBy25);
    }
}
