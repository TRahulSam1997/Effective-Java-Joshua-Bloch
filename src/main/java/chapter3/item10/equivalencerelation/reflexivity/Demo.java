package chapter3.item10.equivalencerelation.reflexivity;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");

        /** The contains method checks if the element is contained in the list */
        /** The returned "true" proves reflexivity as it's looking for the object (or element) in the collection. */
        System.out.println(list.contains("java"));
    }
}
