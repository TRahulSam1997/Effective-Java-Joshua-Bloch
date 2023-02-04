package chapter3.item11.exclude;

public class Person {
    private String firstName;
    private String lastName;
    private String fullName;

    public String getFullName() {
        fullName = firstName.concat(lastName);
        return fullName;
    }

    @Override
    public int hashCode() {
        /** fullName ignored. */
        int result = 17;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}
