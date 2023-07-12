package chapter3.item13.hashtable;

public class HashTable<K, V> implements Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private Entry<K, V>[] buckets;
    private int size;

    protected static class Entry<K, V> {
        final K key;

        V value;

        // Ignore these.
        public K testKey;
        public V testValue;
        public Entry<K, V> testNext;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        /** Recursively copy the linked list headed by this Entry. */
        Entry deepCopy() {
            return new Entry(key, value,
                    next == null ? null : next.deepCopy());
        }

        /** Iteratively copy the linked list headed by this Entry. */
//        Entry<K, V> deepCopy() {
//            Entry<K, V> result = new Entry<>(key, value, next);
//            for (Entry<K, V> p = result; p.next != null; p = p.next)
//                p.next = new Entry<K, V>(p.next.key, p.next.value, p.next.next);
//            return result;
//        }
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        buckets = new Entry[capacity];
        size = 0;
    }

    public
//    private
    void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        Entry<K, V> newEntry = new Entry<>(key, value, buckets[index]);
        buckets[index] = newEntry;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> originalTable = new HashTable<>();
        originalTable.put("one", 1);
        originalTable.put("two", 2);
        originalTable.put("three", 3);

        /* Create a clone of the original HashTable. */
        HashTable clonedTable = originalTable.clone();

        /* Modify the value in the cloned table. */
        clonedTable.put("one", 10);

        /* Access the values from the original and cloned tables. */
        Integer originalValue = originalTable.get("one");
        Integer clonedValue = (Integer) clonedTable.get("one");

        System.out.println("Original value -> " + originalValue); // Output: 1
        System.out.println("Cloned value-> " + clonedValue);     // Output: 10
    }
}
