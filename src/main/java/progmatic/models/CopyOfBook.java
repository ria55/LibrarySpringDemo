package progmatic.models;

public class CopyOfBook extends BaseModel {

    private Book book;
    private String publisher;
    private int releasedYear;
    private BookState state;

    public CopyOfBook() {}

    public CopyOfBook(long id, Book book, String publisher, int releasedYear, BookState state) {
        super(id);
        this.book = book;
        this.publisher = publisher;
        this.releasedYear = releasedYear;
        this.state = state;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return id + ". " +
                book + " --- " +
                publisher + ", " +
                releasedYear + " (" +
                state.HUN_NAME + ")";
    }

}
