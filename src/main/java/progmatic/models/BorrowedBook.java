package progmatic.models;

import java.time.LocalDateTime;

public class BorrowedBook extends BaseModel {

    private LibraryUser user;
    private CopyOfBook book;
    private LocalDateTime borrowedTime;
    private LocalDateTime broughtBackTime;

    public BorrowedBook() {}

    public BorrowedBook(long id, LibraryUser user, CopyOfBook book, LocalDateTime borrowedTime, LocalDateTime broughtBackTime) {
        super(id);
        this.user = user;
        this.book = book;
        this.borrowedTime = borrowedTime;
        this.broughtBackTime = broughtBackTime;
    }

    public LibraryUser getUser() {
        return user;
    }

    public void setUser(LibraryUser user) {
        this.user = user;
    }

    public CopyOfBook getBook() {
        return book;
    }

    public void setBook(CopyOfBook book) {
        this.book = book;
    }

    public LocalDateTime getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime() {
        borrowedTime = LocalDateTime.now();
    }

    public LocalDateTime getBroughtBackTime() {
        return broughtBackTime;
    }

    public void setBroughtBackTime() {
        broughtBackTime = LocalDateTime.now();
    }

}
