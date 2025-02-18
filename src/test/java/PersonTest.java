import com.example.blogapp.models.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void testValidPersonCreation() {
        Person person = new Person("1", "John", "Doe", 30, "Male");
        assertNotNull(person);
        assertEquals("John", person.getFirstName());
    }

    @Test
    void testPersonInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "John", "Doe", 30, "Male"));
    }

    @Test
    void testPersonInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Person("1", "", "Doe", 30, "Male"));
    }
}