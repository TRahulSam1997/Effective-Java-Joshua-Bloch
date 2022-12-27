package chapter3.item10.equivalencerelation.consistency.immutability.string;

/**
 * Example courtesy of Baeldung.
 */
public class Demo {
    public static void main(String[] args) {
        String name = "baeldung";
        String newName = name.replace("dung", "----");

        /** name hasn't changed as newName is a new object */
        System.out.println(name);
        System.out.println(newName);
    }
}
