package chapter3.item10.superclassesoverrideequals;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> hashSet2 = new HashSet<>();
        Set<String> hashSet3 = new HashSet<>();

        hashSet.add("Effective");
        hashSet.add("Java");

        hashSet2.add("Effective");
        hashSet2.add("Java");

        hashSet3.add("Effective");
        hashSet3.add("TypeScript");

        /** Checking for equality. */
        System.out.println("hashSet to hashSet2 comparison -> " + hashSet.equals(hashSet2));
        System.out.println("hashSet to hashSet3 comparison -> " + hashSet.equals(hashSet3));
    }
}
