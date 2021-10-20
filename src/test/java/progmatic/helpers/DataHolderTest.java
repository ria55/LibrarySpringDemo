package progmatic.helpers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DataHolderTest {

    @Autowired
    DataHolder dataHolder;

    @Test
    void getAuthors() {
        assertNotNull(dataHolder.getAuthors());

        String authorLastName = "Tolkien";
        assertEquals(authorLastName, dataHolder.getAuthorById("1").getLastName());
    }

    @Test
    void getBooks() {
        assertNotNull(dataHolder.getBooks());

        String title = "Tíz kicsi néger";
        assertEquals(title, dataHolder.getBookById("18").getTitle());
    }

    @Test
    void getCopiesOfBooks() {
        assertNotNull(dataHolder.getCopiesOfBooks());

        assertEquals(42, dataHolder.getCopiesOfBooks().size());
    }

}