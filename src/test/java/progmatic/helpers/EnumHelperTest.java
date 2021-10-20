package progmatic.helpers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import progmatic.models.BookState;
import progmatic.models.Genre;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EnumHelperTest {

    @Autowired
    EnumHelper helper;

    @Test
    void findGenreEnumByNumber() {
        Genre[] genres = Genre.values();
        Genre genreLit = (Genre) helper.findEnumByNumber(genres, 1);
        Genre genreChildren = (Genre) helper.findEnumByNumber(genres, 9);
        Genre genreNone = (Genre) helper.findEnumByNumber(genres, 10);

        assertEquals(Genre.LITERARY, genreLit);
        assertEquals(Genre.CHILDREN, genreChildren);
        assertEquals(Genre.UNKNOWN, genreNone);
    }

    @Test
    void findBookStateEnumByNumber() {
        BookState[] states = BookState.values();
        BookState discarded = (BookState) helper.findEnumByNumber(states, 1);
        BookState brandNew = (BookState) helper.findEnumByNumber(states, 4);
        BookState stateNone = (BookState) helper.findEnumByNumber(states, 5);

        assertEquals(BookState.DISCARDED, discarded);
        assertEquals(BookState.BRAND_NEW, brandNew);
        assertEquals(BookState.UNCATEGORIZED, stateNone);
    }

    @Test
    void findGenreEnumByName() {
        Genre[] genres = Genre.values();
        Genre genreLit = (Genre) helper.findEnumByName(genres, "literary");
        Genre genreSciFi = (Genre) helper.findEnumByName(genres, "science fiction");
        Genre genreNone = (Genre) helper.findEnumByName(genres, "something");

        assertEquals(Genre.LITERARY, genreLit);
        assertEquals(Genre.SCIENCE_FICTION, genreSciFi);
        assertEquals(Genre.UNKNOWN, genreNone);
    }

    @Test
    void findBookStateEnumByName() {
        BookState[] states = BookState.values();
        BookState discarded = (BookState) helper.findEnumByName(states, "discarded");
        BookState brandNew = (BookState) helper.findEnumByName(states, "brand new");
        BookState stateNone = (BookState) helper.findEnumByName(states, "uncategorized");

        assertEquals(BookState.DISCARDED, discarded);
        assertEquals(BookState.BRAND_NEW, brandNew);
        assertEquals(BookState.UNCATEGORIZED, stateNone);
    }
}