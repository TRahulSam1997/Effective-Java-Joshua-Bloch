package chapter3.item14;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ObjectOrderingDemo {

    public static void main(String[] args) {
        /*
          BigDecimal's compareTo method treats new BigDecimal("1.0") and new BigDecimal("1.00")
          as equal because both represent the same numerical value (1).
          So, compareTo returns 0 for these values.
          However, BigDecimal's equals method considers them unequal because it checks both the numerical value
          and the scale (the number of digits to the right of the decimal point).
          Since "1.0" and "1.00" have different scales, equals returns false.
         */
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");

        // HashSet uses equals() for comparison
        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(bd1);
        hashSet.add(bd2);

        // TreeSet uses compareTo() for comparison
        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(bd1);
        treeSet.add(bd2);

        System.out.println("HashSet size: " + hashSet.size()); // Output: 2
        System.out.println("TreeSet size: " + treeSet.size()); // Output: 1
    }
}
