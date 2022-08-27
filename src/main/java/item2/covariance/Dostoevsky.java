package item2.covariance;

public class Dostoevsky extends Author{
    private String name = "Fyodor Dostoevsky";

    /* This is covariant. */
    @Override
    public String getAuthorName() {
        return name;
    }
}
