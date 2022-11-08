package Item7.WeakHashMap;

import java.lang.ref.WeakReference;

/** Example courtesy of Baeldung */
public class WeakHashMapDemo {
    public static void main(String[] args) {

        /** Creating a weak reference. */
        Integer prime = 1;
        WeakReference<Integer> soft = new WeakReference<>(prime);

        /** When we made a prime reference null,
         * the prime object will be garbage collected in the next GC cycle,
         * as there is no other strong reference pointing to it.
         */
        prime = null;
    }
}
