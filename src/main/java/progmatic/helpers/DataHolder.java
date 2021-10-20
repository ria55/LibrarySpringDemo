package progmatic.helpers;

import org.springframework.stereotype.Component;
import progmatic.models.Author;
import progmatic.models.Book;
import progmatic.models.CopyOfBook;

import java.util.List;
import java.util.Map;

@Component
public class DataHolder {

    private Map<Long, Author> authors;
    private Map<Long, Book> books;
    private List<CopyOfBook> copiesOfBooks;


    public void printCopiesInfo() {
        for (CopyOfBook book : copiesOfBooks) {
            System.out.println(book);
        }
    }


    public Author getAuthorById(String id) {
        return authors.get(Long.parseLong(id));
    }

    public Book getBookById(String id) {
        return books.get(Long.parseLong(id));
    }

    public Map<Long, Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Map<Long, Author> authors) {
        this.authors = authors;
    }

    public Map<Long, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Long, Book> books) {
        this.books = books;
    }

    public List<CopyOfBook> getCopiesOfBooks() {
        return copiesOfBooks;
    }

    public void setCopiesOfBooks(List<CopyOfBook> copiesOfBooks) {
        this.copiesOfBooks = copiesOfBooks;
    }
}
