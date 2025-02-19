import com.example.blogapp.models.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void testValidPersonCreation() {
        Person person = Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build();

        assertNotNull(person);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id(null)
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName("")
                .lastName("Doe")
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName("John")
                .lastName(null)
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> Person.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(-5)
                .gender("Male")
                .build());
    }
}
