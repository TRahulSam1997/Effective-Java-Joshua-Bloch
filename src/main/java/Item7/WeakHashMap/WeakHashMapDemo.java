package Item7.WeakHashMap;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

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

        /** Ideally, we want a Map implementation that allows GC to automatically delete unused objects.
         * When a key of a big image object is not in use in our application in any place,
         * that entry will be deleted from memory.
         */
        WeakHashMap<UniqueImageName, BigImage> wMap = new WeakHashMap<>();
        HashMap<UniqueImageName, BigImage> map = new HashMap<>();
        BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        /** We are putting a BigImage object as a value and an imageName object reference as a key. */
        wMap.put(imageName, bigImage);
        System.out.println("Does Map contains imageName -> " + wMap.containsKey(imageName));

        wMap.put(imageName, bigImage);

        /** The key is set to null. */
        imageName = null;
        /** Forcing JVM to GC. */
        System.gc();
        System.out.println("Weak Map is empty -> " + wMap);
    }

    private static class UniqueImageName {
        public UniqueImageName(String name_of_big_image) {
        }
    }

    private static class BigImage {
        public BigImage(String image_id) {
        }
    }
}
