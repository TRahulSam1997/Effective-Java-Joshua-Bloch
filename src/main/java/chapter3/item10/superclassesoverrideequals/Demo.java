package chapter3.item10.superclassesoverrideequals;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<String> hash_Set = new HashSet<>();
        Set<String> hash_Set_2 = new HashSet<>();

        // Adding elements to the Set
        // using add() method
        hash_Set.add("Geeks");
        hash_Set.add("For");
        hash_Set.add("Geeks");
        hash_Set.add("Example");
        hash_Set.add("Set");

        hash_Set_2.add("Geeks");
        hash_Set_2.add("For");
        hash_Set_2.add("Geeks");
        hash_Set_2.add("Example");
        hash_Set_2.add("Set");

        // Printing elements of HashSet object
        System.out.println(hash_Set.equals(hash_Set_2));
    }
}
