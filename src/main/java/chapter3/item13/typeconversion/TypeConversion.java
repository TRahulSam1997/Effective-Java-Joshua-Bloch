package chapter3.item13.typeconversion;

import java.util.HashSet;
import java.util.TreeSet;

public class TypeConversion {
    public class Main {
        public static void main(String[] args) {
            // Suppose you have a HashSet
            HashSet<String> s = new HashSet<>();
            s.add("One");
            s.add("Two");
            s.add("Three");

            // If you want to copy it as a TreeSet
            // Using clone won't work, as it would just give you another HashSet
            // But with a conversion constructor, it's easy...
            TreeSet<String> ts = new TreeSet<>(s);

            // Now `ts` is a TreeSet with the same elements as `s`
            System.out.println(ts);
        }
    }

}
