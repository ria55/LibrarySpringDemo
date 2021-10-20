package progmatic.models;

public class Author extends BaseModel {

    private String firstName;
    private String lastName;
    private boolean isLastNameFirst;

    public Author() {}

    public Author(long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(long id, String[] lineFromFile) {
        this(id, lineFromFile[1], lineFromFile[2]);
        isLastNameFirst = lineFromFile.length == 4;
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

    public boolean isLastNameFirst() {
        return isLastNameFirst;
    }

    public void setLastNameFirst(boolean lastNameFirst) {
        isLastNameFirst = lastNameFirst;
    }

    @Override
    public String toString() {
        return (isLastNameFirst ?
                lastName + " " + firstName :
                firstName + " " + lastName);
    }

}
