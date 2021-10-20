package progmatic.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LibraryUser extends BaseModel implements UserDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime regTime;
    private boolean isEnable;

    private List<BorrowedBook> books;

    public LibraryUser() {}

    public LibraryUser(long id, String firstName, String lastName, String email, String password,
                       LocalDateTime regTime, boolean isEnable) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.regTime = regTime;
        this.isEnable = isEnable;
        books = new ArrayList<>();
    }

    public LibraryUser(long id, String firstName, String lastName, String email, String password,
                       String role, LocalDateTime regTime, boolean isEnable) {
        this(id, firstName, lastName, email, password, regTime, isEnable);
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public List<BorrowedBook> getBooks() {
        return books;
    }

    public void setBooks(List<BorrowedBook> books) {
        this.books = books;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.toUpperCase()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

}
