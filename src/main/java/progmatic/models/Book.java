package progmatic.models;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;

//@Entity
public class Book extends BaseModel {

    //@Id
    private long bookId;

    private Author author;
    private String title;

    //@Enumerated
    private Genre genre;

    public Book() {}

    public Book(long id, Author author, String title, Genre genre) {
        super(id);
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return author + ": " +
                title + " - " +
                genre.HUN_NAME;
    }

}
