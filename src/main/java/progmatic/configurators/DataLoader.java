package progmatic.configurators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import progmatic.helpers.DataHolder;
import progmatic.helpers.EnumHelper;
import progmatic.models.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    private final String ROOT = "src/main/resources/files/";
    private final String EXTENSION = ".txt";

    private final EnumHelper helper;
    private final DataHolder dataHolder;

    @Autowired
    public DataLoader(EnumHelper helper, DataHolder dataHolder) {
        this.helper = helper;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run(ApplicationArguments args) {
        dataHolder.setAuthors(loadAuthors());
        dataHolder.setBooks(loadBooks());
        dataHolder.setCopiesOfBooks(loadCopies());
    }

    private Map<Long, Author> loadAuthors() {
        Scanner scanner = getScanner(ROOT + "authors" + EXTENSION);

        if (scanner != null) {
            Map<Long, Author> authors = new HashMap<>();

            while (scanner.hasNextLine()) {
                String[] line = getNextLine(scanner);
                long id = Long.parseLong(line[0]);

                Author author = new Author(id, line);
                authors.put(id, author);
            }

            return authors;
        }

        return null;
    }

    private Map<Long, Book> loadBooks() {
        Scanner scanner = getScanner(ROOT + "books" + EXTENSION);

        if (scanner != null && dataHolder.getAuthors() != null) {
            Map<Long, Book> books = new HashMap<>();

            while (scanner.hasNextLine()) {
                String[] line = getNextLine(scanner);

                long id = Long.parseLong(line[0]);
                Author author = dataHolder.getAuthorById(line[1]);
                Genre genre = (Genre) helper.findEnumByNumber(Genre.values(), Integer.parseInt(line[3]));

                books.put(id, new Book(id, author, line[2], genre));
            }

            return books;
        }

        return null;
    }

    private List<CopyOfBook> loadCopies() {
        Scanner scanner = getScanner(ROOT + "copiesOfBooks" + EXTENSION);

        if (scanner != null && dataHolder.getBooks() != null) {
            List<CopyOfBook> copiesOfBooks = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String[] line = getNextLine(scanner);

                long id = Long.parseLong(line[0]);
                Book book = dataHolder.getBookById(line[1]);
                String publisher = line[2];
                int year = Integer.parseInt(line[3]);
                BookState state = (BookState) helper.findEnumByNumber(BookState.values(), Integer.parseInt(line[4]));

                copiesOfBooks.add(new CopyOfBook(id, book, publisher, year, state));
            }

            return copiesOfBooks;
        }

        return null;
    }

    private Scanner getScanner(String filePath) {
        try {
            return new Scanner(new File(filePath));
        } catch (IOException e) {
            return null;
        }
    }

    private String[] getNextLine(Scanner scanner) {
        return scanner.nextLine().split(",");
    }

}
