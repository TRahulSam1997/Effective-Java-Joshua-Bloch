package item2.covariance;

public class Dostoevsky extends Author {
    private String name = "Fyodor Dostoevsky";

    /* This is covariant: while it returns a subclass of the return type (Object -> String)
     * it still fullfills the contract of Author.getAuthorName().
     */
    @Override
    public String getAuthorName() {
        return name;
    }
}
